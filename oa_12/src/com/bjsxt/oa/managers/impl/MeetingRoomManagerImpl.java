package com.bjsxt.oa.managers.impl;

import java.util.Date;
import java.util.List;

import com.bjsxt.oa.managers.MeetingRoomManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.model.MeetingRoom;
import com.bjsxt.oa.model.MeetingRoomApply;

public class MeetingRoomManagerImpl extends AbstractManager implements
		MeetingRoomManager {

	public void addRoom(MeetingRoom room) {
		getHibernateTemplate().save(room);
	}

	public void applyRoom(MeetingRoomApply apply,String sn) {
		
		//是否有冲突？
		Long size = (Long)getSession()
			.createQuery(
					"select count(*) from MeetingRoomApply ap where ap.room.sn = ? and " +
					"(" +
					"(:begin between ap.beginDate and ap.endDate ) or " +
					"(:end between ap.beginDate and ap.endDate )" +
					")")
			.setParameter(0, sn)
			.setParameter("begin", apply.getBeginDate())
			.setParameter("end", apply.getEndDate())
			.uniqueResult();
		if(size >= 1){
			throw new SystemException("您申请的会议室与其他人的申请有冲突，请重新申请！");
		}
		
		apply.setRoom(
			(MeetingRoom)getSession()
			.createQuery("from MeetingRoom ap where ap.sn = ?")
			.setParameter(0, sn)
			.uniqueResult()
		);
		getHibernateTemplate().save(apply);
	}

	public MeetingRoomApply findRoomApply(int applyId) {
		
		return (MeetingRoomApply)getHibernateTemplate().load(MeetingRoomApply.class, applyId);
	}

	public void updateApply(MeetingRoomApply apply, String sn) {
		
		//是否有冲突？
		Long size = (Long)getSession()
			.createQuery(
					"select count(*) from MeetingRoomApply ap where ap.room.sn = ? and " +
					"(" +
					"(:begin between ap.beginDate and ap.endDate ) or " +
					"(:end between ap.beginDate and ap.endDate )" +
					") and " +
					"ap.id <> "+apply.getId())
			.setParameter(0, sn)
			.setParameter("begin", apply.getBeginDate())
			.setParameter("end", apply.getEndDate())
			.uniqueResult();
		if(size >= 1){
			throw new SystemException("您申请的会议室与其他人的申请有冲突，请重新申请！");
		}		
		
		apply.setRoom(
				(MeetingRoom)getSession()
				.createQuery("from MeetingRoom ap where ap.sn = ?")
				.setParameter(0, sn)
				.uniqueResult()
		);		
		getHibernateTemplate().update(apply);
	}

	public List searchAllRooms() {
		return getHibernateTemplate().find("from MeetingRoom");
	}

	public List searchApplies(Date begin, Date end) {
		return getSession().createQuery(
				"select a from MeetingRoomApply a where (a.beginDate between :begin and :end ) " +
				"or (a.endDate between :begin and :end)"
			)
			.setParameter("begin", begin)
			.setParameter("end", end)
			.list();
	}

}
