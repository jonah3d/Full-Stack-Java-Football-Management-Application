package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Font;
import javax.swing.*;
import org.joe.application.constants.ErrMsg;
import org.joe.gestion.model.persistence.EquipDataInterface;

public class RetrievePassowordFrame extends JFrame {

    JTextField txtUsuario;
    JPasswordField txtContraseña;
    JPasswordField txtConfirmarContrasena;
    JButton btnUpdate;
    private EquipDataInterface edi;

    public RetrievePassowordFrame(EquipDataInterface edi) {
        this.edi = edi;
        setTitle("Reestablecer Contraseña");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use null layout for absolute positioning
        setResizable(false);
        setVisible(true);
        initializeComponents();

        listeners();
    }

    private void initializeComponents() {
        // Labels
        JLabel lblUsuario = new JLabel("USUARIO:");
        lblUsuario.setBounds(20, 20, 150, 30);
        lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(lblUsuario);

        JLabel lblContraseña = new JLabel("Nuevo Contraseña:");
        lblContraseña.setBounds(20, 90, 150, 30);
        lblContraseña.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(lblContraseña);

        JLabel lblConContraseña = new JLabel("Confirmar Contraseña:");
        lblConContraseña.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblConContraseña.setBounds(20, 160, 180, 30);
        add(lblConContraseña);

        // Text fields
        txtUsuario = new JTextField();
        txtUsuario.setBounds(20, 50, 280, 30);
        txtUsuario.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        add(txtUsuario);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(20, 120, 280, 30);
        txtContraseña.putClientProperty(FlatClientProperties.STYLE, "arc:12;showRevealButton:true;");
        add(txtContraseña);

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setBounds(20, 190, 280, 30);
        txtConfirmarContrasena.putClientProperty(FlatClientProperties.STYLE, "arc:12;showRevealButton:true;");
        add(txtConfirmarContrasena);

        // Button
        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBounds(115, 250, 100, 30); // Centered horizontally
        btnUpdate.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        add(btnUpdate);
    }

    private void listeners() {
        btnUpdate.addActionListener((e) -> {
            if (e.getSource() == btnUpdate) {
                String password = new String(txtContraseña.getPassword()).trim();
                String conpassword = new String(txtConfirmarContrasena.getPassword()).trim();

                if (password.equals(conpassword)) {
                    try {
                        edi.restorePassword(txtUsuario.getText().trim(), password);
                        JOptionPane.showMessageDialog(this, "Contraseña actualizada exitosamente.");
                        this.dispose();
                    } catch (Exception ex) {
                        ErrMsg.error(ex.getMessage(), ex.getCause());
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Confirmar que las contraseñas coinciden",
                            "Credenciales Inválidas",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

}
