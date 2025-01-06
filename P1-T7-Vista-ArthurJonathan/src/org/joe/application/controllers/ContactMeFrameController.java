/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import org.joe.application.views.ContactMeFrame;

/**
 *
 * @author jonah
 */
public class ContactMeFrameController implements ActionListener {

    private ContactMeFrame cmf;
    private final String recipient = "jonah3d.arthur@gmail.com";

    public ContactMeFrameController() {
        cmf = new ContactMeFrame();
        cmf.setVisible(true);
        cmf.sendButton_Onclick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cmf.getSendButton()) {
            sendEmail();
        }
    }

    private void sendEmail() {
        try {

            String userEmail = cmf.getEmailField().getText();
            String problem = cmf.getSubjectField().getText();
            String description = cmf.getMessageArea().getText();

            if (userEmail.isEmpty() || problem.isEmpty() || description.isEmpty()) {
                System.err.println("All fields must be filled!");
                return;
            }

            String subject = URLEncoder.encode(problem, "UTF-8");
            String body = URLEncoder.encode("From: " + userEmail + "\n\n" + description, "UTF-8");
            String mailtoURI = String.format("mailto:%s?subject=%s&body=%s", recipient, subject, body);

            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                desktop.mail(new URI(mailtoURI));
            } else {
                System.err.println("Mail client is not supported on this system.");
            }
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Error encoding email fields: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error opening mail client: " + ex.getMessage());
        }
    }

}
