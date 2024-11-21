/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.applicacion.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuari
 */
public class LoginScreen {
    
   JFrame loginframe;
    JPanel contentpanel;
    JLabel logintext;
    JTextField JTF_username;
    JLabel JL_passwordtext;
    JTextField JTF_password;
    JButton JB_login;
    
    
    
    public LoginScreen() {
        
        loginscreen();
    }
     public void loginscreen(){
         
        //Initializacion De Componentes 
        loginframe = new JFrame("Login");
        contentpanel = new JPanel();
        logintext = new JLabel("Username: ");
        JTF_username = new JTextField();
        JL_passwordtext = new JLabel("Password");
        JTF_password = new JTextField();
        JB_login = new JButton("Login");
        
        //Operacion De Componentes
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(480,600);
        
        contentpanel.setPreferredSize(new Dimension(480,600));
        contentpanel.setBackground(new Color(26,26,29));
        contentpanel.setLayout(null);
        
        logintext.setBounds(56, 189, 132, 48);
        logintext.setBackground(Color.white);
        logintext.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
        
        JL_passwordtext.setBounds(56,250,132,48);
        JL_passwordtext.setBackground(Color.white);
        JL_passwordtext.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
        
        JTF_username.setBounds(190,198,200,30);
        JTF_password.setBounds(190,260,200,30);
        
        JB_login.setBounds(188,354,109,34);
        
        
        //Añadiendo De Componentes A Su Padres
        contentpanel.add(logintext);
        contentpanel.add(JTF_username);
        contentpanel.add(JL_passwordtext);
        contentpanel.add(JTF_password);
        contentpanel.add(JB_login);
        
        loginframe.setVisible(true);
        loginframe.add(contentpanel);
        loginframe.setResizable(false);
        loginframe.setLocationRelativeTo(null);
    }
     
     public void loginOnClickListener(ActionListener listener){
         this.JB_login.addActionListener(listener);
     }

    public JButton getJB_login() {
        return JB_login;
    }


    
     
}
