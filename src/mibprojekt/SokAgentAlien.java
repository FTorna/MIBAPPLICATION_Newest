/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oru.inf.InfDB;

/**
 *
 * @author trnfa
 */
public class SokAgentAlien extends javax.swing.JFrame {

    /**
     * Creates new form sokAgent
     */
    private JCheckBox cbChoice;

    private InfDB idb;
  
    private String category;
    private String id;
    private String ras = null;
    
    public SokAgentAlien(InfDB idb, String id, String category) {
        this.idb = idb;
        this.id = id;
        this.category = category;
      //  fillRuta();
        initComponents();
        fyllRutor();
    }
    private String getRas(){
        try {
            String isWorm = idb.fetchSingle("SELECT * from worm where alien_ID = " + id);
            String isSquid = idb.fetchSingle("Select * from squid where alien_ID = " + id);
            String isBoglodite = idb.fetchSingle("Select * from boglodite where alien_Id = " + id);
            
            if(isWorm != null)
                ras = "worm";
            else if (isSquid != null)
                ras = "squid";
            else if (isBoglodite != null)
                ras = "boglodite";
            else    
                System.out.println("error");
        }
        catch (Exception e){
            System.out.println("InternFelmeddelande:" + e.getMessage());
        }    
        return ras;
    }
    //boglodite
    //Antal_boogies
    private String getRasBenamning(){
        String ben = " ";
        try{
            switch(ras){
                case"squid":
                    ben = "Arms: " + idb.fetchSingle("Select antal_armar from squid where alien_id = " + id);
                    break;
                case"boglodite":
                    ben = "Boogies: " + idb.fetchSingle("Select antal_boogies from boglodite where alien_id = " + id);
                    break;
            }
        }
        catch(Exception e){
            System.out.println("error");
        }
        return ben;
    }
    
    private void fyllRutor(){
        lblID.setText("ID: " + id);
        lblNamn.setText("Name: " + getInfo("namn"));
        lblTele.setText("Phone: " + getInfo("telefon"));
        
        switch(category){
            case "alien":
                lblDatum.setText("Registration Date: " + getInfo("registreringsdatum"));
                lblOmrade.setText("Region: " + getInfo("plats"));
                lblRas.setText("Race: " + getRas());
                lblRasBenamning.setText(getRasBenamning());
                lblAnsvarig.setText("Responsible Agent: " + getInfo("ansvarig_agent"));
                lblIsAdmin.setText(" ");
                break;
            case "agent":
                lblDatum.setText("Date of Employment: " + getInfo("anstallningsdatum"));
                lblOmrade.setText("Region: " + getInfo("omrade"));
                lblIsAdmin.setText("Is Admin: " + getInfo("administrator"));
                lblRas.setText(" ");
                lblAnsvarig.setText(" ");
                lblRasBenamning.setText(" ");
        }
    }

    private String getInfo(String get){
        String svar = null;
        try{
            switch(category){
                case "agent":
                    svar = idb.fetchSingle("SELECT "+ get + " from agent where agent_id = "+ id); 
                    break;
                case "alien":
                    svar = idb.fetchSingle("SELECT " + get + " from alien where alien_id = " + id);
                    break;
            }
        }
        catch(Exception ettUndantag){
            System.out.println("OJ");
        }
        return svar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new javax.swing.JButton();
        lblNamn = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblTele = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblAnsvarig = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblIsAdmin = new javax.swing.JLabel();
        lblRasBenamning = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 73, -1));

        lblNamn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblNamn.setForeground(new java.awt.Color(255, 255, 255));
        lblNamn.setText("Name:");
        getContentPane().add(lblNamn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, 20));

        lblID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        lblTele.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblTele.setForeground(new java.awt.Color(255, 255, 255));
        lblTele.setText("Phone number:");
        getContentPane().add(lblTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        lblOmrade.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblOmrade.setForeground(new java.awt.Color(255, 255, 255));
        lblOmrade.setText("Region:");
        lblOmrade.setAutoscrolls(true);
        getContentPane().add(lblOmrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        lblAnsvarig.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblAnsvarig.setForeground(new java.awt.Color(255, 255, 255));
        lblAnsvarig.setText("Responsible Agent:");
        getContentPane().add(lblAnsvarig, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        lblRas.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblRas.setForeground(new java.awt.Color(255, 255, 255));
        lblRas.setText("Ras:");
        getContentPane().add(lblRas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        lblDatum.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum.setText("Registered:");
        getContentPane().add(lblDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        lblIsAdmin.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblIsAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblIsAdmin.setText("Is Admin:");
        getContentPane().add(lblIsAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, -1, -1));

        lblRasBenamning.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblRasBenamning.setForeground(new java.awt.Color(255, 255, 255));
        lblRasBenamning.setText("benamning");
        getContentPane().add(lblRasBenamning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 160, 20));

        btnClose.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Results");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Blank.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch(category){
            case"agent":
                new EditAgent(idb, getInfo("namn"),id,getInfo("anstallningsdatum"),getInfo("telefon"), getInfo("omrade"), getInfo("administrator")).setVisible(true);
                dispose();
                break;
            case"alien":
                new EditAlien(idb, getInfo("namn"), id, getInfo("registreringsdatum"), getInfo("telefon"),  getInfo("plats"), getInfo("ansvarig_agent"), getRas()).setVisible(true);
                dispose();
                break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(SokAgentAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SokAgentAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SokAgentAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SokAgentAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new SokAgentAlien(idb).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAnsvarig;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIsAdmin;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblRasBenamning;
    private javax.swing.JLabel lblTele;
    // End of variables declaration//GEN-END:variables
}
