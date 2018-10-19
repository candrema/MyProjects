
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<form:form action="createUser" method="PUT" modelAttribute="user">
	<form:input type = "text" placeholder = "Email" name = "email"  id = "email" path = "email"/>
	<input type = "text" placeholder = "Verify Email"/>
	<form:input type = "text" placeholder = "Username" name = "username"  id = "username" path = "username"/>
	<form:input type = "password" placeholder = "Password" name = "password"  id = "password" path = "password"/>
	<input type = "password" placeholder = "Verify Password"/>
	<button type= "submit" value ="Submit"></button>
</form:form>

</body>
</html>