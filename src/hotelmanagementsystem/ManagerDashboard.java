/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class ManagerDashboard extends javax.swing.JFrame {
Guest guestDetails = new Guest();
DBConnection conn = new DBConnection();
Room room = new Room();
    /**
     * Creates new form ManagerDashboard
     */
    public ManagerDashboard() {
        initComponents();
        this.setTitle("Room assistance dashboard");
        this.setLocationRelativeTo(null);
        
          String sqlQuery = "SELECT firstname,lastname,nidaId,nationality,phoneNumber,email,"
                + "gender,guest.roomNumber,guest.roomType,check_in_date,check_out_date,"
                + " DATEDIFF(check_out_date,check_in_date) * room_amount AS bill FROM guest JOIN room ON guest.roomNumber = room.roomNumber";
        
        try {
            ResultSet result = conn.statment.executeQuery(sqlQuery);
            while(result.next()) //data will be added while the true
            {
                guestDetails.setUsername(result.getString("firstname"));
                guestDetails.setLastName(result.getString("lastname"));
                guestDetails.setId(result.getString("nidaId"));  
                guestDetails.setNationality(result.getString("nationality")); 
                guestDetails.setPhoneNumber(result.getString("phoneNumber"));
                guestDetails.setEmail(result.getString("email"));
                guestDetails.setGender(result.getString("gender"));
                room.setRoomNumber(result.getInt("roomNumber"));
                room.setRoomType(result.getString("roomType"));
                guestDetails.setCheck_in_date(result.getDate("check_in_date")); 
                guestDetails.setCheck_out_date(result.getDate("check_out_date"));
                int dateDiff = result.getInt("bill");
             
                Object ArraytableData[] = {guestDetails.getUsername(),guestDetails.getLastName(),guestDetails.getId(),guestDetails.getNationality(),guestDetails.getPhoneNumber(),guestDetails.getEmail(),
                                           guestDetails.getGender(), String.valueOf(room.getRoomNumber()),
                                           room.getRoomType(),
                                           String.valueOf(guestDetails.getCheck_in_date()),
                                           String.valueOf(guestDetails.check_out_date),
                                           String.valueOf(dateDiff)};
                
                DefaultTableModel tableModel = (DefaultTableModel) tableData.getModel();
                
//                add array data table into table
                tableModel.addRow(ArraytableData);
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminstratorDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        btnLogOut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First name", "Last name", "NIDA Identity", "Nationality", "Phone number", "Email", "Gender", "Room number", "Room type", "Check in date", "Check out date", "Bill"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        btnLogOut.setBackground(new java.awt.Color(255, 102, 102));
        btnLogOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\I.A.T COMPUTERS LLC\\Documents\\NetBeansProjects\\HotelManagementSystem\\logout.png")); // NOI18N
        btnLogOut.setText("Logout");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\I.A.T COMPUTERS LLC\\Documents\\NetBeansProjects\\HotelManagementSystem\\Print_24x24.png")); // NOI18N
        jButton1.setText("Print report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Manager dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 745, Short.MAX_VALUE)
                        .addComponent(btnLogOut))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(btnLogOut)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new ManagerLoginForm().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         MessageFormat header = new MessageFormat("Hotel management system\n");
        MessageFormat footer = new MessageFormat("Hotel management system 2023");
        try{
           tableData.print(JTable.PrintMode.FIT_WIDTH,header,footer);
            
        }catch(PrinterException e){
            JOptionPane.showMessageDialog(null, "Cannot be print !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
