/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.util.Date;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
class GuestDetails extends Registration{
    private String nationality;
    Date check_in_date;
    Date check_out_date;
    
    
    GuestDetails(){
        
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
        
}
