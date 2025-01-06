package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReportBugFrame extends JFrame {

    private JLabel emailLabel, problemLabel, descriptionLabel;
    private JTextField emailField, problemField;
    private JTextArea descriptionArea;
    private JButton sendButton;
    private JScrollPane descriptionScrollPane;

    public ReportBugFrame() {
        setSize(400, 300);
        setTitle("Informe de un Bug");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initialiseComponents();
    }

    private void initialiseComponents() {

        emailLabel = new JLabel("Email (tuyo):");
        emailLabel.setBounds(30, 20, 100, 20);
        add(emailLabel);

        problemLabel = new JLabel("Problem:");
        problemLabel.setBounds(30, 60, 100, 20);
        add(problemLabel);

        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(30, 100, 100, 20);
        add(descriptionLabel);

        emailField = new JTextField();
        emailField.setBounds(140, 20, 200, 25);
        emailField.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(emailField);

        problemField = new JTextField();
        problemField.setBounds(140, 60, 200, 25);
        problemField.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(problemField);

        descriptionArea = new JTextArea();

        descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setBounds(140, 100, 200, 80);
        add(descriptionScrollPane);

        sendButton = new JButton("Send");
        sendButton.setBounds(140, 200, 100, 30);
        sendButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        add(sendButton);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getProblemField() {
        return problemField;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public JButton getSendButton() {
        return sendButton;
    }

    public void sendButton_Onclick(ActionListener listener) {
        this.sendButton.addActionListener(listener);
    }
}
