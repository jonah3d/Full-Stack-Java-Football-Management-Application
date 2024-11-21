
package org.joe.gestion.model.data;

import java.util.Date;


public class Team {
    private int id;
    private String name;
    private Date season_year;
    private Category category;
    private char team_type;


        public Team(String name, Date season_year, Category category, char team_type) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public char getTeam_type() {
        return team_type;
    }

    public void setTeam_type(char team_type) {
        this.team_type = team_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
