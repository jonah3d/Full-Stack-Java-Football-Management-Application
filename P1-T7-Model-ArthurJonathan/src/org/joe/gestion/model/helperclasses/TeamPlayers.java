/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.List;
import org.joe.gestion.model.data.Team;


/**
 * La clase {@code TeamPlayers} representa un equipo y su lista de jugadores.
 * <p>
 * Está diseñada para ser serializada y deserializada en formato XML utilizando JAX-B.
 * </p>
 * <p>
 * La estructura XML generada tendrá el siguiente formato:
 * </p>
 * <pre>{@code
 * <equipojugador>
 *     <equipo>
 *         <!-- Detalles del equipo -->
 *     </equipo>
 *     <jugadores>
 *         <!-- Detalles de los jugadores -->
 *     </jugadores>
 * </equipojugador>
 * }</pre>
 *
 * <ul>
 *     <li>El elemento raíz es {@code equipojugador}.</li>
 *     <li>El elemento {@code equipo} contiene la información del equipo.</li>
 *     <li>El elemento {@code jugadores} contiene la lista de jugadores del equipo.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "equipojugador")
@XmlType(propOrder = {"team", "players"})
public class TeamPlayers {

    private Team team;
    private PlayerList players;
    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public TeamPlayers() {

    }

    /**
     * Constructor que inicializa un objeto {@code TeamPlayers} con un equipo y una lista de jugadores.
     *
     * @param team el equipo asociado con los jugadores.
     * @param players la lista de jugadores del equipo.
     */
    public TeamPlayers(Team team, PlayerList players) {
        this.team = team;
        this.players = players;

    }
    /**
     * Obtiene el equipo asociado a este objeto {@code TeamPlayers}.
     *
     * @return el equipo asociado.
     */
    @XmlElement(name = "equipo")
    public Team getTeam() {
        return team;
    }
    /**
     * Obtiene la lista de jugadores asociados a este objeto {@code TeamPlayers}.
     *
     * @return la lista de jugadores.
     */
    @XmlElement(name = "jugadores")
    public PlayerList getPlayers() {
        return players;
    }
    /**
     * Establece el equipo asociado a este objeto {@code TeamPlayers}.
     *
     * @param team el equipo a establecer.
     */
    public void setTeam(Team team) {
        this.team = team;
    }
    /**
     * Establece la lista de jugadores asociados a este objeto {@code TeamPlayers}.
     *
     * @param players la lista de jugadores a establecer.
     */
    public void setPlayers(PlayerList players) {
        this.players = players;
    }

}
