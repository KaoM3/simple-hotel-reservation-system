/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.HotelReservationSystemController;
import java.awt.Dimension;
/**
 *
 * @author Rafael
 */
public class SideButtons extends javax.swing.JPanel {
    HotelReservationSystemController controller;
    MainFrame frame;

    /**
     * Creates new form SideButtons
     */
    public SideButtons(HotelReservationSystemController controller, MainFrame frame) {
        this.controller = controller;
        this.frame = frame;
        this.setPreferredSize(new Dimension(150, 480));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        manageButton = new javax.swing.JButton();
        bookButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(150, 480));
        setLayout(null);

        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        add(createButton);
        createButton.setBounds(20, 40, 110, 60);

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        add(viewButton);
        viewButton.setBounds(20, 150, 110, 60);

        manageButton.setText("Manage");
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
            }
        });
        add(manageButton);
        manageButton.setBounds(20, 260, 110, 60);

        bookButton.setText("Book");
        add(bookButton);
        bookButton.setBounds(20, 370, 110, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        frame.setMainPanel(new CreateHotel(controller));
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        frame.setMainPanel(new HotelListViewPanel(controller));

    }//GEN-LAST:event_viewButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manageButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton manageButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
