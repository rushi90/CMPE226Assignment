<%@page import="com.cmpe226.dao.NailPolishDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Nail Polish Details</h1>
	<table align="center" width="100%" border="">

		
			<%
			//out.print("<tr align=\"center\" >");
				if (request.getAttribute("NailPolishDAO_Details") != null) {
					NailPolishDao bookDetails = (NailPolishDao) request.getAttribute("NailPolishDAO_Details");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print("<img width=\"40%\" height=\"50%\" align=\"center\" src=\""
							+ bookDetails.getImage() + "\"");
					out.print("</td>");
					out.print("</tr>");
					
					// Name
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getName());
					out.print("</td>");
					out.print("</tr>");
					
					// Price
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getPrice());
					out.print("</td>");
					out.print("</tr>");
					
					//Description
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getDescription());
					out.print("</td>");
					out.print("</tr>");
					
					//Brand
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getBrand());
					out.print("</td>");
					out.print("</tr>");
					
					//Color
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getColour());
					out.print("</td>");
					out.print("</tr>");
					
					//Weight
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getWeight());
					out.print("</td>");
					out.print("</tr>");
					//out.print("</tr>");
				}
				
			%>
		
	</table>


</body>
</html>