<%@page import="com.cmpe226.dao.RefrigeratorDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Refrigerator Details</h1>
	<table align="center" width="100%" border="">
		<tr>
			<td align="center"><h3>Product ID</h3></td>
			<td align="center"><h3>Product Name</h3></td>
			<td align="center"><h3>Product Price</h3></td>
			<td align="center"><h3>Product Description</h3></td>
			<td align="center"><h3>Details</h3></td>
		</tr>
		<%
			if (request.getAttribute("refrigeratorDAO") != null) {
				
				ArrayList<RefrigeratorDao> refrigerator = (ArrayList) request
						.getAttribute("refrigeratorDAO");

				for (int i = 0; i < refrigerator.size(); i++) {
					out.print("<tr>");
					out.print("<td align=\"center\" width=\"10%\">");

					out.print(refrigerator.get(i).getProduct_id());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"20%\">");
					out.print(refrigerator.get(i).getName());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					out.print(refrigerator.get(i).getPrice());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"40%\">");
					out.print(refrigerator.get(i).getDescription());
					out.print("</td>");
					out.print("<td align=\"center\" width=\"10%\">");
					// <form name="main1"  align="center" method="get" action="refrigerator">
					//  <input type="submit" name="ter" value="refrigerator" >
					//</form>
					String productid = "'" + refrigerator.get(i).getProduct_id()
							+ "'";
					
					out.print("<form action=\"refrigeratorDetailServlet\"><input type=\"hidden\" name=\"Details_refrigerator\" value=\""+refrigerator.get(i).getProduct_id()+"\">");
					out.print("<input type=\"submit\" value=\"Details\">");
					out.print("</input>");
					out.print("</form>");
					//out.print("<a href=\"refrigeratorDetails.jsp\"><input type=\"button\" value=\"\"/></a>");
					out.print("</td>");
					out.print("</tr>");
				}

			}
		%>
	</table>
	<p>Data FromServlet:</p>
</body>
</html>