<%-- 
    Document   : logout
    Created on : Aug 2, 2018, 9:59:53 PM
    Author     : IGNITIV0054
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            session.setAttribute("user", null);
            session.invalidate();
            response.sendRedirect("home.jsp");
        %>
    </body>
</html>
