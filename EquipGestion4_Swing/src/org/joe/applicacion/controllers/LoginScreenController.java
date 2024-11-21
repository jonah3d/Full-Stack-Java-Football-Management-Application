/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.applicacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.applicacion.views.LoginScreen;

/**
 *
 * @author Usuari
 */
public class LoginScreenController implements ActionListener {
    private LoginScreen loginScreen;

    public LoginScreenController() {
        loginScreen = new LoginScreen();
        
        loginScreen.loginOnClickListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == loginScreen.getJB_login()) {
        
    }
}
}
