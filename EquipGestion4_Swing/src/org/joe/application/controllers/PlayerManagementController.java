/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.joe.application.views.PlayerManagementScreen;
import org.joe.gestion.model.data.Player;
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
        anadirJugadoresController = new AnadirJugadoresController(edi);
        editarJugadoresController = new EditarJugadoresController(edi);

        playerManagementScreen.getCenterJPanel().addTab("Ver Jugadores", verJugadoresController.getVerJugadores());
        playerManagementScreen.getCenterJPanel().addTab("Anadir Jugadores", anadirJugadoresController.getAnadirJugadores());
        playerManagementScreen.getCenterJPanel().addTab("Editar Jugadores", editarJugadoresController.getEditarJugadores());

        playerManagementScreen.verJugadores_OnClick(this);
        playerManagementScreen.deleteJugadores_OnCLick(this);
        playerManagementScreen.anadirJugadores_OnClick(this);
        playerManagementScreen.editarJugadores_OnClick(this);
    }

    public PlayerManagementScreen getPlayerManagementScreen() {
        return playerManagementScreen;
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

            int selectedplayer = verJugadoresController.getVerJugadores().getPlayerDet_Table().getSelectedRow();
            if (selectedplayer == -1) {
                JOptionPane.showMessageDialog(null, "Seleccionar un jugador de la tabla", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            Player player = verJugadoresController.getCurrrentplayerlist().get(selectedplayer);
            editarJugadoresController.getSelectedPlayer(player);
        }

        if (e.getSource() == playerManagementScreen.getDelply_BTN()) {
            int selectedplayer = verJugadoresController.getVerJugadores().getPlayerDet_Table().getSelectedRow();
            if (selectedplayer == -1) {
                JOptionPane.showMessageDialog(null, "Seleccionar un jugador de la tabla", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            /*else if (selectedplayer > 1) {
                JOptionPane.showMessageDialog(null, "Puedes eliminar solo un jugador", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }*/
            Player player = verJugadoresController.getCurrrentplayerlist().get(selectedplayer);

            try {
                edi.eliminarJugador(player.getLegal_id());
                JOptionPane.showMessageDialog(null,
                        "Player " + player.getName() + " deleted successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                verJugadoresController.getVerJugadores().getRefresh().doClick();
            } catch (Exception ex) {
                errorDialogue(ex.getMessage());
            }

        }

    }

    private void errorDialogue(String message) {

        JOptionPane.showMessageDialog(getPlayerManagementScreen(), message, "Error De Campo", JOptionPane.INFORMATION_MESSAGE);

    }
}
