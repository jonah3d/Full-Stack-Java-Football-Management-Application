/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package org.joe.gestion.model.persistence;

/**
 *
 * @author jonah
 */
public class EquipDataInterfaceException extends RuntimeException{

    /**
     * Creates a new instance of <code>EquipDataInterfaceException</code>
     * without detail message.
     */
    public EquipDataInterfaceException() {
    }

    /**
     * Constructs an instance of <code>EquipDataInterfaceException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public EquipDataInterfaceException(String msg) {
        super(msg);
    }
    
     public EquipDataInterfaceException(String msg,Throwable cause) {
        super(msg,cause);
    }
     
  
    
}
