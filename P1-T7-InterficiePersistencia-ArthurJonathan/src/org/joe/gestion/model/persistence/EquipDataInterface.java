package org.joe.gestion.model.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Season;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.helperclasses.TeamPlayers;

/**
 * La interfaz {@code EquipDataInterface} define los métodos necesarios para la
 * gestión de datos de jugadores, equipos, temporadas y usuarios en la
 * aplicación.
 * <p>
 * Esta interfaz proporciona operaciones para crear usuarios, validar
 * credenciales, restaurar contraseñas, conectar y desconectar fuentes de datos,
 * así como gestionar jugadores, equipos y temporadas.
 * </p>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
public interface EquipDataInterface {

    //Application Management
    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param username el nombre de usuario.
     * @param name el nombre completo del usuario.
     * @param password la contraseña del usuario.
     * @return {@code true} si el usuario fue creado exitosamente, {@code false}
     * en caso contrario.
     */
    public boolean createUser(String username, String name, String password);

    /**
     * Valida las credenciales de un usuario.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña del usuario.
     * @return {@code true} si las credenciales son válidas, {@code false} en
     * caso contrario.
     */
    public boolean validateUser(String username, String password);

    /**
     * Restaura la contraseña de un usuario.
     *
     * @param username el nombre de usuario.
     * @param Password la nueva contraseña.
     */
    public void restorePassword(String username, String Password);

    /**
     * Conecta la aplicación a una fuente de datos.
     *
     * @param Filename el nombre del archivo de los propiedades que que tiene la
     * fuente de datos.
     * @return {@code true} si la conexión fue exitosa, {@code false} en caso
     * contrario.
     */
    public boolean connectDatasource(String Filename);

    /**
     * Desconecta la aplicación de la fuente de datos.
     *
     * @return {@code true} si la desconexión fue exitosa, {@code false} en caso
     * contrario.
     */
    public boolean disconnectDatasource();

    //Player Management
    /**
     * Obtiene un jugador por su identificación legal.
     *
     * @param legalId el ID legal del jugador.
     * @return el jugador con la identificación legal proporcionada.
     */
    public Player getPlayerByLegalId(String legalId);

    /**
     * Obtiene todos los jugadores registrados en el sistema de bases de datos.
     *
     * @return una lista de todos los jugadores.
     */
    public List<Player> getPlayers();

    public void addNewPlayer(Player player);

    public boolean checkPlayerBelongsToTeam(String legalID);

    public Integer checkPlayerTeam(String legalID);

    public Team getPlayerTeam(String legalID);

    public void eliminarJugador(String legalID);

    public Category getCategory(String category);

    public List<Player> playerFilterSearch(String cognom, String legalid, Date birthdate, String categoria, String order);

    //Team Management
    public List<Category> getCategorys();

    public List<Team> getTeamsByCategory(String cat);

    public List<Team> getTeamsBySeason(Date season);

    public List<Team> getAllTeams();

    public int getTeamMemCount(String team);

    public void addNewTeam(String name, String teamtype, String cat_name, Date seasondate);

    public List<Player> getTeamPlayers(String teamName, java.sql.Date seasonyear);

    public void addPlayerToTeam(Player player, Team team, boolean titularidad);

    public void deletePlayerFromTeam(Player player, Integer team);

    public void deleteTeam(String name);

    public Team getTeamByName(String name, java.sql.Date date);

    public List<Team> getSeasonCategoryTeam(String category, Date date);

    //Season management
    public void addNewSeason(String season_n, Date date);

    public void removeTeamFromSeason(String t_name);

    public void removeTeamWithPlayers(Team team);

    public List<Season> getSeasons();

    public void editarJugador(Player player);
}
