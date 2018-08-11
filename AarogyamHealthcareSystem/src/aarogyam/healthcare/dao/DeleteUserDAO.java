package aarogyam.healthcare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.connection.ConnectToDatabase;

public class DeleteUserDAO {

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String userNameDB = "";
	String passwordDB = "";
	String roleDB = "";
	int maxValue = 0;
	boolean isSave = false;
	boolean isDelete = false;

	public boolean deleteUser(EmployeeBean loginBean) {
		establishingConnection();
		
		if (conn != null) {
			try {
				preparedStatement = conn
						.prepareStatement("update aarogyam_emp set emp_active_id = ?, update_date=? where emp_id = ? ");

				preparedStatement.setInt(1, 0);
				preparedStatement.setDate(2, getCurrentDate());
				preparedStatement.setString(3, loginBean.getEmpId());
				
				int i = preparedStatement.executeUpdate();

				if (i != 0) {
					isDelete = true;
					return isDelete;
				}
				return isDelete;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return isDelete;

	}

	private static Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	private void establishingConnection() {
		if (conn != null) {
			try {
				// System.out.println(conn);
				conn.close();
				conn = ConnectToDatabase.connectToDb();
			} catch (SQLException ex) {
				Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		if (conn == null) {
			conn = ConnectToDatabase.connectToDb();
		}
	}

}
