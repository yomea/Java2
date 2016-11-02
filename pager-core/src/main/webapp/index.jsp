<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Hello World!</h2>
	<!-- 总记录数items，当前页数pager标签的pageNumber -->
	<pg:pager url="http://localhost:8080/index.jsp" items="1001" export="currentPageNumber=pageNumber">
		<!-- 参数名 -->
		<pg:param name="id"/>
		<!-- 首页 -->
		<pg:first>
			<!-- 生成链接 -->
			<a href="${pageUrl }">首页</a>

		</pg:first>
		<pg:prev>
			<a href="${pageUrl }">前一页</a>
		</pg:prev>
		<pg:pages>
			<c:choose>
				<c:when test="${currentPageNumber eq pageNumber }">
					<font color="red">${pageNumber }</font>
				</c:when>
				<c:otherwise>
					<a href="${pageUrl }">${pageNumber }</a>
				</c:otherwise>
			</c:choose>

		</pg:pages>
		<pg:next>
			<a href="${pageUrl }">后一页</a>
		</pg:next>
		<pg:last>
			<a href="${pageUrl }">尾页</a>
		</pg:last>
	</pg:pager>

</body>
</html>
