/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

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

        temporadalabel.setBounds(30, 10, 300, 17);
        temporadatF.setBounds(30, 30, 150, 30);

        categorialable = new JLabel("Categoría");
    }
}
