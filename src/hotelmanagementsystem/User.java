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
    private String gender;
    private String id;
    
    User(){
        
    }
    
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
//    parameter to set useraname
  public void setUsername(String username){
        this.username = username;
    }
    
//    return username
    String getUsername(){
        return username;
    }
    
//    parameter to set password
    void setPassword(String password){
        this.password = password;
    }
    
//    return password
    String getPassword(){
        return password;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }

//return gender    
    public String getGender(){
        return gender;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
//    return id
    public String getId(){
        return id;
    }
}
