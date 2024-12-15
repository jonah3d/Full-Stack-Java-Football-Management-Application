/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.tabs.EditarJugadores;

/**
 *
 * @author jonah
 */
public class EditarJugadoresController implements ActionListener {

    private EditarJugadores EditarJugadores;

    public EditarJugadoresController() {

        this.EditarJugadores = new EditarJugadores();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public EditarJugadores getEditarJugadores() {
        return EditarJugadores;
    }

}
