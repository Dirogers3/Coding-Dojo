<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
<div class="container-main">
	<div class="">
		<h2>Submitted Information:</h2>
		<p>Your name: <c:out value="${name}"/></p>
		<p>Dojo Location: <c:out value="${location}"/></p>
		<p>Favorite Language: <c:out value="${language}"/></p>
		<p>Comments: <c:out value="${comments}"/></p>
	<a href="/">Go Back</a>
	</div>
	
</div>
</body>
</html>
