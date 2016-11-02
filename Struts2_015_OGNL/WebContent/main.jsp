<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:property value="cat.friend.name" />|<s:property value="cat.getFriend().getName()" /><br>
<s:property value="cat.friend.name.length()" /><br>
<s:property value="cat.miaomiao()" /><br>
<s:property value="cat.friend.wangwang()" /><br>
<s:property value="cat.age" /> <br>
<s:property value="getCat().age" /><br>
<s:property value="getCat().getFriend().getName()" /><br>
<s:property value="@youth.hong.S@STR" /><br>
<!-- 访问静态方法需要打开访问静态方法的constant -->
<s:property value="@youth.hong.S@s()" /><br>
<s:property value="test()" /> <br>
<s:property value="@youth.hong.Action@test()" /> <br>
<s:property value="@@max(9,10)" /><br>
<s:property value="@youth.hong.Action@string" /> <br>
<hr>
<s:property value="youth" /><br>
<s:property value="hong" /> <br>
<s:property value="string" /> <br>
<s:property value="@youth.hong.Action@count" /> <br>
<hr>
<s:property value="new youth.hong.Cat()" /><br><!-- 得不到值？？？？ -->
<s:property /><br>
<s:property value="dog" /><br>
<hr>
${sessionScope.cat.getFriend().getName() }<!-- 得不到值 -->
<hr>
${requestScope.cat.getFriend().getName() }
<hr>
<!-- <%-- ${@youth.hong.S@s --%> }出错 -->
<hr>
<%=request.getAttribute("hong") %>
<hr>
<%=request.getParameter("a") %><!-- get/post 中传的值 -->
<hr>
<%=request.getAttribute("a") %><!-- null -->
<hr>
${a }<!-- 不能拿parameter的值 -->
<hr>
<s:property value="#request.a" /><!-- 它不是action的属性拿不到 -->
<hr>
<s:property value="#parameters.a" />
<hr>
<s:property value="dogs" />||${dogs }
<hr>
<s:property value="dogs[0]" />||${dogs[0]}
<hr>
<s:property value="dogs.{name}" /> 
<hr>
<s:property value="dogs.{name}[0]" />
<hr>
<s:property value="dogs[0].name" />||${dogs[0].getName() }||${dogs[0].name }
<hr>
<s:property value="cats[0]" /><!-- set集合的元素这样取不到 -->
<hr>
<s:property value="m" />||${m }
<hr>
<s:property value="m.dog1" />||<s:property value="m['dog1']" />||<s:property value="m[\"dog1\"]" />||||${m.dog1}
<hr>
<s:property value="m.keys" />||${m.keySet() }||<s:property value="m.keySet()" />||<s:property value="m.size" />
<hr>
<s:property value="m.values" />
<hr>
<s:property value="cats" />
<hr>
<s:property value="cats.{?#this.getAge()==1}[0].age" /> <!-- 过滤找出age等于1的user集合在得出第一个age等于1的那个user的age -->
<hr>
<s:property value="cats.{^#this.age>1}" /> <!-- age大于1的cat集合的第一个 -->
<hr>
<s:property value="cats.{$#this.age>1}[0]" /> <!-- age大于1的cat集合的最后一个 -->
<hr>
<s:property value="[0]" />
<hr>
<s:property value="[0].sCount" />
<s:debug></s:debug>
</body>
</html>