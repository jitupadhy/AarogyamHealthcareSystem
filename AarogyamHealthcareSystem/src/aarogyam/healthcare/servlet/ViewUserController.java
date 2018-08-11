package aarogyam.healthcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.dao.ViewUserDAO;

public class ViewUserController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		Long empTelephone = Long.parseLong(uname);
		boolean userView = false;
		
		List<EmployeeBean> listEmployeeBean = null;
		
		EmployeeBean loginBean = new EmployeeBean();
		//loginBean.setEmpId(uname);
		loginBean.setEmpTelephone(empTelephone);
		
		ViewUserDAO viewUserDao = new ViewUserDAO();
		
		try {
			listEmployeeBean = viewUserDao.viewUser(loginBean);
			System.out.println(listEmployeeBean.size());
			userView = true;
			System.out.println();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			viewUserDao.closeDBConnections();
		}
		
		if (userView) {
			request.setAttribute("employeeList", listEmployeeBean);  
			request.getRequestDispatcher("ViewUser_Home.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errMessage", "Not Saved");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}

	}

}
