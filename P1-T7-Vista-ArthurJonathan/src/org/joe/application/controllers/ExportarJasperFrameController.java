/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.jasper.DataToJasper;
import org.joe.application.views.ExportarJasperFrame;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarJasperFrameController implements ActionListener {

    private final EquipDataInterface edi;
    private ExportarJasperFrame ejf;

    public ExportarJasperFrameController(EquipDataInterface edi) {
        this.edi = edi;
        ejf = new ExportarJasperFrame();
        ejf.setVisible(true);

        ejf.exportarJug_OnClick(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ejf.getExportBtn()) {
            String temp = ejf.getTemporadatF().getText().trim();
            String cat = ejf.getCategoriatF().getText().trim();
            String equip = ejf.getEquipotF().getText().trim();

            JProgressBar progressBar = ejf.getProgressBar();
            progressBar.setVisible(true);
            progressBar.setIndeterminate(true);

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        DataToJasper dtj = new DataToJasper();
                        dtj.getReport(temp, cat, equip);
                    } catch (Exception ex) {
                        ErrMsg.error(ex.getMessage(), ex.getCause());
                    }
                    return null;
                }

                @Override
                protected void done() {
                    // Hide the progress bar when done
                    progressBar.setIndeterminate(false);
                    progressBar.setVisible(false);
                }
            };

            worker.execute();
        }
    }

}
