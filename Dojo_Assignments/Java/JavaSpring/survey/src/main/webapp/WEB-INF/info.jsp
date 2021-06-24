<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
    <div class="container">
    <h2 class="title">Submitted Info</h2>
            <div class="cols">
                <div class="survey">
                    <label for="name">Your name:</label>
                    <p><c:out value="${name}"/></p>
                </div>
                <div class="survey">
                    <label for="location">Dojo Location:</label>
	                 <p><c:out value="${location}"/></p>
                </div>
                <div class="survey">
                    <label for="language">Favorite Language</label>
                    <p><c:out value="${language}"/></p>
                </div>
            </div>
            <label for="comment">Comment (optional)</label>
            <p><c:out value="${comment}"/></p>
    </div>
</body>
</html>