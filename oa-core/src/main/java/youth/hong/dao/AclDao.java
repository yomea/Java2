package youth.hong.dao;

import java.util.List;

import youth.hong.entity.Module;

public interface AclDao {
	
	/**
	 * ��Ȩ���
	 * @param principalType ��������
	 * @param principalSn �����ʶ
	 * @param resourceSn ��Դ��ʶ
	 * @param permission Ȩ�ޣ�C/R/U/D
	 * @param yes �Ƿ�����true��ʾ����false��ʾ������
	 */
	public void addOrUpdatePermission(
			String principalType,
			int principalSn,
			int resourceSn,
			int permission,
			boolean yes
	);
	
	/**
	 * ɾ����Ȩ
	 * @param principalType
	 * @param principalSn
	 * @param resourceSn
	 */
	public void delPermission(
			String principalType,
			int principalSn,
			int resourceSn			
	);
	
	/**
	 * ��ӻ�����û��ļ̳�����
	 * @param userId �û���ʶ
	 * @param resourceSn ��Դ��ʶ
	 * @param yes true��ʾ�̳�,false��ʾ���̳�
	 */
	public void addOrUpdateUserExtends(int userId,int resourceSn,boolean yes);
	
	/**
	 * �ж��û���ĳģ���ĳ��������Ȩ�����������
	 * @param userId �û���ʶ
	 * @param reourceSn ��Դ��ʶ
	 * @param permission Ȩ�ޣ�C/R/U/D��
	 * @return ����true��������false��
	 */
	public boolean hasPermission(int userId,int reourceSn,int permission);
	
	/**
	 * ����ĳ���û�ӵ�ж�ȡȨ�޵�ģ���б����ڵ�¼���γɵ����˵���ʱ��
	 * @param userId �û���ʶ
	 * @return ģ���б����б��Ԫ����Module����
	 */
	public List<Module> searchModules(int userId);
}
