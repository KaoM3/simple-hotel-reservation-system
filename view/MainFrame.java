/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.HotelReservationSystemController;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Rafael
 */
public class MainFrame extends javax.swing.JFrame {
    HotelReservationSystemController controller;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(HotelReservationSystemController controller) {
        this.controller = controller;
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

        sideButtons1 = new view.SideButtons(controller, this);
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setPreferredSize(new java.awt.Dimension(720, 510));
        setResizable(false);

        // setSize(new java.awt.Dimension(720, 500));
        getContentPane().setPreferredSize(new Dimension(720, 480));
        getContentPane().setLayout(null);
        getContentPane().add(sideButtons1);
        sideButtons1.setBounds(0, 0, 150, 480);
        getContentPane().add(mainPanel);
        mainPanel.setBounds(150, 0, 570, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setMainPanel(JPanel panel) {
        getContentPane().remove(mainPanel);
        mainPanel = panel;
        getContentPane().add(mainPanel);
        mainPanel.setBounds(150, 0, 570, 480);
        
        pack();
    }
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         HotelManager model = new HotelManager();

        //         HotelReservationSystemController controller = new HotelReservationSystemController(model);

        //         new MainFrame(controller).setVisible(true);
        //     }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private view.SideButtons sideButtons1;
    // End of variables declaration//GEN-END:variables
}
