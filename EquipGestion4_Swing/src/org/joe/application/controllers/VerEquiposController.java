/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.tabs.VerEquipos;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Season;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class VerEquiposController implements ActionListener {

    private VerEquipos verEquipos;
    private EquipDataInterface edi;

    public VerEquiposController(EquipDataInterface edi) {
        this.edi = edi;
        verEquipos = new VerEquipos();

        verEquipos.getCatComboBox().addItem("");
        for (Category item : edi.getCategorys()) {
            verEquipos.getCatComboBox().addItem(item.getName());
        }

        for (Season sea : edi.getSeasons()) {
            verEquipos.getTempComboBox().addItem(sea.getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public VerEquipos getVerEquipos() {
        return verEquipos;
    }

}
