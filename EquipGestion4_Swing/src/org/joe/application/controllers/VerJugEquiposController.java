/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.tabs.VerJugEquipos;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class VerJugEquiposController implements ActionListener {

    EquipDataInterface edi;
    private VerJugEquipos verJuEquipos;

    public VerJugEquiposController(EquipDataInterface edi) {
        this.edi = edi;

        verJuEquipos = new VerJugEquipos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public VerJugEquipos getVerJuEquipos() {
        return verJuEquipos;
    }

}
