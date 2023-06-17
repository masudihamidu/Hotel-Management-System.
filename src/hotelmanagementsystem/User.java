/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class User{
    private String username;
    private String password;
    private String gender;
    private String id;
    
    User(){
        
    }
    
    User(String username, String password, String gender, String id){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.id = id;
    }
   
    
//    parameter to set useraname
  public void setUsername(String username){
        this.username = username;
    }
    
//    return username
  public  String getUsername(){
        return username;
    }
    
//    parameter to set password
    void setPassword(String password){
        this.password = password;
    }
    
//    return password
    String getPassword(){
        return password;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

//return gender    
    public String getGender(){
        return gender;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
//    return id
    public String getId(){
        return id;
    }
    
//    Encryption method
    public String encryption(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes();
            byte[] hashBytes = md.digest(passwordBytes);
            StringBuilder sb = new StringBuilder();
            for(byte b: hashBytes){
                sb.append(String.format("%02x", b));
            }
            
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

}
    
//    login method
    public boolean login(String username, String password, String sqlStatement){
        DBConnection conn = new DBConnection();
        this.username = username;
        this.password = password;
        
        try{
            ResultSet result = conn.statment.executeQuery(sqlStatement);
            if(result.next()){
                String uname = result.getString("firstname");
                String pwd = result.getString("password");
                
                if((this.username.equals(uname)) && (this.password.equals(pwd))){  
                  new RoomAssistanceDashboard().setVisible(true); 
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

