/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jpn
 */
public class Validering {
    
    public static boolean textFaltHarVarde(JTextField rutaAttKolla)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter something in the box");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    public static boolean txtHarInteBaraSpace(JTextField rutaAttKolla){
        boolean resultat = true;
        
        String ruta = rutaAttKolla.getText();
        if(ruta.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter something other than spaces in the box.");
            resultat = false;
            rutaAttKolla.requestFocus(); 
        }
        
        return resultat;
    }
    public static boolean isHeltal(JTextField rutaAttKolla)
    {
    boolean resultat = true; 
    
    try{
        String inStrang = rutaAttKolla.getText();
        Integer.parseInt(inStrang);        
        rutaAttKolla.requestFocus();
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Var god ange ett heltal!");
        resultat = false;    
    }
    
    return resultat;
    }
    
    public static boolean okPhoneNumber(JTextField rutaAttKolla){
        String inStrang = rutaAttKolla.getText();
        if (inStrang.matches("[0-9]+") && inStrang.length() > 5 && inStrang.length() < 11) {
            return true;
            }
        else{
            JOptionPane.showMessageDialog(null, "Please enter valid phonenumer");
            rutaAttKolla.requestFocus(); 
                return false;
        }
    }
    
    public static boolean doesNotContainSpace(JTextField rutaAttKolla){
        boolean resultat = true;
        
        String inStrang = rutaAttKolla.getText();
        if(inStrang.contains(" ")){
            JOptionPane.showMessageDialog(null, "Please avoid using spaces.");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    
    public static boolean losenOK(JTextField rutaAttKolla){
        //kollar att rutan har innehåll samt att tecken är under 10 tecken
        boolean resultat = false;      
        String inStrang = rutaAttKolla.getText();

        if(textFaltHarVarde(rutaAttKolla) && inStrang.length() < 10 && doesNotContainSpace(rutaAttKolla)) {
            resultat = true;          
        }
        
        return resultat;
    }

    public static boolean okTxtLang(JTextField rutaAttKolla){
        boolean resultat = true;
        String inStrang = rutaAttKolla.getText();
        if(inStrang.length() < 5 || inStrang.length() > 20){
            JOptionPane.showMessageDialog(null, "Please remain within the 5-20 character limit.");
            resultat = false;
            rutaAttKolla.requestFocus();
        }
        return resultat;
    }
    
    public static boolean isDate(JTextField rutaAttKolla){
        boolean resultat = false;
        String date = rutaAttKolla.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        try {
            // why 2008-02-2x, 20-11-02, 12012-04-05 are valid date?
            sdf.parse(date);
            // strict mode - check 30 or 31 days, leap year
            sdf.setLenient(false);
            resultat = true;

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Please use the YYYY-MM-DD format when entering a date.");
            e.printStackTrace();
            rutaAttKolla.requestFocus();
            resultat = false;
        }
        return resultat;
    }
}
