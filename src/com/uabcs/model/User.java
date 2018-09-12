/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uabcs.model;

import com.uabcs.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jzuniga
 */
public class User {
    
       
    private int id;
    private String email;
    private String password;
    public static final String TABLE = "user";  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static User findByEmail(String email) throws ClassNotFoundException, SQLException {
        
        String query = "SELECT * FROM " + User.TABLE + " where email = ?";
        
        Connection connection = DBConnection.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(query);
        pStatement.setString(1, email);
        ResultSet rs = pStatement.executeQuery();
        if(rs.next()) {
            User u = new User();
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            return u;
        }
        return null;
    }
    
    public User login(String email, String password) throws ClassNotFoundException, SQLException {
        User user = User.findByEmail(email);
        if(user != null) {
           if(user.getPassword().equals(password)) {
               
           }
        }
        return null;
    }
}
