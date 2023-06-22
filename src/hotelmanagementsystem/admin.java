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
//        DBConnection conn = new DBConnection();
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
    
    DBConnection conn = new DBConnection();
    Room room = new Room();
    
    //    =================== function for add room =====================================
    public boolean addRoom(int roomNumber, Double roomAmount, String roomType, String sqlQuery){
        room.setRoomNumber(roomNumber);
        room.setRoomAmount(roomAmount);
        room.setRoomType(roomType);
       
        try{
            boolean b = conn.statment.execute(sqlQuery);
            if(!b){
                JOptionPane.showMessageDialog(null, "Data inserted successful");
                return true;               
            }
            else{
                JOptionPane.showMessageDialog(null, "Ensure inserted data are correctly");
            }                       
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
        
    } 
      //    =================== end function for add room ====================================
    
    
    //   ================= function for delete room ===================================
    public boolean deleteRoom(int roomNumber, String sqlQuery){
        room.setRoomNumber(roomNumber);
        try{
            boolean b = conn.statment.execute(sqlQuery);
            if(!b){
                JOptionPane.showMessageDialog(null, "Data deleted successful");
                return true;               
            }
            else{
                JOptionPane.showMessageDialog(null, "Ensure data you want delete are correctly");
            }                       
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;   
    }   
    
//    ================= end of function delete of room details =====================
    
    
//   =================== function edit of room details =============================
    
     public boolean editRoom(Double roomAmount, String roomType, String sqlQuery){
        room.setRoomAmount(roomAmount);
        room.setRoomType(roomType);
        try{
            boolean b = conn.statment.execute(sqlQuery);
            if(!b){
                JOptionPane.showMessageDialog(null, "Data edited successful");
                return true;               
            }
            else{
                JOptionPane.showMessageDialog(null, "Ensure data you want to edits are correctly");
            }                       
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;   
    }
     
//     =================== end function of edit room details ==========================
    
   
}
