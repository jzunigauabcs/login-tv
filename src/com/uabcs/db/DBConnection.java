/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uabcs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jzuniga
 */
public class DBConnection {
    
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String DB = "login?useSSL=false&serverTimezone=UTC";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection; 
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL + DB, USERNAME, PASSWORD);
        return connection;
    }
}
