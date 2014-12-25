<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="java.util.*,il.ac.shenkar.samples.model.*"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
<h1>Available Products</h1>
 <table class="table">
      <th>Id</th><th>Name</th><th>Price</th><th>Quantity</th><th>Purchase</th>
      <% 
      	Collection products = (Collection)request.getAttribute("products");
		Iterator iterator = products.iterator();
		while(iterator.hasNext())
		{
		Product coupon = (Product)iterator.next();
		String _id  = Integer.toString(coupon.getId());
		%>
		<tr>
		<form action="/SimpleWebStore/StoreController/shoppingcart" method="get">
		<td><input type="text" name="c_id" value="<%=coupon.getId()%>"></td>
		<td><%= coupon.getName() %></td>
		<td><%= coupon.getPrice() %></td>
		<td><input type="number" name="quantity" min="0" max="10" value=""></td>
		<td><input type="submit" value="Buy" /></td>
		</form>
		</tr>
	
		<% 
		}

	 %>

   </table>
</head>
<body>

</body>
</html>