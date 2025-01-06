/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.helperclasses;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.joe.gestion.model.data.Category;

/**
 * La clase {@code CategoriaEquipos} representa una asociación entre una categoría
 * y una lista de equipos pertenecientes a dicha categoría.
 * <p>
 * Está diseñada para ser serializada y deserializada en formato XML utilizando JAX-B.
 * </p>
 * <p>
 * La estructura XML generada tendrá el siguiente formato:
 * </p>
 * <pre>{@code
 * <categoriaequipos>
 *     <categoria>
 *         <!-- Detalles de la categoría -->
 *     </categoria>
 *     <equipos>
 *         <!-- Lista de equipos -->
 *     </equipos>
 * </categoriaequipos>
 * }</pre>
 *
 * <ul>
 *     <li>La propiedad {@code category} representa la categoría asociada.</li>
 *     <li>La propiedad {@code teamList} contiene los equipos relacionados con la categoría.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "categoriaequipos")
@XmlType(propOrder = {"category", "teamList"})
public class CategoriaEquipos {

    private Category category;
    private TeamList teamList;
    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public CategoriaEquipos() {
    }
    /**
     * Constructor que inicializa una nueva instancia de {@code CategoriaEquipos}
     * con una categoría y una lista de equipos.
     *
     * @param category la categoría asociada.
     * @param teamList la lista de equipos pertenecientes a la categoría.
     */
    public CategoriaEquipos(Category category, TeamList teamList) {
        this.category = category;
        this.teamList = teamList;
    }

    /**
     * Obtiene la categoría asociada.
     *
     * @return la categoría asociada.
     */
    @XmlElement(name = "categoria")
    public Category getCategory() {
        return category;
    }

    /**
     * Establece la categoría asociada.
     *
     * @param category la nueva categoría asociada.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Obtiene la lista de equipos pertenecientes a la categoría.
     *
     * @return la lista de equipos.
     */
    @XmlElement(name = "equipos")
    public TeamList getTeamList() {
        return teamList;
    }
    /**
     * Establece la lista de equipos pertenecientes a la categoría.
     *
     * @param teamList la nueva lista de equipos.
     */
    public void setTeamList(TeamList teamList) {
        this.teamList = teamList;
    }

}
