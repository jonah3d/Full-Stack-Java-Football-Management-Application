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

        populateTeamTable(edi.getAllTeams());

        verJuEquipos.getTeamTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedTeamIndex = verJuEquipos.getTeamTable().getSelectedRow();
                if (selectedTeamIndex != -1) {
                    Team selectedTeam = currentTeamlist.get(selectedTeamIndex);
                    populatePlayerTable(edi.getTeamPlayers(selectedTeam.getName()));
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
                        edi.deletePlayerFromTeam(player, team);
                        JOptionPane.showMessageDialog(verJuEquipos, "Player Deleted Successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
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
                    try {
                        edi.addPlayerToTeam(player, team, tit_sel);
                        JOptionPane.showMessageDialog(verJuEquipos, "Player Added Successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(),
                                "Adding Error",
                                JOptionPane.ERROR_MESSAGE
                        );
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
        this.currentPlayerlist = players;
        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getPlayerTable().getModel();
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getName(),
                player.getSurname(),
                calculateAge(player.getBirth_year()),
                player.getSex(),
                player.getCategory()
            };
            tableModel.addRow(row);
        }
    }

    private void populateAddPlayerTable(List<Player> players) {
        this.allplayersList = players;
        DefaultTableModel tableModel = (DefaultTableModel) verJuEquipos.getAddplayerJTable()
                .getModel();
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getName(),
                player.getSurname(),
                calculateAge(player.getBirth_year()),
                player.getSex(),
                calculateCat(calculateAge(player.getBirth_year()))
            };
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

    private String calculateCat(int age) {
        if (age >= 7 && age <= 8) {
            return "Benjamí";
        } else if (age >= 9 && age <= 10) {
            return "Aleví";
        } else if (age >= 12 && age <= 13) {
            return "Infantil";
        } else if (age >= 14 && age <= 15) {
            return "Cadet";
        } else if (age >= 16 && age <= 17) {
            return "Juvenil";
        } else if (age >= 18 && age <= 21) {
            return "Senior";
        }
        return null; // Return null if no category matches
    }
}
