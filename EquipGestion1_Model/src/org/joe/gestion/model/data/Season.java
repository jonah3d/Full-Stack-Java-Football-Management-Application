
package org.joe.gestion.model.data;

import java.util.Date;


public class Season {
    String name;
    private Date season;

    public Season(String name, Date season) {
        setSeason(season);
        setName(name);
    }

    public Date getSeason() {
        return season;
    }

    public void setSeason(Date season) {
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
