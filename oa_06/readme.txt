oa_06:

DWR的基本使用：

1、拷贝dwr.jar文件
2、修改web.xml文件，添加dwr servlet配置：
  <servlet>
    <servlet-name>dwr-invoker</servlet-name>
    <servlet-class>org.directwebremoting.servlet.DwrServlet</servlet-class>
    <init-param>
      <param-name>debug</param-name>
      <param-value>true</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>dwr-invoker</servlet-name>
    <url-pattern>/dwr/*</url-pattern>
  </servlet-mapping> 
3、在web-inf下面添加dwr.xml配置文件：
4、创建页面
需引入以下javascript：

<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/interface/test.js"></script>

具体的使用测试，请参考dwrtest项目！

----------------------------------------------------------------
权限管理的实现：

1、登录之后，根据当前登录人员的权限，列出其拥有权限的所有模块（参考IndexAction.java/back_index.jsp）
2、只有登录之后，才可以访问后台模块（抽象出BaseAction来做统一的登录认证）
	- 覆盖execute方法，在这个方法里做登录认证
3、实现即时认证（即只有拥有相应的权限，才能做相应的操作）
	- 定义JSTL函数（参考SecurityFunctions.java）
	- 在JSP页面上，调用JSTL函数做即时认证，只有通过认证之后，才显示相应的功能按钮
