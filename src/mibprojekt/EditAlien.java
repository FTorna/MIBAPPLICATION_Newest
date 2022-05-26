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
public class EditAlien extends javax.swing.JFrame {

    private static InfDB idb;
    private String namn;
    private static String id;
    private String datum;
    private String telefon;
    private String plats;
    private String ansvarigAgent;  
    private String ras;
    private static String orgRas;
    private String rasBenamning;
    
    public EditAlien(InfDB idb, String namn, String id, String datum, String telefon, String plats, String ansvarigAgent, String ras) {
        initComponents();
        this.idb= idb;
        this.namn = namn; 
        this.id = id;
        this.datum = datum;
        this.telefon = telefon;
        this.ansvarigAgent = ansvarigAgent;
        this.plats = plats;
        this.ras = ras;
        orgRas = ras;
        setStartText();
    }
    
    private void setStartText(){
        setPlatsStart(plats);
        setRasStart(ras);
        //setRasBenStart();
        fyllcbAnsvarig();
        setAnsvarigAgentStart();
        lblVisaID.setText(id);
        txtNamn.setText(namn);
        txtRegDatum.setText(datum);
        txtTelefon.setText(telefon); 
        
    }
    private void setAnsvarigAgentStart(){
        String svar = null;
        try{
            svar = idb.fetchSingle("Select namn from agent where agent_id = " + ansvarigAgent);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong");    
        }
        cbAnsvarigAgent.setSelectedItem(svar);
    }
    private String setRasStart(String ras){
        switch(ras){
                 case "worm":
                    cbRas.setSelectedItem("Worm");
                    break;
                case "squid":
                    cbRas.setSelectedItem("Squid");
                    break;
                case "boglodite":
                    cbRas.setSelectedItem("Boglodite");
                    break;     
            }
        return ras;
    }
    
    private void setRasBenStart(){
        /*
        lblBenamning.setVisible(true);
        txtBenamning.setVisible(true);

        try{
            String benamningSquid = idb.fetchSingle("SELECT antal_armar from SQUID where alien_id = " + id);
            String benamningBogo = idb.fetchSingle("SELECT antal_boogies from boglodite where alien_id = " + id);
        }
        catch(Exception e){
            
        }
            switch(ras){
                case"squid":
                    System.out.println("hej");
                    lblBenamning.setText("Antal ArmarOO: ");
                    break;
                case"boglodite":
                    lblBenamning.setText("Antal Boogies");
                    break;
                case"worm":
                    lblBenamning.setVisible(false);
                    txtBenamning.setVisible(false);
                    break;
            }
        txtBenamning.setText("");*/
    }
    
    private boolean setNamn(){
        String forslagNamn = txtNamn.getText();
        boolean ok = false;
        if (Validering.textFaltHarVarde(txtNamn) && Validering.txtHarInteBaraSpace(txtNamn)){
            try {
                String nr = idb.fetchSingle("SELECT count(*) from agent where namn = '"+ forslagNamn + "'");
                int antal = Integer.valueOf(nr);
                if (antal == 0 || namn.equals(forslagNamn)){
                    namn = forslagNamn;
                    ok = true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please chose an unique name for the Agent.");
                }     
            }
            catch(Exception ettUndantag){
            JOptionPane.showMessageDialog(null, "Something went wrong");         
            }
        }
        return ok;
    }
    private String setPlatsStart(String plats){
        switch(plats){
            case"1":
                cbPlats.setSelectedItem("Örebro");
                break;
            case"2":
                cbPlats.setSelectedItem("Västerås");
                break;
            case"3":
                cbPlats.setSelectedItem("Vilhelmina");
                break;
            case"4":
                cbPlats.setSelectedItem("Borås");
                break;                
        }
        return plats;
    }
        private String getPlats(){
        String nyPlats = null;
        if(cbPlats.getSelectedItem() == "Örebro"){
            nyPlats = "1";
        }
        else if (cbPlats.getSelectedItem() == "Västerås"){
            nyPlats = "2";
        }
        else if(cbPlats.getSelectedItem() == "Vilhelmina"){
            nyPlats ="2";
        }
        else if(cbPlats.getSelectedItem() == "Borås"){
            nyPlats ="4";
        }
        else
            System.out.println("Error");
        return nyPlats;
    }
    private String getAnsvarigAgent(){
        String nyAnsvarig = String.valueOf(cbAnsvarigAgent.getSelectedItem()); 
        try{
            ansvarigAgent = idb.fetchSingle("SELECT agent_id from agent where namn = '" + nyAnsvarig +"'");
        }
        catch(Exception e){
            System.out.println("error");
        }
        return ansvarigAgent;
    }
    
