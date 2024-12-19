/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.joe.application.views.tabs.AnadirEquipo;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class AnadirEquipoController implements ActionListener {

    private EquipDataInterface edi;
    private AnadirEquipo anadirEquipos;
    private final String emptycal = "--/--/----";
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AnadirEquipoController(EquipDataInterface edi) {
        this.edi = edi;
        this.anadirEquipos = new AnadirEquipo();

        anadirEquipos.addEquipo_OnClick(this);

        for (Category item : edi.getCategorys()) {
            anadirEquipos.getCategoriaBox().addItem(item.getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == anadirEquipos.getAddButton()) {
            boolean ans = validatefields();
            if (ans) {
                try {
                    addTeam();
                    JOptionPane.showMessageDialog(anadirEquipos, "Player Added Successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    clearField();
                } catch (EquipDataInterfaceException ex) {
                    error(ex.getMessage(), ex.getCause());
                }

            }
        }
    }

    public AnadirEquipo getAnadirEquipos() {
        return anadirEquipos;
    }

    private boolean validatefields() {
        boolean val = true;

        if (anadirEquipos.getName_tf().getText().isBlank()) {
            anadirEquipos.getNameerr().setVisible(true);
            anadirEquipos.getNameerr().setText("Intoduce nom");
            val = false;
        } else {
            anadirEquipos.getNameerr().setVisible(false);
        }

        if (anadirEquipos.getSeasonsBox().getText().trim().equals(emptycal)) {
            anadirEquipos.getSeaseer().setVisible(true);
            anadirEquipos.getSeaseer().setText("Intoduce temporada");
            val = false;
        } else {
            anadirEquipos.getSeaseer().setVisible(false);
        }

        if (anadirEquipos.getTipogrp().getSelection() == null) {
            anadirEquipos.getTeameeer().setVisible(true);
            anadirEquipos.getTeameeer().setText("Seleciona un tipo");
            val = false;
        } else {
            anadirEquipos.getTeameeer().setVisible(false);
        }

        return val;
    }

    private void errorDialogue(String message) {

        JOptionPane.showMessageDialog(anadirEquipos, message, "Error De Campo", JOptionPane.INFORMATION_MESSAGE);

    }

    private void error(String message, Throwable cause) {
        String fullMessage = message;
        if (cause != null) {
            fullMessage += "\nCausa: " + cause.getMessage();
        }

        JOptionPane.showMessageDialog(
                anadirEquipos,
                fullMessage,
                "Error De Campo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void addTeam() {

        String teamname = anadirEquipos.getName_tf().getText().trim();
        String teamtype = null;
        if (anadirEquipos.getHmRb().isSelected()) {
            teamtype = "H";
        } else if (anadirEquipos.getMjRb().isSelected()) {
            teamtype = "D";
        } else if (anadirEquipos.getMixRb().isSelected()) {
            teamtype = "M";
        }
        String catname = anadirEquipos.getCategoriaBox().getSelectedItem().toString();
        String datainicial = anadirEquipos.getSeasonsBox().getText();
        Date inicial = null;

        try {
            inicial = sdf.parse(datainicial);
        } catch (ParseException ex) {
            errorDialogue(ex.getMessage());
        }

        edi.addNewTeam(teamname, teamtype, catname, inicial);

    }

    private void clearField() {
        anadirEquipos.getName_tf().setText("");
        anadirEquipos.getSeasonsBox().setText(emptycal);

        anadirEquipos.getHmRb().setSelected(false);
        anadirEquipos.getMjRb().setSelected(false);
        anadirEquipos.getMixRb().setSelected(false);

    }
}
