
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.joe.application.constants.ErrMsg;
import org.joe.application.constants.PlayerConstants;
import org.joe.application.views.tabs.VerJugadores;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class VerJugadoresController implements ActionListener {

    private VerJugadores verJugadores;
    private EquipDataInterface edi;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Player> currrentplayerlist;

    public VerJugadoresController(EquipDataInterface edi) {
        this.edi = edi;
        this.verJugadores = new VerJugadores();
        verJugadores.refreshbutton(this);

        currrentplayerlist = new ArrayList<>();

        verJugadores.getCatComboBox().addItem("");
        for (Category item : edi.getCategorys()) {

            verJugadores.getCatComboBox().addItem(item.getName());
        }

        try {
            populateTable(edi.getPlayers());
        } catch (Exception e) {
            ErrMsg.error(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verJugadores.getRefresh()) {

            String nameFilter = verJugadores.getNamefilter().getText().trim();
            String nifFilter = verJugadores.getNiffilter().getText().trim();
            String birthDate = verJugadores.getAnonaceditorfilter().getText().trim();
            String categoryFilter = (String) verJugadores.getCatComboBox().getSelectedItem();
            String ordenar = (String) verJugadores.getOrdenarComboBox().getSelectedItem();
            String emptycal = "--/--/----";

            List<Player> filteredPlayers = edi.getPlayers();
            if (nameFilter.isBlank()) {
                nameFilter = null;
            }
            if (nifFilter.isBlank()) {
                nifFilter = null;
            }
            if (birthDate.isBlank()) {
                birthDate = null;
            }
            if (categoryFilter.isBlank()) {
                categoryFilter = null;
            }

            if (ordenar != null && !ordenar.isBlank()) {
                if (ordenar.equals("Cognom")) {
                    ordenar = "surname"; // Map to database column
                } else if (ordenar.equals("Data Naixement")) {
                    ordenar = "birth_year"; // Map to database column
                } else {
                    ordenar = null; // Default: no ordering
                }
            }

            Date birthday = null;
            try {
                if (birthDate.equals(emptycal)) {
                    birthDate = null;
                } else {
                    birthday = sdf.parse(birthDate);
                }

            } catch (ParseException ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }

            try {
                filteredPlayers = edi.playerFilterSearch(nameFilter, nifFilter, birthday, categoryFilter, ordenar);
            } catch (EquipDataInterfaceException ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }

            populateTable(filteredPlayers);
        }

    }

    public VerJugadores getVerJugadores() {
        return verJugadores;
    }

    private void populateTable(List<Player> players) {
        this.currrentplayerlist = players;

        DefaultTableModel tableModel = (DefaultTableModel) verJugadores.getPlayerDet_Table().getModel();
        verJugadores.getPlayerDet_Table().setDefaultRenderer(Object.class, new CustomPlayerTableCellRenderer());
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getLegal_id(),
                player.getName(),
                player.getSurname(),
                PlayerConstants.calculateAge(player.getBirth_year()),
                player.getSex(),
                PlayerConstants.calculateCat(PlayerConstants.calculateAge(player.getBirth_year())),
                player.getLocalidad(),
                player.getMedical_rev_fin() != null && player.getMedical_rev_fin() > 0
            };
            tableModel.addRow(row);
        }

        if (players.isEmpty()) {
            verJugadores.getErromessage().setVisible(true);
            verJugadores.getErromessage().setText("No Hay Jugadores");
        } else {
            verJugadores.getErromessage().setVisible(false);
        }
    }

    private String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFC);
    }

    public List<Player> getCurrrentplayerlist() {
        return currrentplayerlist;
    }

}
