/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.xml.DataToXML;
import org.joe.application.views.ExportarJugadorFrame;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarJugadorFrameController implements ActionListener {

    private ExportarJugadorFrame ejfc;
    private EquipDataInterface edi;
    Player player = null;

    public ExportarJugadorFrameController(EquipDataInterface edi) {
        this.edi = edi;
        ejfc = new ExportarJugadorFrame();
        ejfc.setVisible(true);

        ejfc.browsDir_onClick(this);
        ejfc.exportarJug_OnClick(this);
        ejfc.searhJugador_OnClick(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ejfc.getSearchButton()) {
            String playerid = ejfc.getJugadornifTf().getText().trim();

            try {
                player = edi.getPlayerByLegalId(playerid);

                JOptionPane.showMessageDialog(null,
                        "Jugador Encontrado",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
        if (e.getSource() == ejfc.getBrowseButton()) {
            int returnValue = ejfc.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = ejfc.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + ejfc.getFilenameTF().getText();
                ejfc.getFilepathTF().setText(fullPath);
            }
        }
        if (e.getSource() == ejfc.getExportButton()) {
            String fileString = ejfc.getFilepathTF().getText();
            try {
                System.out.println("*****************");
                player.mostrarJugDetalle();
                DataToXML.exportPlayer(player, fileString);
                JOptionPane.showMessageDialog(null,
                        "Jugador Exportado Existosamente",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }

        }
    }
}
