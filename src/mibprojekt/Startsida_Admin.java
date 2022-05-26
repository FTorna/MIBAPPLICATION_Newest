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
public class Startsida_Admin extends javax.swing.JFrame {

    /**
     * Creates new form Startsida
     */
    private static InfDB idb;
    public Startsida_Admin(InfDB idb) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        cbLoggaUt = new javax.swing.JComboBox<>();
        btnRegAlien = new javax.swing.JButton();
        btnRegAgent = new javax.swing.JButton();
        cbAgent = new javax.swing.JCheckBox();
        cbAlien = new javax.swing.JCheckBox();
        txtFalt = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        btnEditRegionManager = new javax.swing.JButton();
        btnRaderaUtrustning = new javax.swing.JButton();
        btnEditOfficeManager = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbLoggaUt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Ändra Lösenord", "Logga ut" }));
        cbLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoggaUtActionPerformed(evt);
            }
        });
        getContentPane().add(cbLoggaUt, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        btnRegAlien.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        btnRegAlien.setText("Register New Alien");
        btnRegAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAlienActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegAlien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 240, -1));

        btnRegAgent.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        btnRegAgent.setText("Register New Agent");
        btnRegAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAgentActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 240, -1));

        buttonGroup1.add(cbAgent);
        cbAgent.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cbAgent.setText("Agent");
        getContentPane().add(cbAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        buttonGroup1.add(cbAlien);
        cbAlien.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        cbAlien.setText("Alien");
        getContentPane().add(cbAlien, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));
        getContentPane().add(txtFalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 170, 20));

        btnSok.setText("Search");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });
        getContentPane().add(btnSok, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 70, 20));

<<<<<<< Updated upstream
        btnEditRegionManager.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        btnEditRegionManager.setText("Edit Region Manager");
        btnEditRegionManager.addActionListener(new java.awt.event.ActionListener() {
=======
        jButton1.setText("Show all Aliens in specific region");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 240, -1));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton2.setText("Edit Region Manager");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> Stashed changes
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRegionManagerActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditRegionManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 240, -1));

        btnRaderaUtrustning.setText("Remove Equipment");
        btnRaderaUtrustning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaUtrustningActionPerformed(evt);
            }
        });
        getContentPane().add(btnRaderaUtrustning, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 240, -1));

<<<<<<< Updated upstream
        btnEditOfficeManager.setText("Edit Office Manager");
        getContentPane().add(btnEditOfficeManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 240, 30));
=======
        jButton3.setText("utrustni");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));
>>>>>>> Stashed changes

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Startsida_Agent.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAgentActionPerformed
        new RegAgent(idb).setVisible(true);
    }//GEN-LAST:event_btnRegAgentActionPerformed

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

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
               String svarID = null;
       String category = null;
        if (Validering.textFaltHarVarde(txtFalt)){
                String sokningNamn = txtFalt.getText();
            try{
                if(cbAgent.isSelected()){
                      svarID = idb.fetchSingle("SELECT agent_ID from agent WHERE Namn= '" + sokningNamn + "'");
                       category = "agent";
                }
                else if (cbAlien.isSelected()){
                      svarID = idb.fetchSingle("SELECT alien_ID from alien WHERE Namn= '" + sokningNamn + "'");
                      System.out.println(svarID);
                      category = "alien";
                }
                else {
                    JOptionPane.showMessageDialog(null, "Pick a category");
                }
            }            
            catch (Exception annatUndantag){
                JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator.");
                System.out.println("InternFelmeddelande:" + annatUndantag.getMessage());  
            }
            if (svarID == null){
                JOptionPane.showMessageDialog(null, "You have entered wrong username or category.");            
            }
            else if(svarID !=null){
                new SokAgentAlien(idb, svarID, category).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnSokActionPerformed

    private void btnRegAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAlienActionPerformed
        new RegAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnRegAlienActionPerformed

    private void btnEditRegionManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRegionManagerActionPerformed
       new Andra_Omradeschef(idb).setVisible(true);
    }//GEN-LAST:event_btnEditRegionManagerActionPerformed

    private void btnRaderaUtrustningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaUtrustningActionPerformed
       new RaderaUtrustning(idb).setVisible(true);
    }//GEN-LAST:event_btnRaderaUtrustningActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnEditOfficeManager;
    private javax.swing.JButton btnEditRegionManager;
    private javax.swing.JButton btnRaderaUtrustning;
    private javax.swing.JButton btnRegAgent;
    private javax.swing.JButton btnRegAlien;
    private javax.swing.JButton btnSok;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAgent;
    private javax.swing.JCheckBox cbAlien;
    private javax.swing.JComboBox<String> cbLoggaUt;
    private javax.swing.JTextField txtFalt;
    // End of variables declaration//GEN-END:variables
}
