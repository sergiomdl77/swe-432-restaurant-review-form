<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin + "/restaurantForm3";
  </script>
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
    <h1 style="text-align: center"> SWE432 Course Assignments </h1>
    <h3 style="text-align: center">
        Author's Name:  Sergio Delgado </br>
        George Mason University </br>
        SWE 432: Design and Implementation of Software for the Web </br>
        Term: Spring 2020
    </h3>
    <p style="text-align: center">
        Welcome to my Restaurant Review Form Web Application. </br>
        This is a project that implemented my knowledge on servlets, data manipulation and Database data persistence.
    </p>
    <div style="display: flex; align-items: center;	justify-content: center">
        <div> <button style="text-align: center" onclick="window.location.assign(servletURL);"> Open Web App </button> </div>
    </div>
</body>
</html>