    private void fyllcbAnsvarig() {
        ArrayList<String> allaAgenter;

        try {
            allaAgenter = idb.fetchColumn("SELECT namn FROM agent");
            for (String benamning : allaAgenter) {
                cbAnsvarigAgent.addItem(benamning);
            }
        } catch (Exception annatUndantag) {
            JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator.");
            System.out.println("InternFelmeddelande:" + annatUndantag.getMessage());
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

        lblID = new javax.swing.JLabel();
        lblNamn = new javax.swing.JLabel();
        lblTelefon = new javax.swing.JLabel();
        lblRegDatum = new javax.swing.JLabel();
        lblPlats = new javax.swing.JLabel();
        lblRas = new javax.swing.JLabel();
        lblAnsvarig = new javax.swing.JLabel();
        cbAnsvarigAgent = new javax.swing.JComboBox<>();
        lblBenamning = new javax.swing.JLabel();
        cbRas = new javax.swing.JComboBox<>();
        cbPlats = new javax.swing.JComboBox<>();
        txtBenamning = new javax.swing.JTextField();
        txtRegDatum = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();
        lblVisaID = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("Alien ID:");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 106, -1));

        lblNamn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblNamn.setForeground(new java.awt.Color(255, 255, 255));
        lblNamn.setText("Name:");
        getContentPane().add(lblNamn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 106, -1));

        lblTelefon.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblTelefon.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefon.setText("Phone Number:");
        getContentPane().add(lblTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 106, -1));

        lblRegDatum.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblRegDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblRegDatum.setText("Registration Date:");
        getContentPane().add(lblRegDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        lblPlats.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblPlats.setForeground(new java.awt.Color(255, 255, 255));
        lblPlats.setText("Region:");
        getContentPane().add(lblPlats, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        lblRas.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblRas.setForeground(new java.awt.Color(255, 255, 255));
        lblRas.setText("Ras: ");
        getContentPane().add(lblRas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        lblAnsvarig.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblAnsvarig.setForeground(new java.awt.Color(255, 255, 255));
        lblAnsvarig.setText("Responsible Agent: ");
        getContentPane().add(lblAnsvarig, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        getContentPane().add(cbAnsvarigAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 130, -1));

        lblBenamning.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblBenamning.setForeground(new java.awt.Color(255, 255, 255));
        lblBenamning.setText("Benämning: ");
        getContentPane().add(lblBenamning, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, -1, 20));

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Worm", "Squid", "Boglodite" }));
        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });
        getContentPane().add(cbRas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 130, -1));

        cbPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Örebro", "Västerås", "Vilhelmina", "Borås" }));
        getContentPane().add(cbPlats, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 130, -1));
        getContentPane().add(txtBenamning, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 330, 100, -1));
        getContentPane().add(txtRegDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 130, -1));
        getContentPane().add(txtTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 130, -1));
        getContentPane().add(txtNamn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 130, -1));

        lblVisaID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblVisaID.setForeground(new java.awt.Color(255, 255, 255));
        lblVisaID.setText("jLabel9");
        getContentPane().add(lblVisaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 73, -1));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 86, -1));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 73, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Alien Information");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Blank.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private boolean setBenamning(){
        boolean ok = false;
            if(ras.equals("Boglodite") || ras.equals("Squid")){ 
                if (Validering.textFaltHarVarde(txtBenamning) && Validering.isHeltal(txtBenamning)){
                    rasBenamning = txtBenamning.getText();
                    ok = true;
                }
            }
            else if (ras.equals("Worm"))
                ok = true;
        return ok; 
    }
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
       if(setNamn() && Validering.okPhoneNumber(txtTelefon) && Validering.isDate(txtRegDatum) && setBenamning()){
            try{
                idb.fetchSingle("UPDATE alien SET namn = '" + namn + "', registreringsdatum = '" + txtRegDatum.getText() + "', Telefon = '" + txtTelefon.getText() + 
                "', Plats = " + getPlats() + ", Ansvarig_agent = " + getAnsvarigAgent() + "  WHERE alien_ID = " + id);
                
                idb.fetchSingle("DELETE FROM " + orgRas + " WHERE alien_id = " + id);
                switch(ras){
                    case"Squid":
                        idb.fetchSingle("INSERT INTO Squid (Alien_ID, Antal_Armar) VALUES(" + id + ", " + rasBenamning + ")");
                        break;
                    case"Boglodite":
                        idb.fetchSingle("INSERT INTO Boglodite (Alien_ID, Antal_Boogies) VALUES(" + id + ", " + rasBenamning + ")");
                        break;
                    case"Worm":
                        idb.fetchSingle("INSERT INTO Worm (Alien_ID) VALUES(" + id + ")");
                        break;
                }
            System.out.println("update OK");       
            dispose();                
            }
            catch (Exception e){
                System.out.println("InternFelmeddelande:" + e.getMessage());   
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
               ras = cbRas.getSelectedItem().toString(); 
               String squidDesc = "0";
               String bogoDesc = "0";
        try{
             squidDesc = idb.fetchSingle("SELECT antal_armar from SQUID where alien_id = " + id);
             bogoDesc = idb.fetchSingle("SELECT antal_boogies from boglodite where alien_id = " + id);
        }
        catch(Exception e){
                   
        }
       switch(ras){
           case "Squid":
               lblBenamning.setVisible(true);
               lblBenamning.setText("Amount of Arms: ");
               txtBenamning.setVisible(true);
               txtBenamning.setText(squidDesc);
               break;
           case "Boglodite":
               lblBenamning.setVisible(true);
               lblBenamning.setText("Amount of Boogies: ");
               txtBenamning.setVisible(true);
               txtBenamning.setText(bogoDesc);
               break;
           case "Worm":
               lblBenamning.setVisible(false);
               txtBenamning.setVisible(false);
               break;
       }      
    }//GEN-LAST:event_cbRasActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String input = "You are about to delete an Alien";
        new ControlWindow(input, "alien").setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public static boolean deleteAlien(){
        boolean raderad = false;
        try{
            idb.fetchSingle("DELETE FROM alien WHERE alien_id = " + id);
            idb.fetchSingle("DELETE FROM " + orgRas + " WHERE alien_id = " + id);
            raderad = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong.");
        }   
        return raderad;
    }
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
            java.util.logging.Logger.getLogger(EditAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditAlien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new EditAlien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbAnsvarigAgent;
    private javax.swing.JComboBox<String> cbPlats;
    private javax.swing.JComboBox<String> cbRas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAnsvarig;
    private javax.swing.JLabel lblBenamning;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNamn;
    private javax.swing.JLabel lblPlats;
    private javax.swing.JLabel lblRas;
    private javax.swing.JLabel lblRegDatum;
    private javax.swing.JLabel lblTelefon;
    private javax.swing.JLabel lblVisaID;
    private javax.swing.JTextField txtBenamning;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtRegDatum;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
