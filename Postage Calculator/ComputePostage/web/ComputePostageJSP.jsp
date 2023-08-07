
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- ComputePostageJSP.jsp -->
<html>
<head>
<title>Postage Payment Calculator</title>
</head>
<body>
    
<!-- Import postage file from package so that we can simplify the jsp program -->
<%@ page import = "ImportFiles.Postage" %>

<!-- Use java bean of postage type and use * to set all properties -->
<jsp:useBean id="postage" class="ImportFiles.Postage"></jsp:useBean>
<jsp:setProperty name="postage" property="*" />

<!-- call postage function to get all needed values -->
Length (Inches): <%= postage.getLength() %><br>
Width (Inches): <%= postage.getWidth() %><br>
Height (Inches): <%= postage.getHeight() %><br>

Weight (Pounds): <%= postage.getWeight() %><br>
Zone (Should be a number from 1-4): <%= postage.getZone() %><br>
<b>Postage Payment: <%= postage.getPostagePayment() %><br></b>

</body>
</html>
