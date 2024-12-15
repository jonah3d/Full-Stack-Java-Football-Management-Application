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
import java.awt.event.ActionListener;
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
import org.joe.application.views.tabs.AnadirJugadores;
import org.joe.application.views.tabs.EditarJugadores;
import org.joe.application.views.tabs.VerJugadores;

/**
 *
 * @author jonah
 */
public class PlayerManagementScreen extends JPanel {

    JPanel sideJPanel;
    JButton seeply_BTN;
    JButton addply_BTN;
    JButton edply_BTN;
    JButton delply_BTN;
    JTabbedPane centerJPanel;

    public PlayerManagementScreen() {
        initializeComponents();
    }

    private void initializeComponents() {

        sideJPanel = new JPanel(null);
        // sideJPanel.setBackground(Color.BLUE);
        sideJPanel.setBounds(0, 4, 244, 634);
        seeply_BTN = new JButton("Ver Jugadores");
        addply_BTN = new JButton("Añadir Jugadores");
        edply_BTN = new JButton("Editar Jugador");
        delply_BTN = new JButton("Eliminar Jugador");

        centerJPanel = new JTabbedPane();
        centerJPanel.setBackground(Color.magenta);
        centerJPanel.setBounds(244, -33, 1022, 671);

        //VerJugadores verjugTab = new VerJugadores();
        //AnadirJugadores anadirJugadores = new AnadirJugadores();
        //EditarJugadores editarJugadores = new EditarJugadores();
        //centerJPanel.addTab("Team 1", verjugTab);
        //centerJPanel.addTab("Team 2", anadirJugadores);
        //centerJPanel.addTab("Team 3", editarJugadores);
        seeply_BTN.setBounds(17, 100, 200, 43);
        seeply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        seeply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_verjug.svg", 0.7f));

        addply_BTN.setBounds(17, 200, 200, 43);
        addply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        addply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_addjug.svg", 0.7f));

        edply_BTN.setBounds(17, 300, 200, 43);
        edply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        edply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_editjug.svg", 0.7f));

        delply_BTN.setBounds(17, 400, 200, 43);
        delply_BTN.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        delply_BTN.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_deljug.svg", 0.7f));

        sideJPanel.add(seeply_BTN);
        sideJPanel.add(addply_BTN);
        sideJPanel.add(edply_BTN);
        sideJPanel.add(delply_BTN);

        this.add(sideJPanel);
        this.add(centerJPanel);

        setLayout(null);
    }

    public JTabbedPane getCenterJPanel() {
        return centerJPanel;
    }

    public JButton getSeeply_BTN() {
        return seeply_BTN;
    }

    public JButton getAddply_BTN() {
        return addply_BTN;
    }

    public JButton getEdply_BTN() {
        return edply_BTN;
    }

    public JButton getDelply_BTN() {
        return delply_BTN;
    }

    public void verJugadores_OnClick(ActionListener listener) {
        seeply_BTN.addActionListener(listener);
    }

    public void anadirJugadores_OnClick(ActionListener listener) {
        addply_BTN.addActionListener(listener);
    }

    public void editarJugadores_OnClick(ActionListener listener) {
        edply_BTN.addActionListener(listener);

    }

    public void deleteJugadores_OnCLick(ActionListener listener) {
        delply_BTN.addActionListener(listener);
    }
}
