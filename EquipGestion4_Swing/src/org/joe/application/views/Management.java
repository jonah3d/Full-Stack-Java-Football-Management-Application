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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.joe.application.constants.ManagemetConstants;
import org.joe.application.controllers.PlayerManagementController;
import org.joe.application.controllers.TeamManagementController;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class Management extends JFrame {

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu season;
    JMenu dataMenu;
    /*DATA MENU ITEMS*/
    //Xml
    JMenu exportXmlMenu;
    JMenu jugadoresxml;
    JMenu teamxml;
    JMenuItem todjugadores;
    JMenuItem jugador;

    JMenu todequipo;
    JMenuItem equipo;
    JMenuItem temporadaitem;
    JMenuItem categoriaitem;

    //Jasper
    JMenu exportJsperMenuItem;

    //CSV
    JMenu exportCSVMenuItem;

    JMenu aboutMenu;
    JMenu helpMenu;
    JMenuItem createseason;
    JPanel mngmtypePanel;
    JButton playermngmtBTN;
    JButton teammngmtBTN;
    JTabbedPane managementTyTabbedPane;
    private EquipDataInterface edi;

    public Management(EquipDataInterface edi) {
        this.edi = edi;
        initializeComponents();
    }

    public void initializeComponents() {

        setSize(1280, 720);
        setLayout(null);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Archivo");
        dataMenu = new JMenu("Data");
        helpMenu = new JMenu("Ayuda");
        aboutMenu = new JMenu("Sobre");
        season = new JMenu("Temporada");
        createseason = new JMenuItem("Crear Temporada");
        playermngmtBTN = new JButton("Player Management");
        teammngmtBTN = new JButton("Team Management");
        managementTyTabbedPane = new JTabbedPane(JTabbedPane.NORTH);

        exportXmlMenu = new JMenu("Exportar Xml");
        jugadoresxml = new JMenu("Jugadores");
        teamxml = new JMenu("Equipos");
        todjugadores = new JMenuItem("Todo Jugadores");
        jugador = new JMenuItem("Jugador");

        todequipo = new JMenu("Todo Equipos");
        equipo = new JMenuItem("Equipo");
        temporadaitem = new JMenuItem("Temporada");
        categoriaitem = new JMenuItem("Categoria");

        exportJsperMenuItem = new JMenu("Exportar Report");
        exportCSVMenuItem = new JMenu("Exportar Csv");

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

        PlayerManagementController pms = new PlayerManagementController(edi);
        TeamManagementController tms = new TeamManagementController(edi);

        managementTyTabbedPane.setBounds(0, 10, 1280, 671);
        managementTyTabbedPane.add("Panel1", pms.getPlayerManagementScreen());
        managementTyTabbedPane.add("Panel2", tms.getTeamManagementScreen());
        menuBar.add(fileMenu);
        menuBar.add(dataMenu);
        menuBar.add(season);
        season.add(createseason);
        menuBar.add(helpMenu);
        menuBar.add(aboutMenu);

        dataMenu.add(exportXmlMenu);
        dataMenu.add(exportJsperMenuItem);
        dataMenu.add(exportCSVMenuItem);

        exportXmlMenu.add(jugadoresxml);
        jugadoresxml.add(todjugadores);
        jugadoresxml.add(jugador);

        exportXmlMenu.add(teamxml);
        teamxml.add(todequipo);
        todequipo.add(temporadaitem);
        todequipo.add(categoriaitem);
        teamxml.add(equipo);

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

    public void CreateTemp_OnClick(ActionListener listener) {
        createseason.addActionListener(listener);
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

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getSeason() {
        return season;
    }

    public JMenu getDataMenu() {
        return dataMenu;
    }

    public JMenu getAboutMenu() {
        return aboutMenu;
    }

    public JMenu getHelpMenu() {
        return helpMenu;
    }

    public JMenuItem getCreateseason() {
        return createseason;
    }

    public JPanel getMngmtypePanel() {
        return mngmtypePanel;
    }

    public EquipDataInterface getEdi() {
        return edi;
    }

}
