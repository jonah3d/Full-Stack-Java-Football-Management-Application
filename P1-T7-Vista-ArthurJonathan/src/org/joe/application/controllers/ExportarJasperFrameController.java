/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

            try {
                DataToJasper dtj = new DataToJasper();

                dtj.getReport(temp, cat, equip);
                System.out.println("wait");
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " + " + ex.getCause());
            }

        }

    }

}
