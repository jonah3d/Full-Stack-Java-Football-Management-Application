/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.application.constants;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author jonah
 */
public class PlayerConstants {

    public static String calculateCat(int age) {
        if (age >= 7 && age <= 8) {
            return "Benjamí";
        } else if (age >= 9 && age <= 11) {
            return "Aleví";
        } else if (age >= 12 && age <= 13) {
            return "Infantil";
        } else if (age >= 14 && age <= 15) {
            return "Cadet";
        } else if (age >= 16 && age <= 17) {
            return "Juvenil";
        } else if (age >= 18 && age <= 21) {
            return "Senior";
        }
        return null;
    }

    public static int calculateAge(Date birthDate) {
        if (birthDate == null) {
            return 0;
        }

        LocalDate birthLocalDate;
        if (birthDate instanceof java.sql.Date) {
            birthLocalDate = ((java.sql.Date) birthDate).toLocalDate();
        } else {
            birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        LocalDate referenceDate = LocalDate.of(2024, 9, 1);

        return Period.between(birthLocalDate, referenceDate).getYears();
    }
}
