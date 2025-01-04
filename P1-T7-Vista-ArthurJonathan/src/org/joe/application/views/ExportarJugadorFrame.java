/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jonah
 */
public class ExportarJugadorFrame extends JFrame {

    JLabel filename;
    JTextField jugadornifTf;
    JLabel filepath;
    JLabel jugadorJLabel;
    JTextField filenameTF;
    JTextField filepathTF;
    JButton searchButton;
    JButton browseButton;
    JButton exportButton;
    JFileChooser filepathChooser;

    public ExportarJugadorFrame() {
        setSize(400, 300);
        setTitle("Exportar Jugador");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initialiseComponents();
    }

    private void initialiseComponents() {
        filename = new JLabel("Nombre del archivo");
        filepath = new JLabel("Dirección del archivo");
        filenameTF = new JTextField();
        filepathTF = new JTextField();
        browseButton = new JButton("Browse");
        exportButton = new JButton("Exportar");
        filepathChooser = new JFileChooser();
        filepathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jugadorJLabel = new JLabel("Jugador A Exportar (NIF)");
        jugadornifTf = new JTextField();
        searchButton = new JButton("Buscar");

        jugadorJLabel.setBounds(30, 10, 300, 17);
        jugadornifTf.setBounds(30, 30, 150, 30);
        jugadornifTf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        searchButton.setBounds(190, 30, 90, 30);
        searchButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        filename.setBounds(30, 80, 300, 17);
        filenameTF.setBounds(30, 100, 250, 30);
        filenameTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        filepath.setBounds(30, 150, 300, 17);
        filepathTF.setBounds(30, 180, 150, 30);
        filepathTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        browseButton.setBounds(190, 180, 90, 30);
        browseButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        exportButton.setBounds(130, 225, 100, 30);

        add(filename);
        add(filenameTF);
        add(filepath);
        add(filepathTF);
        add(browseButton);
        add(exportButton);
        add(jugadorJLabel);
        add(jugadornifTf);
        add(searchButton);
    }

    public JLabel getFilename() {
        return filename;
    }

    public JLabel getFilepath() {
        return filepath;
    }

    public JTextField getFilenameTF() {
        return filenameTF;
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

    public JTextField getJugadornifTf() {
        return jugadornifTf;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

}
