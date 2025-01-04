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
import javax.swing.JPasswordField;
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
    JPasswordField JTF_password;
    JButton JB_login;
    JLabel forgotten_passlbl;
    JPanel actionpanel;
    JProgressBar connectionBar;
    JButton registrar_btn;

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
        JTF_password = new JPasswordField();
        JB_login = new JButton("Entrar");
        actionpanel = new JPanel();
        connectionBar = new JProgressBar();
        forgotten_passlbl = new JLabel("Olvidado la contraseña?");
        registrar_btn = new JButton("Registrar");

        //Operacion De Componentes
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setSize(1280, 720);

        contentpanel.setPreferredSize(new Dimension(1280, 720));
        //contentpanel.setBackground(new Color(26,26,29));
        contentpanel.setLayout(null);

        connectionBar.setValue(0);
        connectionBar.setBounds(1090, 665, 160, 10);
        connectionBar.setStringPainted(true);

        actionpanel.putClientProperty(FlatClientProperties.STYLE, "arc:65;");
        actionpanel.setBounds(LoginConstants.loginActPanel_X, LoginConstants.loginActPanel_Y, LoginConstants.loginActPanel_Width, LoginConstants.loginActPanel_Height);
        actionpanel.setLayout(null);
        actionpanel.setBackground(Color.white);

        logintext.setBounds(LoginConstants.loginTxtlbl_X, LoginConstants.loginTxtlbl_Y, LoginConstants.loginTxtlbl_Width, LoginConstants.loginTxtlbl_Height);
        //logintext.setBackground(Color.white);
        logintext.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JL_passwordtext.setBounds(LoginConstants.PassTxtlbl_X, LoginConstants.PassTxtlbl_Y, LoginConstants.PassTxtlbl_Width, LoginConstants.PassTxtlbl_Height);
        JL_passwordtext.setBackground(Color.white);
        JL_passwordtext.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JTF_username.setBounds(LoginConstants.UsTF_X, LoginConstants.UsTF_Y, LoginConstants.UsTF_Width, LoginConstants.UsTF_Height);
        JTF_password.setBounds(LoginConstants.passTF_X, LoginConstants.passTF_Y, LoginConstants.passTF_Width, LoginConstants.passTF_Height);
        JTF_username.putClientProperty(FlatClientProperties.STYLE, "arc:20;");
        JTF_password.putClientProperty(FlatClientProperties.STYLE, "arc:20;showRevealButton:true;");

        JB_login.setBounds(LoginConstants.Enbtn_X, LoginConstants.Enbtn_Y, LoginConstants.Enbtn_Width, LoginConstants.Enbtn_Height);
        JB_login.putClientProperty(FlatClientProperties.STYLE, "arc:20;");

        forgotten_passlbl.setBounds(522, 310, 200, 17);
        forgotten_passlbl.setForeground(Color.decode("#0090FF"));

        registrar_btn.setBounds(522, 347, 96, 48);
        registrar_btn.putClientProperty(FlatClientProperties.STYLE, "arc:20;");

        //Añadiendo De Componentes A Su Padres
        contentpanel.add(connectionBar);
        actionpanel.add(logintext);
        actionpanel.add(JTF_username);
        actionpanel.add(JL_passwordtext);
        actionpanel.add(JTF_password);
        actionpanel.add(JB_login);
        actionpanel.add(forgotten_passlbl);
        actionpanel.add(registrar_btn);
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

    public JPasswordField getJTF_password() {
        return JTF_password;
    }

    public JFrame getLoginframe() {
        return loginframe;
    }

    public void registrarOnClick(ActionListener listener) {
        registrar_btn.addActionListener(listener);
    }

    public JLabel getForgotten_passlbl() {
        return forgotten_passlbl;
    }

    public JButton getRegistrar_btn() {
        return registrar_btn;
    }

}
