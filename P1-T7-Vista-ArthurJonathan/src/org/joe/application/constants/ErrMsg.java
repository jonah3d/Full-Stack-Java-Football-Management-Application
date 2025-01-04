/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.constants;

import javax.swing.JOptionPane;

/**
 *
 * @author jonah
 */
public class ErrMsg {

    public static void error(String message, Throwable cause) {
        String fullMessage = message;
        if (cause != null) {
            fullMessage += "\nCausa: " + cause.getMessage();
        }

        JOptionPane.showMessageDialog(
                JOptionPane.getRootFrame(),
                fullMessage,
                "Error De Campo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
