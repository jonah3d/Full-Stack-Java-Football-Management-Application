/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import raven.datetime.component.date.DatePicker;

/**
 *
 * @author jonah
 */
public class AnadirEquipo extends JPanel {

    JLabel name_lbl;
    JLabel nameerr;
    JLabel teamtype_lbl;
    JLabel teameeer;
    JLabel category_lbl;
    JLabel cateeer;
    JLabel season_lbl;
    JLabel seaseer;

    JTextField name_tf;
    JRadioButton hmRb;
    JRadioButton mjRb;
    JRadioButton mixRb;
    ButtonGroup tipogrp;

    JComboBox<String> categoriaBox;
    JFormattedTextField seasonsBox;
    DatePicker datePicker;

    JButton addButton;

    public AnadirEquipo() {
        setLayout(null);

        init_Components();
    }

    private void init_Components() {
        name_lbl = new JLabel("Nombre");
        teamtype_lbl = new JLabel("Tipo");
        category_lbl = new JLabel("Categoría");
        season_lbl = new JLabel("Fecha Inicial");
        datePicker = new DatePicker();

        hmRb = new JRadioButton("Hombres");
        mjRb = new JRadioButton("Mujer");
        mixRb = new JRadioButton("Mixto");
        tipogrp = new ButtonGroup();
        categoriaBox = new JComboBox<>();
        seasonsBox = new JFormattedTextField();
        addButton = new JButton("Añadir Equipo");

        nameerr = new JLabel("Error");
        cateeer = new JLabel("Error");
        teameeer = new JLabel("Error");
        seaseer = new JLabel("Error");

        name_tf = new JTextField();

        name_lbl.setBounds(205, 120, 101, 25);
        nameerr.setBounds(205, 185, 230, 17);
        nameerr.setForeground(Color.red);
        nameerr.setVisible(false);
        name_lbl.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        name_tf.setBounds(205, 150, 230, 30);
        name_tf.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        teamtype_lbl.setBounds(605, 120, 101, 25);
        teamtype_lbl.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        teameeer.setBounds(605, 185, 230, 17);
        teameeer.setVisible(false);
        teameeer.setForeground(Color.red);
        hmRb.setBounds(550, 150, 101, 25);
        mjRb.setBounds(650, 150, 101, 25);
        mixRb.setBounds(750, 150, 101, 25);
        tipogrp.add(hmRb);
        tipogrp.add(mjRb);
        tipogrp.add(mixRb);

        category_lbl.setBounds(205, 205, 101, 25);
        category_lbl.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        categoriaBox.setBounds(205, 250, 230, 30);
        categoriaBox.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        cateeer.setBounds(205, 285, 230, 17);
        cateeer.setForeground(Color.red);
        cateeer.setVisible(false);

        season_lbl.setBounds(605, 205, 101, 25);
        season_lbl.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        seasonsBox.setBounds(550, 250, 230, 30);
        seasonsBox.putClientProperty(FlatClientProperties.STYLE, "arc:10;");
        seaseer.setBounds(605, 285, 230, 17);
        seaseer.setForeground(Color.red);
        datePicker.setEditor(seasonsBox);
        seaseer.setVisible(false);

        addButton.setBounds(400, 320, 180, 50);
        addButton.putClientProperty(FlatClientProperties.STYLE, "arc:10;");

        this.add(name_lbl);
        this.add(teamtype_lbl);
        this.add(category_lbl);
        this.add(season_lbl);
        this.add(name_tf);
        this.add(hmRb);
        this.add(mjRb);
        this.add(mixRb);
        this.add(categoriaBox);
        this.add(seasonsBox);
        this.add(addButton);
        this.add(nameerr);
        this.add(cateeer);
        this.add(teameeer);
        this.add(seaseer);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JLabel getName_lbl() {
        return name_lbl;
    }

    public JLabel getTeamtype_lbl() {
        return teamtype_lbl;
    }

    public JLabel getCategory_lbl() {
        return category_lbl;
    }

    public JLabel getSeason_lbl() {
        return season_lbl;
    }

    public JTextField getName_tf() {
        return name_tf;
    }

    public JRadioButton getHmRb() {
        return hmRb;
    }

    public JRadioButton getMjRb() {
        return mjRb;
    }

    public JRadioButton getMixRb() {
        return mixRb;
    }

    public ButtonGroup getTipogrp() {
        return tipogrp;
    }

    public JComboBox<String> getCategoriaBox() {
        return categoriaBox;
    }

    public JFormattedTextField getSeasonsBox() {
        return seasonsBox;
    }

    public void addEquipo_OnClick(ActionListener listener) {
        this.addButton.addActionListener(listener);
    }

    public JLabel getNameerr() {
        return nameerr;
    }

    public JLabel getTeameeer() {
        return teameeer;
    }

    public JLabel getCateeer() {
        return cateeer;
    }

    public JLabel getSeaseer() {
        return seaseer;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

}
