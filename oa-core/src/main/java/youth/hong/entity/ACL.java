package youth.hong.entity;

/**
 * ���ʿ����б�
 * @author Administrator
 * @hibernate.class table="T_ACL"
 */
public class ACL {
	
	/**
	 * �������ͣ���ɫ
	 */
	public static final String TYPE_ROLE = "Role";
	
	/**
	 * �������ͣ��û�
	 */
	public static final String TYPE_USER = "User";
	
	/**
	 * ��Ȩ����
	 */
	public static final int ACL_YES = 1;
	
	/**
	 * ��Ȩ������
	 */
	public static final int ACL_NO = 0;
	
	/**
	 * ��Ȩ��ȷ��
	 */
	public static final int ACL_NEUTRAL = -1;
	
	/**
	 * @hibernate.id
	 * 		generator-class="native"
	 */
	private int id;
	
	/**
	 * �������ͣ���ɫ���û�
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private String principalType;
	
	/**
	 * �����ʶ����ɫ��ʶ���û���ʶ
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private int principalSn;
	
	/**
	 * ��Դ��ʶ
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private int resourceSn;
	
	/**
	 * ��Ȩ״̬���������λ��bit������ʾCRUD����
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private int aclState;
	
	/**
	 * ��ʾ�Ƿ�̳У�0��ʾ���̳У�-1��ʾ��ʾ�̳�
	 * @hibernate.property
	 * 		not-null="true"
	 */
	private int aclTriState;

	public int getAclState() {
		return aclState;
	}

	public void setAclState(int aclState) {
		this.aclState = aclState;
	}

	public int getAclTriState() {
		return aclTriState;
	}

	public void setAclTriState(int aclTriState) {
		this.aclTriState = aclTriState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrincipalSn() {
		return principalSn;
	}

	public void setPrincipalSn(int principalSn) {
		this.principalSn = principalSn;
	}

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getResourceSn() {
		return resourceSn;
	}

	public void setResourceSn(int resourceSn) {
		this.resourceSn = resourceSn;
	}
	
	/**
	 * aclʵ�����������Դ����
	 * ��Դ�ʵ��������Ȩ��ĳ�ֲ����Ƿ�����
	 * @param permission ֻ����ȡֵ0,1,2,3
	 *                                                 c,r,u,d
	 *  eg:0��true��ʾ����createȨ�ޣ�0��false��ʾɾ��createȨ��
	 * @param yes true��ʾ����false��ʾ������
	 */
	public void setPermission(int permission,boolean yes){
		int tmp = 1;
		tmp = tmp << permission;
		if(yes){
			aclState |= tmp;
		}else{
			aclState &= ~tmp;
		}
		//1111
		//DURC
	}
	
	/**
	 * ���ACL��Ȩ
	 * @param permission C/R/U/DȨ��
	 * @return ��Ȩ��ʶ������/������/��ȷ��
	 */
	public int getPermission(int permission){
		
		//����̳У��򷵻�δ������Ȩ��Ϣ
		if(aclTriState == 0xFFFFFFFF){
			return ACL_NEUTRAL;
		}
		
		int tmp = 1;
		
		tmp = tmp << permission;
		
		tmp &= aclState;
		
		if(tmp != 0){
			return ACL_YES;
		}
		
		return ACL_NO;
	}
	
	/**
	 * ���ñ���Ȩ�Ƿ��Ǽ̳е�
	 * @param yes true��ʾ�̳У�false��ʾ���̳�
	 */
	public void setExtends(boolean yes){
		if(yes){
			aclTriState = 0xFFFFFFFF;
		}else{
			aclTriState = 0;
		}
	}
}
