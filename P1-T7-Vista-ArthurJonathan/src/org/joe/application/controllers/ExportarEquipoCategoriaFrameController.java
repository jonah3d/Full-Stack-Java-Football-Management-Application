/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.constants.ErrMsg;
import org.joe.application.data.xml.DataToXML;
import org.joe.application.views.ExportarEquipoCategoriaFrame;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;

/**
 *
 * @author jonah
 */
public class ExportarEquipoCategoriaFrameController implements ActionListener {

    private ExportarEquipoCategoriaFrame eecf;
    private final EquipDataInterface edi;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<Team> teams = null;

    public ExportarEquipoCategoriaFrameController(EquipDataInterface edi) {
        this.edi = edi;
        eecf = new ExportarEquipoCategoriaFrame();
        eecf.setVisible(true);
        eecf.browsDir_onClick(this);
        eecf.exportarJug_OnClick(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eecf.getBrowseButton()) {
            int returnValue = eecf.getFilepathChooser().showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedPath = eecf.getFilepathChooser().getSelectedFile().getPath();
                String fullPath = selectedPath + "\\" + eecf.getFilenameTF().getText();
                eecf.getFilepathTF().setText(fullPath);
            }
        }

        if (e.getSource() == eecf.getExportButton()) {
            String fileString = eecf.getFilepathTF().getText();
            String category = eecf.getCategTextField().getText().trim();
            String dateString = eecf.getDatePicker().getSelectedDateAsString();
            try {
                Date date = sdf.parse(dateString);
                Category cat = edi.getCategory(category);
                teams = edi.getSeasonCategoryTeam(category, date);
                DataToXML.exportSeasonCategoryTeam(teams, cat, fileString);
                JOptionPane.showMessageDialog(null,
                        "Equipos Exportado Existosamente",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        }
    }

}
