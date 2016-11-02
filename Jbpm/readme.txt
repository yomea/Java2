理解JBPM(java Business Process Management)的基本概念：

jPDL - JBPM Process Definition Language

JBPM简要过程：
1、定义流程（利用JPDL）
2、部署流程（部署到数据库）
3、创建公文并与流程实例绑定
4、可通过JBPM的接口，触发流程向下流动
5、可通过JBPM的接口，获得流动到某个用户那里的文档（即待处理任务列表）
6、可通过JBPM的接口，结束某个用户的任务（这将触发流程继续向下流动）
7、如此，直到结束

----------------------------------------------
测试：

1、安装JBPM
	- 引入Hibernate依赖包
	- 引入JBPM依赖包
	 * bsh.jar
	 * jcr-1.0.jar
	 * jbpm-identity.jar
	 * jbpm-jpdl.jar
	- 引入数据库驱动
	 * mysql-connector-java-3.1.13-bin.jar
2、定义相关配置文件
	- Hibernate配置文件
	 * 提供hibernate配置文件（可以从config/目录下拷贝，并修改其中的数据库连接设置即可）
3、假设现在有一个公文，需要经过：张三、李四、王五的审批之后才能结束
4、我们定义一个Document对象，及其hibernate映射，并将修改hibernate配置文件，将映射添加到其配置中（以便创建相应的数据库表）
5、现在让我们来测试一下：
	- 创建数据库表: JbpmConfiguration.getInstance().createSchema();
	- 定义流程: 参考process.xml 
	- 部署流程: 
		* JbpmConfiguration.getInstance() - 创建jbpmConfiguration对象
		* ProcessDefinition.parseXmlResource(String); - 读取流程定义文件，创建processdefinition对象
		* jbpmConfiguration.createJbpmContext(); - 创建jbpmContext对象
		* context.deployProcessDefinition(definition); - 部署流程到数据库
		* context.close(); - 关闭context对象
	- 创建公文
	- 将公文与流程绑定（即需要创建流程实例）
		* JbpmConfiguration.getInstance() - 创建jbpmConfiguration对象
		* jbpmConfiguration.createJbpmContext(); - 创建jbpmContext对象
		* context.setSessionFactory(sessionFactory),将JBPM与程序中的session绑定
		* context.getGraphSession().findLatestProcessDefinition("流程名称");
		* new ProcessInstance(definition); - 创建流程实例
		* context.save(processInstance); - 存储流程实例
		* 在Document中添加Long processInstanceId 属性
		* context.getSession().load 操作，加载Document对象
		* document.setProcessInstanceId - 绑定流程实例到公文
		* processInstance.getContextInstance.createVariable("document",document.getId()) - 绑定公文到流程实例
	- 公文创建者提交公文
		* (Document)context.getSession().load(Document.class, 1); - 加载公文信息
		* context.getProcessInstance(从公文中获取的流程实例ID); - 即根据流程实例ID加载流程实例
		* processInstance.getRootToken().signal(); - 触发流程往下走（即到达第一个节点）
	- 这时候，我们可以测试一下，看看流程当前所处的节点
		* processInstance.getRootToken().getNode().getName()
	- 第一个节点对应的用户登录，应该能够查询到其当前的任务（有公文等待其审批）
		* List tasks = context.getTaskMgmtSession().findTaskInstances("张三"); - 查找张三的任务列表
		* 列表元素是TaskInstance实例
		* 通过：taskInstance.getProcessInstance().getContextInstance().getVariable("document"); 可以找到其绑定的公文ID
	- 查找到当前的任务对应的公文之后，即可对其审批，并继续往下走
		* taskInstance.end();
	- 如此，直到结束
		* processInstance.hasEnded() - 如果流程已经到达终点，本调用将返回true