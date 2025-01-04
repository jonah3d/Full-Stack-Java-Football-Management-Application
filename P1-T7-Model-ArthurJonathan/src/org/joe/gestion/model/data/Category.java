package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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

    public Category() {
    }

    public Category(String name, int minimum_age, int maximum_age) {
        setName(name);
        setMinimum_age(minimum_age);
        setMaximum_age(maximum_age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("Nombre no debería ser null o vacio");
        }
        this.name = name;
    }

    public int getMinimum_age() {
        return minimum_age;
    }

    public void setMinimum_age(int minimum_age) {
        if (minimum_age <= 6) {
            throw new RuntimeException("Año minimum no puede ser 6 o menos de 6");
        }
        this.minimum_age = minimum_age;
    }

    public int getMaximum_age() {
        return maximum_age;
    }

    public void setMaximum_age(int maximum_age) {
        if (maximum_age >= 100) {
            throw new RuntimeException("Año maximum no puede ser 100 o mas de 6");
        }
        this.maximum_age = maximum_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new RuntimeException("Id del categoría no puede ser 0 o menos de 0");
        }
        this.id = id;
    }

    public void mostrarDetalle() {
        System.out.println("ID:      " + getId());
        System.out.println("NAME:    " + getName());
        System.out.println("MIN AGE: " + getMinimum_age());
        System.out.println("MAX AGE: " + getMaximum_age());
    }

}
