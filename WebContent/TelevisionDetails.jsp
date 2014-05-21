<%@page import="com.cmpe226.dao.TelevisionDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Television Details</title>

</head>
<body>
	<h1 align="center">Television Details</h1>
	<table align="center" width="100%" border="">

		
			<%
			//out.print("<tr align=\"center\" >");
				if (request.getAttribute("TelevisionDAO_Details") != null) {
					TelevisionDao televisionDetails = (TelevisionDao) request
							.getAttribute("TelevisionDAO_Details");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print("<img width=\"25%\" height=\"25%\" align=\"center\" src=\""
							+ televisionDetails.getImage() + "\"");
					out.print("</td>");
					out.print("</tr>");
					
					// Name
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getName());
					out.print("</td>");
					out.print("</tr>");
					
					// Price
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getPrice());
					out.print("</td>");
					out.print("</tr>");
					
					//Description
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getDescription());
					out.print("</td>");
					out.print("</tr>");
					
					//Ratings
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getRatings());
					out.print("</td>");
					out.print("</tr>");
					
					//Resolutions
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getResolution());
					out.print("</td>");
					out.print("</tr>");
					
					//Refresh Rate
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getRefresh_rate());
					out.print("</td>");
					out.print("</tr>");
					
					//Dimension
					out.print("<br>");
					out.print("<tr align=\"center\" >");
					out.print("<td align=\"center\">");
					out.print(televisionDetails.getDimensions());
					out.print("</td>");
					out.print("</tr>");
					
					//out.print("</tr>");
				}
				
			%>
		
	</table>

</body>
</html>