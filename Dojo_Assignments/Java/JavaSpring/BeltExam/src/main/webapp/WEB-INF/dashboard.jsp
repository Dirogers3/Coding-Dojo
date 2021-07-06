<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Manager Dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	.nav {
	display:flex;
	justify-content:space-between;
	}
</style>
</head>
<body>
	<div class="nav">
		<h1>Welcome, ${user.name}</h1>
		<a href="#">Priority H-L</a>
		<a href="#">Priority L-H</a>
		<a href="/logout">Logout</a>
	</div>
	<table class="table">
        <thead>
	        <tr>
		        <th>Task</th>
	            <th>Creator</th>
	            <th>Assignee</th>
	            <th>Priority</th>
	        </tr>
        </thead>
        <tbody>
            <c:forEach items="${allTasks}" var="task">
	        <tr>
	            <td><a href="/tasks/${task.id}"><c:out value="${task.name}"/></a></td>
	            <td><c:out value="${task.user.name}"/></td>
	            <td><c:out value="${task.assignee}"/></td>
	            <td><c:out value="${task.priority}"/></td>
	        </tr>
	        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="/createTask">Create Task</a>
</body>
</html>