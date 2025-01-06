/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class ExportarEquipoCSVFrame extends JFrame {

    JLabel temporadaLabel;
    JFormattedTextField datefield;
    DatePicker datePicker;
    JButton searchButton;
    JLabel filename;
    JTextField filenameTF;
    JLabel filepath;
    JTextField filepathTF;
    JButton browseButton;
    JButton exportButton;
    JFileChooser filepathChooser;

    public ExportarEquipoCSVFrame() {
        setSize(400, 300);
        setTitle("Exportar Equipo");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initialiseComponents();
    }

    private void initialiseComponents() {
        filename = new JLabel("Nombre del archivo(.xml)");
        filepath = new JLabel("Dirección del archivo");
        filenameTF = new JTextField();
        filepathTF = new JTextField();
        browseButton = new JButton("Browse");
        exportButton = new JButton("Exportar");
        filepathChooser = new JFileChooser();
        filepathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        temporadaLabel = new JLabel("Temporada A Exportar");

        searchButton = new JButton("Buscar");
        searchButton.setToolTipText("Pulsa para buscar equipo");

        datePicker = new DatePicker();
        datefield = new JFormattedTextField();

        temporadaLabel.setBounds(30, 10, 300, 17);
        datefield.setBounds(30, 30, 150, 30);
        datefield.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        searchButton.setBounds(190, 30, 120, 30);
        searchButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        datePicker.setEditor(datefield);

        filename.setBounds(30, 80, 300, 17);
        filenameTF.setBounds(30, 100, 150, 30);
        filenameTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        filepath.setBounds(30, 150, 300, 17);
        filepathTF.setBounds(30, 180, 150, 30);
        filepathTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        browseButton.setBounds(190, 180, 120, 30);
        browseButton.setToolTipText("Seleciona dirección del archivo");
        browseButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        exportButton.setBounds(30, 225, 100, 30);
        exportButton.setToolTipText("Pulsa para guardar equipos");

        add(filename);
        add(filenameTF);
        add(filepath);
        add(filepathTF);
        add(browseButton);
        add(exportButton);
        add(temporadaLabel);
        add(searchButton);

        add(datefield);

    }

    public JLabel getTemporadaLabel() {
        return temporadaLabel;
    }

    public JFormattedTextField getDatefield() {
        return datefield;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JLabel getFilename() {
        return filename;
    }

    public JTextField getFilenameTF() {
        return filenameTF;
    }

    public JLabel getFilepath() {
        return filepath;
    }

    public JTextField getFilepathTF() {
        return filepathTF;
    }

    public JButton getBrowseButton() {
        return browseButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }

    public JFileChooser getFilepathChooser() {
        return filepathChooser;
    }

    public void browsDir_onClick(ActionListener listener) {
        this.browseButton.addActionListener(listener);
    }

    public void exportarJug_OnClick(ActionListener listener) {
        this.exportButton.addActionListener(listener);
    }

    public void searhJugador_OnClick(ActionListener listener) {
        this.searchButton.addActionListener(listener);
    }
}
