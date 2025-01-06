package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * La clase {@code Category} representa una categoría utilizada para clasificar
 * a los jugadores según su rango de edad.
 * <p>
 * Utiliza anotaciones JAX para serialización y deserialización en XML.
 * </p>
 *
 * @author Jonathan Arthur
 * @version 1.0
 * @since 2025-01-01
 */

@XmlRootElement(name = "categoria")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "nombre")
    private String name;
    @XmlElement(name = "edatMin")
    private int minimum_age;
    @XmlElement(name = "edatMax")
    private int maximum_age;

    /**
     * Constructor por defecto requerido para JAX-B.
     */
    public Category() {
    }

    /**
     * Constructor que inicializa una nueva categoría con los datos especificados.
     *
     * @param name        el nombre de la categoría.
     * @param minimum_age la edad mínima para esta categoría.
     * @param maximum_age la edad máxima para esta categoría.
     */
    public Category(String name, int minimum_age, int maximum_age) {
        setName(name);
        setMinimum_age(minimum_age);
        setMaximum_age(maximum_age);
    }


    /**
     * Obtiene el nombre de la categoría.
     *
     * @return el nombre de la categoría.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param name el nuevo nombre de la categoría.
     * @throws RuntimeException si el nombre es nulo o vacío.
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("Nombre no debería ser null o vacio");
        }
        this.name = name;
    }

    /**
     * Obtiene el año minima de la categoría.
     *
     * @return el minimum_age de la categoría.
     */
    public int getMinimum_age() {
        return minimum_age;
    }

    /**
     * Establece el año maximo de la categoría.
     *
     * @param minimum_age el nuevo año maximo de la categoría.
     * @throws RuntimeException si el año maximo es menos de 6.
     */
    public void setMinimum_age(int minimum_age) {
        if (minimum_age <= 6) {
            throw new RuntimeException("Año minimum no puede ser 6 o menos de 6");
        }
        this.minimum_age = minimum_age;
    }

    /**
     * Obtiene el año maxima de la categoría.
     *
     * @return el maximum_age de la categoría.
     */
    public int getMaximum_age() {
        return maximum_age;
    }

    /**
     * Establece el año maximo de la categoría.
     *
     * @param maximum_age el nuevo año maximo de la categoría.
     * @throws RuntimeException si el año maximo es 100 o mas.
     */
    public void setMaximum_age(int maximum_age) {
        if (maximum_age >= 100) {
            throw new RuntimeException("Año maximum no puede ser 100 o mas de 6");
        }
        this.maximum_age = maximum_age;
    }

    /**
     * Obtiene el id de la categoría.
     *
     * @return el id de la categoría.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la categoría.
     *
     * @param id el nuevo id de la categoría.
     * @throws RuntimeException si el id es 0 o menos de 0.
     */
    public void setId(int id) {
        if (id <= 0) {
            throw new RuntimeException("Id del categoría no puede ser 0 o menos de 0");
        }
        this.id = id;
    }

    /**
     * Muestra los detalles de la categoría.
     */
    public void mostrarDetalle() {
        System.out.println("ID:      " + getId());
        System.out.println("NAME:    " + getName());
        System.out.println("MIN AGE: " + getMinimum_age());
        System.out.println("MAX AGE: " + getMaximum_age());
    }

}
