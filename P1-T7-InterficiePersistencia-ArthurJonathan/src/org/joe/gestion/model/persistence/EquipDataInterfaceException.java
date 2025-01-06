/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package org.joe.gestion.model.persistence;

/**
 * La clase {@code EquipDataInterfaceException} es una excepción personalizada
 * que se utiliza para manejar errores específicos relacionados con la interfaz
 * de datos del equipo en el contexto de la gestión de persistencia de datos.
 * <p>
 * Esta clase extiende {@code RuntimeException}, lo que significa que es una
 * excepción no verificada (unchecked), lo que permite ser lanzada sin necesidad
 * de ser declarada en un bloque {@code try-catch}.
 * </p>
 *
 * @author jonah
 * @version 1.0
 * @since 2025-01-01
 */
public class EquipDataInterfaceException extends RuntimeException {

    /**
     * Crea una nueva instancia de {@code EquipDataInterfaceException} sin
     * mensaje de detalle.
     */
    public EquipDataInterfaceException() {
    }

    /**
     * Crea una nueva instancia de {@code EquipDataInterfaceException} con el
     * mensaje de detalle especificado.
     *
     * @param msg el mensaje de detalle que describe el error.
     */
    public EquipDataInterfaceException(String msg) {
        super(msg);
    }

    /**
     * Crea una nueva instancia de {@code EquipDataInterfaceException} con el
     * mensaje de detalle especificado y la causa subyacente del error.
     *
     * @param msg el mensaje de detalle que describe el error.
     * @param cause la causa subyacente de la excepción.
     */
    public EquipDataInterfaceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
