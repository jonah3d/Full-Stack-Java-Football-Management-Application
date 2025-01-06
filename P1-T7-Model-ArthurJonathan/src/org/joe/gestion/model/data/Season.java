package org.joe.gestion.model.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La clase {@code Season} representa una temporada con un nombre y una fecha asociada.
 * <p>
 * Proporciona métodos para acceder y modificar los atributos de la temporada,
 * así como para mostrar los detalles de la misma.
 * </p>
 *
 * @author Jonathan
 * @version 1.0
 * @since 2025-01-01
 */
public class Season {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String name;
    private Date season;

    /**
     * Constructor que inicializa una nueva temporada con el nombre y la fecha especificados.
     *
     * @param name   el nombre de la temporada.
     * @param season la fecha de la temporada.
     */
    public Season(String name, Date season) {
        setSeason(season);
        setName(name);
    }

    /**
     * Obtiene la fecha de la temporada.
     *
     * @return la fecha de la temporada.
     */
    public Date getSeason() {
        return season;
    }

    /**
     * Establece la fecha de la temporada.
     *
     * @param season la nueva fecha de la temporada.
     */
    public void setSeason(Date season) {
        if (season == null) {
            throw new RuntimeException("La data de la temporada no pot ser nul·la.");
        }
        this.season = season;
    }

    /**
     * Obtiene el nombre de la temporada.
     *
     * @return el nombre de la temporada.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la temporada.
     *
     * @param name el nuevo nombre de la temporada.
     * @throws RuntimeException si el nombre es nulo o vacío.
     */

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("El nom de la temporada no pot ser nul o buit.");
        }
        this.name = name;
    }
    /**
     * Muestra los detalles de la temporada en la consola.
     * <p>
     * Formatea la fecha de la temporada utilizando {@code SimpleDateFormat}.
     * </p>
     */

    public void mostrarDetalle() {
        System.out.println("NOM: " + getName());
        System.out.println("Data: " + sdf.format(getSeason()));
    }

}
