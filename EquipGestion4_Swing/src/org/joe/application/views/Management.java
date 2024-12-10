/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.joe.application.constants.ManagemetConstants;

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
    JPanel mngmtypePanel;
    JButton playermngmtBTN;
    JButton teammngmtBTN;
    JTabbedPane managementTyTabbedPane;

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
        playermngmtBTN = new JButton("Player Management");
        teammngmtBTN = new JButton("Team Management");
        managementTyTabbedPane = new JTabbedPane(JTabbedPane.NORTH);

        mngmtypePanel = new JPanel(null);
        mngmtypePanel.setBounds(0, 0, 1280, 48);
        //mngmtypePanel.setBackground(Color.red);
        playermngmtBTN.setBounds(466, 4, 170, 40);
        teammngmtBTN.setBounds(640, 4, 170, 40);
        playermngmtBTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_football.svg", 0.7f));
        playermngmtBTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        teammngmtBTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_person.svg", 0.7f));
        teammngmtBTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.CYAN);
        panel1.add(new JLabel("This is Panel 1"));
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.MAGENTA);
        panel2.add(new JLabel("This is Panel 2"));

        managementTyTabbedPane.setBounds(0, 48, 1280, 633);
        managementTyTabbedPane.add("Panel1", panel1);
        managementTyTabbedPane.add("Panel2", panel2);

        menuBar.add(fileMenu);
        menuBar.add(dataMenu);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);

        mngmtypePanel.add(playermngmtBTN);
        mngmtypePanel.add(teammngmtBTN);

        setJMenuBar(menuBar);
        add(mngmtypePanel);
        add(managementTyTabbedPane);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void TeamManagementBTN_OnClick(ActionListener listener) {
        teammngmtBTN.addActionListener(listener);
    }

    public void PlayerMangementBTN_Onclick(ActionListener listener) {
        playermngmtBTN.addActionListener(listener);
    }

    public JButton getPlayermngmtBTN() {
        return playermngmtBTN;
    }

    public JButton getTeammngmtBTN() {
        return teammngmtBTN;
    }

    public JTabbedPane getManagementTyTabbedPane() {
        return managementTyTabbedPane;
    }

}
