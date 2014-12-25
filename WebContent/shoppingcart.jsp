<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="java.util.*,il.ac.shenkar.samples.model.*"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/buttons.js"></script>
<script src="js/jquery-2.1.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<h1>Total Products</h1>

 	  <table class="table">
      <th>Product</th><th>Amount</th><th>Total Price</th>
      <% Map<String,ShoppingCartLine> orders = (Map<String,ShoppingCartLine>)request.getAttribute("lines");
      	 ShoppingCartLine s1=null;
      	 Iterator iterator = orders.entrySet().iterator();
     	 while (iterator.hasNext())
		 {
			 Map.Entry currentline = (Map.Entry) iterator.next();
			 s1 = (ShoppingCartLine)currentline.getValue();
			 %>
			<tr>
			<td><%=s1.getProductName()%></td>
			<td><%= s1.getAmount()%></td>
			<td><%=s1.lineTotalPrice()%></td>
			</tr>
			<% 
		 }
     	 %>
     	 </table>
     	 <br>
     	 <input  type="button" id="back" onclick="oncheck()" value="Back">
     	 <input  type="button" id="check"  value="Checkout">
     	 
 
		 
      
 
      
      
      
      


</head>
<body>

</body>
</html>