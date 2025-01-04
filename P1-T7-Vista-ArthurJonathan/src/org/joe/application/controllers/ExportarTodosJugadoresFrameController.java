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

import org.joe.application.data.xml.DataToXML;
import org.joe.application.views.ExportarTodosJugadoresFrame;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarTodosJugadoresFrameController implements ActionListener {

    private ExportarTodosJugadoresFrame extodjugF;
    private EquipDataInterface edi;

    public ExportarTodosJugadoresFrameController(EquipDataInterface edi) {
        this.edi = edi;
        extodjugF = new ExportarTodosJugadoresFrame();
        extodjugF.setVisible(true);

        extodjugF.browsDir_onClick(this);
        extodjugF.exportarJug_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == extodjugF.getBrowseButton()) {
            int returnValue = extodjugF.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = extodjugF.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + extodjugF.getFilenameTF().getText();
                extodjugF.getFilepathTF().setText(fullPath);
            }
        }

        if (e.getSource() == extodjugF.getExportButton()) {

            try {
                List<Player> players = edi.getPlayers();
                String fileString = extodjugF.getFilepathTF().getText();
                boolean ans;
                ans = DataToXML.exportAllPlayers(players, fileString);
                if (ans) {
                    JOptionPane.showMessageDialog(null,
                            "Jugadores Exportado Existosamente",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
    }
}
