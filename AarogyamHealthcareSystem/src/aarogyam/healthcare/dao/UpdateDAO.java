package aarogyam.healthcare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import aarogyam.healthcare.bean.RegistrationBean;
import aarogyam.healthcare.connection.ConnectToDatabase;

/**
 *
 * @author Manojeet Padhy
 */

public class UpdateDAO {

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String userNameDB = "";
	String passwordDB = "";
	String roleDB = "";
	int maxValue = 0;
	boolean isSave = false;
	boolean isPasswordUpdate = false;
	boolean isTelephoneUpdate = false;

	public boolean passwordUpdateUser(RegistrationBean registrationBean) {
		// TODO Auto-generated method stub
		establishingConnection();
		if (conn != null) {
			try {
				preparedStatement = conn
						.prepareStatement("update aarogyam_emp set emp_pass = ?, update_date=? where emp_id = ? ");

				preparedStatement.setString(1, registrationBean.getEmpPassword());
				preparedStatement.setDate(2, getCurrentDate());
				preparedStatement.setString(3, registrationBean.getEmpId());

				int i = preparedStatement.executeUpdate();

				if (i != 0) {
					isPasswordUpdate = true;
					return isPasswordUpdate;
				}
				return isPasswordUpdate;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return isPasswordUpdate;

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

	public boolean telephoneUpdateUser(RegistrationBean registrationBean) {

		// TODO Auto-generated method stub
		establishingConnection();
		if (conn != null) {
			try {
				preparedStatement = conn
						.prepareStatement("update aarogyam_emp set emp_telephone = ?, update_date=? where emp_id = ? ");

				preparedStatement.setLong(1, registrationBean.getEmpTelephone());
				preparedStatement.setDate(2, getCurrentDate());
				preparedStatement.setString(3, registrationBean.getEmpId());

				int i = preparedStatement.executeUpdate();

				if (i != 0) {
					isTelephoneUpdate = true;
					return isTelephoneUpdate;
				}
				return isTelephoneUpdate;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return isTelephoneUpdate;

	}

	public void closeDBConnections() {

		if (conn != null) {
			try {
				if (resultSet != null) {
					resultSet.close();
					System.out.println("Closing Result Set ");
				}
				if (statement != null) {

					statement.close();
					System.out.println("Closing Statement ");
				}
				if (preparedStatement != null) {

					preparedStatement.close();
				}

				if (conn != null) {
					conn.close();
					System.out.println("Closing Connection ");
				}
			} catch (SQLException ex) {
				Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

}
