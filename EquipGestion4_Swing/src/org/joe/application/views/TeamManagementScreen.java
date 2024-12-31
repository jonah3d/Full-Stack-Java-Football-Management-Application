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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.joe.application.constants.ManagemetConstants;

/**
 *
 * @author jonah
 */
public class TeamManagementScreen extends JPanel {

    JPanel sideJPanel;
    JButton seeEquip_Btn;
    JButton addEquip_Btn;
    JButton seeJugEquip_Btn;
    JButton elimEquip_Btn;
    JTabbedPane centerJPanel;

    public TeamManagementScreen() {
        initializeComponents();
    }

    private void initializeComponents() {
        sideJPanel = new JPanel(null);

        sideJPanel.setBounds(0, 4, 244, 634);
        seeEquip_Btn = new JButton("Ver Equipos");
        addEquip_Btn = new JButton("Añadir Equipos");
        seeJugEquip_Btn = new JButton("Jugadores Equip");
        elimEquip_Btn = new JButton("Eliminar Equipo");

        centerJPanel = new JTabbedPane();
        centerJPanel.setBackground(Color.magenta);
        centerJPanel.setBounds(244, -33, 1022, 631);

        seeEquip_Btn.setBounds(17, 100, 200, 43);
        seeEquip_Btn.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        seeEquip_Btn.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_verjug.svg", 0.7f));

        addEquip_Btn.setBounds(17, 200, 200, 43);
        addEquip_Btn.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        addEquip_Btn.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_addjug.svg", 0.7f));

        seeJugEquip_Btn.setBounds(17, 300, 200, 43);
        seeJugEquip_Btn.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        seeJugEquip_Btn.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_editjug.svg", 0.7f));

        elimEquip_Btn.setBounds(17, 400, 200, 43);
        elimEquip_Btn.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        elimEquip_Btn.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_deljug.svg", 0.7f));

        sideJPanel.add(seeEquip_Btn);
        sideJPanel.add(addEquip_Btn);
        sideJPanel.add(seeJugEquip_Btn);
        sideJPanel.add(elimEquip_Btn);

        this.add(sideJPanel);
        this.add(centerJPanel);

        setLayout(null);
    }

    public JTabbedPane getCenterJPanel() {
        return centerJPanel;
    }

    public JButton getSeeEquip_Btn() {
        return seeEquip_Btn;
    }

    public JButton getAddEquip_Btn() {
        return addEquip_Btn;
    }

    public JButton getSeeJugEquip_Btn() {
        return seeJugEquip_Btn;
    }

    public JButton getElimEquip_Btn() {
        return elimEquip_Btn;
    }

    public void verEquip_OnClick(ActionListener listener) {
        this.seeEquip_Btn.addActionListener(listener);
    }

    public void addEquip_OnClick(ActionListener listener) {
        this.addEquip_Btn.addActionListener(listener);
    }

    public void seeJugEquip_OnClick(ActionListener listener) {
        this.seeJugEquip_Btn.addActionListener(listener);
    }

    public void elimEquip_OnClick(ActionListener listener) {
        this.elimEquip_Btn.addActionListener(listener);
    }
}
