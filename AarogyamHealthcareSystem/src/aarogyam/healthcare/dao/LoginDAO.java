/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.dao;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.connection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manojeet Padhy
 */
public class LoginDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String userNameDB = "";
	String userFullNameDB = "";
	String passwordDB = "";
	String roleDB = "";
	int empActiveId = 0;

	public LoginDAO() {
		// System.out.println(conn);
	}

	public String authenticateUser(EmployeeBean loginBean) {
		if (conn != null) {
			try {
				// System.out.println(conn);
				conn.close();
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		}

		if (conn == null) {
			conn = ConnectToDatabase.connectToDb();
		}

		String userName = loginBean.getEmpId();
		String password = loginBean.getEmpPassword();
		if (conn != null) {
			try {
				statement = conn.createStatement();
				resultSet = statement
						.executeQuery("select emp_id,emp_name,emp_pass,emp_role,emp_active_id from aarogyam_emp ");

				while (resultSet.next()) {
					if (userName.equals(resultSet.getString("emp_id"))) {
						userNameDB = resultSet.getString("emp_id");
						userFullNameDB = resultSet.getString("emp_name");
						passwordDB = resultSet.getString("emp_pass");
						roleDB = resultSet.getString("emp_role");
						empActiveId = resultSet.getInt("emp_active_id");
						loginBean.setEmpRole(roleDB);
						loginBean.setEmpName(userFullNameDB);
						loginBean.setEmpActiveId(empActiveId);
						break;
					}

				}
			} catch (SQLException ex) {
				System.out.println(ex);
			}

			if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("ADMIN")
					&& empActiveId > 0) {
				return "Admin_Role";
			} else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("USER")
					&& empActiveId > 0) {
				return "User_Role";
			} else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("CUST")
					&& empActiveId > 0) {
				return "Cust_Role";
			} else if (empActiveId == 0) {
				return "Inactive User";
			}

		}
		return "Invalid user credentials";

	}

	public void CloseConnections() {
		try {
			if (resultSet != null) {
				resultSet.close();
				System.out.println("Closing Result Set ");
			}
			if (statement != null) {
				statement.close();
				System.out.println("Closing Statement ");
			}
			if (conn != null) {
				conn.close();
				System.out.println("Closing Connection ");
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
