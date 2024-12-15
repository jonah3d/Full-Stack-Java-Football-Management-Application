package org.joe.gestion.model.data;

import java.io.FileInputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    private int id;
    protected String name;
    protected String surname;
    protected String sex;
    protected Date birth_year;
    protected String legal_id;
    protected String iban;
    protected String direccion;
    protected String codigo_postal;
    protected String localidad;
    protected String provincia;
    protected String pais;
    protected Blob image;
    protected Integer medical_rev_fin;

    public Player() {
    }

    public Player(String name, String surname, String sex, Date birth_year) {
        setName(name);
        setSurname(surname);
        setSex(sex);
        setBirth_year(birth_year);
    }

    public Player(String name, String surname, String sex, Date birth_year, String legal_id, String iban, String direccion, String codigo_postal, String localidad, String provincia, String pais, Blob image, Integer medical_rev_fin) {
        setName(name);
        setSurname(surname);
        setSex(sex);
        setBirth_year(birth_year);
        setLegal_id(legal_id);
        setIban(iban);
        setDireccion(direccion);
        setCodigo_postal(codigo_postal);
        setLocalidad(localidad);
        setProvincia(provincia);
        setPais(pais);
        setImage(image);
        setMedical_rev_fin(medical_rev_fin);
    }

    public String getCodigo_postal() {
        return codigo_postal;
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
            throw new RuntimeException("Legal ID Can't Be Empty");
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

    }

}
