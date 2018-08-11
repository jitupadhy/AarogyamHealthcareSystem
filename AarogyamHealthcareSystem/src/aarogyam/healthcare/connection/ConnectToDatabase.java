/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Manojeet Padhy
 */
public class ConnectToDatabase {

	private static String propertiesFilename;
	private static String url;
	private static String uname;
	private static String password;
	private static String driver;
	static Connection conn = null;

	public ConnectToDatabase() {

	}

	public static Connection connectToDb() {
		// ConnectToDatabase.getProperties();
		try {
			try {
				Class.forName("oracle.jdbc.OracleDriver");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "self_study",
					"self_study");
			System.out.println("Post establishing a DB connection - " + conn);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	private static void getProperties() {
		Properties prop = new Properties();
		propertiesFilename = "dbDetails.properties";
		try (InputStream in = new FileInputStream("dbDetails.properties")) {
			System.out.println("Manojeet");
			prop.load(in);
			url = prop.getProperty("url");
			uname = prop.getProperty("username");
			password = prop.getProperty("password");
			driver = prop.getProperty("driver");

		} catch (IOException e) {
			System.out.println("Manojeet");
			e.printStackTrace();
		}

	}

}
