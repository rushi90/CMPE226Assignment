<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.cmpe226.dao.BooksDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Book Details</h1>
	<table align="center" width="100%" border="">
		<tr>
			<td align="center"><h3>Product ID</h3></td>
			<td align="center"><h3>Product Name</h3></td>
			<td align="center"><h3>Product Price</h3></td>
			<td align="center"><h3>Product Description</h3></td>
			<td align="center"><h3>Details</h3></td>
		</tr>
		<%
			if (request.getAttribute("BookDAO") != null) {
				ArrayList<BooksDao> book = (ArrayList) request
						.getAttribute("BookDAO");

				for (int i = 0; i < book.size(); i++) {
					out.print("<tr>");
					out.print("<td align=\"center\" width=\"10%\">");

					out.print(book.get(i).getProduct_id());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"20%\">");
					out.print(book.get(i).getName());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					out.print(book.get(i).getPrice());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"40%\">");
					out.print(book.get(i).getDescription());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					// <form name="main1"  align="center" method="get" action="Television">
					//  <input type="submit" name="ter" value="Television" >
					//</form>
					String productid = "'" + book.get(i).getProduct_id()
							+ "'";
					
					out.print("<form action=\"BookDetailServlet1\"><input type=\"hidden\" name=\"Details_book\" value=\""+book.get(i).getProduct_id()+"\">");
					out.print("<input type=\"submit\" value=\"Details\">");
					out.print("</input>");
					out.print("</form>");
					//out.print("<a href=\"TelevisionDetails.jsp\"><input type=\"button\" value=\"\"/></a>");
					out.print("</td>");
					out.print("</tr>");
				}

			}
		%>
	</table>
	<p>Data FromServlet:</p>
</body>
</html>