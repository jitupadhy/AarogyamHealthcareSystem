package aarogyam.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aarogyam.healthcare.bean.RegistrationBean;
import aarogyam.healthcare.dao.UpdateDAO;

public class UpdateMobileNumberController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		boolean userNumberUpdate = false;

		String uname = request.getParameter("uname");
		String umobilenumber = request.getParameter("umobilenumber");
		String confirmumobilenumber = request.getParameter("confirmumobilenumber");

		Long empTelephone = Long.parseLong(confirmumobilenumber);

		RegistrationBean registrationBean = new RegistrationBean();
		registrationBean.setEmpId(uname);
		registrationBean.setEmpTelephone(empTelephone);

		UpdateDAO updationDAO = new UpdateDAO();

		try {

			if (umobilenumber.equals(confirmumobilenumber)) {
				userNumberUpdate = updationDAO.telephoneUpdateUser(registrationBean);
			}

			if (userNumberUpdate) {
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
