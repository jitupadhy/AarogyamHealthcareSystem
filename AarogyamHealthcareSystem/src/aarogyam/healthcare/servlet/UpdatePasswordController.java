/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aarogyam.healthcare.bean.RegistrationBean;
import aarogyam.healthcare.dao.UpdateDAO;

/**
 *
 * @author Manojeet Padhy
 */

public class UpdatePasswordController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean userPasswordUpdate = false;

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String confirmPass = request.getParameter("confirmpass");

		RegistrationBean registrationBean = new RegistrationBean();
		registrationBean.setEmpId(uname);
		registrationBean.setEmpPassword(pass);

		UpdateDAO updationDAO = new UpdateDAO();

		try {

			if (pass.equals(confirmPass)) {
				userPasswordUpdate = updationDAO.passwordUpdateUser(registrationBean);
			}

			if (userPasswordUpdate) {
				request.getRequestDispatcher("updated.jsp").forward(request, response);
			} else {
				request.setAttribute("errMessage", "Not Saved");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			updationDAO.closeDBConnections();

		}

	}

}
