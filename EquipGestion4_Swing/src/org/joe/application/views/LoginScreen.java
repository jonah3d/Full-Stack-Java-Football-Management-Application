/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import org.joe.application.constants.LoginConstants;

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
    JPanel actionpanel;
    JProgressBar connectionBar;

    public LoginScreen() {

        loginscreen();
    }

    public void loginscreen() {

        //Initializacion De Componentes
        loginframe = new JFrame("Login");
        contentpanel = new JPanel();
        logintext = new JLabel("Usuario: ");
        JTF_username = new JTextField();
        JL_passwordtext = new JLabel("Contraseña");
        JTF_password = new JTextField();
        JB_login = new JButton("Entrar");
        actionpanel = new JPanel();
        connectionBar = new JProgressBar();

        //Operacion De Componentes
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(1920, 1080);

        contentpanel.setPreferredSize(new Dimension(1920, 1080));
        //contentpanel.setBackground(new Color(26,26,29));
        contentpanel.setLayout(null);

        connectionBar.setValue(0);
        connectionBar.setBounds(279, 342, 160, 10);
        connectionBar.setStringPainted(true);

        actionpanel.putClientProperty(FlatClientProperties.STYLE, "arc:65;");
        actionpanel.setBounds(LoginConstants.loginActPanel_X, LoginConstants.loginActPanel_Y, LoginConstants.loginActPanel_Width, LoginConstants.loginActPanel_Height);
        actionpanel.setLayout(null);
        actionpanel.setBackground(Color.white);

        logintext.setBounds(LoginConstants.loginTxtlbl_X, LoginConstants.loginTxtlbl_Y, LoginConstants.loginTxtlbl_Width, LoginConstants.loginTxtlbl_Height);
        //logintext.setBackground(Color.white);
        logintext.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JL_passwordtext.setBounds(LoginConstants.PassTxtlbl_X, LoginConstants.PassTxtlbl_Y, LoginConstants.PassTxtlbl_Width, LoginConstants.PassTxtlbl_Height);
        JL_passwordtext.setBackground(Color.white);
        JL_passwordtext.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JTF_username.setBounds(LoginConstants.UsTF_X, LoginConstants.UsTF_Y, LoginConstants.UsTF_Width, LoginConstants.UsTF_Height);
        JTF_password.setBounds(LoginConstants.passTF_X, LoginConstants.passTF_Y, LoginConstants.passTF_Width, LoginConstants.passTF_Height);
        JTF_username.putClientProperty(FlatClientProperties.STYLE, "arc:20;");
        JTF_password.putClientProperty(FlatClientProperties.STYLE, "arc:20;");

        JB_login.setBounds(LoginConstants.Enbtn_X, LoginConstants.Enbtn_Y, LoginConstants.Enbtn_Width, LoginConstants.Enbtn_Height);
        JB_login.putClientProperty(FlatClientProperties.STYLE, "arc:20;");

        //Añadiendo De Componentes A Su Padres
        actionpanel.add(connectionBar);
        actionpanel.add(logintext);
        actionpanel.add(JTF_username);
        actionpanel.add(JL_passwordtext);
        actionpanel.add(JTF_password);
        actionpanel.add(JB_login);
        contentpanel.add(actionpanel);

        loginframe.setVisible(true);
        loginframe.add(contentpanel);
        loginframe.setResizable(false);
        loginframe.setLocationRelativeTo(null);
    }

    public void loginOnClickListener(ActionListener listener) {
        this.JB_login.addActionListener(listener);
    }

    public JButton getJB_login() {
        return JB_login;
    }

    public JProgressBar getConnectionBar() {
        return connectionBar;
    }

    public void setConnectionBar(JProgressBar connectionBar) {
        this.connectionBar = connectionBar;
    }

    public JTextField getJTF_username() {
        return JTF_username;
    }

    public JTextField getJTF_password() {
        return JTF_password;
    }

    public JFrame getLoginframe() {
        return loginframe;
    }

}
