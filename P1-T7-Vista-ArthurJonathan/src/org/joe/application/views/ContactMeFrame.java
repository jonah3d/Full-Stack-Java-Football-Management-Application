package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ContactMeFrame extends JFrame {

    private JLabel emailLabel, subjectLabel, messageLabel;
    private JTextField emailField, subjectField;
    private JTextArea messageArea;
    private JScrollPane messageScrollPane;
    private JButton sendButton;

    public ContactMeFrame() {
        setSize(400, 300);
        setTitle("Contactame");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initialiseComponents();
    }

    private void initialiseComponents() {

        emailLabel = new JLabel("Email (tuyo):");
        emailLabel.setBounds(30, 20, 100, 20);
        add(emailLabel);

        subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(30, 60, 100, 20);
        add(subjectLabel);

        messageLabel = new JLabel("Message:");
        messageLabel.setBounds(30, 100, 100, 20);
        add(messageLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 20, 200, 25);
        emailField.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(emailField);

        subjectField = new JTextField();
        subjectField.setBounds(140, 60, 200, 25);
        subjectField.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(subjectField);

        messageArea = new JTextArea();

        messageScrollPane = new JScrollPane(messageArea);
        messageScrollPane.setBounds(140, 100, 200, 80);
        add(messageScrollPane);

        sendButton = new JButton("Enviar");
        sendButton.setToolTipText("Pulsa para enviar mensaje al desarrollador");
        sendButton.setBounds(140, 200, 100, 30);
        sendButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(sendButton);
    }

    public void sendButton_Onclick(ActionListener listener) {
        this.sendButton.addActionListener(listener);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getSubjectField() {
        return subjectField;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public JButton getSendButton() {
        return sendButton;
    }

}
