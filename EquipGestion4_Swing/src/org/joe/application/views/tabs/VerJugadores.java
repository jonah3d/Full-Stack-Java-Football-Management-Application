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

public class VerJugadores extends JPanel {

    JPanel btn_filterJPanel;
    JToggleButton namefilt_TB;
    JToggleButton niffilt_TB;
    JToggleButton datnaixfilt_TB;
    JToggleButton catfilt_TB;
    JToggleButton sexfilt_TB;
    JTextField search_TF;
    JComboBox<String> searchord_CB;
    JTable playerDet_Table;

    public VerJugadores() {

        setLayout(null);
        setSize(1589, 970);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);

        // Filter Buttons Panel
        btn_filterJPanel = new JPanel(flowLayout);
        namefilt_TB = new JToggleButton("Nom", true);
        niffilt_TB = new JToggleButton("Nif");
        datnaixfilt_TB = new JToggleButton("Data Naixement");
        catfilt_TB = new JToggleButton("Categoria");
        sexfilt_TB = new JToggleButton("Sexe");
        search_TF = new JTextField();
        searchord_CB = new JComboBox<>();
        playerDet_Table = new JTable();

        // Define column names and set up table model
        String[] plytab_ColNames = {"NIF", "NOMBRE", "EDAD", "SEXE", "CATEGORIA", "REV FIN", "DIRECCION"};
        DefaultTableModel tableModel = new DefaultTableModel(plytab_ColNames, 0);
        playerDet_Table.setModel(tableModel);

        // Text Field Properties
        search_TF.setBounds(520, 77, 512, 48);
        search_TF.putClientProperty(FlatClientProperties.STYLE, "arc:12;");

        // ComboBox Properties
        searchord_CB.setBounds(1050, 77, 176, 48);

        // Table wrapped in JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(playerDet_Table);
        tableScrollPane.setBounds(73, 140, 1440, 720);

        // Filter Buttons Panel Setup
        btn_filterJPanel.setBounds(73, 77, 432, 44);
        btn_filterJPanel.setBackground(new Color(221, 221, 221));
        btn_filterJPanel.putClientProperty(FlatClientProperties.STYLE, "arc:12;");
        btn_filterJPanel.add(namefilt_TB);
        btn_filterJPanel.add(niffilt_TB);
        btn_filterJPanel.add(datnaixfilt_TB);
        btn_filterJPanel.add(catfilt_TB);
        btn_filterJPanel.add(sexfilt_TB);

        // Add components to the panel
        add(btn_filterJPanel);
        add(search_TF);
        add(searchord_CB);
        add(tableScrollPane); // Add JScrollPane instead of JTable directly
    }
}
