<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<%
System.out.println("Hello Manish");
%>
<body>

<p><font color="red"><b>${errorMessage}</b></font></p>
<form action="/spring-mvc/welcome" method="POST">
<label for="name"><b>Enter Your Name</b></label>
<input type="text" name="name" id="name"><b>
&nbsp
<label for="password"><b>Enter Your Password</b></label>
<input type="password" name="password" id="password">
<br><br>
<input type="submit">
</form>
</body>
</html>