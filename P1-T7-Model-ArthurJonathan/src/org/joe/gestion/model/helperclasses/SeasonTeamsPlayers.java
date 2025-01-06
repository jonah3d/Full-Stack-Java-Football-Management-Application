/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * La clase {@code SeasonTeamsPlayers} representa la asociación de equipos y jugadores
 * durante una temporada específica.
 * <p>
 * Está diseñada para ser serializada y deserializada en formato XML utilizando JAX-B.
 * </p>
 * <p>
 * La estructura XML generada tendrá el siguiente formato:
 * </p>
 * <pre>{@code
 * <temporadaequipos>
 *     <equipos>
 *         <!-- Lista de equipos -->
 *     </equipos>
 *     <jugadores>
 *         <!-- Lista de jugadores -->
 *     </jugadores>
 * </temporadaequipos>
 * }</pre>
 *
 * <ul>
 *     <li>El elemento raíz es {@code temporadaequipos}.</li>
 *     <li>El elemento {@code equipos} contiene una lista de equipos.</li>
 *     <li>El elemento {@code jugadores} contiene una lista de jugadores.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "temporadaequipos")
public class SeasonTeamsPlayers {

    private TeamList teams;
    private PlayerList players;
    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public SeasonTeamsPlayers() {

    }
    /**
     * Constructor que inicializa la relación de equipos y jugadores para una temporada.
     *
     * @param teams   la lista de equipos.
     * @param players la lista de jugadores.
     */
    public SeasonTeamsPlayers(TeamList teams, PlayerList players) {
        this.teams = teams;
        this.players = players;
    }

    /**
     * Obtiene la lista de equipos asociados a la temporada.
     *
     * @return la lista de equipos.
     */
    @XmlElement(name = "equipos")
    public TeamList getTeams() {
        return teams;
    }
    /**
     * Establece la lista de equipos asociados a la temporada.
     *
     * @param teams la nueva lista de equipos.
     */
    public void setTeams(TeamList teams) {
        this.teams = teams;
    }
    /**
     * Obtiene la lista de jugadores asociados a la temporada.
     *
     * @return la lista de jugadores.
     */
    @XmlElement(name = "jugadores")
    public PlayerList getPlayers() {
        return players;
    }
    /**
     * Establece la lista de jugadores asociados a la temporada.
     *
     * @param players la nueva lista de jugadores.
     */
    public void setPlayers(PlayerList players) {
        this.players = players;
    }

}
