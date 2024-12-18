/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.TeamManagementScreen;
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
        }

        if (e.getSource() == teamManagementScreen.getSeeJugEquip_Btn()) {
            teamManagementScreen.getCenterJPanel().setSelectedIndex(1);
        }
        if (e.getSource() == teamManagementScreen.getAddEquip_Btn()) {
            teamManagementScreen.getCenterJPanel().setSelectedIndex(2);
        }

    }

    public TeamManagementScreen getTeamManagementScreen() {
        return teamManagementScreen;
    }

}
