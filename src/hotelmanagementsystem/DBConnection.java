/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *r I.A.T COMPU
 * @authoTERS LLC
 */


public class DBConnection {
    Connection conn;
    Statement statment;
    
    DBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management_system","leocardia","shugi");
            statment = conn.createStatement();                    
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }   
}
