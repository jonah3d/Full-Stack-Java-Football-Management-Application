package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.joe.application.views.tabs.VerJugEquipos;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

public class VerJugEquiposController implements ActionListener {

    EquipDataInterface edi;
    private VerJugEquipos verJuEquipos;
    private List<Team> currentTeamlist;

    public VerJugEquiposController(EquipDataInterface edi) {
        this.edi = edi;
        verJuEquipos = new VerJugEquipos();
        currentTeamlist = new ArrayList<>();

        populateTeamTable(edi.getAllTeams());

//        verJuEquipos.getTeamTable().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int selectedTeamIndex = verJuEquipos.getTeamTable().getSelectedRow();
//                if (selectedTeamIndex != -1) {
//                    Team selectedTeam = currentTeamlist.get(selectedTeamIndex);
//                    populatePlayerTable(edi.getTeamPlayers(selectedTeam.getName()));
//                }
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public VerJugEquipos getVerJuEquipos() {
        return verJuEquipos;
    }

    private void populateTeamTable(List<Team> teams) {
        this.currentTeamlist = teams;

        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getTeamTable().getModel();
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

    private void populatePlayerTable(List<Player> players) {
        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getPlayerTable().getModel();
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getName(),
                player.getSurname(),
                calculateAge(player.getBirth_year()),
                player.getSex(),};
            tableModel.addRow(row);
        }
    }

    private int calculateAge(Date birthDate) {
        if (birthDate == null) {
            return 0;
        }

        LocalDate birthLocalDate;
        if (birthDate instanceof java.sql.Date) {
            birthLocalDate = ((java.sql.Date) birthDate).toLocalDate();
        } else {
            birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        LocalDate referenceDate = LocalDate.of(2024, 9, 1);

        return Period.between(birthLocalDate, referenceDate).getYears();
    }
}
