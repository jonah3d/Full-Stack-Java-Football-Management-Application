/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

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
public class AnadirJugadores extends JPanel{
    
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
    JComboBox<String> categoria_cb;
   JLabel datnnaix_lbl;
    DatePicker datePicker;
    JFormattedTextField dateeditor; 
    
    
    
    public AnadirJugadores(){
        setLayout(null);
        setSize(1589, 970);
        init_Components();
        
        setupcomponents();
        addComponents();
    }
    
    private void init_Components(){
        nif_lbl =  new JLabel("Nif");
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
        categoria_cb = new JComboBox<>();
        datnnaix_lbl = new JLabel("Data De Naixement");
        datePicker = new DatePicker();
        dateeditor = new JFormattedTextField();
    }
    
    private void addComponents(){
        
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
        this.add(categoria_cb);
        this.add(datnnaix_lbl);
        this.add(sexe_lbl);
    }
    
    private void setupcomponents(){
        
        nif_lbl.setBounds(73, 77, 24,17);
        nif_tf.setBounds(73, 107, 509, 74);
        
        nombre_lbl.setBounds(73, 212, 57,17);
        nombre_tf.setBounds(73, 242, 509, 74);
        
        addr_lbl.setBounds(73, 347, 73, 17);
        add_tf.setBounds(73, 377, 509, 74);
        
        ciu_lbl.setBounds(73, 482, 73, 17);
        ciu_tf.setBounds(73,512,249,74);
        
        codipos_lbl.setBounds(332, 482, 101, 17);
        codipos_tf.setBounds(332, 512, 249, 74);
        
        pais_lbl.setBounds(73, 617, 73, 17);
        pais_tf.setBounds(73,647,509,74);
        
        appellido_lbl.setBounds(817, 212, 59, 17);
        appellido_tf.setBounds(817, 242, 249, 74);
        
        Iban_lbl.setBounds(817, 347, 24, 17);
        iban_tf.setBounds(817, 377, 509, 74);
    }
}
