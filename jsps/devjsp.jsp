<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		h2{
			width:100px;
			height:100px;
			background:blue;
		}
	</style>
	<title>firstjsp</title>
</head>
<body>
<h1>testing some shit out</h1>

<h1>pluggin in first val: ${initParam["id1"]}</h1>

<br>

<%
	String x=config.getInitParameter("id2");
	out.println(x);
	int y[]={11,322,33,44};
	request.setAttribute("id2",x);
	request.setAttribute("array",y);
%>
<h1>pluggin in first val: ${requestScope.id2}</h1>

<c:if test="${id2=='poopmehard80'}">
<h1>this is id2 now appended</h1>
</c:if>

<c:forEach var="eles" items="${array}" varStatus="countme">
	${countme.count}..........
	<h2>${eles}</h2>
	<br>
</c:forEach>

<c:choose>
	<c:when test="${num == 10}">
	<p>num > 10</p>
	</c:when>
	<c:when test="${num <10}">
	<p>num < 10</p>
	</c:when>
	<c:otherwise>
	<p>num > 10</p>
	</c:otherwise>
</c:choose>	


<c:set var="number" scope="page">
hello there
</c:set>
<c:remove var="number" scope="page"/>
<!-- <p>this is number after deleting ${pageScope.number}</p> -->

<p>The number using c:set is ${pageScope.number}</p>

<c:import url="welldone.html">
<c:param name="name" value="<from devjsp.jsp>"/>
</c:import>

<br>
</body>
</html>