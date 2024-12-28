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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.joe.application.constants.ErrMsg;
import org.joe.application.constants.PlayerConstants;
import org.joe.application.views.tabs.VerJugEquipos;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

public class VerJugEquiposController implements ActionListener {

    EquipDataInterface edi;
    private VerJugEquipos verJuEquipos;
    private List<Team> currentTeamlist;
    private List<Player> currentPlayerlist;
    private List<Player> allplayersList;

    public VerJugEquiposController(EquipDataInterface edi) {
        this.edi = edi;
        verJuEquipos = new VerJugEquipos();
        currentTeamlist = new ArrayList<>();
        currentPlayerlist = new ArrayList<>();
        allplayersList = new ArrayList<>();

        try {
            populateTeamTable(edi.getAllTeams());
        } catch (Exception ex) {
            ErrMsg.error(ex.getMessage(), ex.getCause());
        }

        verJuEquipos.getTeamTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedTeamIndex = verJuEquipos.getTeamTable().getSelectedRow();
                if (selectedTeamIndex != -1) {
                    Team selectedTeam = currentTeamlist.get(selectedTeamIndex);
                    populatePlayerTable(edi.getTeamPlayers(selectedTeam.getName(), (java.sql.Date) selectedTeam.getSeason_year()));
                }
            }
        });

        verJuEquipos.addJugadorEquipo(this);
        verJuEquipos.delJugadorEquipo(this);
        populateAddPlayerTable(edi.getPlayers());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == verJuEquipos.getDeljugadorbtn()) {
            int selectplaayerindex = verJuEquipos.getPlayerTable().getSelectedRow();
            int selectedTeamindex = verJuEquipos.getTeamTable().getSelectedRow();
            if (selectplaayerindex != -1) {
                if (selectedTeamindex != -1) {
                    Player player = currentPlayerlist.get(selectplaayerindex);
                    Team team = currentTeamlist.get(selectedTeamindex);
                    try {
                        edi.deletePlayerFromTeam(player, team.getId());
                        JOptionPane.showMessageDialog(verJuEquipos, "Player Deleted Successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        List<Player> updatedPlayerList = edi.getTeamPlayers(team.getName(), (java.sql.Date) team.getSeason_year());

                        populatePlayerTable(updatedPlayerList);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(),
                                "Deleting Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Select A Team To Delete From",
                            "Selection Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Select A Player To Delete",
                        "Selection Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        if (e.getSource() == verJuEquipos.getAddjugadorbtn()) {
            int selectplaayerindex = verJuEquipos.getAddplayerJTable().getSelectedRow();
            int selectedTeamindex = verJuEquipos.getTeamTable().getSelectedRow();
            if (selectedTeamindex != -1) {
                if (selectplaayerindex != -1) {
                    Player player = allplayersList.get(selectplaayerindex);
                    Team team = currentTeamlist.get(selectedTeamindex);
                    boolean tit_sel = verJuEquipos.getTitularidad().isSelected();
                    System.out.println(tit_sel);
                    try {
                        edi.addPlayerToTeam(player, team, tit_sel);
                        JOptionPane.showMessageDialog(verJuEquipos, "Player Added Successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        List<Player> updatedPlayerList = edi.getTeamPlayers(team.getName(), (java.sql.Date) team.getSeason_year());

                        populatePlayerTable(updatedPlayerList);
                    } catch (Exception ex) {
                        ErrMsg.error(ex.getMessage(), ex.getCause());
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Select A Player To Add",
                            "Selection Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Select A Team To Add Player",
                        "Selection Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public VerJugEquipos getVerJuEquipos() {
        return verJuEquipos;
    }

    public void populateTeamTable(List<Team> teams) {
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
        this.currentPlayerlist = players;
        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getPlayerTable().getModel();
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getName(),
                player.getSurname(),
                PlayerConstants.calculateAge(player.getBirth_year()),
                player.getSex(),
                player.getCategory(),
                player.getTitularidad()
            };
            tableModel.addRow(row);
        }
    }

    public void populateAddPlayerTable(List<Player> players) {
        this.allplayersList = players;
        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getAddplayerJTable()
                .getModel();
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getName(),
                player.getSurname(),
                PlayerConstants.calculateAge(player.getBirth_year()),
                player.getSex(),
                PlayerConstants.calculateCat(PlayerConstants.calculateAge(player.getBirth_year()))
            };
            tableModel.addRow(row);
        }
    }

}
