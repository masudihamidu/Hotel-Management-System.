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
public class User {
    private String username;
    private String password;
    
    User(){
        
    }
    
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    String getUsername(){
        return username;
    }
    
    String getPassword(){
        return password;
    }
    
}
