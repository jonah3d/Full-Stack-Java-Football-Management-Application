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

import java.io.Serializable;
import java.sql.Blob;

import java.util.Date;

import org.joe.gestion.model.adapter.DataAdapter;

/**
 * La clase {@code Player} representa un jugador dentro del sistema.
 * <p>
 * Está diseñada para ser serializable en XML utilizando anotaciones JAX-B.
 * </p>
 *
 * @author Jonathan Arthur
 * @version 1.0
 * @since 2025-01-01
 */
@XmlRootElement(name = "jugador")
@XmlAccessorType(XmlAccessType.FIELD)
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

    @XmlTransient
    private Blob image;

    @XmlElement(name = "revisiónMedica")
    private Integer medical_rev_fin;

    @XmlTransient
    private String category;

    @XmlTransient
    private String titularidad;

    /**
     * Constructor por defecto requerido por JAX-B.
     */
    public Player() {
    }

    /**
     * Constructor que inicializa un jugador con información básica.
     *
     * @param name       el nombre del jugador.
     * @param surname    el apellido del jugador.
     * @param sex        el sexo del jugador.
     * @param birth_year el año de nacimiento del jugador.
     */
    public Player(String name, String surname, String sex, Date birth_year) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birth_year = birth_year;
    }

    /**
     * Constructor que inicializa un jugador con información detallada.
     *
     * @param name            el nombre del jugador.
     * @param surname         el apellido del jugador.
     * @param sex             el sexo del jugador.
     * @param birth_year      el año de nacimiento del jugador.
     * @param legal_id        el identificador legal del jugador.
     * @param iban            el IBAN del jugador.
     * @param direccion       la dirección del jugador.
     * @param codigo_postal   el código postal del jugador.
     * @param localidad       la localidad del jugador.
     * @param provincia       la provincia del jugador.
     * @param pais            el país del jugador.
     * @param image           la imagen del jugador.
     * @param medical_rev_fin la fecha de finalización de la revisión médica del jugador.
     */

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

    /**
     * Obtiene el código postal del jugador.
     *
     * @return el código postal del jugador.
     */

    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Obtiene la titularidad del jugador.
     *
     * @return la titularidad del jugador.
     */

    public String getTitularidad() {
        return titularidad;
    }

    /**
     * Establece la titularidad del jugador.
     *
     * @param titularidad la nueva titularidad del jugador.
     * @throws RuntimeException si la titularidad es nula o vacía.
     */
    public void setTitularidad(String titularidad) {
        if (titularidad == null || titularidad.isBlank()) {
            throw new RuntimeException("Titularidad del jugador no puede ser nulo o vacío");
        }
        this.titularidad = titularidad;
    }

    /**
     * Establece el código postal del jugador.
     *
     * @param codigo_postal el nuevo código postal del jugador.
     * @throws RuntimeException si el código postal es nulo o vacío.
     */

    public void setCodigo_postal(String codigo_postal) {

        if (codigo_postal == null || codigo_postal.isBlank()) {
            throw new RuntimeException("Codigo Postal no puede ser vacio o nulo");
        }

        this.codigo_postal = codigo_postal;

    }

    /**
     * Obtiene la localidad del jugador.
     *
     * @return la localidad del jugador.
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Establece la localidad del jugador.
     *
     * @param localidad la nueva localidad del jugador.
     * @throws RuntimeException si la localidad es nula o vacía.
     */
    public void setLocalidad(String localidad) {
        if (localidad == null || localidad.isBlank()) {
            throw new RuntimeException("Localidad no puede ser vacio o null");
        }
        this.localidad = localidad;

    }

    /**
     * Obtiene la provincia del jugador.
     *
     * @return la provincia del jugador.
     */

    public String getProvincia() {
        return provincia;
    }

    /**
     * Establece la provincia del jugador.
     *
     * @param provincia la nueva provincia del jugador.
     * @throws RuntimeException si la provincia es nula o vacía.
     */

    public void setProvincia(String provincia) {
        if (provincia == null || provincia.isBlank()) {
            throw new RuntimeException("Provincia no puede ser vacio o nulo");
        }

        this.provincia = provincia;

    }

    /**
     * Obtiene el país del jugador.
     *
     * @return el país del jugador.
     */

    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del jugador.
     *
     * @param pais el nuevo país del jugador.
     * @throws RuntimeException si el país es nulo o vacío.
     */
    public void setPais(String pais) {
        if (pais == null || pais.isBlank()) {
            throw new RuntimeException("Pais no puede ser vacio o null");
        }
        this.pais = pais;
    }

    /**
     * Obtiene el identificador del jugador.
     *
     * @return el identificador del jugador.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del jugador.
     *
     * @param id el nuevo identificador del jugador.
     * @throws RuntimeException si el identificador es menor o igual a 0.
     */

    public void setId(int id) {
        if (id <= 0) {
            throw new RuntimeException("Id no puedo 0 o menos de 0");
        }

        this.id = id;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador.
     */

    public String getName() {
        return name;
    }

    /**
     * Obtiene el apellido del jugador.
     *
     * @return el apellido del jugador.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Obtiene el sexo del jugador.
     *
     * @return el sexo del jugador.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Obtiene el año de nacimiento del jugador.
     *
     * @return el año de nacimiento del jugador.
     */
    public Date getBirth_year() {
        return birth_year;
    }

    /**
     * Obtiene el identificador legal del jugador.
     *
     * @return el identificador legal del jugador.
     */
    public String getLegal_id() {
        return legal_id;
    }

    /**
     * Obtiene el IBAN del jugador.
     *
     * @return el IBAN del jugador.
     */
    public String getIban() {
        return iban;
    }

    /**
     * Obtiene la dirección del jugador.
     *
     * @return la dirección del jugador.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene la imagen del jugador.
     *
     * @return la imagen del jugador como Blob.
     */
    public Blob getImage() {
        return image;
    }

    /**
     * Obtiene la fecha de finalización de la revisión médica del jugador.
     *
     * @return la fecha de finalización de la revisión médica del jugador.
     */
    public Integer getMedical_rev_fin() {
        return medical_rev_fin;
    }

    /**
     * Establece el nombre del jugador.
     *
     * @param name el nuevo nombre del jugador.
     * @throws RuntimeException si el nombre es nulo o vacío.
     */
    public void setName(String name) {
        if (!name.isEmpty() || name != null) {
            this.name = name;
        } else {
            throw new RuntimeException("Nombre no puede ser null o vació");
        }
    }

    /**
     * Establece el apellido del jugador.
     *
     * @param surname el nuevo apellido del jugador.
     * @throws RuntimeException si el apellido es nulo o vacío.
     */

    public void setSurname(String surname) {
        if (!surname.isEmpty() || surname != null) {
            this.surname = surname;
        } else {
            throw new RuntimeException("Appellido no puede ser null o vació");
        }
    }

    /**
     * Establece el sexo del jugador.
     *
     * @param sex el nuevo sexo del jugador.
     * @throws RuntimeException si el sexo no es igual a H o D.
     */

    public void setSex(String sex) {

        if (sex.toUpperCase().equals("H") || sex.toUpperCase().equals("D")) {
            this.sex = sex;
        } else {
            throw new RuntimeException("El sexo tiene que ser D o H");
        }
    }

    /**
     * Establece el año de nacimiento del jugador.
     *
     * @param birth_year el nuevo año de nacimiento del jugador.
     * @throws RuntimeException si el año de nacimiento es nulo.
     */

    public void setBirth_year(Date birth_year) {
        if (birth_year == null) {
            throw new RuntimeException("Año Nacieminto no puede ser null");
        }

        this.birth_year = birth_year;
    }

    /**
     * Establece el identificador legal del jugador.
     *
     * @param legal_id el nuevo identificador legal del jugador.
     * @throws RuntimeException si el NIF no es igual a 8 o vacío.
     */

    public void setLegal_id(String legal_id) {
        if (!legal_id.isEmpty() && legal_id.length() == 8) {
            this.legal_id = legal_id;
        } else {
            throw new RuntimeException("El Nif no pueder ser vació y tiene que ser 8 caracteres");
        }
    }

    /**
     * Establece el IBAN del jugador.
     *
     * @param iban el nuevo IBAN del jugador.
     * @throws RuntimeException si el IBAN no es igual al 24 o vacío.
     */

    public void setIban(String iban) {
        if (!iban.isEmpty() || iban.length() == 24) {
            this.iban = iban;
        } else {
            throw new RuntimeException("IBAN tiene que ser 24 caracteres");
        }
    }

    /**
     * Establece la dirección del jugador.
     *
     * @param direccion la nueva dirección del jugador.
     * @throws RuntimeException si la dirección es nula o vacía.
     */

    public void setDireccion(String direccion) {
        if (!direccion.isEmpty() || direccion != null) {
            this.direccion = direccion;
        } else {
            throw new RuntimeException("Dirección no puede ser null");
        }
    }

    /**
     * Establece la imagen del jugador.
     *
     * @param image la nueva imagen del jugador.
     * @throws RuntimeException si la imagen es nula.
     */

    public void setImage(Blob image) {
        if (image == null) {
            throw new RuntimeException("Imagen no puede ser null");
        }

        this.image = image;
    }

    /**
     * Establece la fecha de finalización de la revisión médica del jugador.
     *
     * @param medical_rev_fin la nueva fecha de finalización de la revisión médica del jugador.
     * @throws RuntimeException si la fecha de finalización de la revisión médica es nula.
     */

    public void setMedical_rev_fin(Integer medical_rev_fin) {

        if (medical_rev_fin == null) {
            throw new RuntimeException("Revisión medical no puede ser null");
        }

        this.medical_rev_fin = medical_rev_fin;
    }

    /**
     * Muestra los detalles del jugador.
     */
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

    /**
     * Obtiene la categoría del jugador.
     *
     * @return la categoría del jugador.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Establece la categoría del jugador.
     *
     * @param category la nueva categoría del jugador.
     * @throws RuntimeException si la categoría es nula o vacía.
     */
    public void setCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new RuntimeException("Categoría del jugador no puede ser nulo o vacío");
        }
        this.category = category;
    }
}
