/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.data.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.helperclasses.PlayerList;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.helperclasses.SeasonTeamsPlayers;
import org.joe.gestion.model.helperclasses.TeamList;
import org.joe.gestion.model.helperclasses.TeamPlayers;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class DataToXML {

    public DataToXML() {

    }

    public static boolean exportAllPlayers(List<Player> players, String pathname) {
        boolean ans = false;
        if (players == null || players.isEmpty()) {
            throw new EquipDataInterfaceException("Passed a null or empty player list.");
        }

        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }

        File file = new File(pathname);
        try {

            PlayerList playerList = new PlayerList(players);

            JAXBContext jaxbContext = JAXBContext.newInstance(PlayerList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(playerList, os);
            ans = true;

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
        return ans;
    }

    public static void exportPlayer(Player player, String pathname) {
        if (player == null) {
            throw new EquipDataInterfaceException("Passed a null or empty player.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        File file = new File(pathname);
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Player.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(player, os);

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
    }

    public static void exportTeam(Team team, String pathname) {
        if (team == null) {
            throw new EquipDataInterfaceException("Passed a null or empty team.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        File file = new File(pathname);
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Team.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(team, os);

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
    }

    public static void exportTeamWithPlayers(Team team, List<Player> players, String pathname) {
        if (team == null) {
            throw new EquipDataInterfaceException("Passed a null or empty team.");
        }
        if (players == null) {
            throw new EquipDataInterfaceException("Passed a null or empty player.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        File file = new File(pathname);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(TeamPlayers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            PlayerList playerList = new PlayerList(players);
            TeamPlayers teamPlayers = new TeamPlayers(team, playerList);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(teamPlayers, os);

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
    }

    public static void exportSeasonTeam(List<Team> teams, String pathname) {
        if (teams == null || teams.isEmpty()) {
            throw new EquipDataInterfaceException("Passed a null or empty player list.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        File file = new File(pathname);
        try {

            TeamList teamList = new TeamList(teams);

            JAXBContext jaxbContext = JAXBContext.newInstance(TeamList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(teamList, os);

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
    }

    public static void exportSeasonTeamWithPlayers(List<Team> teams, List<Player> players, String pathname) {
        if (teams == null) {
            throw new EquipDataInterfaceException("Passed a null or empty team.");
        }
        if (players == null) {
            throw new EquipDataInterfaceException("Passed a null or empty player.");
        }
        if (pathname == null || pathname.isBlank()) {
            throw new EquipDataInterfaceException("Can't pass a null or empty pathname.");
        }
        File file = new File(pathname);

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(SeasonTeamsPlayers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            PlayerList playerList = new PlayerList(players);
            TeamList teamList = new TeamList(teams);
            SeasonTeamsPlayers seasonteamPlayers = new SeasonTeamsPlayers(teamList, playerList);

            OutputStream os = new FileOutputStream(file);
            marshaller.marshal(seasonteamPlayers, os);

        } catch (JAXBException ex) {
            throw new EquipDataInterfaceException("JAXB Exception: " + ex.getMessage(), ex.getCause());
        } catch (FileNotFoundException ex) {
            throw new EquipDataInterfaceException("Error finding file: " + ex.getMessage(), ex.getCause());
        }
    }
}
