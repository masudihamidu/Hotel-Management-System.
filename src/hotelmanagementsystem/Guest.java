/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
class Guest extends Employee{
    private String nationality;
    Date check_in_date;
    Date check_out_date;
    
    
    Guest(){
    
    }
    
    Guest(String nationality, Date checkInDate, Date checkOutDate){
        this.nationality = nationality;
        this.check_in_date = checkInDate;
        this.check_out_date = checkOutDate;
    }
    
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    
    public String getNationality(){
        return nationality;
    }
    
    public void setCheck_in_date(Date check_in_date){
        this.check_in_date = check_in_date;
    }
    
    public Date getCheck_in_date(){
        return check_in_date;
    }
    
    public void setCheck_out_date(Date check_out_date){
        this.check_out_date = check_out_date;
    }
    
    public Date getCheck_out_date(){
        return check_out_date;
    }
    
    
    DBConnection conn = new DBConnection();    
    
//    ================== add guest details function ===================================    
    public boolean addGuest(String firstname, String lastname, String nidaId, String nationality, String email, String gender,String phoneNumber,int roomNumber,String roomType,Date checkInDate, Date checkOutDate,String sqlQuery){
        Room room = new Room();
        setUsername(firstname);
        setLastName(lastname);
        setId(nidaId);
        setNationality(nationality);
        setEmail(email);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        room.setRoomNumber(roomNumber);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        room.setRoomType(roomType);
        setCheck_in_date(check_in_date);
        setCheck_out_date(check_out_date);
       
        try{
            boolean b = conn.statment.execute(sqlQuery);
            if(!b){
                JOptionPane.showMessageDialog(null, "Data inserted successful");
                String senderEmail = "masudihmfaume@gmail.com";
                String senderPassword = "vmtx xvwg syrq mvex";
                String host = "smtp.gmail.com";
                String port = "587";

                Email emailSender = new Email(senderEmail, senderPassword, host, port);
                String subject = "Welcome to our hotel!";
                String messageContent = "Dear " + firstname + " "+ lastname+",\n\nWelcome to Hotel ABC\n "
                        + "Your selected room :" +roomNumber+"\n Check in date : "+check_in_date+"\nCheck out date :"+check_out_date;

                emailSender.sendEmail(email, subject, messageContent);
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
//    ===============================   end of add guest function =====================
   
    
//   ================================= delete function ================================
    
        public boolean deleteRoom(String nida, String sqlQuery){
        this.setId(nida);
        try{
            boolean b = conn.statment.execute(sqlQuery);
            if(!b){
                JOptionPane.showMessageDialog(null, "Guest details deleted successful");
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
        
//        ========================== end of delete function ==============================
        
        
           
//   =================== function edit of guest details =============================
    
     public boolean editGuest(String firstname, String lastname, String nidaId, String nationality, String email, String gender,String phoneNumber,int roomNumber,String roomType,Date checkInDate, Date checkOutDate,String sqlQuery){
       Room room = new Room();
        setUsername(firstname);
        setLastName(lastname);
        setId(nidaId);
        setNationality(nationality);
        setEmail(email);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        room.setRoomNumber(roomNumber);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        room.setRoomType(roomType);
        setCheck_in_date(check_in_date);
        setCheck_out_date(check_out_date);
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
     
//     =================== end function of edit guest details ==========================
    
}
