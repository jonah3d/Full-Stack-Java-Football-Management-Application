/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jonah
 */
public class ExportarJasperFrame extends JFrame {

    JLabel temporadalabel;
    JTextField temporadatF;

    JLabel categorialable;
    JTextField categoriatF;

    JLabel equipolable;
    JTextField equipotF;

    JLabel filepathJLabel;
    JTextField filepathtf;

    JButton exportBtn;

    public ExportarJasperFrame() {
        setSize(400, 300);
        setTitle("Exportar Informe");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initialiseComponents();
    }

    private void initialiseComponents() {
        temporadalabel = new JLabel("Temporada (yy/yy)");
        temporadatF = new JTextField();
        temporadatF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        temporadalabel.setBounds(30, 10, 300, 17);
        temporadatF.setBounds(30, 30, 150, 30);

        categorialable = new JLabel("Categoría");
        categoriatF = new JTextField();
        categoriatF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        categorialable.setBounds(30, 80, 300, 17);
        categoriatF.setBounds(30, 100, 150, 30);

        equipolable = new JLabel("Equipo");
        equipotF = new JTextField();
        equipotF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        equipolable.setBounds(30, 150, 300, 17);
        equipotF.setBounds(30, 180, 150, 30);

        exportBtn = new JButton("Exportar");
        exportBtn.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        exportBtn.setBounds(30, 228, 150, 30);

        add(temporadalabel);
        add(temporadatF);
        add(categorialable);
        add(categoriatF);
        add(equipolable);
        add(equipotF);
        add(exportBtn);

    }

    public JTextField getTemporadatF() {
        return temporadatF;
    }

    public JTextField getCategoriatF() {
        return categoriatF;
    }

    public JTextField getEquipotF() {
        return equipotF;
    }

    public JTextField getFilepathtf() {
        return filepathtf;
    }

    public JButton getExportBtn() {
        return exportBtn;
    }

    public void exportarJug_OnClick(ActionListener listener) {
        this.exportBtn.addActionListener(listener);
    }

}
