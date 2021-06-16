<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Visit Count</title>
</head>
<body>
<h3>You have visited <a href="http://your_server">http://your_server</a> <c:out value="${count}"/> times.</h3>
<h3><a href="http://localhost:8080/your_server/">Test another visit?</a></h3>
</body>
</html>