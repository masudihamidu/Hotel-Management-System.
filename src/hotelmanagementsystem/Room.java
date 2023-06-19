/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class Room {
    private int roomNumber;
    private String roomType;
    private Double roomAmount;
    
    public Room(){
        
    }
    
    Room(int roomNumber, String roomType, Double roomAmount){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomAmount = roomAmount;
    }
    
    public void setRoomAmount(Double roomAmount){
        this.roomAmount = roomAmount;
    }
    
    public Double getRoomAmount(){
        return roomAmount;
    }
    
   
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    
   
    public String getRoomType(){
        return roomType;
    }
    
    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
// Object for class object for database connection
    
    DBConnection conn = new DBConnection();
    
//    =================== function for add room =====================================
    public boolean addRoom(int roomNumber, Double roomAmount, String roomType, String sqlQuery){
        this.setRoomNumber(roomNumber);
        this.setRoomAmount(roomAmount);
        this.setRoomType(roomType);
       
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
    
//   ================= function for delete room ===================================
    public boolean deleteRoom(int roomNumber, String sqlQuery){
        this.setRoomNumber(roomNumber);
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
        this.setRoomNumber(roomNumber);
        this.setRoomAmount(roomAmount);
        this.setRoomType(roomType);
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

















