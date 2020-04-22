<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin + "/hello";
    var servletURL2 = window.location.origin + "/twoButtons";
    var servletURL3 = window.location.origin + "/restaurantForm";
    var servletURL4 = window.location.origin + "/restaurantForm2";
    var servletURL5 = window.location.origin + "/restaurantForm3";
  </script>
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>Hello Heroku! I am JSP</h2>
<strong>Current Time is</strong>: <%=new Date() %>
<button onclick="window.location.assign(servletURL);"> Try the Hello servlet </button>
<button onclick="window.location.assign(servletURL2);"> Try the TwoButtons servlet </button>
<button onclick="window.location.assign(servletURL3);"> Try the Restaurant Form (Assignment 6) servlet </button>
<button onclick="window.location.assign(servletURL4);"> Try the Restaurant Form (Assignment 7) ReactJS app </button>
<button onclick="window.location.assign(servletURL5);"> Try the Restaurant Form (Assignment 8) servlet </button>
</body>
</html>
