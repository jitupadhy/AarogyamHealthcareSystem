/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.dao;

import aarogyam.healthcare.bean.RegistrationBean;
import aarogyam.healthcare.connection.ConnectToDatabase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manojeet Padhy
 */
public class RegistrationDAO {

	Connection conn = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String userNameDB = "";
	String passwordDB = "";
	String roleDB = "";
	int maxValue = 0;
	boolean isSave = false;
	boolean isUpdate = false;

	public boolean saveUser(RegistrationBean registrationBean) {
		establishingConnection();
		if (conn != null) {
			findingMaximumIDValue();
			try {
				preparedStatement = conn.prepareStatement(
						"insert into aarogyam_emp(id,emp_name,emp_id,emp_pass,emp_mail_id,emp_dob,city,emp_telephone,emp_active_id,emp_role,create_date,update_date) values (?,?,?,?,?,?,?,?,?,?,?,?)");

				preparedStatement.setInt(1, maxValue);
				preparedStatement.setString(2, registrationBean.getEmpName());
				preparedStatement.setString(3, registrationBean.getEmpId());
				preparedStatement.setString(4, registrationBean.getEmpPassword());
				preparedStatement.setString(5, registrationBean.getEmpMailId());
				preparedStatement.setDate(6, java.sql.Date.valueOf(registrationBean.getEmpDOB()));
				preparedStatement.setString(7, registrationBean.getEmpCity());
				preparedStatement.setLong(8, registrationBean.getEmpTelephone());
				preparedStatement.setInt(9, registrationBean.getEmpActiveId());
				preparedStatement.setString(10, registrationBean.getEmpRole());
				preparedStatement.setDate(11, getCurrentDate());
				preparedStatement.setDate(12, getCurrentDate());

				int i = preparedStatement.executeUpdate();

				if (i != 0) {
					isSave = true;

				}
				return isSave;

			} catch (SQLException ex) {
				Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
		return isSave;
	}

	private void findingMaximumIDValue() {
		try {
			String b_code = "SELECT MAX(id) FROM aarogyam_emp";

			statement = conn.createStatement();
			resultSet = statement.executeQuery(b_code);

			while (resultSet.next()) {
				maxValue = resultSet.getInt(1);
				maxValue++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
					System.out.println("Closing prepared Statement ");
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
