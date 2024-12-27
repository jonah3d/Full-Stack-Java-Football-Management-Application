/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author jonah
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    public CustomTableCellRenderer() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Object categoryValue = table.getValueAt(row, 5);

        if (categoryValue != null) {
            switch (categoryValue.toString()) {
                case "Benjamí" ->
                    component.setBackground(Color.decode("#FFFFFF"));
                case "Aleví" ->
                    component.setBackground(Color.decode("#F7F7F7"));
                case "Infantil" ->
                    component.setBackground(Color.decode("#DFDFDF"));
                case "Cadet" ->
                    component.setBackground(Color.decode("#C4C4C4"));
                case "Juvenil" ->
                    component.setBackground(Color.decode("#ABABAB"));
                case "Senior" ->
                    component.setBackground(Color.decode("#919191"));
                default ->
                    component.setBackground(Color.WHITE);
            }
        }

        // Set the default foreground color for better contrast
        if (!isSelected) {
            component.setForeground(Color.BLACK);
        }

        return component;
    }
}
