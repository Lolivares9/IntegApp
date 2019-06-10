/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author wilson
 */
public class dbConn {
 static Connection conn=null;
    public static Connection getConn(){
    
        try {
          conn = DriverManager.getConnection("jdbc:sqlite:employee.sqlite");
          return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
   
    }  
}
