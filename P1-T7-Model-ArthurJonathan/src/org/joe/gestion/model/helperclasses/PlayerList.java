/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import org.joe.gestion.model.data.Player;

/**
 * La clase {@code PlayerList} representa una lista de jugadores.
 * <p>
 * Está diseñada para ser serializada y deserializada en formato XML utilizando JAX-B.
 * </p>
 * <p>
 * La estructura XML generada tendrá el siguiente formato:
 * </p>
 * <pre>{@code
 * <jugadores>
 *     <jugador>
 *         <!-- Detalles del jugador -->
 *     </jugador>
 *     <jugador>
 *         <!-- Detalles del jugador -->
 *     </jugador>
 * </jugadores>
 * }</pre>
 *
 * <ul>
 *     <li>El elemento raíz es {@code jugadores}.</li>
 *     <li>Cada jugador se representa como un elemento {@code jugador}.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "jugadores")
public class PlayerList {

    private List<Player> players;

    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public PlayerList() {
    }
    /**
     * Constructor que inicializa una nueva lista de jugadores.
     *
     * @param players la lista de jugadores a incluir.
     */
    public PlayerList(List<Player> players) {
        this.players = players;
    }

    /**
     * Obtiene la lista de jugadores.
     *
     * @return la lista de jugadores.
     */
    @XmlElement(name = "jugador")
    public List<Player> getPlayers() {
        return players;
    }
    /**
     * Establece la lista de jugadores.
     *
     * @param players la nueva lista de jugadores.
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
