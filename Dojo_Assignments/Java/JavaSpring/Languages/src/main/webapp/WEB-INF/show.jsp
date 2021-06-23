<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/languages">Dashboard</a>
	<br><br>
	<h1><c:out value="${language.name}"/></h1>
		<p>Name: <c:out value="${language.name}"/></p>
		<p>Creator: <c:out value="${language.creator}"/></p>
		<p>Version: <c:out value="${language.version}"/></p>

	<a href="/languages/${language.id}/edit">edit</a>
	<form action="/languages/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
</body>
</html>