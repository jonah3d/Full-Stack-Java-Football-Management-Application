/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jonah
 */
public class VerJugadores extends JPanel {
    
    
    
    public VerJugadores(){
        
        setLayout(null);
        setSize(1589, 970);
        //setBackground(Color.white);
         JLabel label = new JLabel("Team Information");
        label.setBounds(10, 10, 200, 30);
        add(label);
        
        JButton button = new JButton("Action Button");
        button.setBounds(10, 50, 150, 30);
        add(button);
    }
}
