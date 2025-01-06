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
import javax.swing.SwingWorker;
import org.joe.application.constants.ErrMsg;
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
    private ExportarEquipoCategoriaFrameController eecf;
    private ExportarJugadorCSVFrameController ejcsvfc;
    private ExportarEquipoCSVFrameController eecsvfc;
    private ExportarJasperFrameController ejasfc;
    static EquipDataInterface edi;
    private ContactMeFrameController cmfc;
    private ReportBugFrameController rbfc;
    private AboutMeFrameController amfc;
    JProgressBar progressBar = null;

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
        managementview.ExportarEquiposCSV_OnClick(this);
        managementview.ExportarJugadoresCSV_onClick(this);
        managementview.ExportarJasper_onClick(this);

        managementview.contactMe_OnClick(this);
        managementview.reportBug_OnClick(this);
        managementview.sobreMe_OnClick(this);
        managementview.closeApp_OnClick(this);
        progressBar = managementview.getProgressBar();

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

        if (e.getSource() == managementview.getCategoriaitem()) {
            eecf = new ExportarEquipoCategoriaFrameController(edi);
        }

        if (e.getSource() == managementview.getExportJugadoresItem()) {
            ejcsvfc = new ExportarJugadorCSVFrameController(edi);
        }

        if (e.getSource() == managementview.getExportarSeasonTeamsItem()) {
            eecsvfc = new ExportarEquipoCSVFrameController(edi);
        }

        if (e.getSource() == managementview.getExportJsperMenuItem()) {
            ejasfc = new ExportarJasperFrameController(edi);
        }

        if (e.getSource() == managementview.getContactMenuItem()) {
            cmfc = new ContactMeFrameController();
        }

        if (e.getSource() == managementview.getReportBugItem()) {
            rbfc = new ReportBugFrameController();
        }

        if (e.getSource() == managementview.getSobreme()) {
            amfc = new AboutMeFrameController();
        }

        if (e.getSource() == managementview.getCloseApp()) {
            closeApp();
        }
    }

    private void closeApp() {
        progressBar.setVisible(true);
        progressBar.setIndeterminate(true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    if (edi != null) {
                        edi.disconnectDatasource();
                    }
                } catch (Exception ex) {
                    ErrMsg.error(ex.getMessage(), ex.getCause());
                }
                return null;
            }

            @Override
            protected void done() {
                progressBar.setIndeterminate(false);
                progressBar.setVisible(false);
                System.exit(0);
            }
        };
        worker.execute();
    }

    public void onWindowOpened() {
        managementview.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {

                progressBar.setVisible(true);
                progressBar.setIndeterminate(true);

                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {

                        try {
                            if (edi != null) {

                                edi.disconnectDatasource();
                            }
                        } catch (Exception ex) {
                            ErrMsg.error(ex.getMessage(), ex.getCause());
                        }
                        return null;
                    }

                    @Override
                    protected void done() {

                        progressBar.setIndeterminate(false);
                        progressBar.setVisible(false);
                    }
                };
                worker.execute();

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
