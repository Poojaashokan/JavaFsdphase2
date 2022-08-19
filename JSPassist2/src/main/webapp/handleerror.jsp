<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    pageEncoding="UTF-8" isErrorPage = "true"%>
<!DOCTYPE html
<html>
<head>
<meta charset="ISO-8859-1">
<title>error handling</title>
</head>
<body>
<% exception.printStackTrace(response.getWriter()); %>
<hr>
An exception was generated. Details are above:<br>

</body>
</html>