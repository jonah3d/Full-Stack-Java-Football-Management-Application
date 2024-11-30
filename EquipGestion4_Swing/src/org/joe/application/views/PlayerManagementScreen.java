/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatPropertiesLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import org.joe.application.constants.ManagemetConstants;
import org.joe.application.views.tabs.VerJugadores;

/**
 *
 * @author jonah
 */

public class PlayerManagementScreen {
    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu dataMenu;
    JMenu aboutMenu;
    JMenu helpMenu;
    JPanel contentPanel;
    JPanel sidepane;
    JPanel centerpane;
    JButton seeply_BTN;
    JButton addply_BTN;
    JButton edply_BTN;
    JButton delply_BTN;
    JComboBox<String> uisection;
    JTabbedPane playersections;
    
    public PlayerManagementScreen(){
        window();
        //verEquipos();
    }
    
 private void window(){
        
        //Initialising The component
        frame = new JFrame("Player Management");
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        dataMenu = new JMenu("Data");
        helpMenu = new JMenu("Help");
        aboutMenu = new JMenu("About");
        contentPanel = new JPanel();
        sidepane = new JPanel();
        centerpane = new JPanel();
        seeply_BTN = new JButton("Ver Jugadores");
        addply_BTN = new JButton("Añadir Jugadores");
        edply_BTN = new JButton("Editar Jugador");
        delply_BTN = new JButton("Eliminar Jugador");
        uisection = new JComboBox<>();
        playersections = new JTabbedPane(JTabbedPane.TOP);
                
        
        
        seeply_BTN.setBounds(17,318, 257, 43);
        seeply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        seeply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_verjug.svg",0.7f));
        
        addply_BTN.setBounds(17,421,257,43);
        addply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        addply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_addjug.svg",0.7f));
        
        edply_BTN.setBounds(17, 529, 257, 43);
        edply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        edply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_editjug.svg",0.7f));
        
        delply_BTN.setBounds(17,633,257,43);
        delply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        delply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_deljug.svg",0.7f));
        
        uisection.setBounds(9, 96, 279, 81);
        uisection.addItem("Player Management");
        uisection.addItem("Team Management");
        
        playersections.setBounds(0, 0, 1589, 970);
        playersections.setBackground(Color.red);
        
     VerJugadores verjugTab = new VerJugadores();
        playersections.addTab("Team 1",verjugTab);
        playersections.addTab("Team 2", new JLabel("Content for Team 2"));
        
       
        frame.setSize(ManagemetConstants.mgmtScrn_Width,ManagemetConstants.mgmtScrn_Height);
        frame.setLayout(null);
        
        contentPanel.setSize(ManagemetConstants.mgmtScrn_Width,ManagemetConstants.mgmtScrn_Height);
        contentPanel.setLayout(null);
        //contentPanel.setBackground(Color.red);
       
        sidepane.setLayout(null);
        //sidepane.setBackground(Color.yellow);
        sidepane.setBounds(ManagemetConstants.sdpane_X, ManagemetConstants.sdpane_Y, ManagemetConstants.sdpane_Width, ManagemetConstants.sdpane_Height);
        sidepane.add(seeply_BTN);
        sidepane.add(addply_BTN);
        sidepane.add(edply_BTN);
        sidepane.add(delply_BTN);
        sidepane.add(uisection);

        centerpane.setLayout(null);
        centerpane.setBackground(Color.WHITE);
        centerpane.putClientProperty(FlatClientProperties.STYLE, "arc:65;");
        centerpane.setBounds(ManagemetConstants.cnpane_X,ManagemetConstants.cnpane_Y,ManagemetConstants.cnpane_Width,ManagemetConstants.cnpane_Height);
        centerpane.add(playersections);
        centerpane.revalidate();
        centerpane.repaint();
        
          
       
       
        
        menuBar.add(fileMenu);
        menuBar.add(dataMenu);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);
        
        contentPanel.add(sidepane);
        contentPanel.add(centerpane);
        
        frame.add(contentPanel);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        
    } 


}