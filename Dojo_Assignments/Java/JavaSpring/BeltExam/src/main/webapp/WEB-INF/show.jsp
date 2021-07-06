<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	body {
		padding:20px;
	}
</style>
<title>${task.name}</title>
</head>
<body>
	<h1>Task: ${task.name}</h1>
	<p>Creator: ${task.user.name}</p>
	<p>Assignee: ${task.assignee}</p>
	<p>Priority: ${task.priority}</p>
	<a class="btn btn-primary" href="/edit/${task.id}" class="btn btn-primary">Edit</a>
	<a class="btn btn-danger" href="/delete/${task.id}" class="btn btn-primary">Delete</a>
	<br />
	<a class="btn btn-primary" href="/completed/${task.id}" class="btn btn-primary">Completed</a>
</body>
</html>