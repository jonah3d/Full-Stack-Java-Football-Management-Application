/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.joe.gestion.model.data.Category;

/**
 *
 * @author jonah
 */
@XmlRootElement(name = "categoriaequipos")
@XmlType(propOrder = {"category", "teamList"})
public class CategoriaEquipos {

    private Category category;
    private TeamList teamList;

    public CategoriaEquipos() {
    }

    public CategoriaEquipos(Category category, TeamList teamList) {
        this.category = category;
        this.teamList = teamList;
    }

    @XmlElement(name = "categoria")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlElement(name = "equipos")
    public TeamList getTeamList() {
        return teamList;
    }

    public void setTeamList(TeamList teamList) {
        this.teamList = teamList;
    }

}
