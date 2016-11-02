package com.bjsxt.oa.managers.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjsxt.oa.managers.InitSystemDatas;
import com.bjsxt.oa.managers.OrgManager;
import com.bjsxt.oa.managers.SystemException;
import com.bjsxt.oa.managers.UserManager;
import com.bjsxt.oa.model.ACL;
import com.bjsxt.oa.model.Module;
import com.bjsxt.oa.model.Organization;
import com.bjsxt.oa.model.Permission;
import com.bjsxt.oa.model.Person;
import com.bjsxt.oa.model.Role;
import com.bjsxt.oa.model.User;

public class InitSystemDatasImpl extends AbstractManager implements
		InitSystemDatas {
	private static Log logger = LogFactory.getLog(InitSystemDatasImpl.class);
	private String file;
	private OrgManager orgManager;
	private UserManager userManager;
	
	public void addOrUpdateInitDatas(String xmlFilePath){
		try {
			String filePath = null;
			if(xmlFilePath == null || xmlFilePath.trim().equals("")){
				filePath = file;
			}else{
				filePath = xmlFilePath;
			}
			
			//DOM4Jʹ��ʾ��
			Document document = new SAXReader().read(
				Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)
			);
			
			importModules( document.selectNodes("//Modules/Module") ,null);
			importRoleAndAcl(document.selectNodes("//Roles/Role"));
			importOrgAndPerson(document.selectNodes("//Organizations/Org"),null);

		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException("��ʼ��������������");
		}
	}

	
	//����ģ����Ϣ
	protected void importModules(List modules,Module parent){
		
		for (Iterator iter = modules.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Module module = new Module();
			module.setName(element.attributeValue("name"));
			module.setSn(element.attributeValue("sn"));
			module.setUrl(element.attributeValue("url"));
			module.setOrderNo(Integer.parseInt(element.attributeValue("orderNo")));
			module.setParent(parent);
			getHibernateTemplate().save(module);
			logger.info("����ģ�顾"+module.getName()+"��");
			importModules( element.selectNodes("Module") , module);
		}
	}
	
	protected void importRoleAndAcl(List roles){
		for (Iterator iter = roles.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Role role = new Role();
			role.setName(element.attributeValue("name"));
			getHibernateTemplate().save(role);
			
			//����ɫ��Ȩ
			List acls = element.selectNodes("Acl");
			for (Iterator iterator = acls.iterator(); iterator.hasNext();) {
				Element aclElem = (Element) iterator.next();
				Integer moduleId = 
					(Integer)getSession()
					.createQuery("select m.id from Module m where m.name = ?")
					.setParameter(0, aclElem.attributeValue("module"))
					.uniqueResult();
				ACL acl = new ACL();
				acl.setPrincipalType(ACL.TYPE_ROLE);
				acl.setPrincipalSn(role.getId());
				acl.setResourceSn(moduleId);
				if("true".equals(aclElem.attributeValue("C"))){
					acl.setPermission(Permission.CREATE, true);
				}
				if("true".equals(aclElem.attributeValue("R"))){
					acl.setPermission(Permission.READ, true);
				}
				if("true".equals(aclElem.attributeValue("U"))){
					acl.setPermission(Permission.UPDATE, true);
				}
				if("true".equals(aclElem.attributeValue("D"))){
					acl.setPermission(Permission.DELETE, true);
				}
				getHibernateTemplate().save(acl);
			}
		}
	}
	
	protected void importOrgAndPerson(List orgs,Organization parent){
		for (Iterator iter = orgs.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Organization org = new Organization();
			org.setName(element.attributeValue("name"));
			orgManager.addOrg(org, parent == null?0:parent.getId());
			
			//���һ����µ���Ա��Ϣ������ʼ��
			List persons = element.selectNodes("Person");
			for (Iterator iterator = persons.iterator(); iterator.hasNext();) {
				Element personElem = (Element) iterator.next();
				Person person = new Person();
				person.setName(personElem.attributeValue("name"));
				person.setOrg(org);
				getHibernateTemplate().save(person);
				
				//����Ա�����½�ʺ�
				User user = new User();
				user.setUsername(personElem.attributeValue("username"));
				user.setPassword(personElem.attributeValue("password"));
				user.setPerson(person);
				getHibernateTemplate().save(user);
				
				//���û������ɫ
				String roles = personElem.attributeValue("roles");
				String[] roleNames = roles.split(",");
				for(int i=0; i<roleNames.length; i++){
					int roleId = 
						(Integer)getSession()
						.createQuery("select r.id from Role r where r.name = ?")
						.setParameter(0, roleNames[i])
						.uniqueResult();
					userManager.addOrUpdateUserRole(user.getId(), roleId, i+1);
				}
			}
			
			//��ʼ���˻����µ��ӻ�����Ϣ
			importOrgAndPerson( element.selectNodes("Org") , org);
		}
	}
	
	
	public void setFile(String file) {
		this.file = file;
	}


	public void setOrgManager(OrgManager orgManager) {
		this.orgManager = orgManager;
	}


	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
