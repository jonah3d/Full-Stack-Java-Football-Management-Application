/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author jonah
 */
public class Management extends JFrame {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu dataMenu;
    JMenu aboutMenu;
    JMenu helpMenu;

    public Management() {
        initializeComponents();
    }

    public void initializeComponents() {

        setSize(1280, 720);
        setLayout(null);
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        dataMenu = new JMenu("Data");
        helpMenu = new JMenu("Help");
        aboutMenu = new JMenu("About");
        menuBar.add(fileMenu);
        menuBar.add(dataMenu);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);
        setJMenuBar(menuBar);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
