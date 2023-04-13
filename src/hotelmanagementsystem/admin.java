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
public class admin extends User {
    private String password;
    
//    setter method for admin password
    void setPassword(String password){
        this.password = password;
    }
    
//    getter method for admin password
    String getPassword(String password){
        return password;
    }
}
