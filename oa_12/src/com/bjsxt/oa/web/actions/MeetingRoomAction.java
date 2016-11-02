package com.bjsxt.oa.web.actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bjsxt.oa.managers.MeetingRoomManager;
import com.bjsxt.oa.model.MeetingRoomApply;
import com.bjsxt.oa.web.forms.MeetingRoomActionForm;

public class MeetingRoomAction extends BaseAction {

	private MeetingRoomManager meetingRoomManager;
	private static SimpleDateFormat format = new SimpleDateFormat("H");
	
	/**
	 * ��ʾ�����������������
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomActionForm mraf = (MeetingRoomActionForm)form;
		//���еĻ�����
		request.setAttribute("rooms", meetingRoomManager.searchAllRooms());
		
		//���»��ض��·ݵ������¼
		int year = mraf.getYear();
		int month = mraf.getMonth();
		
		if(year == 0 || month == 0){
			year = currentYear();
			month = currentMonth();
		}
		
		if(mraf.getNav() != null){
			Calendar now = Calendar.getInstance();
			now.set(year, month-1, 1);
			if(mraf.getNav().equals("pre")){
				now.add(Calendar.MONTH, -1);
			}else{
				now.add(Calendar.MONTH, 1);
			}
			year = now.get(Calendar.YEAR);
			month = now.get(Calendar.MONTH) + 1;
		}
		
		request.setAttribute("applies", 
			meetingRoomManager.searchApplies(
				firstDayOfMonth(year,month), lastDayOfMonth(year,month)
			)
		);
		
		request.setAttribute("maxDay", maxDayOfMonth(year,month));
		request.setAttribute("beginTime", 8);
		request.setAttribute("endTime", 18);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		
		return mapping.findForward("index");
	}
	
	//�����������
	public ActionForward applyInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomActionForm mraf = (MeetingRoomActionForm)form;
		if(mraf.getApplyId() != 0){
			 MeetingRoomApply apply = meetingRoomManager.findRoomApply(mraf.getApplyId());
			 BeanUtils.copyProperties(mraf, apply);
			 mraf.setEndTime(Integer.parseInt(format.format(apply.getEndDate())));
		}
		return mapping.findForward("apply_input");
	}
	
	//���뱣��
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomActionForm mraf = (MeetingRoomActionForm)form;
		MeetingRoomApply apply = new MeetingRoomApply();
		apply.setApplyReason(mraf.getApplyReason());
		
		Calendar begin = Calendar.getInstance();
		begin.setTime(mraf.getBeginDate());
		begin.set(Calendar.HOUR_OF_DAY, mraf.getBeginTime());
		
		apply.setBeginDate(begin.getTime());
		
		
		Calendar end = Calendar.getInstance();
		end.setTime(mraf.getEndDate());
		end.set(Calendar.HOUR_OF_DAY, mraf.getEndTime());
		apply.setEndDate(end.getTime());
		
		
		apply.setStatus(mraf.getStatus());
		
		if(mraf.getApplyId() != 0){
			apply.setId(mraf.getApplyId());
			meetingRoomManager.updateApply(apply, mraf.getSn());
		}else{
			meetingRoomManager.applyRoom(apply, mraf.getSn());
		}
		return mapping.findForward("pub_update_success");
	}
	
	private int currentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	private int currentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}
	
	private Date firstDayOfMonth(int year,int month){
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, now.getActualMinimum(Calendar.DAY_OF_MONTH));
		return now.getTime();
	}
		
	private Date lastDayOfMonth(int year,int month){
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, now.getActualMaximum(Calendar.DAY_OF_MONTH));
		return now.getTime();
	}
	
	private int maxDayOfMonth(int year,int month){
		Calendar now = Calendar.getInstance();
		now.set(year, month - 1, 1);
		return now.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public void setMeetingRoomManager(MeetingRoomManager meetingRoomManager) {
		this.meetingRoomManager = meetingRoomManager;
	}
	
}
