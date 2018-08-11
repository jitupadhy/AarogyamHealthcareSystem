package aarogyam.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import aarogyam.healthcare.bean.EmployeeBean;
import aarogyam.healthcare.connection.ConnectToDatabase;

public class ViewUserDAO {

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

	public List<EmployeeBean> viewUser(EmployeeBean loginBean) {

		List<EmployeeBean> listEmployeeBean = new ArrayList<>();

		try {
			conn = ConnectToDatabase.connectToDb();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (conn != null) {
			try {

				long number = loginBean.getEmpTelephone();

				statement = conn.createStatement();

				resultSet = statement.executeQuery("select * from aarogyam_emp where emp_telephone =" + number);

				int g = 0;

				while (resultSet.next()) {
					EmployeeBean empBean = new EmployeeBean();
					empBean.setId(resultSet.getInt(1));
					empBean.setEmpName(resultSet.getString(2));
					empBean.setEmpId(resultSet.getString(3));
					empBean.setEmpPassword(resultSet.getString(4));
					empBean.setEmpMailId(resultSet.getString(5));
					empBean.setEmpDOB(resultSet.getDate(6));
					empBean.setEmpCity(resultSet.getString(7));
					empBean.setEmpTelephone(resultSet.getLong(8));
					empBean.setEmpActiveId(resultSet.getInt(9));
					empBean.setEmpRole(resultSet.getString(10));
					empBean.setEmpCreateDate(resultSet.getDate(11));
					empBean.setEmpUpdateDate(resultSet.getDate(12));

					listEmployeeBean.add(empBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return listEmployeeBean;

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
