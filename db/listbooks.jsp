<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.chill.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>List books</title>
</head>
<body>
<table>
	<c:forEach var="count" items="${requestScope.list}">
	<tr>
		<td>${count.id}</td>
		<td>${count.author}</td>
		<td>${count.name}</td>
	</tr>
	</c:forEach>
	<!-- <%
			LinkedList<book> temp=(LinkedList<book>)request.getAttribute("list");
			out.println(temp);
	%> -->

</table>


</body>
</html>