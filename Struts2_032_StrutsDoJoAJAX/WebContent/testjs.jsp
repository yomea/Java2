<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>  
<script type="text/javascript">
var a = document.createElement("table");
a.border = 1;
var caption = a.createCaption();
a.style.backgroundColor = "#ddd";
var books = ['a','b','c'];
for(var i = 0; i < books.length; i++) {
	var tr = a.insertRow(i);
	var td = tr.insertCell(0);
	td.innerHTML = books[i];
}
document.body.appendChild(a);
</script>
<div>ksadigfshdiufhiu</div>
<s:property value="data"/>
<s:debug></s:debug>
   