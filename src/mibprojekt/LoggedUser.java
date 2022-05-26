/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibprojekt;

import javax.swing.JOptionPane;
import oru.inf.InfDB;

public class LoggedUser {
    private static InfDB idb;
    private static String password;
    private static String userID;
    private static boolean isAlien;
    private static boolean isAdmin;
    
    public LoggedUser(InfDB idb, String userID, String password, boolean isAlien, boolean isAdmin){
        this.idb = idb;
        this.password = password;
        this.userID = userID;
        this.isAlien = isAlien;
        this.isAdmin = isAdmin; 
    }
    
    public static String getPassword(){
        updatePassword();
        return password;
    }
    
    public static String updatePassword(){
        if(isAlien){
            try{
                password = idb.fetchSingle ("SELECT Losenord FROM alien WHERE alien_ID = " + userID);
            }
            catch(Exception ettUndantag){
                JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator. isAlien");
                System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());
            }
        }       
        else if (!isAlien){
            try{
                password = idb.fetchSingle("SELECT Losenord from agent where agent_Id = " + userID);
            }
            catch(Exception ettUndantag){
                JOptionPane.showMessageDialog(null, "Something went wrong. Please contact your IT-Administrator. is not Alien");
                System.out.println("InternFelmeddelande:" + ettUndantag.getMessage());
            }
        }    
        return password;
    }
    
    public static String getUserID(){
        return userID;
    }
    public static boolean getIsAdmin(){
        return isAdmin;
    }
    
    public static boolean getIsAlien(){
        return isAlien;
    }

}
