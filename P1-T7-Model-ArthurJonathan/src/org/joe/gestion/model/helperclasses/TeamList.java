/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import org.joe.gestion.model.data.Team;

/**
 * La clase {@code TeamList} representa una lista de equipos.
 * <p>
 * Está diseñada para ser serializada y deserializada en formato XML utilizando JAX-B.
 * </p>
 * <p>
 * La estructura XML generada tendrá el siguiente formato:
 * </p>
 * <pre>{@code
 * <equipos>
 *     <equipo>
 *         <!-- Detalles del equipo -->
 *     </equipo>
 *     <equipo>
 *         <!-- Detalles del equipo -->
 *     </equipo>
 * </equipos>
 * }</pre>
 *
 * <ul>
 *     <li>El elemento raíz es {@code equipos}.</li>
 *     <li>Cada equipo se representa como un elemento {@code equipo}.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "equipos")
public class TeamList {

    private List<Team> teams;
    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public TeamList() {

    }
    /**
     * Constructor que inicializa una nueva lista de equipos.
     *
     * @param teams la lista de equipos a incluir.
     */
    public TeamList(List<Team> teams) {
        this.teams = teams;
    }
    /**
     * Obtiene la lista de equipos.
     *
     * @return la lista de equipos.
     */
    @XmlElement(name = "equipo")
    public List<Team> getTeams() {
        return teams;
    }
    /**
     * Establece la lista de equipos.
     *
     * @param teams la nueva lista de equipos.
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

}
