/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.joe.application.constants.ManagemetConstants;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author Usuari
 */
public class EditarJugadores extends JPanel {

    JLabel nif_lbl;
    JTextField nif_tf;
    JLabel nombre_lbl;
    JTextField nombre_tf;
    JLabel addr_lbl;
    JTextField add_tf;
    JLabel ciu_lbl;
    JTextField ciu_tf;
    JLabel codipos_lbl;
    JTextField codipos_tf;
    JLabel pais_lbl;
    JTextField pais_tf;
    JLabel appellido_lbl;
    JTextField appellido_tf;
    JLabel sexe_lbl;
    JRadioButton hombre_rb;
    JRadioButton mujer_rb;
    JLabel Iban_lbl;
    JTextField iban_tf;
    JLabel categ_lbl;
    JLabel profileJLabel;
    ButtonGroup sexebutons_btn;
    JLabel revisionmedicaJLabel;
    JRadioButton siRadioButton;
    JRadioButton noJRadioButton;
    ButtonGroup revmedbtngrp;

    JLabel datnnaix_lbl;
    DatePicker datePicker;
    JFormattedTextField dateeditor;

    JButton addplayer;

    public EditarJugadores() {
        setLayout(null);

        init_Components();

        setupcomponents();
        addComponents();
    }

    private void init_Components() {
        nif_lbl = new JLabel("Nif");
        nif_tf = new JTextField();
        nombre_lbl = new JLabel("Nombre");
        nombre_tf = new JTextField();
        addr_lbl = new JLabel("Dirección");
        add_tf = new JTextField();
        ciu_lbl = new JLabel("Ciudad");
        ciu_tf = new JTextField();
        codipos_lbl = new JLabel("Codigo Postal");
        codipos_tf = new JTextField();
        pais_lbl = new JLabel("Pais");
        pais_tf = new JTextField();
        appellido_lbl = new JLabel("Apellido");
        appellido_tf = new JTextField();
        sexe_lbl = new JLabel("Sexe");
        hombre_rb = new JRadioButton("Hombre");
        mujer_rb = new JRadioButton("Mujer");
        Iban_lbl = new JLabel("Iban");
        iban_tf = new JTextField();
        categ_lbl = new JLabel("Categoria");
        sexebutons_btn = new ButtonGroup();
        revisionmedicaJLabel = new JLabel("Revisión Medica");
        siRadioButton = new JRadioButton("Sí");
        noJRadioButton = new JRadioButton("No");
        revmedbtngrp = new ButtonGroup();

        datnnaix_lbl = new JLabel("Data De Naixement");
        datePicker = new DatePicker();
        dateeditor = new JFormattedTextField();
        addplayer = new JButton("Aplicar");
        addplayer.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_editjug.svg", 0.7f));
        profileJLabel = new JLabel();
        ImageIcon profileIcon = new ImageIcon(getClass().getClassLoader().getResource("org/joe/application/resources/img/User.png"));
        if (profileIcon.getIconWidth() == -1) {
            System.out.println("Image not found!");
        }
        profileJLabel.setIcon(profileIcon);

    }

    private void addComponents() {

        this.add(nif_lbl);
        this.add(nif_tf);
        this.add(nombre_lbl);
        this.add(nombre_tf);
        this.add(addr_lbl);
        this.add(add_tf);
        this.add(ciu_lbl);
        this.add(ciu_tf);
        this.add(codipos_lbl);
        this.add(codipos_tf);
        this.add(pais_lbl);
        this.add(pais_tf);
        this.add(appellido_lbl);
        this.add(appellido_tf);
        this.add(sexe_lbl);
        this.add(hombre_rb);
        this.add(mujer_rb);
        this.add(Iban_lbl);
        this.add(iban_tf);
        this.add(categ_lbl);
        sexebutons_btn.add(mujer_rb);
        sexebutons_btn.add(hombre_rb);
        this.add(datnnaix_lbl);
        this.add(sexe_lbl);
        this.add(dateeditor);
        this.add(profileJLabel);
        this.add(addplayer);
        this.add(revisionmedicaJLabel);
        this.add(siRadioButton);
        this.add(noJRadioButton);
        revmedbtngrp.add(siRadioButton);
        revmedbtngrp.add(noJRadioButton);
    }

    private void setupcomponents() {

        nif_lbl.setBounds(25, 20, 24, 17);
        nif_tf.setBounds(25, 50, 230, 25);

        nombre_lbl.setBounds(25, 125, 57, 17);
        nombre_tf.setBounds(25, 155, 230, 25);

        addr_lbl.setBounds(25, 230, 73, 17);
        add_tf.setBounds(25, 260, 230, 25);

        ciu_lbl.setBounds(25, 335, 73, 17);
        ciu_tf.setBounds(25, 365, 230, 25);

        codipos_lbl.setBounds(305, 335, 101, 17);
        codipos_tf.setBounds(305, 365, 230, 25);

        pais_lbl.setBounds(25, 440, 73, 17);
        pais_tf.setBounds(25, 470, 230, 25);

        appellido_lbl.setBounds(305, 125, 59, 17);
        appellido_tf.setBounds(305, 155, 230, 25);

        Iban_lbl.setBounds(305, 230, 24, 17);
        iban_tf.setBounds(305, 260, 230, 25);

        datnnaix_lbl.setBounds(305, 440, 130, 17);
        dateeditor.setBounds(305, 470, 230, 25);
        datePicker.setEditor(dateeditor);

        revisionmedicaJLabel.setBounds(630, 440, 130, 17);
        siRadioButton.setBounds(600, 470, 100, 20);
        noJRadioButton.setBounds(700, 470, 100, 20);

        sexe_lbl.setBounds(305, 20, 50, 17);
        hombre_rb.setBounds(305, 50, 100, 20);
        mujer_rb.setBounds(450, 50, 100, 20);

        profileJLabel.setBounds(700, 50, 280, 280);

        addplayer.setBounds(350, 530, 160, 40);
    }
}
