<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Page</title>
</head>
<body>
	<h1>Burbank Location Ninjas</h1>
	<table>
	<thead>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Age</td>

		</tr>
	</thead>
	<tbody>
	 	<c:forEach items="${ninjas}" var="ninja">
	        <tr>
	            <td><c:out value="${ninja.firstname}"/></td>
	            <td><c:out value="${ninja.lastname}"/></td>
	            <td><c:out value="${ninja.age}"/></td>
	        </tr>
        </c:forEach>
	</tbody>
</table>
</body>
</html>