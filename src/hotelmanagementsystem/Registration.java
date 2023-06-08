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
public class Registration extends User{
    private String lastName;
    private String registrationNumber;
    private String email;
    private String phoneNumber;
        
    Registration(){
        
    }
        
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
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
        
}
