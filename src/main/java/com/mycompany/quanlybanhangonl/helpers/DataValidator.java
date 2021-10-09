
package com.mycompany.quanlybanhangonl.helpers;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DataValidator {
    public static void ValidateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        } 
    }
    public static void ValidateEmpty(JPasswordField field, StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());
        if(password.equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        } 
    }
}
