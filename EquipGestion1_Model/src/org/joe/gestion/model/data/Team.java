
package org.joe.gestion.model.data;

import java.util.Date;


public class Team {
    private int id;
    private String name;
    private Date season_year;
    private String categoryName;
    private String team_type;


        public Team(String name, Date season_year, String category, String team_type) {
        setName(name);
        setSeason_year(season_year);
        setCategory(category);
        setTeam_type(team_type);
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
    
    public void mostrarDetalle(){
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Season: " + getSeason_year().toString());
        System.out.println("Category: " + getCategory());
        System.out.println("Team Type: " + getTeam_type());
 
    }
    
    
}
