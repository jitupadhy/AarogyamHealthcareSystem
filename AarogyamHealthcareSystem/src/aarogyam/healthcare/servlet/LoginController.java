/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.servlet;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Manojeet Padhy
 */
@SuppressWarnings("serial")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pass");

        System.out.println(uname);
        System.out.println(pwd);

        EmployeeBean loginBean = new EmployeeBean();
        loginBean.setEmpId(uname);
        loginBean.setEmpPassword(pwd);

        LoginDAO loginDao = new LoginDAO();

        try {
            String userValidate = loginDao.authenticateUser(loginBean);

            if (userValidate.equals("Admin_Role")) {
                HttpSession session = request.getSession(); //Creating a session
                System.out.println("Users Role : "+loginBean.getEmpRole());
                    session.setAttribute("Admin", uname); //setting session attribute
                    request.setAttribute("userName", loginBean.getEmpName()); 
                    session.setAttribute("user", uname);
                    //request.getRequestDispatcher("Admin_Home.jsp").forward(request, response);
                    request.getRequestDispatcher("Admin.jsp").forward(request, response);
            }
            else if (userValidate.equals("User_Role")) {
                System.out.println("User's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Editor", uname);
                request.setAttribute("userName", uname);
                session.setAttribute("user", uname);
                request.getRequestDispatcher("Users.jsp").forward(request, response);

            }
            else if (userValidate.equals("Cust_Role")) {

            }
            else {
                System.out.println("Error message = " + userValidate);
                request.setAttribute("errMessage", userValidate);

                request.getRequestDispatcher("login_1.jsp").forward(request, response);
            }
            
            System.out.println("Admin's Home");
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally{
            loginDao.CloseConnections();
        }

        
    }

}
