package mibprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trnfa
 */
public class Startsida_Agent extends javax.swing.JFrame {
    private InfDB idb;
    private static String omrade;
    /**
     * Creates new form Startsida
     */
    public Startsida_Agent(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbLoggaUt = new javax.swing.JComboBox<>();
        btnSok = new javax.swing.JButton();
        lblShowRegion = new javax.swing.JLabel();
        cbOmradesChef = new javax.swing.JComboBox<>();
        lblOmradesChef = new javax.swing.JLabel();
        btnRegisterAlien = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtSearchAlien = new javax.swing.JTextField();
        btnSearchAlien = new javax.swing.JButton();
        btnRegisterEquipment = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbLoggaUt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Ändra Lösenord", "Logga ut" }));
        cbLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoggaUtActionPerformed(evt);
            }
        });
        getContentPane().add(cbLoggaUt, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        btnSok.setText("Search for Aliens in Area");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });
        getContentPane().add(btnSok, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 170, -1));

        lblShowRegion.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        lblShowRegion.setForeground(new java.awt.Color(255, 255, 255));
        lblShowRegion.setText("Show region manager in:");
        getContentPane().add(lblShowRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 20));

        cbOmradesChef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Svealand", "Götaland", "Norrland" }));
        cbOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOmradesChefActionPerformed(evt);
            }
        });
        getContentPane().add(cbOmradesChef, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, 20));
        getContentPane().add(lblOmradesChef, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 70, 20));

        btnRegisterAlien.setText("Register Alien");
        btnRegisterAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterAlienActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegisterAlien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 170, -1));

        jButton1.setText("Search for Aliens within Race");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 170, -1));
        getContentPane().add(txtSearchAlien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 30));

        btnSearchAlien.setText("SEARCH");
        btnSearchAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAlienActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchAlien, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 80, 30));

        btnRegisterEquipment.setText("Register Equipment");
        btnRegisterEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterEquipmentActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegisterEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 207, 170, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/Bild_Startsida_Agent.png"))); // NOI18N
        bg.setText("jLabel3");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        new Alien_OmradeNY(idb).setVisible(true);
    }//GEN-LAST:event_btnSokActionPerformed

    private void cbOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOmradesChefActionPerformed
        // TODO add your handling code here:
        String chef = null;
        int chef_ID = 0;
        try {
            chef = cbOmradesChef.getSelectedItem().toString();
            if (chef.equals("Svealand")) {
                chef_ID = 1;
            } else if (chef.equals("Götaland")) {
                chef_ID = 2;
            } else if (chef.equals("Norrland")) {
                chef_ID = 4;
            }
            String OID = idb.fetchSingle("Select Agent_ID FROM omradeschef WHERE Omrade =" + chef_ID);
            String CID = idb.fetchSingle("SELECT Namn FROM agent WHERE Agent_ID =" + OID);
            lblOmradesChef.setText(CID);
        } catch (Exception ettUndantag) {
            JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator.");
            System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());
        }
    }//GEN-LAST:event_cbOmradesChefActionPerformed

    private void cbLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoggaUtActionPerformed
        String action = cbLoggaUt.getSelectedItem().toString();
        switch(action){
            case "Logga ut":
                System.exit(0);
                break;
            case "Ändra Lösenord":
                new BytLosen(idb).setVisible(true);
                dispose();
                break;
        }
       
    }//GEN-LAST:event_cbLoggaUtActionPerformed

    private void btnRegisterEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterEquipmentActionPerformed
        new RegUtrustning(idb).setVisible(true);
    }//GEN-LAST:event_btnRegisterEquipmentActionPerformed

    private void btnRegisterAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterAlienActionPerformed
        new RegAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnRegisterAlienActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Alien_Ras(idb).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSearchAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAlienActionPerformed
        String svarID = null;
        if (Validering.textFaltHarVarde(txtSearchAlien)){
                String sokningNamn = txtSearchAlien.getText();
            try{
                svarID = idb.fetchSingle("SELECT alien_ID from alien WHERE Namn= '" + sokningNamn + "'");
            }            
            catch (Exception annatUndantag){
                JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator.");
                System.out.println("InternFelmeddelande:" + annatUndantag.getMessage());  
            }
            if (svarID == null){
                JOptionPane.showMessageDialog(null, "You have entered wrong username");            
            }
            else if(svarID !=null){
                new SokAgentAlien(idb, svarID, "alien").setVisible(true);
            }
        }
    }//GEN-LAST:event_btnSearchAlienActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnRegisterAlien;
    private javax.swing.JButton btnRegisterEquipment;
    private javax.swing.JButton btnSearchAlien;
    private javax.swing.JButton btnSok;
    private javax.swing.JComboBox<String> cbLoggaUt;
    private javax.swing.JComboBox<String> cbOmradesChef;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblOmradesChef;
    private javax.swing.JLabel lblShowRegion;
    private javax.swing.JTextField txtSearchAlien;
    // End of variables declaration//GEN-END:variables
}
