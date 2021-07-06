<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Task</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	body {
		padding:20px;
	}
</style>
</head>
<body>

	<form:form class="form" action="/newTask" method="post" modelAttribute="task">
		<input type="hidden" name="_method" value="put">
		<form:input type="hidden" path="user" value="${user.id}"/>
		<p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name" class="text-danger"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	    	<form:label path="assignee">Assignee:</form:label>
		    <form:errors path="assignee"/>
	        <form:select path="assignee">
				<c:forEach items="${users}" var="user">
		    		<form:option value="${user.name}"><c:out value="${user.name}"/></form:option>
	    		</c:forEach>
		 	</form:select>
		</p>
	    <p>
	    	<form:label path="priority">Priority:</form:label>
		    <form:errors path="priority"/>
	        <form:select path="priority">
		    		<form:option value="Low"><c:out value="Low"/></form:option>
		    		<form:option value="Medium"><c:out value="Medium"/></form:option>
		    		<form:option value="High"><c:out value="High"/></form:option>
		 	</form:select>
		</p>
	    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>