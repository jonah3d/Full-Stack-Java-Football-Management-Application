
package org.joe.gestion.model.data;

import java.util.Date;

/**
 * La clase {@code PlayerTeam} representa la relación entre un jugador y un equipo
 * en una temporada específica.
 * <p>
 * No incluye anotaciones JAX, pero puede extenderse para integrar datos serializables.
 * </p>
 *
 * @author Jonathan
 * @version 1.0
 * @since 2025-01-01
 */
public class PlayerTeam {
    private int playerID;
    private int teamID;
    private int categoryID;
    private Date season;

    /**
     * Obtiene el identificador del jugador.
     *
     * @return el ID del jugador.
     */
    public int getPlayerID() {
        return playerID;
    }
    /**
     * Establece el identificador del jugador.
     *
     * @param playerID el nuevo ID del jugador.
     */

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    /**
     * Obtiene el identificador del equipo.
     *
     * @return el ID del equipo.
     */
    public int getTeamID() {
        return teamID;
    }
    /**
     * Establece el identificador del equipo.
     *
     * @param teamID el nuevo ID del equipo.
     */
    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }
    /**
     * Obtiene el identificador de la categoría.
     *
     * @return el ID de la categoría.
     */
    public int getCategoryID() {
        return categoryID;
    }
    /**
     * Establece el identificador de la categoría.
     *
     * @param categoryID el nuevo ID de la categoría.
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    /**
     * Obtiene la temporada de la relación.
     *
     * @return la temporada.
     */
    public Date getSeason() {
        return season;
    }
    /**
     * Establece la temporada de la relación.
     *
     * @param season la nueva temporada.
     */
    public void setSeason(Date season) {
        this.season = season;
    }
    /**
     * Constructor para inicializar los datos de la relación jugador-equipo.
     *
     * @param playerID   el identificador del jugador.
     * @param teamID     el identificador del equipo.
     * @param categoryID el identificador de la categoría.
     * @param season     la temporada de la relación.
     */
    public PlayerTeam(int playerID, int teamID, int categoryID, Date season) {
        this.playerID = playerID;
        this.teamID = teamID;
        this.categoryID = categoryID;
        this.season = season;
    }

    
}
