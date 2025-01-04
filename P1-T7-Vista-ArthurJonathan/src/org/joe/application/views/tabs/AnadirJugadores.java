/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.icons.FlatFileViewComputerIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.joe.application.constants.ManagemetConstants;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class AnadirJugadores extends JPanel {

    JLabel nif_lbl;
    JLabel niferror;
    JTextField nif_tf;
    JLabel nombre_lbl;
    JTextField nombre_tf;
    JLabel nombreerror;
    JLabel addr_lbl;
    JTextField add_tf;
    JLabel dirrerror;
    JLabel ciu_lbl;
    JTextField ciu_tf;
    JLabel ciuerror;
    JLabel codipos_lbl;
    JTextField codipos_tf;
    JLabel codiposerror;
    JLabel pais_lbl;
    JTextField pais_tf;
    JLabel paiserror;
    JLabel appellido_lbl;
    JTextField appellido_tf;
    JLabel appellidoerror;
    JLabel sexe_lbl;
    JRadioButton hombre_rb;
    JRadioButton mujer_rb;
    JLabel sexeerror;
    JLabel Iban_lbl;
    JTextField iban_tf;
    JLabel ibanerror;
    JLabel categ_lbl;
    JLabel profileJLabel;
    JLabel profilerror;
    JLabel revisionmedicaJLabel;
    JLabel revisionmederror;
    JRadioButton siRadioButton;
    JRadioButton noJRadioButton;
    ButtonGroup revmedbtngrp;
    JLabel provincialabel;
    JTextField provincia_tf;
    JLabel provinciaerror;

    JLabel datnnaix_lbl;
    DatePicker datePicker;
    JFormattedTextField dateeditor;
    JLabel dateerror;
    ButtonGroup sexebutons_btn;

    JButton addplayer;

    public AnadirJugadores() {
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
        pais_lbl = new JLabel("País");
        pais_tf = new JTextField();
        appellido_lbl = new JLabel("Apellido");
        appellido_tf = new JTextField();
        sexe_lbl = new JLabel("Sexo");
        hombre_rb = new JRadioButton("Hombre");
        mujer_rb = new JRadioButton("Mujer");
        Iban_lbl = new JLabel("Iban");
        iban_tf = new JTextField();
        categ_lbl = new JLabel("Categoría");
        sexebutons_btn = new ButtonGroup();
        revisionmedicaJLabel = new JLabel("Revisión Medica");
        siRadioButton = new JRadioButton("Sí");
        noJRadioButton = new JRadioButton("No");
        revmedbtngrp = new ButtonGroup();

        //Error Messages
        niferror = new JLabel("Error");
        nombreerror = new JLabel("Error");
        dirrerror = new JLabel("Error");
        ciuerror = new JLabel("Error");
        codiposerror = new JLabel("Error");
        paiserror = new JLabel("Error");
        appellidoerror = new JLabel("Error");
        sexeerror = new JLabel("Error");
        ibanerror = new JLabel("Error");
        profilerror = new JLabel("Error");
        revisionmederror = new JLabel("Error");
        dateerror = new JLabel("Error");

        datnnaix_lbl = new JLabel("Año De Nacimiento");
        datePicker = new DatePicker();
        dateeditor = new JFormattedTextField();
        addplayer = new JButton("Anadir");
        addplayer.setIcon(new FlatSVGIcon(ManagemetConstants.sideicon_path + "icon_addjug.svg", 0.7f));
        profileJLabel = new JLabel();

        provincialabel = new JLabel("Provincia");
        provincia_tf = new JTextField();
        provinciaerror = new JLabel("Error");
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
        sexebutons_btn.add(mujer_rb);
        sexebutons_btn.add(hombre_rb);
        this.add(Iban_lbl);
        this.add(iban_tf);
        this.add(categ_lbl);

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

        this.add(niferror);
        this.add(nombreerror);
        this.add(dirrerror);
        this.add(ciuerror);
        this.add(codiposerror);
        this.add(paiserror);
        this.add(appellidoerror);
        this.add(sexeerror);
        this.add(ibanerror);
        this.add(profilerror);
        this.add(revisionmederror);
        this.add(dateerror);

        this.add(provincia_tf);
        this.add(provinciaerror);
        this.add(provincialabel);

    }

    private void setupcomponents() {

        nif_lbl.setBounds(25, 20, 24, 17);
        nif_tf.setBounds(25, 50, 230, 25);
        nif_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        nombre_lbl.setBounds(25, 125, 57, 17);
        nombre_tf.setBounds(25, 155, 230, 25);
        nombre_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        addr_lbl.setBounds(25, 230, 73, 17);
        add_tf.setBounds(25, 260, 230, 25);
        add_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        ciu_lbl.setBounds(25, 335, 73, 17);
        ciu_tf.setBounds(25, 365, 230, 25);
        ciu_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        codipos_lbl.setBounds(305, 335, 101, 17);
        codipos_tf.setBounds(305, 365, 230, 25);
        codipos_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        provincialabel.setBounds(630, 335, 101, 17);
        provincia_tf.setBounds(630, 365, 230, 25);
        provincia_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        provinciaerror.setBounds(630, 395, 200, 17);

        pais_lbl.setBounds(25, 440, 73, 17);
        pais_tf.setBounds(25, 470, 230, 25);
        pais_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        appellido_lbl.setBounds(305, 125, 59, 17);
        appellido_tf.setBounds(305, 155, 230, 25);
        appellido_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        Iban_lbl.setBounds(305, 230, 24, 17);
        iban_tf.setBounds(305, 260, 230, 25);
        iban_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        datnnaix_lbl.setBounds(305, 440, 130, 17);
        dateeditor.setBounds(305, 470, 230, 25);
        datePicker.setEditor(dateeditor);
        dateeditor.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        revisionmedicaJLabel.setBounds(630, 440, 130, 17);
        siRadioButton.setBounds(600, 470, 100, 20);
        noJRadioButton.setBounds(700, 470, 100, 20);

        sexe_lbl.setBounds(305, 20, 50, 17);
        hombre_rb.setBounds(305, 50, 100, 20);
        mujer_rb.setBounds(450, 50, 100, 20);

        profileJLabel.setBounds(700, 50, 280, 280);

        addplayer.setBounds(350, 530, 160, 40);

        //ERROR MESSAGES
        niferror.setBounds(25, 80, 200, 17);
        nombreerror.setBounds(25, 185, 200, 17);
        dirrerror.setBounds(25, 290, 200, 17);
        ciuerror.setBounds(25, 395, 200, 17);
        codiposerror.setBounds(305, 395, 200, 17);
        paiserror.setBounds(25, 500, 200, 17);
        appellidoerror.setBounds(305, 185, 200, 17);
        sexeerror.setBounds(305, 80, 200, 17);
        ibanerror.setBounds(305, 290, 200, 17);
        profilerror.setBounds(750, 340, 200, 17);
        revisionmederror.setBounds(650, 500, 200, 17);
        dateerror.setBounds(305, 500, 200, 17);

        niferror.setForeground(Color.red);
        niferror.setVisible(false);
        nombreerror.setForeground(Color.red);
        nombreerror.setVisible(false);
        dirrerror.setForeground(Color.red);
        dirrerror.setVisible(false);
        ciuerror.setForeground(Color.red);
        ciuerror.setVisible(false);
        codiposerror.setForeground(Color.red);
        codiposerror.setVisible(false);
        paiserror.setForeground(Color.red);
        paiserror.setVisible(false);
        appellidoerror.setForeground(Color.red);
        appellidoerror.setVisible(false);
        sexeerror.setForeground(Color.red);
        sexeerror.setVisible(false);
        ibanerror.setForeground(Color.red);
        ibanerror.setVisible(false);
        profilerror.setForeground(Color.red);
        profilerror.setVisible(false);
        revisionmederror.setForeground(Color.red);
        revisionmederror.setVisible(false);
        dateerror.setForeground(Color.red);
        dateerror.setVisible(false);
        provinciaerror.setVisible(false);
        provinciaerror.setForeground(Color.red);

    }

    public JLabel getProvincialabel() {
        return provincialabel;
    }

    public JTextField getProvincia_tf() {
        return provincia_tf;
    }

    public JLabel getProvinciaerror() {
        return provinciaerror;
    }

    public JButton getAddplayer() {
        return addplayer;
    }

    public void addPlayer_OnClick(ActionListener listener) {
        this.addplayer.addActionListener(listener);
    }

    public JLabel getNif_lbl() {
        return nif_lbl;
    }

    public JLabel getNiferror() {
        return niferror;
    }

    public JTextField getNif_tf() {
        return nif_tf;
    }

    public JLabel getNombre_lbl() {
        return nombre_lbl;
    }

    public JTextField getNombre_tf() {
        return nombre_tf;
    }

    public JLabel getNombreerror() {
        return nombreerror;
    }

    public JLabel getAddr_lbl() {
        return addr_lbl;
    }

    public JTextField getAdd_tf() {
        return add_tf;
    }

    public JLabel getDirrerror() {
        return dirrerror;
    }

    public JLabel getCiu_lbl() {
        return ciu_lbl;
    }

    public JTextField getCiu_tf() {
        return ciu_tf;
    }

    public JLabel getCiuerror() {
        return ciuerror;
    }

    public JLabel getCodipos_lbl() {
        return codipos_lbl;
    }

    public JTextField getCodipos_tf() {
        return codipos_tf;
    }

    public JLabel getCodiposerror() {
        return codiposerror;
    }

    public JLabel getPais_lbl() {
        return pais_lbl;
    }

    public JTextField getPais_tf() {
        return pais_tf;
    }

    public JLabel getPaiserror() {
        return paiserror;
    }

    public JLabel getAppellido_lbl() {
        return appellido_lbl;
    }

    public JTextField getAppellido_tf() {
        return appellido_tf;
    }

    public JLabel getAppellidoerror() {
        return appellidoerror;
    }

    public JLabel getSexe_lbl() {
        return sexe_lbl;
    }

    public JRadioButton getHombre_rb() {
        return hombre_rb;
    }

    public JRadioButton getMujer_rb() {
        return mujer_rb;
    }

    public JLabel getSexeerror() {
        return sexeerror;
    }

    public JLabel getIban_lbl() {
        return Iban_lbl;
    }

    public JTextField getIban_tf() {
        return iban_tf;
    }

    public JLabel getIbanerror() {
        return ibanerror;
    }

    public JLabel getCateg_lbl() {
        return categ_lbl;
    }

    public JLabel getProfileJLabel() {
        return profileJLabel;
    }

    public JLabel getProfilerror() {
        return profilerror;
    }

    public JLabel getRevisionmedicaJLabel() {
        return revisionmedicaJLabel;
    }

    public JLabel getRevisionmederror() {
        return revisionmederror;
    }

    public JRadioButton getSiRadioButton() {
        return siRadioButton;
    }

    public JRadioButton getNoJRadioButton() {
        return noJRadioButton;
    }

    public ButtonGroup getRevmedbtngrp() {
        return revmedbtngrp;
    }

    public JLabel getDatnnaix_lbl() {
        return datnnaix_lbl;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JFormattedTextField getDateeditor() {
        return dateeditor;
    }

    public JLabel getDateerror() {
        return dateerror;
    }

    public ButtonGroup getSexebutons_btn() {
        return sexebutons_btn;
    }

}
