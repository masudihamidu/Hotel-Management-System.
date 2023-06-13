/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author I.A.T COMPUTERS LLC
 */
public class AdminstratorDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminstratorDashboard
     */
    DBConnection conn = new DBConnection();
    Room room = new Room();
    public AdminstratorDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Adminstrator dashboard");
         
        String sqlQuery = "SELECT roomNumber,room_amount,roomType FROM room";
        
        try {
            ResultSet result = conn.statment.executeQuery(sqlQuery);
            while(result.next()) //data will be added while the true
            {
                room.setRoomNumber(result.getInt("roomNumber"));
                room.setRoomAmount(result.getDouble("room_amount"));
                room.setRoomType(result.getString("roomType"));           
             
                String ArraytableData[] = {String.valueOf(room.getRoomNumber()),String.valueOf(room.getRoomAmount()),room.getRoomType()};
                
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuAddRoom = new javax.swing.JMenu();
        menuEditRoom = new javax.swing.JMenu();
        menuDeleteRoom = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\I.A.T COMPUTERS LLC\\Documents\\NetBeansProjects\\HotelManagementSystem\\logout.png")); // NOI18N
        jButton1.setText("logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room number", "Room amount", "Room type"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        jButton2.setText("Show room details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        menuAddRoom.setText("Add room");
        menuAddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAddRoomMouseClicked(evt);
            }
        });
        menuAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddRoomActionPerformed(evt);
            }
        });
        menuBar.add(menuAddRoom);

        menuEditRoom.setText("Edit room");
        menuBar.add(menuEditRoom);

        menuDeleteRoom.setText("Delete room");
        menuDeleteRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDeleteRoomMouseClicked(evt);
            }
        });
        menuBar.add(menuDeleteRoom);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(44, 44, 44)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddRoomActionPerformed
        // TODO add your handling code here:
        new addRoom().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuAddRoomActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AdminstratorLoginForm().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuAddRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAddRoomMouseClicked
        // TODO add your handling code here:
        new addRoom().setVisible(true);
        
    }//GEN-LAST:event_menuAddRoomMouseClicked

    private void menuDeleteRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDeleteRoomMouseClicked
        // TODO add your handling code here:
       new DeleteRoom().setVisible(true);
       
    }//GEN-LAST:event_menuDeleteRoomMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                    // TODO add your handling code here:
            DBConnection conn = new DBConnection();
                        
            try {
            int row = tableData.getSelectedRow();
            String value = (tableData.getModel().getValueAt(row, 0).toString());
            String sqlQuery = "DELETE FROM room WHERE roomNumber = '"+value+"'";
            conn.statment.executeUpdate(sqlQuery);
            DefaultTableModel model = (DefaultTableModel)tableData.getModel();
            JOptionPane.showMessageDialog(null,"Data deleted successfully");
        } catch (SQLException ex) {
            Logger.getLogger(AdminstratorDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminstratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminstratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminstratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminstratorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminstratorDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAddRoom;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuDeleteRoom;
    private javax.swing.JMenu menuEditRoom;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
