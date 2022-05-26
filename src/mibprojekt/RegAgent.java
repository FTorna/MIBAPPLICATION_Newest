/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author trnfa
 */
public class RegAgent extends javax.swing.JFrame {

    /**
     * Creates new form RegAgent
     */
    private static InfDB idb;
    
    private static int agentID;
    private static String anstallning;
    private static String losen;
    private static String namn; 
    private static String telefon;
    private static int omrade;
    private static String isAdmin;
    
    public RegAgent(InfDB idb) {
        this.idb = idb;
        initComponents();
        setAgentID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgentID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblLosen = new javax.swing.JLabel();
        lblLosenUpprepa = new javax.swing.JLabel();
        lblOmrade = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        cbAdmin = new javax.swing.JComboBox<>();
        cbOmrade = new javax.swing.JComboBox<>();
        txtLosenUpprepa = new javax.swing.JPasswordField();
        txtLosen = new javax.swing.JPasswordField();
        txtTelefon = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();
        lblVisaID = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblAnstallning = new javax.swing.JLabel();
        txtAnstallning = new javax.swing.JTextField();
        lblRegisterNewAgent = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgentID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblAgentID.setForeground(new java.awt.Color(255, 255, 255));
        lblAgentID.setText("Agent ID:");
        getContentPane().add(lblAgentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        lblNamn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblNamn.setForeground(new java.awt.Color(255, 255, 255));
        lblNamn.setText("Name: *");
        getContentPane().add(lblNamn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        lblTelefon.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblTelefon.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefon.setText("Phone number:*");
        getContentPane().add(lblTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, 14));

        lblLosen.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblLosen.setForeground(new java.awt.Color(255, 255, 255));
        lblLosen.setText("Password:*");
        getContentPane().add(lblLosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        lblLosenUpprepa.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblLosenUpprepa.setForeground(new java.awt.Color(255, 255, 255));
        lblLosenUpprepa.setText("Repeat Password:*");
        getContentPane().add(lblLosenUpprepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        lblOmrade.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblOmrade.setForeground(new java.awt.Color(255, 255, 255));
        lblOmrade.setText("Region:*");
        getContentPane().add(lblOmrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, -1, -1));

        lblAdmin.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Is Admin:");
        getContentPane().add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, -1, -1));

        cbAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nej", "Ja" }));
        getContentPane().add(cbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 140, -1));

        cbOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Svealand", "Götaland", "Norrland" }));
        getContentPane().add(cbOmrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 140, -1));
        getContentPane().add(txtLosenUpprepa, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 140, -1));
        getContentPane().add(txtLosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 140, -1));
        getContentPane().add(txtTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 140, -1));
        getContentPane().add(txtNamn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 140, -1));

        lblVisaID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblVisaID.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblVisaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 88, 18));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 73, -1));

        lblAnstallning.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblAnstallning.setForeground(new java.awt.Color(255, 255, 255));
        lblAnstallning.setText("Date of Employment:*");
        getContentPane().add(lblAnstallning, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));
        getContentPane().add(txtAnstallning, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 140, -1));

        lblRegisterNewAgent.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        lblRegisterNewAgent.setForeground(new java.awt.Color(255, 255, 255));
        lblRegisterNewAgent.setText("Register New Agent");
        getContentPane().add(lblRegisterNewAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Blank.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (setNamn() && setPW()&& setTelefon()&& setAnstallning()) {
            setOmrade();
            setAdmin();
            System.out.println(agentID + anstallning+  losen+ namn+  telefon+ omrade +isAdmin);
            try {
                idb.fetchSingle("INSERT INTO agent (Agent_ID, Namn, Telefon, Anstallningsdatum, Administrator, Losenord, Omrade)" +
                "VALUES (" + agentID + ", '" + namn + "', '" + telefon + "', '" + anstallning + "', '" + isAdmin + "', '" + losen + "' ," + omrade + ");");
                dispose();
            }
            catch(InfException ettUndantag){
                System.out.println("InternFelmeddelande:" + ettUndantag.getMessage()); 
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(RegAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegAgent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegAgent(idb).setVisible(true);
            }
        });
    }
        public void setOmrade(){
            String inOmrade = cbOmrade.getSelectedItem().toString();
            switch(inOmrade){
                case "Svealand": 
                    omrade = 1;
                    break;
                case "Götaland":
                    omrade = 2;
                    break;
                case"Norrland":
                    omrade = 4;
                    break;
            }
        }
        public void setAdmin(){
           String isAdminCheck = cbAdmin.getSelectedItem().toString();
           switch (isAdminCheck){
            case"Nej":
                isAdmin = "N";
                break;
            case"Ja":
                isAdmin = "J";
                break;
            }
        }
        
        public boolean setAgentID(){
        boolean ok = true;
        try{
            int nyttID = Integer.parseInt(idb.fetchSingle("Select MAX(agent_ID) from agent"));
            nyttID++;
            agentID = nyttID;
            lblVisaID.setText(String.valueOf(agentID));
        }
        catch(Exception ettUndantag){
            JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator. is not Alien");
            System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());         
            ok = false;
        }
        return ok;
    }
        public boolean setNamn(){
        boolean ok = false;
        String forslagNamn = txtNamn.getText();
        if (Validering.textFaltHarVarde(txtNamn) && Validering.txtHarInteBaraSpace(txtNamn)){
           try {
                String nr = idb.fetchSingle("SELECT count(*) from agent where namn = '"+ forslagNamn + "'");
                int antal = Integer.valueOf(nr);
                if (antal == 0){
                    namn = forslagNamn;
                    ok = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please chose an unique name for the Alien.");
                }     
            }
            catch(Exception ettUndantag){
            JOptionPane.showMessageDialog(null, "Something went wrong");         
            }
        }
        return ok;
    }  
        
    public boolean setTelefon(){    
        boolean resultat = false;
        if(Validering.okPhoneNumber(txtTelefon)){
            telefon = txtTelefon.getText();
            resultat = true;
        }
        return resultat;
    }
    
    public boolean setPW(){
        boolean ok = true;
        String newPW = txtLosen.getText();
        String newPWUpp = txtLosenUpprepa.getText();
        
        if(Validering.losenOK(txtLosen)){
            if(newPW.equals(newPWUpp))
                losen = newPW;
            else{
                JOptionPane.showMessageDialog(null, "The two passwords does not match");
                ok = false;
            }
        } 
        else
            ok = false;

        return ok;
    }
    
    public boolean setAnstallning(){
        boolean ok = false;
        if (Validering.isDate(txtAnstallning)){
            anstallning = txtAnstallning.getText();
            ok = true;
        }    
        
        return ok;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbAdmin;
    private javax.swing.JComboBox<String> cbOmrade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAgentID;
    private javax.swing.JLabel lblAnstallning;
    private javax.swing.JLabel lblLosen;
    private javax.swing.JLabel lblLosenUpprepa;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblOmrade;
    private javax.swing.JLabel lblRegisterNewAgent;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblVisaID;
    private javax.swing.JTextField txtAnstallning;
    private javax.swing.JPasswordField txtLosen;
    private javax.swing.JPasswordField txtLosenUpprepa;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
