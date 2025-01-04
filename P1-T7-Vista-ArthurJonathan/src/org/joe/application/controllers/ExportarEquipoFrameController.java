/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.xml.DataToXML;
import org.joe.application.views.ExportarEquipoFrame;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarEquipoFrameController implements ActionListener {

    private ExportarEquipoFrame ejf;
    private EquipDataInterface edi;
    Team team = null;
    String teamname = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<Player> players = null;
    java.sql.Date oracldate = null;

    public ExportarEquipoFrameController(EquipDataInterface edi) {
        this.edi = edi;
        ejf = new ExportarEquipoFrame();
        ejf.setVisible(true);

        ejf.browsDir_onClick(this);
        ejf.exportarJug_OnClick(this);
        ejf.searhJugador_OnClick(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ejf.getSearchButton()) {
            teamname = ejf.getEquiponameTf().getText().trim();

            try {
                String dateString = ejf.getDatePicker().getSelectedDateAsString();
                Date date = sdf.parse(dateString);

                oracldate = new java.sql.Date(date.getTime());
                team = edi.getTeamByName(teamname, oracldate);

                JOptionPane.showMessageDialog(null,
                        "Equipo Encontrado",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
        if (e.getSource() == ejf.getBrowseButton()) {
            int returnValue = ejf.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = ejf.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + ejf.getFilenameTF().getText();
                ejf.getFilepathTF().setText(fullPath);
            }
        }
        if (e.getSource() == ejf.getExportButton()) {
            String fileString = ejf.getFilepathTF().getText();
            try {

                if (ejf.getAddPlayers().isSelected()) {

                    players = edi.getTeamPlayers(teamname, oracldate);

                    DataToXML.exportTeamWithPlayers(team, players, fileString);
                    JOptionPane.showMessageDialog(null,
                            "Equipo Con Jugadres Exportado Existosamente",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (!ejf.getAddPlayers().isSelected()) {

                    DataToXML.exportTeam(team, fileString);
                    JOptionPane.showMessageDialog(null,
                            "Equipo Exportado Existosamente",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }

        }
    }
}
