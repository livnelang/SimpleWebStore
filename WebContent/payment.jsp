<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Shopping Cart Store</title>
</head>
<body>
<%
double total = (Double)request.getAttribute("total_price");
%>
<h1>Total Price Order: <%=total%> </h1>


</body>
</html>