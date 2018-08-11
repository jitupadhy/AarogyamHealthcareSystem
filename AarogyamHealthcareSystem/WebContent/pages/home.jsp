<%-- 
    Document   : home
    Created on : Aug 2, 2018, 9:55:39 PM
    Author     : IGNITIV0054
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aarogyam Home Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
        %>
        You are not logged in<br/>
        <a href="login.jsp">Please Login</a>
        <%} else {
        %>
        Welcome <%=session.getAttribute("user")%>
        <a href='logout.jsp'>Log out</a>
        <%
            }
        %>
    </body>
</html>
