
package org.joe.gestion.model.data;

import java.util.Date;


public class PlayerTeam {
    private int playerID;
    private int teamID;
    private int categoryID;
    private Date season;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Date getSeason() {
        return season;
    }

    public void setSeason(Date season) {
        this.season = season;
    }

    public PlayerTeam(int playerID, int teamID, int categoryID, Date season) {
        this.playerID = playerID;
        this.teamID = teamID;
        this.categoryID = categoryID;
        this.season = season;
    }

    
}
