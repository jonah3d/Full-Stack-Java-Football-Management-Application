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
import org.joe.application.data.xml.DataToXML;
import org.joe.application.views.ExportarEquipoTemporadaFrame;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarEquipoTemporadaFrameController implements ActionListener {

    private ExportarEquipoTemporadaFrame eetf;
    private EquipDataInterface edi;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<Team> teams = null;
    Team team = null;
    List<Player> players = null;

    public ExportarEquipoTemporadaFrameController(EquipDataInterface edi) {
        this.edi = edi;
        eetf = new ExportarEquipoTemporadaFrame();
        eetf.setVisible(true);

        eetf.browsDir_onClick(this);
        eetf.exportarJug_OnClick(this);
        eetf.searhJugador_OnClick(this);
        eetf.getAddPlayers().setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eetf.getSearchButton()) {
            String dateString = eetf.getDatePicker().getSelectedDateAsString();
            try {
                Date date = sdf.parse(dateString);

                teams = edi.getTeamsBySeason(date);
                JOptionPane.showMessageDialog(null,
                        "Equipos Encontrado",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }

        if (e.getSource() == eetf.getBrowseButton()) {
            int returnValue = eetf.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = eetf.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + eetf.getFilenameTF().getText();
                eetf.getFilepathTF().setText(fullPath);
            }
        }

        if (e.getSource() == eetf.getExportButton()) {
            String fileString = eetf.getFilepathTF().getText();
            try {

                DataToXML.exportSeasonTeam(teams, fileString);
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
