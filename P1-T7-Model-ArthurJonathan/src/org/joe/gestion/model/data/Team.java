package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import org.joe.gestion.model.adapter.DataAdapter;
/**
 * La clase {@code Team} representa un equipo en el sistema.
 * <p>
 * Utiliza anotaciones JAX para serialización y deserialización en XML,
 * incluyendo detalles como el nombre del equipo, la temporada, la categoría,
 * y el tipo de equipo.
 * </p>
 *
 * @author Jonathan
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "equipo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Team {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "nombre")
    private String name;
    @XmlElement(name = "temporada")
    @XmlJavaTypeAdapter(DataAdapter.class)
    private Date season_year;
    @XmlElement(name = "categoria")
    private String categoryName;
    @XmlAttribute(name = "tipo")
    private String team_type;

    /**
     * Constructor que inicializa un nuevo equipo con los datos especificados.
     *
     * @param name        el nombre del equipo.
     * @param season_year la temporada asociada al equipo.
     * @param category    la categoría del equipo.
     * @param team_type   el tipo de equipo.
     */
    public Team(String name, Date season_year, String category, String team_type) {
        setName(name);
        setSeason_year(season_year);
        setCategory(category);
        setTeam_type(team_type);
    }
    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public Team() {
    }
    /**
     * Obtiene el nombre del equipo.
     *
     * @return el nombre del equipo.
     */
    public String getName() {
        return name;
    }
    /**
     * Establece el nombre del equipo.
     *
     * @param name el nuevo nombre del equipo.
     * throws RuntimeException si el nombre es nulo o vacío.
     */
    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new RuntimeException("El nombre del equipo no puede ser nulo o vacío.");
        }
        this.name = name;
    }
    /**
     * Obtiene la temporada asociada al equipo.
     *
     * @return la temporada asociada.
     */
    public Date getSeason_year() {
        return season_year;
    }
    /**
     * Establece la temporada asociada al equipo.
     *
     * @param season_year la nueva temporada asociada.
     */
    public void setSeason_year(Date season_year) {
        this.season_year = season_year;
    }
    /**
     * Obtiene la categoría del equipo.
     *
     * @return la categoría del equipo.
     */

    public String getCategory() {
        return categoryName;
    }
    /**
     * Establece la categoría del equipo.
     *
     * @param category la nueva categoría del equipo.
     */
    public void setCategory(String category) {
        this.categoryName = category;
    }
    /**
     * Obtiene el tipo de equipo.
     *
     * @return el tipo de equipo.
     */
    public String getTeam_type() {
        return team_type;
    }
    /**
     * Establece el tipo de equipo.
     *
     * @param team_type el nuevo tipo de equipo.
     */
    public void setTeam_type(String team_type) {
        this.team_type = team_type;
    }
    /**
     * Obtiene el identificador único del equipo.
     *
     * @return el ID del equipo.
     */
    public int getId() {
        return id;
    }
    /**
     * Establece el identificador único del equipo.
     *
     * @param id el nuevo ID del equipo.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Muestra los detalles del equipo en la consola.
     */
    public void mostrarDetalle() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Season: " + getSeason_year().toString());
        System.out.println("Category: " + getCategory());
        System.out.println("Team Type: " + getTeam_type());

    }

}
