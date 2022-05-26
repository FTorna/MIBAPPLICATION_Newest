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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblID.setText("ID:");

        lblNamn.setText("Namn:");

        lblTelefon.setText("Telefon:");

        lblRegDatum.setText("Registreringsdatum:");

        lblPlats.setText("Plats:");

        lblRas.setText("Ras: ");

        lblAnsvarig.setText("AnsvarigAgent: ");

        lblBenamning.setText("Benämning: ");

        cbRas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Worm", "Squid", "Boglodite" }));
        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });

        cbPlats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Örebro", "Västerås", "Vilhelmina", "Borås" }));

        lblVisaID.setText("jLabel9");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnsvarig)
                            .addComponent(lblPlats)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBenamning)))
                        .addGap(18, 18, 18)
                        .addComponent(txtBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblRegDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNamn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtRegDatum)
                                    .addComponent(txtTelefon)
                                    .addComponent(txtNamn)
                                    .addComponent(lblVisaID)
                                    .addComponent(cbPlats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblID))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblVisaID))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNamn)
                            .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelefon)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRegDatum)
                            .addComponent(txtRegDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlats)
                            .addComponent(cbPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRas)
                            .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBenamning, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnsvarig)
                            .addComponent(cbAnsvarigAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
               lblBenamning.setText("Ange antal armar: ");
               txtBenamning.setVisible(true);
               txtBenamning.setText(squidDesc);
               break;
           case "Boglodite":
               lblBenamning.setVisible(true);
               lblBenamning.setText("Ange antal boogies: ");
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
