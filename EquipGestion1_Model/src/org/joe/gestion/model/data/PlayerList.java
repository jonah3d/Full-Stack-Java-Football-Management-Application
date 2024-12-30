/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author jonah
 */
@XmlRootElement(name = "jugadores")
public class PlayerList {

    private List<Player> players;

    public PlayerList() {
    }

    public PlayerList(List<Player> players) {
        this.players = players;
    }

    @XmlElement(name = "jugador")
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
