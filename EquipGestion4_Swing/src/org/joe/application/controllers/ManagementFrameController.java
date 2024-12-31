/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.joe.application.views.ExportarTodosJugadoresFrame;
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
    private ExportarTodosJugadoresFrameController etjfc;
    private ExportarJugadorFrameController ejfc;
    private ExportarEquipoFrameController eefc;
    private ExportarEquipoTemporadaFrameController eetfc;
    static EquipDataInterface edi;

    public ManagementFrameController(EquipDataInterface edi) {
        this.edi = edi;
        managementview = new Management(edi);

        managementview.PlayerMangementBTN_Onclick(this);
        managementview.TeamManagementBTN_OnClick(this);
        managementview.CreateTemp_OnClick(this);
        managementview.ExportarTodJugadores_OnClicK(this);
        managementview.ExportarJugador_OnClick(this);
        managementview.ExportarEquipo_OnClick(this);
        managementview.ExportarEquipoCat_OnClick(this);
        managementview.ExportarEquipoTemp_OnClick(this);
        onWindowOpened();
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

        if (e.getSource() == managementview.getTodjugadores()) {
            etjfc = new ExportarTodosJugadoresFrameController(edi);
        }

        if (e.getSource() == managementview.getJugador()) {
            ejfc = new ExportarJugadorFrameController(edi);
        }

        if (e.getSource() == managementview.getEquipo()) {
            eefc = new ExportarEquipoFrameController(edi);
        }

        if (e.getSource() == managementview.getTemporadaitem()) {
            eetfc = new ExportarEquipoTemporadaFrameController(edi);
        }
    }

    public void onWindowOpened() {
        managementview.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                edi.disconnectDatasource();
            }

            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }

        }
        );
    }

}
