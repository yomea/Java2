oa_07:

������ת�����̹�����

1������������ת��ص�ʵ���࣬���������ݿ��
2�����ݶ������ķ�������������������ת��صĽӿ�
3��ʵ�ֽӿ�
	- ����JBPM��OAϵͳ����һ�����������ݿ��
		* ������ص���������WEB-INF/lib����(bsh.jar/ jcr-1.0.jar/ jbpm-identity.jar/ jbpm-jpdl.jar)
		* �޸�hibernate.cfg.xml�����JBPM��ӳ�����ã��Լ��������Ե�����
		* ��ΪJBPM�е�User������OAϵͳ�е�User�����������г�ͻ��������Ҫ
		  �޸�OAϵͳ��Userӳ���auto-import����Ϊ"false"�����ο�User.hbm.xml��
		* ���޸���Userӳ���auto-import="false"֮����Ҫ�ڲ�ѯUser����
		  ��ʱ��ʹ����ȫ·����������ο�UserManagerImpl.java��
		* ����Tomcat��Ӧ����ȷ����JBPM���������ݿ��
	- ����JBPM��OAϵͳ���ڶ�������Spring���ɣ�
		* ����JBPM��spring����Ҫ�õ��������ļ��ɰ���spring-modules-0.8.zip
		* �����е�spring-modules-jbpm31.jar������WEB-INF/lib���漴��
		* ����JBPM��Spring�ķ����ǣ���JbpmConfiguration����Ĵ�������Spring�����
		* ���ԣ���Ҫ��spring�����ļ�������JbpmConfiguration����Ĵ���
			<!-- ����JbmpConfiguration -->
			<bean id="jbpmConfiguration" class="org.springmodules.workflow.jbpm31.LocalJbpmConfigurationFactoryBean">
				<property name="configuration" value="classpath:jbpm.cfg.xml"></property>
			</bean>
		* ��ʱ����Ҫjbpm.cfg.xml������JBPM�������ļ������ǿ��Դӣ�
		  JBPM_HOME\src\jpdl\org\jbpmĿ¼�¿���default.jbpm.cfg.xml�ļ���
		  ����������Ϊjbpm.cfg.xml
	- ����JBPM��OAϵͳ�������������ʵ��ҵ���߼��࣬��ο�WorkflowManagerImpl.java��
		* �õ�jbpmConfiguration�����ʱ����Ҫע�� (<property name="jbpmConfiguration" ref="jbpmConfiguration"></property>)
		* ������ʹ��JbpmContext����������JBPM��ʱ����Ҫ��JbpmContext��HibernateSession��������Ϊ��ǰ��HibernateSession����
			private JbpmContext getContext(){
				JbpmContext context = jbpmConfiguration.createJbpmContext();
				context.setSession(getSession());
				return context;
			}
4��ʵ��WorkflowManagerImpl
	- ��������JBPM���������̶��塢����ʵ���������б�����
