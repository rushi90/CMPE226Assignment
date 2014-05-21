<%@page import="com.cmpe226.dao.RefrigeratorDao"%>
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

		
			<%
			//out.print("<tr align=\"center\" >");
				if (request.getAttribute("RefrigeratorDAO_Details") != null) {
					RefrigeratorDao refrigeratorDetails = (RefrigeratorDao) request
							.getAttribute("RefrigeratorDAO_Details");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print("<img width=\"25%\" height=\"80%\" align=\"center\" src=\""
							+ refrigeratorDetails.getImage() + "\"");
					out.print("</td>");
					out.print("</tr>");
					
					// Name
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(refrigeratorDetails.getName());
					out.print("</td>");
					out.print("</tr>");
					
					// Price
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(refrigeratorDetails.getPrice());
					out.print("</td>");
					out.print("</tr>");
					
					//Description
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(refrigeratorDetails.getDescription());
					out.print("</td>");
					out.print("</tr>");
					
					//Brand
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(refrigeratorDetails.getBrand());
					out.print("</td>");
					out.print("</tr>");
					
					//color
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(refrigeratorDetails.getColour());
					out.print("</td>");
					out.print("</tr>");
					
					
					//out.print("</tr>");
				}
				
			%>
		
	</table>

</body>
</html>