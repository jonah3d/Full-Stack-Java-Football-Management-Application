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
public class ExportarJugadorCSVFrame extends JFrame {

    JLabel filename;
    JLabel filepath;
    JTextField filenameTF;
    JTextField filepathTF;
    JButton browseButton;
    JButton exportButton;
    JFileChooser filepathChooser;

    public ExportarJugadorCSVFrame() {
        setSize(400, 300);
        setTitle("Exportar Jugadores");
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

        filename.setBounds(30, 30, 300, 17);
        filenameTF.setBounds(30, 50, 250, 30);
        filenameTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        filepath.setBounds(30, 100, 300, 17);
        filepathTF.setBounds(30, 120, 150, 30);
        filepathTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        browseButton.setBounds(190, 120, 90, 30);
        browseButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        exportButton.setBounds(110, 200, 100, 30);

        add(filename);
        add(filenameTF);
        add(filepath);
        add(filepathTF);
        add(browseButton);
        add(exportButton);

    }

    public void browsDir_onClick(ActionListener listener) {
        this.browseButton.addActionListener(listener);
    }

    public void exportarJug_OnClick(ActionListener listener) {
        this.exportButton.addActionListener(listener);
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
}
