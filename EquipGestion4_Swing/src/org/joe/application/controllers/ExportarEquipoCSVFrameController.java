/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.xml.DataToCSV;
import org.joe.application.views.ExportarEquipoCSVFrame;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarEquipoCSVFrameController implements ActionListener {

    private final EquipDataInterface edi;
    private ExportarEquipoCSVFrame eecsvf;
    List<Team> teams = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ExportarEquipoCSVFrameController(EquipDataInterface edi) {
        this.edi = edi;
        eecsvf = new ExportarEquipoCSVFrame();
        eecsvf.setVisible(true);

        eecsvf.browsDir_onClick(this);
        eecsvf.exportarJug_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eecsvf.getBrowseButton()) {
            int returnValue = eecsvf.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = eecsvf.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + eecsvf.getFilenameTF().getText();
                eecsvf.getFilepathTF().setText(fullPath);
            }
        }

        if (e.getSource() == eecsvf.getExportButton()) {

            try {
                String fileString = eecsvf.getFilepathTF().getText();
                String dateString = eecsvf.getDatePicker().getSelectedDateAsString();
                Date date = sdf.parse(dateString);

                teams = edi.getTeamsBySeason(date);
                DataToCSV.exportSeasonTeam(fileString, teams);
                JOptionPane.showMessageDialog(null,
                        "Equipos Exportado Existosamente",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
    }

}
