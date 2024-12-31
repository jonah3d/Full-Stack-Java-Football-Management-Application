/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 */
@XmlRootElement(name = "equipos")
public class TeamList {

    private List<Team> teams;

    public TeamList() {

    }

    public TeamList(List<Team> teams) {
        this.teams = teams;
    }

    @XmlElement(name = "equipo")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
