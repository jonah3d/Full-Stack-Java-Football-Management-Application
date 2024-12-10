/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views.tabs;

import com.formdev.flatlaf.extras.FlatSVGIcon;
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
 * @author Usuari
 */
public class EditorJugadores extends JPanel {
    
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
   JLabel datarevmed_lbl;
    DatePicker datePicker_naix;
    JFormattedTextField dateeditor_naix; 
    DatePicker datePicker_rev;
    JFormattedTextField dateeditor_rev;
    JLabel profile_lb;
    
    
      public EditorJugadores(){
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
        profile_lb = new JLabel();
        datePicker_naix = new DatePicker();
        dateeditor_naix = new JFormattedTextField();
       datarevmed_lbl =  new JLabel("Revision Medica FIn");
       
       datePicker_rev = new DatePicker();
       dateeditor_rev = new JFormattedTextField();
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
        this.add(profile_lb);
        this.add(datarevmed_lbl);
        this.add(datePicker_naix);
        this.add(dateeditor_naix);
        this.add(datePicker_rev);
        this.add(dateeditor_rev);
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
        
        hombre_rb.setBounds(1340,404,90,30);
        mujer_rb.setBounds(1450,404,90,30);
        profile_lb.setBounds(1300, 77, 280, 280); 
       profile_lb.setIcon(new FlatSVGIcon(ManagemetConstants.extraicon_path + "icon_user.svg"));
       profile_lb.setToolTipText("Haz Un Click Para Añadir Un Jugador");
       
       datnnaix_lbl.setBounds(817,482,136,17);
       dateeditor_naix.setBounds(817, 512, 510, 74);
       datePicker_naix.setEditor(dateeditor_naix);
       datePicker_naix.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
       
       datarevmed_lbl.setBounds(817, 617, 136, 17);
       dateeditor_rev.setBounds(817, 647, 510, 74);
       datePicker_rev.setEditor(dateeditor_rev);
       datePicker_rev.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
    }
}
