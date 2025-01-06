/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class AboutMeFrame extends JFrame {

    private JEditorPane editorPane;
    private JScrollPane scrollPane;

    public AboutMeFrame() {
        setTitle("About Me");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        initialiseComponents();
    }

    private void initialiseComponents() {

        editorPane = new JEditorPane();
        editorPane.setEditable(false);

        try {

            URL resourceUrl = getClass().getClassLoader().getResource("org/joe/application/resources/staticfiles/index.html");
            if (resourceUrl != null) {
                editorPane.setPage(resourceUrl);
            } else {
                throw new EquipDataInterfaceException("Resource not found: org/joe/application/resources/staticfiles/index.html");
            }
        } catch (IOException e) {
            editorPane.setText("<html><body><h1>Error Loading Page</h1><p>" + e.getMessage() + "</p></body></html>");
        }

        scrollPane = new JScrollPane(editorPane);

        add(scrollPane, BorderLayout.CENTER);
    }
}
