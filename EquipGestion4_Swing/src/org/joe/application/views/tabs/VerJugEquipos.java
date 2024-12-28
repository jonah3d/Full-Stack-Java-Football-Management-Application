/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.joe.application.constants.ManagemetConstants;

/**
 *
 * @author jonah
 */
public class VerJugEquipos extends JPanel {

    JTable teamTable;
    JTable playerTable;
    JLabel teamJLabel;
    JLabel playerJLabel;
    JRadioButton titularidad;

    JLabel añdJugEqLb;
    JTable addplayerJTable;
    JButton addjugadorbtn;
    JButton deljugadorbtn;

    public VerJugEquipos() {
        setLayout(null);

        initComponents();
    }

    private void initComponents() {

        String[] TcolumnNames = {"Nom", "Categoria", "Tipo", "Temporada"};
        String[] PTableNames = {"NOM", "COGNOM", "EDAT", "SEXE", "CATEGORIA", "Titularidad"};
        DefaultTableModel teamTableModel = new DefaultTableModel(TcolumnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {

                if (columnIndex == 7) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        teamTable = new JTable(teamTableModel);
        teamJLabel = new JLabel("EQUIPOS");
        teamTable.setRowHeight(25);
        JScrollPane TscrollPane = new JScrollPane(teamTable);
        TscrollPane.setBounds(20, 40, 500, 150);
        teamJLabel.setBounds(20, 20, 75, 17);

        DefaultTableModel PlaayerTableModel = new DefaultTableModel(PTableNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {

                if (columnIndex == 7) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        playerTable = new JTable(PlaayerTableModel);
        playerJLabel = new JLabel("JUGADORES");
        playerTable.setRowHeight(25);
        JScrollPane PsScrollPane = new JScrollPane(playerTable);
        PsScrollPane.setBounds(20, 250, 500, 150);
        playerJLabel.setBounds(20, 230, 75, 17);

        String[] ADPTableNames = {"NOM", "COGNOM", "EDAT", "SEXE", "CATEGORIA"};
        DefaultTableModel ADPTableModel = new DefaultTableModel(ADPTableNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {

                if (columnIndex == 7) {
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };
        añdJugEqLb = new JLabel("Añadir Jugadores A Equipo");
        añdJugEqLb.setBounds(600, 20, 150, 17);
        addplayerJTable = new JTable(ADPTableModel);
        addplayerJTable.setRowHeight(25);
        JScrollPane ADPScrollPane = new JScrollPane(addplayerJTable);
        ADPScrollPane.setBounds(600, 40, 400, 150);

        addjugadorbtn = new JButton();
        addjugadorbtn.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_addjug.svg", 0.7f));
        addjugadorbtn.putClientProperty(FlatClientProperties.BUTTON_TYPE, "borderless");
        addjugadorbtn.setBounds(530, 100, 60, 35);
        addjugadorbtn.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        deljugadorbtn = new JButton("Delete Jugador");

        deljugadorbtn.setBounds(530, 300, 250, 35);
        titularidad = new JRadioButton("Titular?");
        titularidad.setBounds(530, 140, 60, 17);

        this.add(TscrollPane);
        this.add(PsScrollPane);
        this.add(teamJLabel);
        this.add(playerJLabel);
        this.add(añdJugEqLb);
        this.add(ADPScrollPane);
        this.add(addjugadorbtn);
        this.add(deljugadorbtn);
        this.add(titularidad);
    }

    public JTable getTeamTable() {
        return teamTable;
    }

    public JTable getPlayerTable() {
        return playerTable;
    }

    public JLabel getTeamJLabel() {
        return teamJLabel;
    }

    public JLabel getPlayerJLabel() {
        return playerJLabel;
    }

    public JLabel getAñdJugEqLb() {
        return añdJugEqLb;
    }

    public JTable getAddplayerJTable() {
        return addplayerJTable;
    }

    public JButton getAddjugadorbtn() {
        return addjugadorbtn;
    }

    public void addJugadorEquipo(ActionListener listener) {
        this.addjugadorbtn.addActionListener(listener);
    }

    public void delJugadorEquipo(ActionListener listener) {
        this.deljugadorbtn.addActionListener(listener);
    }

    public JButton getDeljugadorbtn() {
        return deljugadorbtn;
    }

    public JRadioButton getTitularidad() {
        return titularidad;
    }

}
