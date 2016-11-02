oa_09:

实现动态表单的定义
	- 添加FormManager.java
	- 添加FormManagerImpl.java
	- 修改applicationContext-beans.xml，添加对FormManager的配置
	- 修改init_datas.xml，添加动态表单的初始化数据
	- 修改InitSystemDatasImpl.java，导入动态表单的初始化数据
	- 添加FlowFormActionForm.java 以及 AutoArrayList.java
		× 如何批量获取多行数据?
	- 添加FlowFormAction.java
	- 修改struts-config.xml和ApplicationContext-action.xml，添加关于Action的配置
	- 在WebRoot下添加form目录，包含动态表单定义的相关JSP文件
	- 修改WebRoot/workflow/index.jsp，添加定义表单定义的链接

如何开始？
1、
drop database oa;
create database oa;
2、重新运行初始化数据的程序
3、利用流程管理功能，部署一个流程到数据库
4、测试表单定义
