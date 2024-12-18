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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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

        populateTable(edi.getPlayers());
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

            //GET ALL PLAYERS AND ORDER THEM
            if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayers_ordCognom();
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayers_ordDatnaix();

            }

            //GET PLAYERS BY LEGAL ID
            if (nameFilter.isBlank() && nifFilter.length() > 2 && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByLegalId(nifFilter);

            }
            //GET PLAYERS BY SURNAME
            if (nameFilter.length() > 3 && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayerBySurname(nameFilter);
            } else if (nameFilter.length() > 3 && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayerBySurname_ordCognom(nameFilter);
            } else if (nameFilter.length() > 3 && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayerBySurname_ordDatnaix(nameFilter);
            }

            //GET PLAYERS BY BIRTH YEAR AND ORDER THEM
            if (nameFilter.isBlank() && nifFilter.isBlank() && !birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.isBlank()) {

                try {
                    filteredPlayers = edi.getPlayerByBirthYear(sdf.parse(birthDate));
                } catch (ParseException ex) {

                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Date Parsing Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && !birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Cognom")) {
                try {
                    filteredPlayers = edi.getPlayerByBirthYear_ordCognom(sdf.parse(birthDate));
                } catch (ParseException ex) {

                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Date Parsing Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && !birthDate.equals(emptycal) && categoryFilter.isBlank() && ordenar.equals("Data Naixement")) {
                try {
                    filteredPlayers = edi.getPlayerByBirthYear_ordCognom(sdf.parse(birthDate));
                } catch (ParseException ex) {

                    JOptionPane.showMessageDialog(null,
                            ex.getMessage(),
                            "Date Parsing Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Juvenil") && ordenar.isBlank()) {

                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Juvenil") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Juvenil") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
            } //CAT BENJAMI
            else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Benjamí") && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Benjamí") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Benjamí") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
            }//CAT Aleví
            else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Aleví") && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Aleví") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Aleví") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
            }//CAT Infantil
            else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Infantil") && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Infantil") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Infantil") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
            }//CAT Cadet
            else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Cadet") && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Cadet") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Cadet") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
            }//CAT Senior
            else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Senior") && ordenar.isBlank()) {
                filteredPlayers = edi.getPlayersByCat(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Senior") && ordenar.equals("Cognom")) {
                filteredPlayers = edi.getPlayeraByCat_ordCognom(categoryFilter);
            } else if (nameFilter.isBlank() && nifFilter.isBlank() && birthDate.equals(emptycal) && categoryFilter.equals("Senior") && ordenar.equals("Data Naixement")) {
                filteredPlayers = edi.getPlayeraByCat_ordDatnaix(categoryFilter);
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
        tableModel.setRowCount(0);

        for (Player player : players) {
            Object[] row = {
                player.getLegal_id(),
                player.getName(),
                player.getSurname(),
                calculateAge(player.getBirth_year()),
                player.getSex(),
                calculateCat(calculateAge(player.getBirth_year())),
                player.getLocalidad(),
                player.getMedical_rev_fin() != null && player.getMedical_rev_fin() > 0
            };
            tableModel.addRow(row);
        }
    }

    private int calculateAge(Date birthYear) {
        if (birthYear == null) {
            return 0;
        }
        Date now = new Date();
        int age = now.getYear() - birthYear.getYear();

        return age;
    }

    private String calculateCat(int age) {
        if (age >= 7 && age <= 8) {
            return "Benjamí";
        } else if (age >8 & age <= 11) {
            return "Aleví";
        } else if (age > 12 & age < 13) {
            return "Infantil";
        } else if (age > 14 & age < 15) {
            return "Cadet";
        } else if (age >= 16 & age <= 17) {
            return "Juvenil";
        } else if (age >= 18 & age < 21) {
            return "Senior";
        }
        return null;
    }

    private String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFC);
    }

    public List<Player> getCurrrentplayerlist() {
        return currrentplayerlist;
    }

}
