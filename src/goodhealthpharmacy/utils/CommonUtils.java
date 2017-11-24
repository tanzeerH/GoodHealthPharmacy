/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goodhealthpharmacy.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Tanzeer
 */
public class CommonUtils {
    
    public static void showWarningDialog()
    {
            JOptionPane.showMessageDialog(null, "Field can not be empty.");
    }
    public static void showNotSelectedWarningDialog()
    {
            JOptionPane.showMessageDialog(null, "Please select an option.");
    }
   
    public static void showTooBigTextWarningDialog()
    {
            JOptionPane.showMessageDialog(null, "Input is too big.");
    }
    public static boolean isNumber(String text)
    {
     try {
        Integer.parseInt(text);
    } catch(Exception e) {
        System.out.println("Non-numeric character exist");
        return  false;
    }
     return true;
    }
}
