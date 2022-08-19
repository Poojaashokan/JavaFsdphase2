<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Title here</title>
</head>
<body>
Product Id: <%=session.getAttribute("product_id")%><br><br>

   Product Name: <%= session.getAttribute("product_name")%><br><br>

   Price of Product: <%= session.getAttribute("price")%><br><br>

  Quantity: <%= session.getAttribute("quantity")%><br><br>
</body>
</html>