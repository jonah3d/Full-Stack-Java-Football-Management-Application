package org.joe.gestion.model.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La clase {@code DataAdapter} es un adaptador para convertir entre objetos
 * {@code Date} y cadenas de texto en formato {@code yyyy-MM-dd} durante el
 * proceso de serialización y deserialización con JAX-B.
 * <p>
 * Esta clase permite manejar fechas en formato ISO 8601 dentro de documentos
 * XML.
 * </p>
 *
 * <ul>
 * <li>El método {@code marshal} convierte un objeto {@code Date} a una cadena
 * de texto.</li>
 * <li>El método {@code unmarshal} convierte una cadena de texto en formato
 * {@code yyyy-MM-dd} a un objeto {@code Date}.</li>
 * </ul>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
public class DataAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Convierte una cadena de texto en formato {@code yyyy-MM-dd} a un objeto
     * {@code Date}.
     *
     * @param date la cadena de texto a convertir.
     * @return el objeto {@code Date} correspondiente.
     * @throws Exception si el formato de la cadena no es válido.
     */
    @Override
    public Date unmarshal(String date) throws Exception {

        return sdf.parse(date);
    }

    /**
     * Convierte un objeto {@code Date} a una cadena de texto en formato
     * {@code yyyy-MM-dd}.
     *
     * @param date el objeto {@code Date} a convertir.
     * @return la cadena de texto en formato {@code yyyy-MM-dd}.
     * @throws Exception si ocurre un error durante el formato.
     */
    @Override
    public String marshal(Date date) throws Exception {
        return sdf.format(date);
    }

}
