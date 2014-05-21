<%@page import="java.util.ArrayList"%>
<%@page import="com.cmpe226.dao.TelevisionDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Television Details</h1>
	<table align="center" width="100%" border="">
		<tr>
			<td align="center"><h3>Product ID</h3></td>
			<td align="center"><h3>Product Name</h3></td>
			<td align="center"><h3>Product Price</h3></td>
			<td align="center"><h3>Product Description</h3></td>
			<td align="center"><h3>Details</h3></td>
		</tr>
		<%
			if (request.getAttribute("TelevisionDAO") != null) {
				ArrayList<TelevisionDao> television = (ArrayList) request
						.getAttribute("TelevisionDAO");

				for (int i = 0; i < television.size(); i++) {
					out.print("<tr>");
					out.print("<td align=\"center\" width=\"10%\">");

					out.print(television.get(i).getProduct_id());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"20%\">");
					out.print(television.get(i).getName());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					out.print(television.get(i).getPrice());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"40%\">");
					out.print(television.get(i).getDescription());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					// <form name="main1"  align="center" method="get" action="Television">
					//  <input type="submit" name="ter" value="Television" >
					//</form>
					String productid = "'" + television.get(i).getProduct_id()
							+ "'";
					
					out.print("<form action=\"TelevisionDetailServlet\"><input type=\"hidden\" name=\"Details_Television\" value=\""+television.get(i).getProduct_id()+"\">");
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