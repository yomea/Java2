<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin: 0; padding: 0;}
li{style-type:none;}
hr{ margin:10px 0;}
</style>
</head>
<body>
<s:property value="username" default="youth" />
<hr>
<s:property value="name" />
<hr>
${requestScope.name }
<hr>
<s:set var="userpassword" value="'admin'" scope="session" ></s:set><!-- 注意如果你不加‘’那么系统会认为它是个OGNL表达式  -->
<s:property value="#session.userpassword" />
<hr>
<s:bean name="youth.hong.Cat">
	<s:param name="name" value="'hashiqi'"></s:param>
	<%-- <s:debug></s:debug> --%><!-- 在bean标签结束前会将new出来的对象放到栈顶 -->
</s:bean>
<hr>
<s:bean name="youth.hong.Cat" var="cat">
	<s:param name="name" value="'hashiqi'"></s:param>
	
</s:bean>
<hr>
include：<s:include value="include1.html" />
<hr>
<s:include value="include2.html" />
<hr>
<s:fielderror fieldName="name"> </s:fielderror>
<hr>
if else：
<s:set var="age" value="#parameters.age[0]" />
<s:if test="#age < 0" >error age</s:if>
<s:elseif test="#age < 20">too young</s:elseif>
<s:else>ok!</s:else>
<hr>
<s:iterator value="{1,2,3}">
<s:property /> | 
</s:iterator>
<hr>
<s:iterator value="{'aaa','bbb','ccc'}" var="x">
<s:property value="#x" /> | 
</s:iterator>
<hr>
<s:iterator value="#{1:'a',2:'b',3:'c' }">
<s:property value="key" /> | <s:property value="value" />&
</s:iterator>
<hr>
<s:iterator value="#{1:'a',2:'b',3:'c' }" var="x">
<s:property value="#x.key" /> | <s:property value="#x.value" />&
</s:iterator>
<hr>
<s:subset source="{1,2,3}" count="2">
	<s:iterator >
		<s:property/>
	</s:iterator>

</s:subset>
<s:debug></s:debug>
</body>
</html>