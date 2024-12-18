/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.joe.application.views.Management;
import org.joe.gestion.model.persistence.EquipDataInterface;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class ManagementFrameController implements ActionListener {

    private Management managementview;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    static EquipDataInterface edi;

    public ManagementFrameController(EquipDataInterface edi) {
        this.edi = edi;
        managementview = new Management(edi);

        managementview.PlayerMangementBTN_Onclick(this);
        managementview.TeamManagementBTN_OnClick(this);
        managementview.CreateTemp_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == managementview.getPlayermngmtBTN()) {
            managementview.getManagementTyTabbedPane().setSelectedIndex(0);
        }

        if (e.getSource() == managementview.getTeammngmtBTN()) {
            managementview.getManagementTyTabbedPane().setSelectedIndex(1);
        }

        if (e.getSource() == managementview.getCreateseason()) {
            tempframe();
        }
    }

    public static void tempframe() {

        JFrame seasonFrame = new JFrame("Temporada");
        seasonFrame.setLayout(null); // Use absolute layout

        JLabel name = new JLabel("Nombre Temporada (yy/yy):");
        JLabel season = new JLabel("Fecha de Inicio de Temporada:");
        JTextField nameTF = new JTextField();
        JFormattedTextField seasonTF = new JFormattedTextField();
        JButton submitButton = new JButton("Guardar");
        JButton cancelButton = new JButton("Cancelar");
        DatePicker datePicker = new DatePicker();
        datePicker.setEditor(seasonTF);

        name.setBounds(30, 30, 300, 17);
        nameTF.setBounds(30, 50, 250, 30);

        season.setBounds(30, 100, 300, 17);
        seasonTF.setBounds(30, 120, 250, 30);

        submitButton.setBounds(30, 200, 100, 30);
        cancelButton.setBounds(140, 200, 100, 30);

        seasonFrame.add(name);
        seasonFrame.add(nameTF);
        seasonFrame.add(season);
        seasonFrame.add(seasonTF);
        seasonFrame.add(submitButton);
        seasonFrame.add(cancelButton);

        seasonFrame.setSize(new Dimension(330, 300));
        seasonFrame.setVisible(true);
        seasonFrame.setResizable(false);
        seasonFrame.setLocationRelativeTo(null);
        seasonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        submitButton.addActionListener(e -> {
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
                JOptionPane.showMessageDialog(seasonFrame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                edi.addNewSeason(seasonName, dateseason);
                JOptionPane.showMessageDialog(seasonFrame, "Temporada guardada: " + seasonName + ", Fecha: " + seasonDate, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                seasonFrame.dispose();
            }
        });

        cancelButton.addActionListener(e -> seasonFrame.dispose());
    }

}
