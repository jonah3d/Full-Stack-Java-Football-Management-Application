/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.joe.application.constants.ErrMsg;
import org.joe.application.views.tabs.VerEquipos;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Season;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class VerEquiposController implements ActionListener {

    private VerEquipos verEquipos;
    private EquipDataInterface edi;
    private List<Team> currentTeams;

    public VerEquiposController(EquipDataInterface edi) {
        this.edi = edi;
        verEquipos = new VerEquipos();
        currentTeams = new ArrayList<>();
        try {
            verEquipos.getCatComboBox().addItem("");
            for (Category item : edi.getCategorys()) {
                verEquipos.getCatComboBox().addItem(item.getName());
            }

            for (Season season : edi.getSeasons()) {
                verEquipos.getTempComboBox().addItem(season.getName());
            }
        } catch (Exception ex) {
            ErrMsg.error(ex.getMessage(), ex.getCause());
        }

        verEquipos.getTeamDetails_JTable().setDefaultRenderer(Object.class, new CustomTeamTableCellRenderer());

        try {
            Season currentSeason = edi.getSeasons().get(0);
            populateTable(edi.getTeamsBySeason(currentSeason.getSeason()));
        } catch (EquipDataInterfaceException ex) {
            error(ex.getMessage(), ex.getCause());
        }

        verEquipos.getRefresh().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verEquipos.getRefresh()) {

            String selectedSeasonName = (String) verEquipos.getTempComboBox().getSelectedItem();
            String selectedCategoryName = (String) verEquipos.getCatComboBox().getSelectedItem();

            try {
                List<Team> teams = null;

                if (selectedSeasonName != null && !selectedSeasonName.isEmpty()) {

                    Season selectedSeason = edi.getSeasons().stream()
                            .filter(season -> season.getName().equals(selectedSeasonName))
                            .findFirst()
                            .orElse(null);

                    if (selectedSeason != null) {
                        if (selectedCategoryName != null && !selectedCategoryName.isEmpty()) {

                            List<Team> teamsByCategory = edi.getTeamsByCategory(selectedCategoryName);
                            teams = teamsByCategory.stream()
                                    .filter(team -> team.getSeason_year().equals(selectedSeason.getSeason()))
                                    .toList();
                        } else {

                            teams = edi.getTeamsBySeason(selectedSeason.getSeason());
                        }
                    }
                } else if (selectedCategoryName != null && !selectedCategoryName.isEmpty()) {

                    teams = edi.getTeamsByCategory(selectedCategoryName);
                }

                if (teams != null) {
                    populateTable(teams);
                }

                if (teams.size() < 1) {
                    verEquipos.getErromessage().setVisible(true);
                    verEquipos.getErromessage().setText("No hay equipos");
                } else {
                    verEquipos.getErromessage().setVisible(false);
                }

            } catch (EquipDataInterfaceException ex) {
                error(ex.getMessage(), ex.getCause());
            }
        }
    }

    public VerEquipos getVerEquipos() {
        return verEquipos;
    }

    private void populateTable(List<Team> teams) {
        this.currentTeams = teams;
        DefaultTableModel tableModel = (DefaultTableModel) verEquipos.getTeamDetails_JTable().getModel();
        tableModel.setRowCount(0);
        for (Team team : teams) {
            Object[] row = {
                team.getName(),
                team.getCategory(),
                team.getTeam_type(),
                team.getSeason_year()
            };
            tableModel.addRow(row);
        }
    }

    private void error(String message, Throwable cause) {
        String fullMessage = message;
        if (cause != null) {
            fullMessage += "\nCausa: " + cause.getMessage();
        }

        JOptionPane.showMessageDialog(
                verEquipos,
                fullMessage,
                "Error De Campo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public List<Team> getCurrentTeams() {
        return currentTeams;
    }

}
