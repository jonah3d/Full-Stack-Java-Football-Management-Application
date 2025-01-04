/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonah
 */
@XmlRootElement(name = "temporadaequipos")
public class SeasonTeamsPlayers {

    private TeamList teams;
    private PlayerList players;

    public SeasonTeamsPlayers() {

    }

    public SeasonTeamsPlayers(TeamList teams, PlayerList players) {
        this.teams = teams;
        this.players = players;
    }

    @XmlElement(name = "equipos")
    public TeamList getTeams() {
        return teams;
    }

    public void setTeams(TeamList teams) {
        this.teams = teams;
    }

    @XmlElement(name = "jugadores")
    public PlayerList getPlayers() {
        return players;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

}
