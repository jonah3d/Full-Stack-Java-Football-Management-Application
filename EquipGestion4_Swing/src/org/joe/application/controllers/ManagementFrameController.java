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
import org.joe.application.views.TemporadaFrame;
import org.joe.gestion.model.persistence.EquipDataInterface;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class ManagementFrameController implements ActionListener {

    private Management managementview;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private TemporadaFrame tempframe;

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
            tempframe = new TemporadaFrame(edi);
        }
    }

}
