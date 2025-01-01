/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.data.xml;

import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 */
public class DataToCSV {

    public DataToCSV() {
    }

    public static void exportAllPlayers(String pathname, List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new EquipDataInterfaceException("Passed a null or empty player list.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        CSVFormat format = CSVFormat.Builder.create()
                .setHeader("ID", "Nif", "Nombre", "Appellido", "Sexo", "Ano Nacimiento", "Iban", "Dirección", "Localidad", "Codigo Postal", "Provincia", "Pais", "Revisión Medica")
                .setDelimiter(',')
                .build();

        try {
            FileWriter writer = new FileWriter(pathname);
            CSVPrinter csvPrinter = new CSVPrinter(writer, format);
            for (Player player : players) {
                csvPrinter.printRecord(
                        player.getId(),
                        player.getLegal_id(),
                        player.getName(),
                        player.getSurname(),
                        player.getSex(),
                        player.getBirth_year(),
                        player.getIban(),
                        player.getDireccion(),
                        player.getLocalidad(),
                        player.getCodigo_postal(),
                        player.getProvincia(),
                        player.getPais(),
                        player.getMedical_rev_fin()
                );
            }

            writer.close();
            csvPrinter.close();
        } catch (Exception e) {
            throw new EquipDataInterfaceException("Error writing CSV file: " + e.getMessage(), e.getCause());
        }
    }

    public static void exportSeasonTeam(String pathname, List<Team> teams) {
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        if (teams == null || teams.isEmpty()) {
            throw new EquipDataInterfaceException("Passed a null or empty player list.");
        }
        CSVFormat format = CSVFormat.Builder.create()
                .setHeader("ID", "Tipo", "Nombre", "Temporada", "Categoria")
                .setDelimiter(',')
                .build();
        try {
            FileWriter writer = new FileWriter(pathname);
            CSVPrinter csvPrinter = new CSVPrinter(writer, format);

            for (Team team : teams) {
                csvPrinter.printRecord(
                        team.getId(),
                        team.getTeam_type(),
                        team.getName(),
                        team.getSeason_year(),
                        team.getCategory()
                );
            }
            writer.close();
            csvPrinter.close();
        } catch (Exception e) {
            throw new EquipDataInterfaceException("Error writing CSV file: " + e.getMessage(), e.getCause());
        }
    }

}
