/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class HotelManagementSystem extends JFrame{

    /**
     * @param args the command line arguments
     */
    //constructor
    HotelManagementSystem(){
        JButton systemAdmin = new JButton("System admin");
        JButton roomAssistant = new JButton("Room assistant");
        JLabel containerTitle = new JLabel("Hotel management System");
        
        add(systemAdmin);
        add(roomAssistant);
        add(containerTitle);
        
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
