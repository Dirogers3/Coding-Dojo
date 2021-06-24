<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
		<p class="error"><c:out value="${error}"/></p>
		<p>What is the code?</p>
		<form action="/validate" method="POST">
			<input type="text" name="code" id="code" />
			<button>Try Code</button>
		</form>
</body>
</html>