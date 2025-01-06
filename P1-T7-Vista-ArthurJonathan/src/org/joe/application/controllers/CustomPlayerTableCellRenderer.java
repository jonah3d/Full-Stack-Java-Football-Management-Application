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
public class CustomPlayerTableCellRenderer extends DefaultTableCellRenderer {

    public CustomPlayerTableCellRenderer() {
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

        if (isSelected) {
            component.setForeground(Color.WHITE);
            component.setBackground(table.getSelectionBackground());
        } else {

            component.setForeground(
                    component.getBackground().equals(Color.WHITE) ? Color.BLACK : Color.DARK_GRAY);
        }

        if (!isSelected) {
            component.setForeground(Color.BLACK);
        }

        return component;
    }
}
