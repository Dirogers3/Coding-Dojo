<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
	<h1>${category.name}</h1>
	<div class="container">
		<div class="left">
			<h2>Products</h2>
			<ul>
				<c:forEach items="${products}" var="product">
					<li>${product.name}</li>
				</c:forEach>
			</ul>
		</div>
		<div class="right">
		<form:form action="/addProduct" method="post" modelAttribute="addProduct">
			<form:label path="notProduct">Add Product:</form:label>
		    <form:errors path="notProduct"/>
	        <form:select path="notProduct">
				<c:forEach items="${notProducts}" var="notProduct">
		    		<form:option value="${notProduct.id}"><c:out value="${notProduct.name}"/></form:option>
	    		</c:forEach>
		 	</form:select>
		 	<input type="submit" value="Create"/>
 		</form:form>
		</div>
	</div>
</body>
</html>