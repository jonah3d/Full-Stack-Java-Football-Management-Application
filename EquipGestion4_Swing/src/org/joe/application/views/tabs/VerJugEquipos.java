/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonah
 */
public class VerJugEquipos extends JPanel {

    JTable teamTable;
    JTable playerTable;
    JLabel teamJLabel;
    JLabel playerJLabel;

    public VerJugEquipos() {
        setLayout(null);

        initComponents();
    }

    private void initComponents() {

        String[] TcolumnNames = {"Nom", "Categoria", "Tipo", "Temporada"};
        String[] PTableNames = {"NOM", "COGNOM", "EDAT", "SEXE", "CATEGORIA"};
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

        this.add(TscrollPane);
        this.add(PsScrollPane);
        this.add(teamJLabel);
        this.add(playerJLabel);
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

}
