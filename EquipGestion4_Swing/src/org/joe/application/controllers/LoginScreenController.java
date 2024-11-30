/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.joe.application.views.LoginScreen;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author Usuari
 */
public class LoginScreenController implements ActionListener {
    private LoginScreen loginScreen;
    private EquipDataInterface edi;
    private String persistenceClassName;

    public LoginScreenController(String persistenceClassName) {
      this.persistenceClassName = persistenceClassName;
        loginScreen = new LoginScreen();
   
        loginScreen.loginOnClickListener(this);
        connectToDatabase();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        try{
         if (e.getSource() == loginScreen.getJB_login()) {
           if(edi.validateUser(loginScreen.getJTF_username().getText(), loginScreen.getJTF_password().getText())){
               JOptionPane.showMessageDialog(null, "Credenciales Validada");
           }
      }
        }catch(EquipDataInterfaceException ex){
             JOptionPane.showMessageDialog(null, 
                     ex.getMessage(),
                     "Credenciales Invalido",
                     JOptionPane.ERROR_MESSAGE
                     
                     );
        }
         
    }
    
    private void connectToDatabase(){
        new Thread(()->{
                try {
                    JProgressBar progressBar = loginScreen.getConnectionBar();
                    progressBar.setValue(0);
                    for (int i = 1; i <= 100; i+=20) {
                        Thread.sleep(500);
                        progressBar.setValue(i);
                    }
                    
                    edi = (EquipDataInterface)Class.forName(persistenceClassName).newInstance();
                    progressBar.setValue(100);
                    progressBar.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Connectado Al Servidor");
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                         e.getMessage(),
                        "Error De Conexion",
                JOptionPane.ERROR_MESSAGE
                
                );
               
        }
        
        } ).start();
    }
    
   
}
