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

    /**
     * Agrega un nuevo jugador al sistema.
     *
     * @param player el jugador a agregar.
     */
    public void addNewPlayer(Player player);

    /**
     * Verifica si un jugador pertenece a un equipo.
     *
     * @param legalID el ID legal del jugador.
     * @return {@code true} si el jugador pertenece a un equipo, {@code false}
     * en caso contrario.
     */
    public boolean checkPlayerBelongsToTeam(String legalID);

    /**
     * Recupera el ID del equipo al que pertenece un jugador.
     *
     * @param legalID el ID legal del jugador.
     * @return el ID del equipo, o {@code null} si el jugador no pertenece a un
     * equipo.
     */
    public Integer checkPlayerTeam(String legalID);

    /**
     * Recupera el equipo al que pertenece un jugador.
     *
     * @param legalID el ID legal del jugador.
     * @return el equipo, o {@code null} si el jugador no está asignado a un
     * equipo.
     */
    public Team getPlayerTeam(String legalID);

    /**
     * Elimina a un jugador del sistema.
     *
     * @param legalID el ID legal del jugador a eliminar.
     */
    public void eliminarJugador(String legalID);

    /**
     * Recupera una categoría por su nombre.
     *
     * @param category el nombre de la categoría.
     * @return la categoría correspondiente al nombre especificado.
     */
    public Category getCategory(String category);

    /**
     * Realiza una búsqueda filtrada de jugadores.
     *
     * @param cognom el apellido del jugador (opcional).
     * @param legalid el ID legal del jugador (opcional).
     * @param birthdate la fecha de nacimiento del jugador (opcional).
     * @param categoria la categoría del jugador (opcional).
     * @param order los criterios de ordenación (opcional).
     * @return una lista de jugadores que coinciden con los criterios de
     * búsqueda.
     */
    public List<Player> playerFilterSearch(String cognom, String legalid, Date birthdate, String categoria, String order);

    // Gestión de equipos
    /**
     * Recupera todas las categorías.
     *
     * @return una lista de categorías.
     */
    public List<Category> getCategorys();

    /**
     * Recupera equipos por categoría.
     *
     * @param cat el nombre de la categoría.
     * @return una lista de equipos en la categoría especificada.
     */
    public List<Team> getTeamsByCategory(String cat);

    /**
     * Recupera equipos por temporada.
     *
     * @param season la temporada.
     * @return una lista de equipos en la temporada especificada.
     */
    public List<Team> getTeamsBySeason(Date season);

    /**
     * Recupera todos los equipos registrados en el sistema.
     *
     * @return una lista de todos los equipos.
     */
    public List<Team> getAllTeams();

    /**
     * Recupera el número de miembros en un equipo.
     *
     * @param team el nombre del equipo.
     * @return el número de miembros en el equipo especificado.
     */
    public int getTeamMemCount(String team);

    /**
     * Agrega un nuevo equipo al sistema.
     *
     * @param name el nombre del equipo.
     * @param teamtype el tipo de equipo.
     * @param cat_name el nombre de la categoría.
     * @param seasondate la fecha de la temporada.
     */
    public void addNewTeam(String name, String teamtype, String cat_name, Date seasondate);

    /**
     * Recupera los jugadores de un equipo específico.
     *
     * @param teamName el nombre del equipo.
     * @param seasonyear el año de la temporada.
     * @return una lista de jugadores en el equipo especificado.
     */
    public List<Player> getTeamPlayers(String teamName, java.sql.Date seasonyear);

    /**
     * Agrega un jugador a un equipo.
     *
     * @param player el jugador a agregar.
     * @param team el equipo al que se agregará el jugador.
     * @param titularidad indica si el jugador es titular.
     */
    public void addPlayerToTeam(Player player, Team team, boolean titularidad);

    /**
     * Elimina un jugador de un equipo.
     *
     * @param player el jugador a eliminar.
     * @param team el ID del equipo.
     */
    public void deletePlayerFromTeam(Player player, Integer team);

    /**
     * Elimina un equipo del sistema.
     *
     * @param name el nombre del equipo a eliminar.
     */
    public void deleteTeam(String name);

    /**
     * Recupera un equipo por su nombre y fecha de temporada.
     *
     * @param name el nombre del equipo.
     * @param date la fecha de la temporada.
     * @return el equipo correspondiente al nombre y fecha especificados.
     */
    public Team getTeamByName(String name, java.sql.Date date);

    /**
     * Recupera los equipos de una categoría específica en una temporada.
     *
     * @param category la categoría.
     * @param date la fecha de la temporada.
     * @return una lista de equipos en la categoría y temporada especificadas.
     */
    public List<Team> getSeasonCategoryTeam(String category, Date date);

    // Gestión de temporadas
    /**
     * Agrega una nueva temporada al sistema.
     *
     * @param season_n el nombre de la temporada.
     * @param date la fecha de la temporada.
     */
    public void addNewSeason(String season_n, Date date);

    /**
     * Elimina un equipo de una temporada.
     *
     * @param t_name el nombre del equipo a eliminar.
     */
    public void removeTeamFromSeason(String t_name);

    /**
     * Elimina un equipo junto con sus jugadores.
     *
     * @param team el equipo a eliminar.
     */
    public void removeTeamWithPlayers(Team team);

    /**
     * Recupera todas las temporadas registradas en el sistema.
     *
     * @return una lista de todas las temporadas.
     */
    public List<Season> getSeasons();

    /**
     * Edita los datos de un jugador existente.
     *
     * @param player el jugador con los datos actualizados.
     */
    public void editarJugador(Player player);
}
