/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.PlayerManagementScreen;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author Usuari
 */
public class PlayerManagementController implements ActionListener {

    private PlayerManagementScreen playerManagementScreen;
    private VerJugadoresController verJugadoresController;
    private AnadirJugadoresController anadirJugadoresController;
    private EditarJugadoresController editarJugadoresController;
    private EquipDataInterface edi;

    public PlayerManagementController(EquipDataInterface edi) {
        this.edi = edi;
        playerManagementScreen = new PlayerManagementScreen();
        verJugadoresController = new VerJugadoresController(edi);
        anadirJugadoresController = new AnadirJugadoresController();
        editarJugadoresController = new EditarJugadoresController();

        getPlayerManagementScreen().getCenterJPanel().addTab("Ver Jugadores", verJugadoresController.getVerJugadores());
        getPlayerManagementScreen().getCenterJPanel().addTab("Anadir Jugadores", anadirJugadoresController.getAnadirJugadores());
        getPlayerManagementScreen().getCenterJPanel().addTab("Editar Jugadores", editarJugadoresController.getEditarJugadores());

        playerManagementScreen.verJugadores_OnClick(this);
        playerManagementScreen.deleteJugadores_OnCLick(this);
        playerManagementScreen.anadirJugadores_OnClick(this);
        playerManagementScreen.editarJugadores_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playerManagementScreen.getSeeply_BTN()) {
            playerManagementScreen.getCenterJPanel().setSelectedIndex(0);
        }
        if (e.getSource() == playerManagementScreen.getAddply_BTN()) {
            playerManagementScreen.getCenterJPanel().setSelectedIndex(1);
        }

        if (e.getSource() == playerManagementScreen.getEdply_BTN()) {
            playerManagementScreen.getCenterJPanel().setSelectedIndex(2);
        }

    }

    public PlayerManagementScreen getPlayerManagementScreen() {
        return playerManagementScreen;
    }

}
