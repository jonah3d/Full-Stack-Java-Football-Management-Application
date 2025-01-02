/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatPropertiesLaf;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonah
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionListener;
import org.joe.application.views.HintTextField;
import raven.datetime.component.date.DatePicker;

public class VerJugadores extends JPanel {

    JTable playerDet_Table;
    JTextField namefilter;
    JLabel nameJLabel;
    JTextField niffilter;
    JLabel niJLabel;
    DatePicker anonacfilter;
    JLabel anoJLabel;
    JFormattedTextField anonaceditorfilter;
    JComboBox<String> catComboBox;
    JLabel catJLabel;
    JComboBox<String> ordenarComboBox;
    JLabel ordenarJLabel;
    JButton refresh;
    JLabel erromessage;

    public VerJugadores() {

        setLayout(null);

        initialiseComponents();

    }

    private void initialiseComponents() {
        namefilter = new JTextField();
        niffilter = new JTextField();
        anonacfilter = new DatePicker();
        anonaceditorfilter = new JFormattedTextField();
        catComboBox = new JComboBox<>();
        ordenarComboBox = new JComboBox<>();
        refresh = new JButton("Refrescar");
        erromessage = new JLabel();

        nameJLabel = new JLabel("Apellido");
        niJLabel = new JLabel("Id Legal");
        anoJLabel = new JLabel("Año Nacimiento");
        catJLabel = new JLabel("Categoría");
        ordenarJLabel = new JLabel("Ordenar por");

        namefilter.setBounds(20, 17, 140, 30);
        namefilter.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        niffilter.setBounds(170, 17, 140, 30);
        niffilter.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        anonaceditorfilter.setBounds(320, 17, 140, 30);
        anonacfilter.setEditor(anonaceditorfilter);
        anonaceditorfilter.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        catComboBox.setBounds(470, 17, 140, 30);
        catComboBox.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        ordenarComboBox.setBounds(620, 17, 140, 30);
        ordenarComboBox.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        refresh.setBounds(820, 17, 100, 30);
        refresh.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        nameJLabel.setBounds(20, 50, 100, 30);
        niJLabel.setBounds(170, 50, 100, 30);
        anoJLabel.setBounds(320, 50, 100, 30);
        catJLabel.setBounds(470, 50, 100, 30);
        ordenarJLabel.setBounds(620, 50, 100, 30);

        String[] ordenarlist = {"", "Apellido", "Año Nacimiento"};
        for (String item : ordenarlist) {
            ordenarComboBox.addItem(item);
        }

        String[] columnNames = {"NIF", "Nom", "Apellido", "Edat", "Sexe", "Categoria", "Localidad", "Medical Revision"};
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

        playerDet_Table = new JTable(tableModel);

        //playerDet_Table = new JTable(tableModel);
        playerDet_Table.setRowHeight(25);
        playerDet_Table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(playerDet_Table);
        scrollPane.setBounds(20, 90, 900, 500);
        erromessage.setBounds(830, 590, 100, 20);
        erromessage.setVisible(false);
        erromessage.setForeground(Color.red);

        this.add(scrollPane);

        this.add(namefilter);
        this.add(niffilter);
        this.add(anonaceditorfilter);
        this.add(catComboBox);
        this.add(ordenarComboBox);
        this.add(refresh);

        this.add(nameJLabel);
        this.add(niJLabel);
        this.add(anoJLabel);
        this.add(catJLabel);
        this.add(ordenarJLabel);
        this.add(erromessage);
    }

    public JLabel getErromessage() {
        return erromessage;
    }

    public JTable getPlayerDet_Table() {
        return playerDet_Table;
    }

    public JButton getRefresh() {
        return refresh;
    }

    public JTextField getNamefilter() {
        return namefilter;
    }

    public JTextField getNiffilter() {
        return niffilter;
    }

    public DatePicker getAnonacfilter() {
        return anonacfilter;
    }

    public JFormattedTextField getAnonaceditorfilter() {
        return anonaceditorfilter;
    }

    public JComboBox<String> getCatComboBox() {
        return catComboBox;
    }

    public JComboBox<String> getOrdenarComboBox() {
        return ordenarComboBox;
    }

    public void refreshbutton(ActionListener listener) {
        refresh.addActionListener(listener);
    }
}
