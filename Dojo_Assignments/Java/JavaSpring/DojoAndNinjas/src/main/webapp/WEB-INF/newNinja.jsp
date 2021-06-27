<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="/newNinja" method="post" modelAttribute="ninja">
			<p>
		        <form:label path="dojo">Dojo:</form:label>
		        <form:errors path="dojo"/>
		        <form:select path="dojo">
   					<c:forEach items="${dojos}" var="dojo">
   			    		<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
		    		</c:forEach>
 			 	</form:select>
		    </p>
		    <p>
		        <form:label path="firstname">First Name:</form:label>
		        <form:errors path="firstname"/>
		        <form:textarea path="firstname"/>
		    </p>
		    <p>
		        <form:label path="lastname">Last Name:</form:label>
		        <form:errors path="lastname"/>
		        <form:input path="lastname"/>
		    </p>
		    <p>
		        <form:label path="age">Age:</form:label>
		        <form:errors path="age"/>
		        <form:input path="age"/>
		    </p>
		    <input type="submit" value="Create"/>
	</form:form>
</body>
</html>