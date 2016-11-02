oa_07:

公文流转（流程管理）：

1、创建公文流转相关的实体类，并创建数据库表
2、根据对用例的分析，初步建立公文流转相关的接口
3、实现接口
	- 集成JBPM到OA系统（第一步：创建数据库表）
		* 拷贝相关的依赖包到WEB-INF/lib下面(bsh.jar/ jcr-1.0.jar/ jbpm-identity.jar/ jbpm-jpdl.jar)
		* 修改hibernate.cfg.xml，添加JBPM的映射配置，以及缓存属性的配置
		* 因为JBPM中的User对象与OA系统中的User对象名称上有冲突，所以需要
		  修改OA系统中User映射的auto-import属性为"false"。（参考User.hbm.xml）
		* 当修改了User映射的auto-import="false"之后，需要在查询User对象
		  的时候，使用其全路径类名（请参考UserManagerImpl.java）
		* 启动Tomcat，应能正确创建JBPM的所有数据库表
	- 集成JBPM到OA系统（第二步：与Spring集成）
		* 集成JBPM与spring，需要用到第三方的集成包：spring-modules-0.8.zip
		* 将其中的spring-modules-jbpm31.jar拷贝到WEB-INF/lib下面即可
		* 集成JBPM与Spring的方法是：将JbpmConfiguration对象的创建交给Spring来完成
		* 所以，需要在spring配置文件中配置JbpmConfiguration对象的创建
			<!-- 配置JbmpConfiguration -->
			<bean id="jbpmConfiguration" class="org.springmodules.workflow.jbpm31.LocalJbpmConfigurationFactoryBean">
				<property name="configuration" value="classpath:jbpm.cfg.xml"></property>
			</bean>
		* 这时候，需要jbpm.cfg.xml，这是JBPM的配置文件，我们可以从：
		  JBPM_HOME\src\jpdl\org\jbpm目录下拷贝default.jbpm.cfg.xml文件，
		  并重新命名为jbpm.cfg.xml
	- 集成JBPM到OA系统（第三步：如何实现业务逻辑类，请参考WorkflowManagerImpl.java）
		* 用到jbpmConfiguration对象的时候，需要注入 (<property name="jbpmConfiguration" ref="jbpmConfiguration"></property>)
		* 当我们使用JbpmContext对象来操纵JBPM的时候，需要将JbpmContext的HibernateSession对象设置为当前的HibernateSession对象
			private JbpmContext getContext(){
				JbpmContext context = jbpmConfiguration.createJbpmContext();
				context.setSession(getSession());
				return context;
			}
4、实现WorkflowManagerImpl
	- 理解基本的JBPM操作：流程定义、流程实例、任务列表、流向
