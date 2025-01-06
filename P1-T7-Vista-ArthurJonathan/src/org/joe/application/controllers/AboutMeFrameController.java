/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.controllers;

import org.joe.application.constants.ErrMsg;
import org.joe.application.views.AboutMeFrame;

/**
 *
 * @author jonah
 */
public class AboutMeFrameController {

    private AboutMeFrame aboutMeFrame;

    public AboutMeFrameController() {

        try {
            aboutMeFrame = new AboutMeFrame();
            aboutMeFrame.setVisible(true);
        } catch (Exception e) {
            ErrMsg.error(e.getMessage(), e.getCause());
        }

    }

}
