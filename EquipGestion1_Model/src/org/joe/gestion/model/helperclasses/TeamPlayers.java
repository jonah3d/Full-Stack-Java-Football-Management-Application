/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 */
@XmlRootElement(name = "equipojugador")
@XmlType(propOrder = {"team", "players"})
public class TeamPlayers {

    private Team team;
    private PlayerList players;

    public TeamPlayers() {

    }

    public TeamPlayers(Team team, PlayerList players) {
        this.team = team;
        this.players = players;

    }

    @XmlElement(name = "equipo")
    public Team getTeam() {
        return team;
    }

    @XmlElement(name = "jugadores")
    public PlayerList getPlayers() {
        return players;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

}
