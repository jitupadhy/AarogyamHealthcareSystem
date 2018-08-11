/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aarogyam.healthcare.bean.RegistrationBean;
import aarogyam.healthcare.dao.RegistrationDAO;

/**
 *
 * @author Manojeet Padhy
 */
@SuppressWarnings("serial")
public class RegistrationController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String confirmPass = request.getParameter("confirmpass");
		String telephone = request.getParameter("telephone");
		Long empTelephone = Long.parseLong(telephone);
		String city = request.getParameter("city");
		String role = request.getParameter("role");

		String dateString = request.getParameter("dateofbirth");

		RegistrationBean registrationBean = new RegistrationBean();
		registrationBean.setEmpName(fullName);
		registrationBean.setEmpId(uname);
		registrationBean.setEmpPassword(pass);
		registrationBean.setEmpMailId(email);
		registrationBean.setEmpTelephone(empTelephone);
		registrationBean.setEmpActiveId(1);
		registrationBean.setEmpCity(city);
		registrationBean.setEmpRole(role);

		registrationBean.setEmpDOB(dateString);
		registrationBean.setEmpCreateDate(currentDate);
		registrationBean.setEmpUpdateDate(currentDate);

		RegistrationDAO registrationDao = new RegistrationDAO();

		try {
			boolean userSave = registrationDao.saveUser(registrationBean);

			if (userSave) {
				request.getRequestDispatcher("registered.jsp").forward(request, response);
			} else {
				request.setAttribute("errMessage", "Not Saved");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			registrationDao.closeDBConnections();

		}

	}

}
