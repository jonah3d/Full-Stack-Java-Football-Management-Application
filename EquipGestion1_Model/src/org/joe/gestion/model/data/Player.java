package org.joe.gestion.model.data;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joe.gestion.model.adapter.DataAdapter;

@XmlRootElement(name = "jugador")
@XmlAccessorType(XmlAccessType.FIELD) // Use field-level annotations
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class Player implements Serializable {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "nombre")
    private String name;

    @XmlElement(name = "appellido")
    private String surname;

    @XmlElement(name = "sexo")
    private String sex;

    @XmlElement(name = "anoNacimiento")
    @XmlJavaTypeAdapter(DataAdapter.class)
    private Date birth_year;

    @XmlAttribute(name = "nif")
    private String legal_id;

    @XmlElement(name = "iban")
    private String iban;

    @XmlElement(name = "dirección")
    private String direccion;

    @XmlElement(name = "codigoPostal")
    private String codigo_postal;

    @XmlElement(name = "localidad")
    private String localidad;

    @XmlElement(name = "provincia")
    private String provincia;

    @XmlElement(name = "pais")
    private String pais;

    @XmlTransient // Exclude from serialization
    private Blob image;

    @XmlElement(name = "revisiónMedica")
    private Integer medical_rev_fin;

    @XmlTransient // Exclude from serialization
    private String category;

    @XmlTransient // Exclude from serialization
    private String titularidad;

    public Player() {
    }

    public Player(String name, String surname, String sex, Date birth_year) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birth_year = birth_year;
    }

    public Player(String name, String surname, String sex, Date birth_year, String legal_id, String iban,
            String direccion, String codigo_postal, String localidad, String provincia,
            String pais, Blob image, Integer medical_rev_fin) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birth_year = birth_year;
        this.legal_id = legal_id;
        this.iban = iban;
        this.direccion = direccion;
        this.codigo_postal = codigo_postal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.image = image;
        this.medical_rev_fin = medical_rev_fin;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getTitularidad() {
        return titularidad;
    }

    public void setTitularidad(String titularidad) {
        this.titularidad = titularidad;
    }

    public void setCodigo_postal(String codigo_postal) {

        if (!codigo_postal.isEmpty()) {
            this.codigo_postal = codigo_postal;
        } else {
            throw new RuntimeException("Direccion Field Can't Be Empty");
        }

    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        if (!localidad.isEmpty()) {
            this.localidad = localidad;
        } else {
            throw new RuntimeException("Direccion Field Can't Be Empty");
        }
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        if (!provincia.isEmpty()) {
            this.provincia = provincia;
        } else {
            throw new RuntimeException("Direccion Field Can't Be Empty");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        if (!pais.isEmpty()) {
            this.pais = pais;
        } else {
            throw new RuntimeException("Direccion Field Can't Be Empty");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth_year() {
        return birth_year;
    }

    public String getLegal_id() {
        return legal_id;
    }

    public String getIban() {
        return iban;
    }

    public String getDireccion() {
        return direccion;
    }

    public Blob getImage() {
        return image;
    }

    public Integer getMedical_rev_fin() {
        return medical_rev_fin;
    }

    public void setName(String name) {
        if (!name.isEmpty() || name != null) {
            this.name = name;
        } else {
            throw new RuntimeException("The Name Field Can't Be Empty Or Null");
        }
    }

    public void setSurname(String surname) {
        if (!surname.isEmpty() || surname != null) {
            this.surname = surname;
        } else {
            throw new RuntimeException("The Surname Field Can't Be Empty Or Null");
        }
    }

    public void setSex(String sex) {

        if (sex.toUpperCase().equals("H") || sex.toUpperCase().equals("D")) {
            this.sex = sex;
        } else {
            throw new RuntimeException("The Sex Of The Character Must Either be H or D");
        }
    }

    public void setBirth_year(Date birth_year) {
        if (birth_year == null) {
            throw new RuntimeException("Birth Year Is null");
        }

        this.birth_year = birth_year;
    }

    public void setLegal_id(String legal_id) {
        if (!legal_id.isEmpty() && legal_id.length() == 8) {
            this.legal_id = legal_id;
        } else {
            throw new RuntimeException("Legal ID Can't Be Empty Or Less Than 8 Digits");
        }
    }

    public void setIban(String iban) {
        if (!iban.isEmpty() || iban.length() == 24) {
            this.iban = iban;
        } else {
            throw new RuntimeException("The IBAN Must Be 24 Digits");
        }
    }

    public void setDireccion(String direccion) {
        if (!direccion.isEmpty()) {
            this.direccion = direccion;
        } else {
            throw new RuntimeException("Direccion Field Can't Be Empty");
        }
    }

    public void setImage(Blob image) {

        this.image = image;
    }

    public void setMedical_rev_fin(Integer medical_rev_fin) {
        this.medical_rev_fin = medical_rev_fin;
    }

    public void mostrarJugDetalle() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Apellido: " + getSurname());
        System.out.println("Sexo: " + getSex());
        System.out.println("Año Nacimiento: " + getBirth_year());
        System.out.println("ID Legal: " + getLegal_id());
        System.out.println("Iban: " + getIban());
        System.out.println("Ubicación: " + getDireccion());
        System.out.println("Photo: " + getImage());
        System.out.println("Medical Revision Fin: " + getMedical_rev_fin());
        System.out.println("Category " + getCategory());
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
