<%-- 
    Document   : registration
    Created on : Aug 2, 2018, 10:21:53 PM
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
        
        <form method="post" action="Registration">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Full Name</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>                    
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td><input type = "date" name = "dateofbirth">
                    </td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="confirmpass" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="" /></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="" /></td>
                    </tr>                    
                    <tr>
                        <td>Role</td>
                        <td>
                            <select name="role">                                
                                <option value="USER">USER</option>
                                <option value="ADMIN">ADMIN</option>
                                <option value="CUSTOMER">CUSTOMER</option>
                                <option value="OTHERS">OTHERS</option>
                            </select>
                            
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="login.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
