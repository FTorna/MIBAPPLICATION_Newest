/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;

/**
 *
 * @author trnfa
 */
public class RegUtrustning extends javax.swing.JFrame {

    private static InfDB idb;
    private static int utrustningID;
    private static String benamning;
    /**
     * Creates new form RegUtrustning
     */
    public RegUtrustning(InfDB idb) {
        this.idb = idb;
        initComponents();
        setUtrustningsID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUtrustingID = new javax.swing.JLabel();
        lblBenamning = new javax.swing.JLabel();
        lblRegisterNewEquipment = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        lblVisaID = new javax.swing.JLabel();
        txtBenamning = new javax.swing.JTextField();
        cbKategori = new javax.swing.JComboBox<>();
        lblEgenskap = new javax.swing.JLabel();
        lblKategori = new javax.swing.JLabel();
        txtEgenskap = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUtrustingID.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblUtrustingID.setForeground(new java.awt.Color(255, 255, 255));
        lblUtrustingID.setText("Equipment ID:");
        getContentPane().add(lblUtrustingID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        lblBenamning.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblBenamning.setForeground(new java.awt.Color(255, 255, 255));
        lblBenamning.setText("Name:");
        getContentPane().add(lblBenamning, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        lblRegisterNewEquipment.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        lblRegisterNewEquipment.setForeground(new java.awt.Color(255, 255, 255));
        lblRegisterNewEquipment.setText("Register New Equipment");
        getContentPane().add(lblRegisterNewEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        getContentPane().add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 73, -1));
        getContentPane().add(lblVisaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 64, 25));

        txtBenamning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBenamningActionPerformed(evt);
            }
        });
        getContentPane().add(txtBenamning, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 132, -1));

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vapen", "Teknik", "Kommunikation" }));
        cbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKategoriActionPerformed(evt);
            }
        });
        getContentPane().add(cbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 132, -1));

        lblEgenskap.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblEgenskap.setForeground(new java.awt.Color(255, 255, 255));
        lblEgenskap.setText("Caliber:");
        getContentPane().add(lblEgenskap, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 50, -1));

        lblKategori.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(255, 255, 255));
        lblKategori.setText("Category:");
        getContentPane().add(lblKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, -1, -1));
        getContentPane().add(txtEgenskap, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 132, -1));

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mibprojekt/pictures/Bild_Blank.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (setBenamning() && setKategori(String.valueOf(cbKategori.getSelectedItem()))){
                try{
                idb.fetchSingle("INSERT INTO utrustning (Utrustnings_ID, Benamning)"
                    + "Values (" + utrustningID + ", ' " + benamning + "' )");
                    System.out.println("OK");
                    dispose();
                }
                
                catch (Exception ettUndantag){
                    System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());  
                }
            }
    }//GEN-LAST:event_btnOKActionPerformed
    private boolean setKategori(String kategori){
        boolean ok = false;
        try{
            switch(kategori){
                case"Vapen":
                    if(Validering.isHeltal(txtEgenskap)){
                    idb.fetchSingle("INSERT INTO vapen (Utrustnings_ID, Kaliber) VALUES(" + utrustningID + ", " + txtEgenskap.getText() + ");");
                    ok = true;
                    }
                    break;
                case"Teknik":
                    if(Validering.textFaltHarVarde(txtEgenskap) && Validering.txtHarInteBaraSpace(txtEgenskap)){
                        idb.fetchSingle("INSERT INTO Teknik(Utrustnings_ID, Kraftkalla) VALUES (" + utrustningID + ", '" + txtEgenskap.getText() + "');");
                    ok = true;
                    }
                    break;
                case"Kommunikation":
                    if (Validering.textFaltHarVarde(txtEgenskap) && Validering.txtHarInteBaraSpace(txtEgenskap)){
                        idb.fetchSingle("INSERT INTO Kommunikation (Utrustnings_ID, Overforingsteknik) VALUES (" + utrustningID + ", '"+ txtEgenskap.getText() + "');");
                    ok = true;
                    }
                    break;  
            }
        }
        catch(Exception e){
            
        }
        return ok;
    }
    private void cbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKategoriActionPerformed
        String selectedItem = String.valueOf(cbKategori.getSelectedItem());    
        switch(selectedItem){
            case"Vapen":
                lblEgenskap.setText("Kaliber: ");
                break;
            case"Teknik":
                lblEgenskap.setText("Kraftkalla: ");
                break;
            case"Kommunikation":
                lblEgenskap.setText("??verf??ringsteknik: ");
                break;
        }
    }//GEN-LAST:event_cbKategoriActionPerformed

    private void txtBenamningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBenamningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBenamningActionPerformed

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
            java.util.logging.Logger.getLogger(RegUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegUtrustning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegUtrustning(idb).setVisible(true);
            }
        });
    }

    public boolean setUtrustningsID(){
        boolean ok = true;
        try{
            int nyttID = Integer.parseInt(idb.fetchSingle("Select MAX(Utrustnings_ID) from utrustning"));
            nyttID++;
            utrustningID = nyttID;
            lblVisaID.setText(String.valueOf(utrustningID));
        }
        catch(Exception ettUndantag){
            JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator. is not Alien");
            System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());         
            ok = false;
        }
        return ok;
    }
    
    public boolean setBenamning(){
        if(Validering.textFaltHarVarde(txtBenamning) && Validering.txtHarInteBaraSpace(txtBenamning)&& Validering.okTxtLang(txtBenamning)){
            benamning = txtBenamning.getText();
            return true;
        }  
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel lblBenamning;
    private javax.swing.JLabel lblEgenskap;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblRegisterNewEquipment;
    private javax.swing.JLabel lblUtrustingID;
    private javax.swing.JLabel lblVisaID;
    private javax.swing.JTextField txtBenamning;
    private javax.swing.JTextField txtEgenskap;
    // End of variables declaration//GEN-END:variables
}
