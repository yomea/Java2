package com.bjsxt.oa.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DocumentAction extends BaseAction {

	//���Ĺ��������棬��ʾ�ҵĹ����б�
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("index");
	}
	
	/**
	 * �������б���ʾ�ɵ�ǰ��¼��Ա��˵Ĺ����б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approved_list");
	}
	
	/**
	 * �������б���ʾ�ȴ���ǰ��¼��Ա��˵Ĺ����б�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvingList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approving_list");
	}
	
	/**
	 * �ڴ������б��ϣ����ĳ���ĵ������Ե�����������棬�Դ��ĵ���������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approveInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approve_input");
	}
	
	/**
	 * �û�����������Ϣ֮�󣬵�����棬���ĵ�������������
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * ���ҵĹ��Ļ�������б��ϣ�����ύ���ɴ��ύ��ѡ�����
	 * ����������ϣ��г���һ�����п�ѡ�Ĳ��裬�û�����ѡ������һ��
	 * ��������ύ������ϵͳ�������û���ѡ��ת�Ƶ���һ���ڵ�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submitInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("submit_input");
	}
	
	/**
	 * �û�ѡ��������һ�����裬����ύ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward submit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		return mapping.findForward("pub_add_success");
	}
	
	/**
	 * �鿴���ĵ�������ʷ
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward approvedHistory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("approved_history");
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("pub_del_success");
	}
	
	/**
	 * �����ӹ��ĵ�ʱ����Ҫѡ����Ӧ�����̣��˽����г����е������Թ�ѡ��
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward selectFlow(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("flow_list");
	}
	
	/**
	 * ѡ��������֮�󣨼�����������ƣ�����Ҫ�򿪹���¼�����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addInput(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return mapping.findForward("add_input");
	}
	
	
	
}
