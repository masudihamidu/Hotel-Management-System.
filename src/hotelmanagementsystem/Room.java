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
public class Room {
    int roomNumber;
    String roomType;
    private Double roomAmount;
    
    Room(){
        
    }
    
    public void setRoomAmount(Double roomAmount){
        this.roomAmount = roomAmount;
    }
    
    public Double getRoomAmount(){
        return roomAmount;
    }
}
