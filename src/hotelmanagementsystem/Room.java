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
        
}

















