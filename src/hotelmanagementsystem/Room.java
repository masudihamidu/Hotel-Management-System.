/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class Room implements roomInterface{
    private int roomNumber;
    private String roomType;
    private Double roomAmount;
    
    Room(){
        
    }
    
    @Override
    public void setRoomAmount(Double roomAmount){
        this.roomAmount = roomAmount;
    }
    
    @Override
    public Double getRoomAmount(){
        return roomAmount;
    }
    
    @Override
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }
    
    @Override
    public String getRoomType(){
        return roomType;
    }
    
    @Override
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }
    
    @Override
    public int getRoomNumber(){
        return roomNumber;
    }
}

















