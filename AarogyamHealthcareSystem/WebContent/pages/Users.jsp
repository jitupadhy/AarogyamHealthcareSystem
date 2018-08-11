<%-- 
    Document   : Users
    Created on : Aug 4, 2018, 2:30:12 PM
    Author     : IGNITIV0054
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User's Page</title>
    </head>
    <body>
    <center><h2>User's Home</h2></center>

    Welcome <%=request.getAttribute("userName")%>

    <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

    </body>
</html>
