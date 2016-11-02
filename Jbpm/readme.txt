���JBPM(java Business Process Management)�Ļ������

jPDL - JBPM Process Definition Language

JBPM��Ҫ���̣�
1���������̣�����JPDL��
2���������̣��������ݿ⣩
3���������Ĳ�������ʵ����
4����ͨ��JBPM�Ľӿڣ�����������������
5����ͨ��JBPM�Ľӿڣ����������ĳ���û�������ĵ����������������б�
6����ͨ��JBPM�Ľӿڣ�����ĳ���û��������⽫�������̼�������������
7����ˣ�ֱ������

----------------------------------------------
���ԣ�

1����װJBPM
	- ����Hibernate������
	- ����JBPM������
	 * bsh.jar
	 * jcr-1.0.jar
	 * jbpm-identity.jar
	 * jbpm-jpdl.jar
	- �������ݿ�����
	 * mysql-connector-java-3.1.13-bin.jar
2��������������ļ�
	- Hibernate�����ļ�
	 * �ṩhibernate�����ļ������Դ�config/Ŀ¼�¿��������޸����е����ݿ��������ü��ɣ�
3������������һ�����ģ���Ҫ���������������ġ����������֮����ܽ���
4�����Ƕ���һ��Document���󣬼���hibernateӳ�䣬�����޸�hibernate�����ļ�����ӳ����ӵ��������У��Ա㴴����Ӧ�����ݿ��
5������������������һ�£�
	- �������ݿ��: JbpmConfiguration.getInstance().createSchema();
	- ��������: �ο�process.xml 
	- ��������: 
		* JbpmConfiguration.getInstance() - ����jbpmConfiguration����
		* ProcessDefinition.parseXmlResource(String); - ��ȡ���̶����ļ�������processdefinition����
		* jbpmConfiguration.createJbpmContext(); - ����jbpmContext����
		* context.deployProcessDefinition(definition); - �������̵����ݿ�
		* context.close(); - �ر�context����
	- ��������
	- �����������̰󶨣�����Ҫ��������ʵ����
		* JbpmConfiguration.getInstance() - ����jbpmConfiguration����
		* jbpmConfiguration.createJbpmContext(); - ����jbpmContext����
		* context.setSessionFactory(sessionFactory),��JBPM������е�session��
		* context.getGraphSession().findLatestProcessDefinition("��������");
		* new ProcessInstance(definition); - ��������ʵ��
		* context.save(processInstance); - �洢����ʵ��
		* ��Document�����Long processInstanceId ����
		* context.getSession().load ����������Document����
		* document.setProcessInstanceId - ������ʵ��������
		* processInstance.getContextInstance.createVariable("document",document.getId()) - �󶨹��ĵ�����ʵ��
	- ���Ĵ������ύ����
		* (Document)context.getSession().load(Document.class, 1); - ���ع�����Ϣ
		* context.getProcessInstance(�ӹ����л�ȡ������ʵ��ID); - ����������ʵ��ID��������ʵ��
		* processInstance.getRootToken().signal(); - �������������ߣ��������һ���ڵ㣩
	- ��ʱ�����ǿ��Բ���һ�£��������̵�ǰ�����Ľڵ�
		* processInstance.getRootToken().getNode().getName()
	- ��һ���ڵ��Ӧ���û���¼��Ӧ���ܹ���ѯ���䵱ǰ�������й��ĵȴ���������
		* List tasks = context.getTaskMgmtSession().findTaskInstances("����"); - ���������������б�
		* �б�Ԫ����TaskInstanceʵ��
		* ͨ����taskInstance.getProcessInstance().getContextInstance().getVariable("document"); �����ҵ���󶨵Ĺ���ID
	- ���ҵ���ǰ�������Ӧ�Ĺ���֮�󣬼��ɶ���������������������
		* taskInstance.end();
	- ��ˣ�ֱ������
		* processInstance.hasEnded() - ��������Ѿ������յ㣬�����ý�����true