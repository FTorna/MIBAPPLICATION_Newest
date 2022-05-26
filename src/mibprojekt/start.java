package mibprojekt;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class start {
    private static InfDB idb;
    public static void main(String[] args)throws InfException{
        try{
         idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
         new Inlogg(idb).setVisible(true);
         
         
         
        }      
        catch (InfException ettUndantag){
            JOptionPane.showMessageDialog(null, "Fel vid anslutning till databas. \n\n Kontakta din IT-administratör.");
            System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());
        }        
    }
}