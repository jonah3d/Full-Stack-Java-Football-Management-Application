package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import org.joe.gestion.model.adapter.DataAdapter;

@XmlRootElement(name = "equipo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Team {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "nombre")
    private String name;
    @XmlElement(name = "temporada")
    @XmlJavaTypeAdapter(DataAdapter.class)
    private Date season_year;
    @XmlElement(name = "categoria")
    private String categoryName;
    @XmlAttribute(name = "tipo")
    private String team_type;

    public Team(String name, Date season_year, String category, String team_type) {
        setName(name);
        setSeason_year(season_year);
        setCategory(category);
        setTeam_type(team_type);
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSeason_year() {
        return season_year;
    }

    public void setSeason_year(Date season_year) {
        this.season_year = season_year;
    }

    public String getCategory() {
        return categoryName;
    }

    public void setCategory(String category) {
        this.categoryName = category;
    }

    public String getTeam_type() {
        return team_type;
    }

    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void mostrarDetalle() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Season: " + getSeason_year().toString());
        System.out.println("Category: " + getCategory());
        System.out.println("Team Type: " + getTeam_type());

    }

}
