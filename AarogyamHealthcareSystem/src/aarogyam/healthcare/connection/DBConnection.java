/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aarogyam.healthcare.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Manojeet Padhy
 */
public class DBConnection {

    private static String propertiesFilename;
    private static String url;
    private static String uname;
    private static String password;
    private static String driver;

    public DBConnection() {
        DBConnection.getProperties();
        DBConnection.createConnection();
    }

    private static void getProperties() {
        Properties prop = new Properties();
        FileInputStream input = null;
        propertiesFilename = "resources/dbDetails.properties";

        try {
            input = new FileInputStream(propertiesFilename);
            prop.load(input);

            url = prop.getProperty("url");
            uname = prop.getProperty("username");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection() {
        Connection con = null;
        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url, uname, "password");
            System.out.println("Post establishing a DB connection - " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

}
