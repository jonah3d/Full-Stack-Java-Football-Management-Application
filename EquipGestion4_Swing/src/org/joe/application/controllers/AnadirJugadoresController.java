/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.views.tabs.AnadirJugadores;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class AnadirJugadoresController implements ActionListener {

    private AnadirJugadores AnadirJugadores;
    private final String emptycal = "--/--/----";
    private final ImageIcon defaultIcon;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AnadirJugadoresController() {

        this.AnadirJugadores = new AnadirJugadores();

        this.defaultIcon = new ImageIcon(getClass().getClassLoader().getResource("org/joe/application/resources/img/User.png"));
        AnadirJugadores.getProfileJLabel().setIcon(defaultIcon);
        if (defaultIcon.getIconWidth() == -1) {
            System.out.println("Image not found!");
        }

        AnadirJugadores.addPlayer_OnClick(this);
        profileimage();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == AnadirJugadores.getAddplayer()) {
            boolean isvalid = settingUpCampVal();

            if (isvalid) {
                addPlayer();
                JOptionPane.showMessageDialog(AnadirJugadores, "Validated Successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public AnadirJugadores getAnadirJugadores() {
        return AnadirJugadores;
    }

    private void errorDialogue(String message) {

        JOptionPane.showMessageDialog(AnadirJugadores, message, "Error De Campo", 0);

    }

    private boolean settingUpCampVal() {

        boolean isValid = true;

        //Setting Up NIF VALIDATION
        if (AnadirJugadores.getNif_tf().getText().isBlank()) {
            AnadirJugadores.getNiferror().setVisible(true);
            AnadirJugadores.getNiferror().setText("NIF no puede ser vacio");
            isValid = false;
        } else if (AnadirJugadores.getNif_tf().getText().length() != 8
                && !Character.isLetter(AnadirJugadores.getNif_tf().getText().trim().
                        charAt(AnadirJugadores.getNif_tf().getText().trim().length() - 1))) {
            AnadirJugadores.getNiferror().setVisible(true);
            AnadirJugadores.getNiferror().setText("NIF debería ser 8 characters");
            isValid = false;
        } else if (AnadirJugadores.getNif_tf().getText().length() == 8
                && !Character.isLetter(AnadirJugadores.getNif_tf().getText().trim().
                        charAt(AnadirJugadores.getNif_tf().getText().trim().length() - 1))) {
            AnadirJugadores.getNiferror().setVisible(true);
            AnadirJugadores.getNiferror().setText("NIF debería acabar con una letra");
            isValid = false;
        } else {
            AnadirJugadores.getNiferror().setVisible(false);
        }
        //Setting Up SEXO VALIDATION
        if (AnadirJugadores.getSexebutons_btn().getSelection() == null) {
            AnadirJugadores.getSexeerror().setVisible(true);
            AnadirJugadores.getSexeerror().setText("Elige un sexe");
            isValid = false;
        } else {
            AnadirJugadores.getSexeerror().setVisible(false);
        }

        //SETTING UP NOMBRE VALIDATION
        if (AnadirJugadores.getNombre_tf().getText().isBlank()) {
            AnadirJugadores.getNombreerror().setVisible(true);
            AnadirJugadores.getNombreerror().setText("Nombre no puede ser vacio");
            isValid = false;
        } else if (AnadirJugadores.getNombre_tf().getText().trim().length() < 2) {
            AnadirJugadores.getNombreerror().setVisible(true);
            AnadirJugadores.getNombreerror().setText("Nombre tiene que ser mas de 2 characters");
            isValid = false;
        } else {
            AnadirJugadores.getNombreerror().setVisible(false);
        }

        //SETTING UP APELLIDO VALIDATION
        if (AnadirJugadores.getAppellido_tf().getText().isBlank()) {
            AnadirJugadores.getAppellidoerror().setVisible(true);
            AnadirJugadores.getAppellidoerror().setText("Apellido no puede ser vacio");
            isValid = false;
        } else if (AnadirJugadores.getAppellido_tf().getText().trim().length() < 2) {
            AnadirJugadores.getAppellidoerror().setVisible(true);
            AnadirJugadores.getAppellidoerror().setText("Apellido tiene que ser mas de 2 characters");
            isValid = false;
        } else {
            AnadirJugadores.getAppellidoerror().setVisible(false);
        }

        //SETTING UP DIRECCION
        if (AnadirJugadores.getAdd_tf().getText().isBlank()) {
            AnadirJugadores.getDirrerror().setVisible(true);
            AnadirJugadores.getDirrerror().setText("Dirección no puede ser vacío");
            isValid = false;
        } else if (AnadirJugadores.getAdd_tf().getText().trim().length() < 2) {
            AnadirJugadores.getDirrerror().setVisible(true);
            AnadirJugadores.getDirrerror().setText("Entrar un direccion valida");
            isValid = false;
        } else {
            AnadirJugadores.getDirrerror().setVisible(false);
        }

        //Setting Up Ciudad
        if (AnadirJugadores.getCiu_tf().getText().isBlank()) {
            AnadirJugadores.getCiuerror().setVisible(true);
            AnadirJugadores.getCiuerror().setText("Ciudad no puede ser vacío");
            isValid = false;
        } else if (AnadirJugadores.getCiu_tf().getText().trim().length() < 2) {
            AnadirJugadores.getCiuerror().setVisible(true);
            AnadirJugadores.getCiuerror().setText("Entrar una ciudad valida");
            isValid = false;
        } else {
            AnadirJugadores.getCiuerror().setVisible(false);
        }

        //Setting Up Pais
        if (AnadirJugadores.getPais_tf().getText().isBlank()) {
            AnadirJugadores.getPaiserror().setVisible(true);
            AnadirJugadores.getPaiserror().setText("Ciudad no puede ser vacío");
            isValid = false;
        } else if (AnadirJugadores.getPais_tf().getText().trim().length() < 2) {
            AnadirJugadores.getPaiserror().setVisible(true);
            AnadirJugadores.getPaiserror().setText("Entrar una ciudad valida");
            isValid = false;
        } else {
            AnadirJugadores.getPaiserror().setVisible(false);
        }

        //Setting Up Codigo postal
        try {
            if (AnadirJugadores.getCodipos_tf().getText().isBlank()) {
                AnadirJugadores.getCodiposerror().setVisible(true);
                AnadirJugadores.getCodiposerror().setText("Introduce un codigo postal");
                isValid = false;
            } else {
                String codigoPostal = AnadirJugadores.getCodipos_tf().getText().trim();
                if (codigoPostal.length() < 4) {
                    AnadirJugadores.getCodiposerror().setVisible(true);
                    AnadirJugadores.getCodiposerror().setText("Introduce mas de 5 digitos");
                    isValid = false;
                } else {
                    Integer.parseInt(codigoPostal);
                    AnadirJugadores.getCodiposerror().setVisible(false);
                }
            }
        } catch (NumberFormatException e) {
            AnadirJugadores.getCodiposerror().setVisible(true);
            AnadirJugadores.getCodiposerror().setText("El código postal tiene que ser un número");
        }

        //Setting Up Revision Medica
        if (AnadirJugadores.getRevmedbtngrp().getSelection() == null) {
            AnadirJugadores.getRevisionmederror().setVisible(true);
            AnadirJugadores.getRevisionmederror().setText("Confirma la revision medica");
            isValid = false;
        } else {
            AnadirJugadores.getRevisionmederror().setVisible(false);
        }

        //Setting Up Iban
        if (AnadirJugadores.getIban_tf().getText().isBlank()) {
            AnadirJugadores.getIbanerror().setVisible(true);
            getAnadirJugadores().getIbanerror().setText("IBAN no puede ser vacio");
            isValid = false;
        } else if ((AnadirJugadores.getIban_tf().getText().replace(" ", "")).trim().length() != 24) {
            AnadirJugadores.getIbanerror().setVisible(true);
            getAnadirJugadores().getIbanerror().setText("IBAN tiene que ser 24 digitos");
            isValid = false;
        } else {
            AnadirJugadores.getIbanerror().setVisible(false);
        }

        //Setting Up Calender
        if (AnadirJugadores.getDateeditor().getText().equals(emptycal)) {
            AnadirJugadores.getDateerror().setVisible(true);
            AnadirJugadores.getDateerror().setText("Data Naixement no pueder ser vacio");
            isValid = false;
        } else {
            AnadirJugadores.getDateerror().setVisible(false);
        }

        if (AnadirJugadores.getProfileJLabel().getIcon() == defaultIcon) {
            AnadirJugadores.getProfilerror().setVisible(true);
            AnadirJugadores.getProfilerror().setText("Tiene que selectionar un imagen");
            isValid = false;
        } else {
            AnadirJugadores.getProfilerror().setVisible(false);
        }
        return isValid;
    }

    public void profileimage() {
        AnadirJugadores.getProfileJLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Profile Image");
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg") || filePath.endsWith(".png") || filePath.endsWith(".gif")) {

                        ImageIcon profileIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(280, 280, java.awt.Image.SCALE_SMOOTH));
                        AnadirJugadores.getProfileJLabel().setIcon(profileIcon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a valid image file.", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public void addPlayer() {

        String nif = AnadirJugadores.getNif_tf().getText().trim();
        String nombre = AnadirJugadores.getNombre_tf().getText().trim();
        String apellido = AnadirJugadores.getAppellido_tf().getText().trim();
        String sexe = null;
        if (AnadirJugadores.getHombre_rb().isSelected()) {
            sexe = "H";
        } else if (AnadirJugadores.getMujer_rb().isSelected()) {
            sexe = "D";
        }
        String birthday = AnadirJugadores.getDateeditor().getText().trim();
        try {
            Date datanaix = sdf.parse(birthday);
        } catch (ParseException ex) {
            System.out.println("Error Pasrsing Date into player");
        }
        String iban = AnadirJugadores.getIban_tf().getText().trim();
        String direccion = AnadirJugadores.getAdd_tf().getText().trim();
        String codipostal = AnadirJugadores.getCodipos_tf().getText().trim();
        String localidad = AnadirJugadores.getCiu_tf().getText().trim();
        // String provincia = AnadirJugadores.getpro.getText().trim();
        String pais = AnadirJugadores.getPais_tf().getText().trim();
        Integer medical = null;
        if (AnadirJugadores.getSiRadioButton().isSelected()) {
            medical = 1;
        } else if (AnadirJugadores.getNoJRadioButton().isSelected()) {
            medical = 0;
        }

        System.out.println(nif);
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(sexe);
        System.out.println(birthday);
        System.out.println(iban);
        System.out.println(direccion);
        System.out.println(codipostal);
        System.out.println(localidad);
        System.out.println(pais);
        System.out.println(medical);

    }
}
