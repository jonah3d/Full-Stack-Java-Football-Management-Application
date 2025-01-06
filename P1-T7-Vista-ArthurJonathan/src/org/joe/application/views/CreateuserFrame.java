/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import org.joe.gestion.model.persistence.EquipDataInterface;

public class CreateuserFrame extends JFrame {

    JTextField txtUsuario;
    JTextField txtNombre;
    JPasswordField txtContraseña;
    JPasswordField txtConfirmarContrasena;
    JButton btnCrear;
    private EquipDataInterface edi;

    public CreateuserFrame(EquipDataInterface edi) {
        this.edi = edi;
        setTitle("Create User");
        setSize(336, 476);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        initializeComponents();
        listeners();
    }

    private void initializeComponents() {

        setLayout(null);

        JLabel lblUsuario = new JLabel("USUARIO:");
        lblUsuario.setBounds(20, 20, 100, 30);
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(lblUsuario);

        JLabel lblNombre = new JLabel("NOMBRE:");
        lblNombre.setBounds(20, 90, 100, 30);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(lblNombre);

        JLabel lblContraseña = new JLabel("CONTRASEÑA");
        lblContraseña.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblContraseña.setBounds(20, 160, 100, 30);
        add(lblContraseña);

        JLabel lblConfirmarContrasena = new JLabel("CONFIRMAR CONTRASEÑA:");
        lblConfirmarContrasena.setBounds(20, 230, 200, 30);
        lblConfirmarContrasena.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(lblConfirmarContrasena);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(20, 50, 280, 30);
        txtUsuario.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        add(txtUsuario);

        txtNombre = new JTextField();
        txtNombre.setBounds(20, 120, 280, 30);
        txtNombre.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        add(txtNombre);

        txtContraseña = new JPasswordField();
        txtContraseña.putClientProperty(FlatClientProperties.STYLE, "arc:12;showRevealButton:true;");

        txtContraseña.setBounds(20, 190, 280, 30);
        add(txtContraseña);

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setBounds(20, 260, 280, 30);
        txtConfirmarContrasena.putClientProperty(FlatClientProperties.STYLE, "arc:12;showRevealButton:true;");
        add(txtConfirmarContrasena);

        btnCrear = new JButton("Crear");
        btnCrear.setToolTipText("Pulsa para crear nuevo usuario");
        btnCrear.setBounds(115, 400, 100, 30);
        btnCrear.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        add(btnCrear);
    }

    private void listeners() {
        btnCrear.addActionListener((e) -> {
            if (e.getSource() == btnCrear) {

                String password = new String(txtContraseña.getPassword()).trim();
                String conpassword = new String(txtConfirmarContrasena.getPassword()).trim();

                if (password.equals(conpassword)) {
                    try {
                        edi.createUser(txtUsuario.getText().trim(), txtNombre.getText().trim(), password);
                        JOptionPane.showMessageDialog(null, "User Creado");
                        this.dispose();
                    } catch (Exception ex) {
                        error(ex.getMessage(), ex.getCause());
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Confirmar que las contraseñas coinciden",
                            "Credenciales Inválidas",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    private void error(String message, Throwable cause) {
        String fullMessage = message;
        if (cause != null) {
            fullMessage += "\nCausa: " + cause.getMessage();
        }

        JOptionPane.showMessageDialog(
                createRootPane(),
                fullMessage,
                "Error De Campo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
