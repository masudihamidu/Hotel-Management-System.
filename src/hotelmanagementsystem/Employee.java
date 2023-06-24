/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class Employee extends User {
    private String lastName;
    private String email;
    private String phoneNumber;
        
 
      
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
     public String getLastName(){
        return lastName;
    }
        
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    
    public boolean register(String username, String lastname, String gender, String registrationNumber, String email, String phoneNumber, String password) throws SQLException{
        boolean registrationSuccess  = false;
        this.setUsername(username);
        this.setLastName(lastname);
        this.setGender(gender);
        this.setEmail(email);
        this.setId(registrationNumber);
        this.setPhoneNumber(phoneNumber);
        this.setPassword(password);                         

        
//    check username is empty    
        if(username.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please provide firstname");   
            return registrationSuccess;
        }
        
//        check lastname is empty
        if(lastname.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please provide lastname"); 
           return registrationSuccess;
        }
        
//        check gender is empty
        if(gender.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please provide gender");
            return registrationSuccess;
        }
        
//        check email is empty
        if(email.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please provide email");
            return registrationSuccess;
        }
        
//        check registration number is empty
        if(registrationNumber.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter registration number");   
            return registrationSuccess;
        }
        
//        check phone number is empty
        if(phoneNumber.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please provide phone number");
            return registrationSuccess; 
        }
        
//        check password is empty
        if(password.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please provide password");
            return registrationSuccess; 
        }
        
//        Validate email
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email format.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return registrationSuccess;
        }
        

//        Database connection nad registration logic
        DBConnection conn = new DBConnection();
                
        try{            
            boolean b = conn.statment.execute("INSERT INTO roomassistance(firstname,lastname,gender,registrationNumber,email,phoneNumber,password) VALUES('"+this.getUsername()+"','"+this.getLastName()+"','"+this.getGender()+"','"+this.getId()+"','"+getEmail()+"','"+getPhoneNumber()+"','"+getPassword()+"')");
            if(!b){
                JOptionPane.showMessageDialog(null, "Your registered successful");
                new RoomAssistanceLogin().setVisible(true);
                String senderEmail = "masudihmfaume@gmail.com";
                String senderPassword = "vmtx xvwg syrq mvex";
                String host = "smtp.gmail.com";
                String port = "587";

                Email emailSender = new Email(senderEmail, senderPassword, host, port);
                String subject = "Welcome to our platform!";
                String messageContent = "Dear " + username + " "+ lastname+",\n\nWelcome to hotel management system, that system\nassist you to insert new guest, delete and modify\n"
                        + " guest details.\n\n! Thank you for registering.";

                emailSender.sendEmail(email, subject, messageContent);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error");
            }
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }      
     return registrationSuccess;
    }
    
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
    
            
}
