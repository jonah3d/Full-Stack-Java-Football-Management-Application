/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonah
 */
public class VerEquipos extends JPanel {

    JTable teamDetails_JTable;
    JLabel temporadaJLabel;
    JLabel categoriaJLabel;
    JComboBox<String> catComboBox;
    JComboBox<String> tempComboBox;
    JButton refresh;

    public VerEquipos() {
        setLayout(null);

        initialiseComponents();
    }

    private void initialiseComponents() {
        temporadaJLabel = new JLabel("Temporada");
        categoriaJLabel = new JLabel("Categoria");
        catComboBox = new JComboBox<>();
        tempComboBox = new JComboBox<>();
        refresh = new JButton("Refrescar");

        categoriaJLabel.setBounds(170, 50, 100, 30);
        catComboBox.setBounds(170, 17, 140, 30);
        temporadaJLabel.setBounds(20, 50, 100, 30);
        tempComboBox.setBounds(20, 17, 140, 30);

        refresh.setBounds(320, 17, 140, 30);
        refresh.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        String[] columnNames = {"Nom", "Categoria", "Tipo", "Temporada",};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
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
        teamDetails_JTable = new JTable(tableModel);
        teamDetails_JTable = new JTable(tableModel);

        teamDetails_JTable.setRowHeight(25);
        teamDetails_JTable.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(teamDetails_JTable);
        scrollPane.setBounds(20, 90, 900, 500);

        this.add(scrollPane);
        this.add(temporadaJLabel);
        this.add(categoriaJLabel);
        this.add(catComboBox);
        this.add(tempComboBox);
        this.add(refresh);
    }

    public JTable getTeamDetails_JTable() {
        return teamDetails_JTable;
    }

    public JLabel getTemporadaJLabel() {
        return temporadaJLabel;
    }

    public JLabel getCategoriaJLabel() {
        return categoriaJLabel;
    }

    public JComboBox<String> getCatComboBox() {
        return catComboBox;
    }

    public JComboBox<String> getTempComboBox() {
        return tempComboBox;
    }

    public JButton getRefresh() {
        return refresh;
    }

}
