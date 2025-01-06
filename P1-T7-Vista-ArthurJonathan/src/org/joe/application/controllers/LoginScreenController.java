/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import org.joe.application.constants.ErrMsg;
import org.joe.application.views.CreateuserFrame;
import org.joe.application.views.LoginScreen;
import org.joe.application.views.RetrievePassowordFrame;
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
    private ManagementFrameController managementFrameController;
    private CreateuserFrame createuser;
    private RetrievePassowordFrame rpf;

    public LoginScreenController(EquipDataInterface edi) {

        loginScreen = new LoginScreen();
        this.edi = edi;

        loginScreen.loginOnClickListener(this);
        loginScreen.registrarOnClick(this);
        restorePassword_OnMouse();
        connectToDatabase();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == loginScreen.getJB_login()) {
                String password = new String(loginScreen.getJTF_password().getPassword());
                if (edi.validateUser(loginScreen.getJTF_username().getText(), password)) {
                    JOptionPane.showMessageDialog(null, "Credenciales Validada");
                    managementFrameController = new ManagementFrameController(edi);
                    loginScreen.getLoginframe().dispose();

                }
            }

            if (e.getSource() == loginScreen.getRegistrar_btn()) {
                createuser = new CreateuserFrame(edi);

            }
        } catch (EquipDataInterfaceException ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Credenciales Invalido",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    private void connectToDatabase() {

        JProgressBar progressBar = loginScreen.getConnectionBar();
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    edi.connectDatasource("config.properties");
                } catch (Exception ex) {
                    ErrMsg.error(ex.getMessage(), ex.getCause());
                }
                return null;
            }

            @Override
            protected void done() {

                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
            }
        };
        worker.execute();
    }

    private void restorePassword_OnMouse() {
        loginScreen.getForgotten_passlbl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == loginScreen.getForgotten_passlbl()) {
                    rpf = new RetrievePassowordFrame(edi);

                }
            }
        });
    }

}
