package aarogyam.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.dao.DeleteUserDAO;

@SuppressWarnings("serial")
public class DeleteUserController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		boolean userDelete = false;

		EmployeeBean loginBean = new EmployeeBean();
		loginBean.setEmpId(uname);

		DeleteUserDAO deleteUserDao = new DeleteUserDAO();

		try {
			userDelete = deleteUserDao.deleteUser(loginBean);

			if (userDelete) {

				request.getRequestDispatcher("updated.jsp").forward(request, response);
			} else {
				request.setAttribute("errMessage", "Not Saved");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
