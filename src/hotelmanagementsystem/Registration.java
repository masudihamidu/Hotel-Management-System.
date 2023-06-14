/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class Registration extends User {
    private String lastName;
    private String registrationNumber;
    private String email;
    private String phoneNumber;
        
    Registration(){
        
    }
        
      
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
     public String getLastName(){
        return lastName;
    }
       
    public void setRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
        
    }
    
    public String getRegistrationNumber(){
        return registrationNumber;
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
        this.setRegistrationNumber(registrationNumber);
        this.setPhoneNumber(phoneNumber);
        this.setPassword(password);
               
        if(username.isEmpty() || lastname.isEmpty() || gender.isEmpty() || registrationNumber.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return registrationSuccess;
        }
        
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
        
//        check password length
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return registrationSuccess;
        }

//        Database connection nad registration logic
        DBConnection conn = new DBConnection();
//        Registration registrationDetails = new Registration();
                
        try{            
            boolean b = conn.statment.execute("INSERT INTO roomassistance(firstname,lastname,gender,registrationNumber,email,phoneNumber,password) VALUES('"+this.getUsername()+"','"+this.getLastName()+"','"+this.getGender()+"','"+getRegistrationNumber()+"','"+getEmail()+"','"+getPhoneNumber()+"','"+getPassword()+"')");
            if(!b){
                JOptionPane.showMessageDialog(null, "Data inserted successful");
                new RoomAssistanceLogin().setVisible(true);
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
