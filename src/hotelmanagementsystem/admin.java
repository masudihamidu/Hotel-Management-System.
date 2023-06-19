/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class Admin extends User {
    
    @Override
    public boolean login(String username, String password, String sqlStatement){
        DBConnection conn = new DBConnection();
        this.setUsername(username);
        this.setPassword(password);
        
        try{
            ResultSet result = conn.statment.executeQuery(sqlStatement);
            if(result.next()){
                String uname = result.getString("username");
                String pwd = result.getString("password");
                
                if((username.equals(uname)) && (password.equals(pwd))){  
                  new AdminstratorDashboard().setVisible(true); 
                  return true;
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Username and password does not match");
                    return false;
                }   
                
            } 
            
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
}
