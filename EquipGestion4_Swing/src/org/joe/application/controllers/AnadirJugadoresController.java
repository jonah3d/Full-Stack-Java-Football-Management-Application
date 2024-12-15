/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.tabs.AnadirJugadores;

/**
 *
 * @author jonah
 */
public class AnadirJugadoresController implements ActionListener {

    private AnadirJugadores AnadirJugadores;

    public AnadirJugadoresController() {

        this.AnadirJugadores = new AnadirJugadores();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public AnadirJugadores getAnadirJugadores() {
        return AnadirJugadores;
    }

}
