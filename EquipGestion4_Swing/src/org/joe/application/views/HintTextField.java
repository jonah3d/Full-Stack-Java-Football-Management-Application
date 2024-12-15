/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author jonah
 */
public class HintTextField extends JTextField {

    private String hint;
    private boolean showingHint;

    public HintTextField(String hint) {
        super();
        this.hint = hint;
        this.showingHint = true;

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().isEmpty()) {
                    showingHint = false;
                    repaint();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    showingHint = true;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (showingHint) {

            g.setColor(Color.GRAY);
            g.drawString(hint, 5, 15);
        }
    }

    @Override
    public void setText(String t) {
        super.setText(t);
        if (t.isEmpty()) {
            showingHint = true;
            repaint();
        } else {
            showingHint = false;
        }
    }
}
