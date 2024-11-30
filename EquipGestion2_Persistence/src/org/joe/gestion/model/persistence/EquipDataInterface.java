
package org.joe.gestion.model.persistence;

import java.util.Date;
import java.util.List;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
/**
 *
 * @author jonah
 * @version 1.0
 */

public interface EquipDataInterface {

       //Application Management
   public boolean createUser(String username, String name,String password);
    public boolean validateUser(String username,String password);
    public void restorePassword(String username, String Password);
    
    public boolean connectDatasource(String Filename);
    public boolean disconnectDatasource();
    
    //Player Management
    public Player getPlayerByLegalId(String legalID);
    public List<Player> getPlayerByBirthYear(Date date);
    public List<Player> getPlayerByName(String Name);
    public List<Player> getPlayerBySurname(String surname);
    public void addNewPlayer(Player player);
    public void eliminarJugador(String legalID);
    
    
    //Team Management
    public List<Category> getCategorys();
    public List<Team> getTeamsByCategory(String cat);
    public List<Team> getTeamsByType (String type);
  
    
     public void addNewTeam(String name, String teamtype, String cat_name,Date  seasondate);
    public List<Player> getTeamPlayers(String teamName);
    public void addPlayerToTeam(String LegalID);
    public void deletePlayerFromTeam(String legalID);
    public void deleteTeam(String name);
    
    //Season management
    public void addNewSeason(String season_n,Date date);
    public void removeSeason(String season_n);
    public void removeTeamFromSeason(String t_name);
    public List<Team> getSeasonTeams(String season_n);
   
    //PlayerTeam
    public List<Player> getPlayersByCat(String cat);
    public void editarJugador(String legalID);
}
