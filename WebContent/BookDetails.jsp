<%@page import="com.cmpe226.dao.BooksDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Book Details</h1>
	<table align="center" width="100%" border="">

		
			<%
			//out.print("<tr align=\"center\" >");
				if (request.getAttribute("BookDAO_Details") != null) {
					BooksDao bookDetails = (BooksDao) request.getAttribute("BookDAO_Details");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print("<img width=\"40%\" height=\"75%\" align=\"center\" src=\""
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
					
					//Author
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getAuthor());
					out.print("</td>");
					out.print("</tr>");
					
					//Resolutions
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(bookDetails.getPublisher());
					out.print("</td>");
					out.print("</tr>");
					
					
					//out.print("</tr>");
				}
				
			%>
		
	</table>


</body>
</html>