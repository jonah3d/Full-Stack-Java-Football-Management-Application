/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joe.application.views.Management;

/**
 *
 * @author jonah
 */
public class ManagementFrameController implements ActionListener {

    private Management managementview;

    public ManagementFrameController() {
        managementview = new Management();

        managementview.PlayerMangementBTN_Onclick(this);
        managementview.TeamManagementBTN_OnClick(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == managementview.getPlayermngmtBTN()) {
            managementview.getManagementTyTabbedPane().setSelectedIndex(0);
        }

        if (e.getSource() == managementview.getTeammngmtBTN()) {
            managementview.getManagementTyTabbedPane().setSelectedIndex(1);
        }
    }

}
