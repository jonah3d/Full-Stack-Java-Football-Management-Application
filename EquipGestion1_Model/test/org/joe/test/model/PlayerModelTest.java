
package org.joe.test.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joe.gestion.model.data.Player;


public class PlayerModelTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = sdf.parse("1990-01-01"); // Example date
        
        Player player1 = new Player("Bru", "Protonoy", 'H', birthDate);
        player1.setLegal_id("X6200841H");
        player1.setAddress("Trav del Valles 11, 08500, Igualada - Vic");
        player1.mostrarJugDetalle();
    }
}
