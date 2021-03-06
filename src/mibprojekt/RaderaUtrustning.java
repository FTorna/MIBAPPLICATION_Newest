/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author trnfa
 */
public class RaderaUtrustning extends javax.swing.JFrame {

    private String chosenItem;
    private static String kategori;
    private static String id;
    private static InfDB idb;
    
    public RaderaUtrustning(InfDB idb) {
        initComponents();
        this.idb = idb;
        fyllcbUtrustning();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRadera = new javax.swing.JToggleButton();
        btnCancel = new javax.swing.JToggleButton();
        cbUtrustning = new javax.swing.JComboBox<>();
        lblDeleteEquipment = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRadera.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRadera.setText("Delete");
        btnRadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRadera, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 105, -1));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 105, -1));

        cbUtrustning.setEditable(true);
        getContentPane().add(cbUtrustning, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 170, -1));

        lblDeleteEquipment.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        lblDeleteEquipment.setForeground(new java.awt.Color(255, 255, 255));
        lblDeleteEquipment.setText("Delete Equipment");
        getContentPane().add(lblDeleteEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Blank.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private String getChosenItemID(){
        try{
        id = idb.fetchSingle("SELECT utrustnings_ID FROM utrustning where benamning = '"+ cbUtrustning.getSelectedItem() + "'");
        }   
        catch (Exception e){
        System.out.println("Error");
        }
        return id;
    }
    private void btnRaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaActionPerformed
        getChosenItemID();
        String input = "You are about to delete equipment.";
        new ControlWindow(input, "utrustning").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRaderaActionPerformed
    
     public static boolean deleteUtrustning(){
        getKategori();
        boolean raderad = false;
        try{
            idb.fetchSingle("Delete from utrustning where utrustnings_id = " + id);
            idb.fetchSingle("Delete from " + kategori + " where utrustnings_id = " + id );
            raderad = true;
        }
        catch(Exception e){
            System.out.println("radera error");
        }
        return raderad;
    }
    private static String getKategori(){
        try{
            String isVapen = idb.fetchSingle("SELECT * from vapen where utrustnings_id = " + id);
            String isTeknik = idb.fetchSingle("Select * from teknik where utrustnings_id = " + id);
            String isKommunikation = idb.fetchSingle("Select * from kommunikation where utrustnings_id = " + id);
            
            if(isVapen != null)
                kategori = "vapen";
            else if (isTeknik != null)
                kategori = "teknik";
            else if (isKommunikation != null)
                kategori = "kommunikation";
            else    
                System.out.println("error");
        }
        catch (Exception e){
            System.out.println("InternFelmeddelande:" + e.getMessage());
        }    
        return kategori;        
    }
    private void fyllcbUtrustning() {
        ArrayList<String> allaOmraden;
        try {
            allaOmraden = idb.fetchColumn("Select benamning from utrustning");
            for (String benamning : allaOmraden) {        
                cbUtrustning.addItem(benamning);
            }
        } catch (Exception annatUndantag) {
            JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator.");
            System.out.println("InternFelmeddelande:" + annatUndantag.getMessage());
        }
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
            java.util.logging.Logger.getLogger(RaderaUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaderaUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaderaUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaderaUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaderaUtrustning(idb).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JToggleButton btnCancel;
    private javax.swing.JToggleButton btnRadera;
    private javax.swing.JComboBox<String> cbUtrustning;
    private javax.swing.JLabel lblDeleteEquipment;
    // End of variables declaration//GEN-END:variables
}
