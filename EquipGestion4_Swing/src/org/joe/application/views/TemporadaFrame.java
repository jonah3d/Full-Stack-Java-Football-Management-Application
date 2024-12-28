/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.joe.gestion.model.persistence.EquipDataInterface;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class TemporadaFrame extends JFrame {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    JLabel name;
    JLabel season;
    JTextField nameTF;
    JFormattedTextField seasonTF;
    JButton submitButton;
    JButton cancelButton;
    DatePicker datePicker;
    EquipDataInterface edi;

    public TemporadaFrame(EquipDataInterface edi) {
        this.edi = edi;
        setTitle("Temporada");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializecomponents();
    }

    private void initializecomponents() {
        name = new JLabel("Nombre Temporada (yy/yy):");
        season = new JLabel("Fecha de Inicio de Temporada:");
        nameTF = new JTextField();
        nameTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        seasonTF = new JFormattedTextField();
        seasonTF.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        submitButton = new JButton("Guardar");
        submitButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        cancelButton = new JButton("Cancelar");
        cancelButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        datePicker = new DatePicker();
        datePicker.setEditor(seasonTF);

        name.setBounds(
                30, 30, 300, 17);
        nameTF.setBounds(30, 50, 250, 30);

        season.setBounds(30, 100, 300, 17);
        seasonTF.setBounds(30, 120, 250, 30);

        submitButton.setBounds(30, 200, 100, 30);
        cancelButton.setBounds(140, 200, 100, 30);
        add(name);

        add(nameTF);

        add(season);

        add(seasonTF);

        add(submitButton);

        add(cancelButton);

        setSize(new Dimension(330, 300));
        submitButton.addActionListener(e
                -> {
            String seasonName = nameTF.getText();
            String seasonDate = seasonTF.getText();
            Date dateseason = null;
            try {
                dateseason = sdf.parse(seasonDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null,
                        ex.getMessage(),
                        "Error Inserting Player",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            if (seasonName.isEmpty() || seasonDate.isEmpty()) {
                JOptionPane.showMessageDialog(getContentPane(), "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                edi.addNewSeason(seasonName, dateseason);
                JOptionPane.showMessageDialog(getContentPane(), "Temporada guardada: " + seasonName + ", Fecha: " + seasonDate, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
        );

        cancelButton.addActionListener(e
                -> dispose());
    }

}
