<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<style>
	.container {
		display:flex;
	}
</style>
</head>
<body>
	<h1>${product.name}</h1>
	<div class="container">
		<div class="left">
			<h2>Categories</h2>
			<ul>
				<c:forEach items="${product.categories}" var="category">
					<li>${category.name}</li>
				</c:forEach>
			</ul>
		</div>
		<div class="right">
		<form:form action="/addCategory" method="post" modelAttribute="addCategory">
			<form:input path="product" type="hidden" value="${product.id}" />
			<form:label path="category">Add Category:</form:label>
		    <form:errors path="category"/>
	        <form:select path="category">
				<c:forEach items="${notCategories}" var="category">
		    		<form:option value="${category.id}"><c:out value="${category.name}"/></form:option>
	    		</c:forEach>
		 	</form:select>
		 	<input type="submit" value="Create"/>
 		</form:form>
		</div>
	</div>
</body>
</html>