/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.initialize;

import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.joe.application.controllers.LoginScreenController;
import org.joe.application.controllers.ManagementFrameController;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author Usuari
 */
public class Application {

    private LoginScreenController screenController;
    private static String nomClassePersistencia = null;
    private EquipDataInterface dbad = null;

    public Application() {
        try {

            dbad = (EquipDataInterface) Class.forName(nomClassePersistencia).newInstance();

            screenController = new LoginScreenController(dbad);
        } catch (Exception e) {
            System.err.println("Error initializing persistence class: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (args.length == 0) {
            System.out.println("Please provide the persistence class name as the first argument.");
            System.exit(0);
        }
        nomClassePersistencia = args[0];

        new Application();
    }
}
