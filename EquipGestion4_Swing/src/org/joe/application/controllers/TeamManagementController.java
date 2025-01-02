/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.views.TeamManagementScreen;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class TeamManagementController implements ActionListener {

    private EquipDataInterface edi;
    private TeamManagementScreen teamManagementScreen;
    private VerEquiposController verEquiposController;
    private AnadirEquipoController anadirEquipoController;
    private VerJugEquiposController verJugEquiposController;

    public TeamManagementController(EquipDataInterface edi) {
        this.edi = edi;
        teamManagementScreen = new TeamManagementScreen();
        verEquiposController = new VerEquiposController(edi);
        anadirEquipoController = new AnadirEquipoController(edi);
        verJugEquiposController = new VerJugEquiposController(edi);

        teamManagementScreen.getCenterJPanel().addTab("Ver Equipos", verEquiposController.getVerEquipos());
        teamManagementScreen.getCenterJPanel().addTab("Ver Jug", verJugEquiposController.getVerJuEquipos());
        teamManagementScreen.getCenterJPanel().add("Añadir Equipo", anadirEquipoController.getAnadirEquipos());

        teamManagementScreen.seeJugEquip_OnClick(this);
        teamManagementScreen.addEquip_OnClick(this);
        teamManagementScreen.elimEquip_OnClick(this);
        teamManagementScreen.verEquip_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == teamManagementScreen.getSeeEquip_Btn()) {
            teamManagementScreen.getCenterJPanel().setSelectedIndex(0);
            verEquiposController.getVerEquipos().getRefresh().doClick();
        }

        if (e.getSource() == teamManagementScreen.getSeeJugEquip_Btn()) {
            teamManagementScreen.getCenterJPanel().setSelectedIndex(1);
            try {
                verJugEquiposController.populateAddPlayerTable(edi.getPlayers());
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
        if (e.getSource() == teamManagementScreen.getAddEquip_Btn()) {
            teamManagementScreen.getCenterJPanel().setSelectedIndex(2);

        }

        if (e.getSource() == teamManagementScreen.getElimEquip_Btn()) {
            int selectedteam = verEquiposController.getVerEquipos().getTeamDetails_JTable().getSelectedRow();

            if (selectedteam == -1) {
                JOptionPane.showMessageDialog(null, "Seleccionar un equipo de la tabla", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Team team = verEquiposController.getCurrentTeams().get(selectedteam);

            try {
                int count = edi.getTeamMemCount(team.getName());

                if (count == 0) {

                    edi.removeTeamFromSeason(team.getName());
                    verJugEquiposController.populateTeamTable(edi.getAllTeams());
                    JOptionPane.showMessageDialog(null,
                            "Equipo " + team.getName() + " eliminado exitosamente",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                } else if (count >= 1) {

                    int confirmation = JOptionPane.showConfirmDialog(null,
                            "El equipo tiene miembros. Estás seguro de que quieres eliminarlo?",
                            "Confirmar Eliminación",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (confirmation == JOptionPane.OK_OPTION) {

                        edi.removeTeamWithPlayers(team);
                        verJugEquiposController.populateTeamTable(edi.getAllTeams());
                        JOptionPane.showMessageDialog(null,
                                "Equipo " + team.getName() + " eliminado exitosamente",
                                "Exito",
                                JOptionPane.INFORMATION_MESSAGE);
                        verEquiposController.getVerEquipos().getRefresh().doClick();

                    } else {

                        JOptionPane.showMessageDialog(null,
                                "Operación de eliminación de equipo cancelada.",
                                "Cancelada",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            } catch (Exception ex) {
                errorDialogue(ex.getMessage());
            }
        }

    }

    public TeamManagementScreen getTeamManagementScreen() {
        return teamManagementScreen;
    }

    private void errorDialogue(String message) {

        JOptionPane.showMessageDialog(getTeamManagementScreen(), message, "Error De Campo", JOptionPane.INFORMATION_MESSAGE);

    }
}
