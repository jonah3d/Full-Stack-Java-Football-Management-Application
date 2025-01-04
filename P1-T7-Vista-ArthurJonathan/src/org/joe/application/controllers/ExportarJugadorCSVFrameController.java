/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.xml.DataToCSV;
import org.joe.application.views.ExportarJugadorCSVFrame;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarJugadorCSVFrameController implements ActionListener {

    private ExportarJugadorCSVFrame ejcsvf;
    private final EquipDataInterface edi;
    List<Player> players = null;

    public ExportarJugadorCSVFrameController(EquipDataInterface edi) {
        this.edi = edi;

        ejcsvf = new ExportarJugadorCSVFrame();
        ejcsvf.setVisible(true);

        ejcsvf.browsDir_onClick(this);
        ejcsvf.exportarJug_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ejcsvf.getBrowseButton()) {
            int returnValue = ejcsvf.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = ejcsvf.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + ejcsvf.getFilenameTF().getText();
                ejcsvf.getFilepathTF().setText(fullPath);
            }
        }

        if (e.getSource() == ejcsvf.getExportButton()) {
            try {
                players = edi.getPlayers();
                String fileString = ejcsvf.getFilepathTF().getText();
                DataToCSV.exportAllPlayers(fileString, players);
                JOptionPane.showMessageDialog(null,
                        "Jugadores Exportado Existosamente",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }

        }

    }

}
