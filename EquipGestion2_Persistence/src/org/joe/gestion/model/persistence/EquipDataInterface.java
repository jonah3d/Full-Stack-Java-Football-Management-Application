package org.joe.gestion.model.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Season;
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 * @version 1.0
 */
public interface EquipDataInterface {

    //Application Management
    public boolean createUser(String username, String name, String password);

    public boolean validateUser(String username, String password);

    public void restorePassword(String username, String Password);

    public boolean connectDatasource(String Filename);

    public boolean disconnectDatasource();

    //Player Management
    public List<Player> getPlayersByLegalId(String legalID);

    public Player getPlayerByLegalId(String legalId);

    public List<Player> getPlayerByBirthYear(Date date);

    public List<Player> getPlayerByBirthYear_ordCognom(Date date);

    public List<Player> getPlayerByBirthYear_orddDatnaix(Date date);

    public List<Player> getPlayerByName(String Name);

    public List<Player> getPlayerBySurname(String surname);

    public List<Player> getPlayerBySurname_ordCognom(String surname);

    public List<Player> getPlayerBySurname_ordDatnaix(String surname);

    public List<Player> getPlayers();

    public List<Player> getPlayers_ordCognom();

    public List<Player> getPlayers_ordDatnaix();

    public void addNewPlayer(Player player);

    public boolean checkPlayerBelongsToTeam(String legalID);

    public Integer checkPlayerTeam(String legalID);

    public Team getPlayerTeam(String legalID);

    public void eliminarJugador(String legalID);

    //Team Management
    public List<Category> getCategorys();

    public List<Team> getTeamsByCategory(String cat);

    public List<Team> getTeamsByType(String type);

    public List<Team> getTeamsBySeason(Date season);

    public List<Team> getAllTeams();

    public int getTeamMemCount(String team);

    public void addNewTeam(String name, String teamtype, String cat_name, Date seasondate);

    public List<Player> getTeamPlayers(String teamName);

    public void addPlayerToTeam(Player player, Team team, boolean titularidad);

    public void deletePlayerFromTeam(Player player, Integer team);

    public void deleteTeam(String name);

    //Season management
    public void addNewSeason(String season_n, Date date);

    public void removeSeason(String season_n);

    public void removeTeamFromSeason(String t_name);

    public void removeTeamWithPlayers(Team team);

    public List<Team> getSeasonTeams(String season_n);

    public List<Season> getSeasons();

    //PlayerTeam
    public List<Player> getPlayersByCat(String cat);

    public List<Player> getPlayeraByCat_ordCognom(String cat);

    public List<Player> getPlayeraByCat_ordDatnaix(String cat);

    public void editarJugador(Player player);
}
