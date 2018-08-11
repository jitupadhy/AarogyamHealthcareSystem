<%-- 
    Document   : Admin
    Created on : Aug 4, 2018, 2:27:55 PM
    Author     : IGNITIV0054
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
    <center><h2>Admin's Home</h2></center>

    Welcome <%=request.getAttribute("userName")%>
    <br/>
    <a href="registration.jsp">Registration Page</a><br/>
    <a href="UpdateContactNumber.jsp">Update Contact Details Page</a><br/>
    <a href="UpdatePassword.jsp">Update Password Page</a></br>
    <a href="deleteUser.jsp">Delete User</a></br>
    <a href="ViewUser_Home.jsp">View User</a></br>
    <a href="registration.jsp">Logout</a>
    
    <div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
    </body>
</html>
