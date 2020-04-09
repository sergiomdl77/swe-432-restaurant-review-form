<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Rate Restaurants on Campus - Form Results</title>
        <!-- custom css -->
        <link rel="stylesheet" type="text/css" href="/resources/css/form.css"> 
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css"> 
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.min.css.css">
    </head>
    <%@ page import="java.util.Enumeration" %>
    <body class="container">
        <div class="text-center">
        	<h1>Form Results Page</h1>
        	<p class="font-italic f-09">Thank you for submitting the form.</p>
	   		<table class="table table-bordered table-hover">
	   		<caption>Submitted form information.</caption>
		   		<thead class="thead-light">
		   			<tr>
		   				<th>Parameter Name</th>
		   				<th>Value</th>
		   			</tr>
	   			</thead>
	   			<%
	   			Enumeration<String> parameters = request.getParameterNames();
	   			while (parameters.hasMoreElements()) {
				   String parameterName = parameters.nextElement();
				   String parameterValue = request.getParameter(parameterName);
			    %>
			   <tr>
				   <td><%= parameterName %></td>
				   <td><%= parameterValue %></td>
			   </tr>
			   <%
			   }
			   %>
	   		</table>
		</div>
	</body>
</html>