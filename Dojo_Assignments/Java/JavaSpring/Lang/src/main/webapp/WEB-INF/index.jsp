<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<td>Name</td>
			<td>Creator</td>
			<td>Version</td>
			<td>action</td>
		</tr>
	</thead>
	<tbody>
	 	<c:forEach items="${langs}" var="lang">
	        <tr>
	            <td><c:out value="${lang.name}"/></td>
	            <td><c:out value="${lang.creator}"/></td>
	            <td><c:out value="${lang.version}"/></td>
	        </tr>
        </c:forEach>
	</tbody>
</table>
<form:form action="/langs" method="post" modelAttribute="lang">
		<p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator:</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version:</form:label>
	        <form:errors path="version"/>
	        <form:input path="version"/>
	    </p>
	    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>