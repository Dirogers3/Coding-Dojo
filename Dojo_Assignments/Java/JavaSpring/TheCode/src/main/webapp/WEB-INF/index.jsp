<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
</head>
<body>
	<c:out value="${flashError}"/>
	<form method="POST" action="/validate">
		<h3>What is the Code?</h3>
		<input type="text" name="code" id="code">
    	<button>Try Code</button>
	</form>
</body>
</html>