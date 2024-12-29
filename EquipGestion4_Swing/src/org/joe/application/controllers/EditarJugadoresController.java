/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.joe.application.views.tabs.EditarJugadores;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterface;
import java.sql.Blob;
import java.text.ParseException;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.Icon;
import org.joe.application.constants.ErrMsg;
import org.joe.application.constants.PlayerConstants;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class EditarJugadoresController implements ActionListener {

    private EditarJugadores EditarJugadores;
    private final ImageIcon defaultIcon;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    EquipDataInterface edi;

    public EditarJugadoresController(EquipDataInterface edi) {
        this.edi = edi;
        this.EditarJugadores = new EditarJugadores();
        this.defaultIcon = new ImageIcon(getClass().getClassLoader().getResource("org/joe/application/resources/img/User.png"));
        EditarJugadores.getProfileJLabel().setIcon(defaultIcon);
        if (defaultIcon.getIconWidth() == -1) {
            System.out.println("Image not found!");
        }
        EditarJugadores.editPlayer_OnClick(this);
        profileimage();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getEditarJugadores().getEditplayer()) {

            boolean isvalid = settingUpCampVal();

            if (isvalid) {
                boolean ans = editplayer();
                if (ans) {
                    JOptionPane.showMessageDialog(EditarJugadores, "Jugador Editado", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(EditarJugadores, "Jugador No Editado", "Failure",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        }
    }

    public EditarJugadores getEditarJugadores() {
        return EditarJugadores;
    }

    public void profileimage() {
        EditarJugadores.getProfileJLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Profile Image");
                fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif"));

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg") || filePath.endsWith(".png") || filePath.endsWith(".gif")) {

                        ImageIcon profileIcon = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(280, 280, java.awt.Image.SCALE_SMOOTH));
                        EditarJugadores.getProfileJLabel().setIcon(profileIcon);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a valid image file.", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public void getSelectedPlayer(Player player) {
        EditarJugadores.getNif_tf().setText(player.getLegal_id());
        EditarJugadores.getNombre_tf().setText(player.getName());
        EditarJugadores.getAppellido_tf().setText(player.getSurname());

        String sexe = player.getSex();
        if (sexe.equals("D")) {
            EditarJugadores.getMujer_rb().setSelected(true);
        } else if (sexe.equals("H")) {
            EditarJugadores.getHombre_rb().setSelected(true);
        }
        Date birthyear = player.getBirth_year();
        EditarJugadores.getDateeditor().setText(sdf.format(birthyear));
        EditarJugadores.getIban_tf().setText(player.getIban());
        EditarJugadores.getAdd_tf().setText(player.getDireccion());
        EditarJugadores.getCodipos_tf().setText(player.getCodigo_postal());
        EditarJugadores.getCiu_tf().setText(player.getLocalidad());
        EditarJugadores.getPais_tf().setText(player.getPais());

        int med = player.getMedical_rev_fin();
        if (med == 1) {
            EditarJugadores.getSiRadioButton().setSelected(true);
        } else if (med == 0) {
            EditarJugadores.getNoJRadioButton().setSelected(true);
        }
        EditarJugadores.getProvincia_tf().setText(player.getProvincia());

        Blob imageBlob = player.getImage();
        if (imageBlob != null) {
            try {

                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                BufferedImage bufferedImage = ImageIO.read(bais);

                ImageIcon icon = new ImageIcon(bufferedImage);
                EditarJugadores.getProfileJLabel().setIcon(icon);
            } catch (Exception ex) {
                ErrMsg.error(ex.getMessage(), ex.getCause());
            }
        } else {
            EditarJugadores.getProfilerror().setVisible(true);
            EditarJugadores.getProfilerror().setText("No Image For Selected Player");
        }
    }

    private boolean settingUpCampVal() {

        boolean isValid = true;

        //Setting Up NIF VALIDATION
        if (EditarJugadores.getNif_tf().getText().isBlank()) {
            EditarJugadores.getNiferror().setVisible(true);
            EditarJugadores.getNiferror().setText("NIF no puede ser vacio");
            isValid = false;
        } else if (EditarJugadores.getNif_tf().getText().length() != 8
                && !Character.isLetter(EditarJugadores.getNif_tf().getText().trim().
                        charAt(EditarJugadores.getNif_tf().getText().trim().length() - 1))) {
            EditarJugadores.getNiferror().setVisible(true);
            EditarJugadores.getNiferror().setText("NIF debería ser 8 characters");
            isValid = false;
        } else if (EditarJugadores.getNif_tf().getText().length() == 8
                && !Character.isLetter(EditarJugadores.getNif_tf().getText().trim().
                        charAt(EditarJugadores.getNif_tf().getText().trim().length() - 1))) {
            EditarJugadores.getNiferror().setVisible(true);
            EditarJugadores.getNiferror().setText("NIF debería acabar con una letra");
            isValid = false;
        } else {
            EditarJugadores.getNiferror().setVisible(false);
        }
        //Setting Up SEXO VALIDATION
        if (EditarJugadores.getSexebutons_btn().getSelection() == null) {
            EditarJugadores.getSexeerror().setVisible(true);
            EditarJugadores.getSexeerror().setText("Elige un sexe");
            isValid = false;
        } else {
            EditarJugadores.getSexeerror().setVisible(false);
        }

        //SETTING UP NOMBRE VALIDATION
        if (EditarJugadores.getNombre_tf().getText().isBlank()) {
            EditarJugadores.getNombreerror().setVisible(true);
            EditarJugadores.getNombreerror().setText("Nombre no puede ser vacio");
            isValid = false;
        } else if (EditarJugadores.getNombre_tf().getText().trim().length() < 2) {
            EditarJugadores.getNombreerror().setVisible(true);
            EditarJugadores.getNombreerror().setText("Nombre tiene que ser mas de 2 characters");
            isValid = false;
        } else {
            EditarJugadores.getNombreerror().setVisible(false);
        }

        //SETTING UP APELLIDO VALIDATION
        if (EditarJugadores.getAppellido_tf().getText().isBlank()) {
            EditarJugadores.getAppellidoerror().setVisible(true);
            EditarJugadores.getAppellidoerror().setText("Apellido no puede ser vacio");
            isValid = false;
        } else if (EditarJugadores.getAppellido_tf().getText().trim().length() < 2) {
            EditarJugadores.getAppellidoerror().setVisible(true);
            EditarJugadores.getAppellidoerror().setText("Apellido tiene que ser mas de 2 characters");
            isValid = false;
        } else {
            EditarJugadores.getAppellidoerror().setVisible(false);
        }

        //SETTING UP DIRECCION
        if (EditarJugadores.getAdd_tf().getText().isBlank()) {
            EditarJugadores.getDirrerror().setVisible(true);
            EditarJugadores.getDirrerror().setText("Dirección no puede ser vacío");
            isValid = false;
        } else if (EditarJugadores.getAdd_tf().getText().trim().length() < 2) {
            EditarJugadores.getDirrerror().setVisible(true);
            EditarJugadores.getDirrerror().setText("Entrar un direccion valida");
            isValid = false;
        } else {
            EditarJugadores.getDirrerror().setVisible(false);
        }

        //Setting Up Ciudad
        if (EditarJugadores.getCiu_tf().getText().isBlank()) {
            EditarJugadores.getCiuerror().setVisible(true);
            EditarJugadores.getCiuerror().setText("Ciudad no puede ser vacío");
            isValid = false;
        } else if (EditarJugadores.getCiu_tf().getText().trim().length() < 2) {
            EditarJugadores.getCiuerror().setVisible(true);
            EditarJugadores.getCiuerror().setText("Entrar una ciudad valida");
            isValid = false;
        } else {
            EditarJugadores.getCiuerror().setVisible(false);
        }

        //Setting Up Pais
        if (EditarJugadores.getPais_tf().getText().isBlank()) {
            EditarJugadores.getPaiserror().setVisible(true);
            EditarJugadores.getPaiserror().setText("Ciudad no puede ser vacío");
            isValid = false;
        } else if (EditarJugadores.getPais_tf().getText().trim().length() < 2) {
            EditarJugadores.getPaiserror().setVisible(true);
            EditarJugadores.getPaiserror().setText("Entrar una ciudad valida");
            isValid = false;
        } else {
            EditarJugadores.getPaiserror().setVisible(false);
        }

        //SETTING UP PROVINCIA
        if (EditarJugadores.getProvincia_tf().getText().isBlank()) {
            EditarJugadores.getProvinciaerror().setVisible(true);
            EditarJugadores.getProvinciaerror().setText("Provincia no puede ser vacío");
            isValid = false;
        } else if (EditarJugadores.getProvincia_tf().getText().trim().length() < 2) {
            EditarJugadores.getProvinciaerror().setVisible(true);
            EditarJugadores.getProvinciaerror().setText("Entrar una provincia valida");
            isValid = false;
        } else {
            EditarJugadores.getProvinciaerror().setVisible(false);
        }

        //Setting Up Codigo postal
        try {
            if (EditarJugadores.getCodipos_tf().getText().isBlank()) {
                EditarJugadores.getCodiposerror().setVisible(true);
                EditarJugadores.getCodiposerror().setText("Introduce un codigo postal");
                isValid = false;
            } else {
                String codigoPostal = EditarJugadores.getCodipos_tf().getText().trim();
                if (codigoPostal.length() < 4) {
                    EditarJugadores.getCodiposerror().setVisible(true);
                    EditarJugadores.getCodiposerror().setText("Introduce mas de 5 digitos");
                    isValid = false;
                } else {
                    Integer.parseInt(codigoPostal);
                    EditarJugadores.getCodiposerror().setVisible(false);
                }
            }
        } catch (NumberFormatException e) {
            ErrMsg.error(e.getMessage(), e.getCause());
        }

        //Setting Up Revision Medica
        if (EditarJugadores.getRevmedbtngrp().getSelection() == null) {
            EditarJugadores.getRevisionmederror().setVisible(true);
            EditarJugadores.getRevisionmederror().setText("Confirma la revision medica");
            isValid = false;
        } else {
            EditarJugadores.getRevisionmederror().setVisible(false);
        }

        //Setting Up Iban
        if (EditarJugadores.getIban_tf().getText().isBlank()) {
            EditarJugadores.getIbanerror().setVisible(true);
            getEditarJugadores().getIbanerror().setText("IBAN no puede ser vacio");
            isValid = false;
        } else if ((EditarJugadores.getIban_tf().getText().replace(" ", "")).trim().length() != 24) {
            EditarJugadores.getIbanerror().setVisible(true);
            getEditarJugadores().getIbanerror().setText("IBAN tiene que ser 24 digitos");
            isValid = false;
        } else {
            EditarJugadores.getIbanerror().setVisible(false);
        }

        //Setting Up Calender
        if (EditarJugadores.getDateeditor().getText().equals("")) {
            EditarJugadores.getDateerror().setVisible(true);
            EditarJugadores.getDateerror().setText("Data Naixement no pueder ser vacio");
            isValid = false;
        } else {
            EditarJugadores.getDateerror().setVisible(false);
        }

        if (EditarJugadores.getProfileJLabel().getIcon() == defaultIcon) {
            EditarJugadores.getProfilerror().setVisible(true);
            EditarJugadores.getProfilerror().setText("Tiene que selectionar un imagen");
            isValid = false;
        } else {
            EditarJugadores.getProfilerror().setVisible(false);
        }
        return isValid;
    }

    public boolean editplayer() {
        boolean ans = false;

        String nif = EditarJugadores.getNif_tf().getText().trim();
        String nombre = EditarJugadores.getNombre_tf().getText().trim();
        String apellido = EditarJugadores.getAppellido_tf().getText().trim();
        String sexe = null;
        if (EditarJugadores.getHombre_rb().isSelected()) {
            sexe = "H";
        } else if (EditarJugadores.getMujer_rb().isSelected()) {
            sexe = "D";
        }
        String birthday = EditarJugadores.getDateeditor().getText().trim();
        Date datanaix = null;
        try {
            datanaix = sdf.parse(birthday);
        } catch (ParseException ex) {
            System.out.println("Error Pasrsing Date into player");
        }
        String iban = EditarJugadores.getIban_tf().getText().trim();
        String direccion = EditarJugadores.getAdd_tf().getText().trim();
        String codipostal = EditarJugadores.getCodipos_tf().getText().trim();
        String localidad = EditarJugadores.getCiu_tf().getText().trim();
        // String provincia = AnadirJugadores.getpro.getText().trim();
        String pais = EditarJugadores.getPais_tf().getText().trim();
        Integer medical = null;
        if (EditarJugadores.getSiRadioButton().isSelected()) {
            medical = 1;
        } else if (EditarJugadores.getNoJRadioButton().isSelected()) {
            medical = 0;
        }
        String provincia = EditarJugadores.getProvincia_tf().getText().trim();

        Icon icon = EditarJugadores.getProfileJLabel().getIcon();
        Blob image = null;

        if (icon != null && icon instanceof ImageIcon) {

            image = convertIconToBlob((ImageIcon) icon);

        } else {
            errorDialogue("Ningun Imagen O Tipo No Suportado");
        }
        Player player = new Player(nombre, apellido, sexe, datanaix, nif, iban,
                direccion, codipostal, localidad, provincia, pais, image, medical);
        try {
            boolean btoteam = edi.checkPlayerBelongsToTeam(player.getLegal_id());
            Team playerteam = edi.getPlayerTeam(player.getLegal_id());
            String teamtype = playerteam.getTeam_type();
            String category = playerteam.getCategory();

            // Retrieve the current player's information for comparison
            Player currentPlayer = edi.getPlayerByLegalId(player.getLegal_id());

            // Check if the date of birth or sexe has been edited
            boolean isDateChanged = !currentPlayer.getBirth_year().equals(datanaix);
            boolean isSexChanged = !currentPlayer.getSex().equals(sexe);

            // Perform validation only if there are edits
            if (!btoteam || teamtype.equals("M")
                    || (isDateChanged && !category.equals(PlayerConstants.calculateAge(datanaix)))
                    || isSexChanged) {

                errorDialogue("No Puede Cambiar El Sexe O Data Nacimiento.");
            } else {
                edi.editarJugador(player);
                ans = true;
            }
        } catch (EquipDataInterfaceException e) {
            ErrMsg.error(e.getMessage(), e.getCause());
        }

        return ans;

    }

    private void errorDialogue(String message) {

        JOptionPane.showMessageDialog(EditarJugadores, message, "Error De Campo", JOptionPane.INFORMATION_MESSAGE);

    }

    private Blob convertIconToBlob(ImageIcon icon) {

        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(
                image.getWidth(null),
                image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB
        );
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        SerialBlob serialBlob = null;
        try {
            // Write BufferedImage to ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();

            serialBlob = new SerialBlob(imageBytes);
            return serialBlob;
        } catch (Exception ex) {
            ErrMsg.error(ex.getMessage(), ex.getCause());

        }
        return serialBlob;
    }

}
