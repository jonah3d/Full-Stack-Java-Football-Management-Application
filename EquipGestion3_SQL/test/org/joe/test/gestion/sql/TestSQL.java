/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.test.gestion.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;
import org.joe.gestion.model.sqlpersistencia.EquipDataImplementationSQL;
import javax.sql.rowset.serial.SerialBlob;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Season;
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 */
public class TestSQL {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void addNewPlayer() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Player p1 = new Player();
        p1.setName("Jonathan");
        p1.setSurname("Moreno");
        p1.setSex("H");
        try {
            p1.setBirth_year(sdf.parse("2001-09-05"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        p1.setLegal_id("X620841H");
        p1.setIban("ES7612345555952023456820");
        p1.setDireccion("Travessia del valles 11");
        p1.setCodigo_postal("04700");
        p1.setProvincia("Almeria");
        p1.setPais("España");
        p1.setLocalidad("Roquetas De Mar");

        p1.setMedical_rev_fin(1);

        try {
            FileInputStream fis = new FileInputStream(new File("testfoto.png"));

            Blob blob = createBlobFromInputStream(fis);

            p1.setImage(blob);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("unable to load image");
        } catch (SQLException ex) {
            Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        p1.mostrarJugDetalle();

        implementationSQL.addNewPlayer(p1);
    }

    public static Player newPlayer() {
        Player p1 = new Player();
        p1.setName("Jonathan");
        p1.setSurname("Moreno");
        p1.setSex("H");
        try {
            p1.setBirth_year(sdf.parse("2001-09-05"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        p1.setLegal_id("X620841H");
        p1.setIban("ES7612345555952023456820");
        p1.setDireccion("Travessia del valles 11");
        p1.setCodigo_postal("04700");
        p1.setProvincia("Almeria");
        p1.setPais("España");
        p1.setLocalidad("Roquetas De Mar");

        p1.setMedical_rev_fin(1);

        try {
            FileInputStream fis = new FileInputStream(new File("testfoto.png"));

            Blob blob = createBlobFromInputStream(fis);

            p1.setImage(blob);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("unable to load image");
        } catch (SQLException ex) {
            Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p1;
    }

    public static void editPlayer() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
        isql.editarJugador(newPlayer());

    }

    private static Blob createBlobFromInputStream(InputStream is) throws SQLException, IOException {
        byte[] bytes = is.readAllBytes();
        return new SerialBlob(bytes);
    }

    public static void CREATEUSER() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        implementationSQL.createUser("admin", "joe", "admin");
    }

    public static void VALIDATEUSER() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();

        boolean result = isql.validateUser("admin", "admin");
        if (result) {
            System.out.println("USER IS VALID");
        } else {
            System.out.println("Incorrect user");
        }
    }

    public static void RESTOREPASS() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
        isql.restorePassword("admin", "ADMIN");

    }

    public static void getPlayersByLegalId() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> player = implementationSQL.getPlayersByLegalId("ID016");

        for (Player play : player) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void GETTEAMSBYCAT() {
        List<Team> teamsbycat = new ArrayList<>();

        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        teamsbycat = implementationSQL.getTeamsByCategory("Cadet");

        for (Team t : teamsbycat) {
            System.out.println("\n=========================\n");
            t.mostrarDetalle();
        }

    }

    public static void getTeamsByType() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Team> teamsbytype = new ArrayList<>();

        teamsbytype = implementationSQL.getTeamsByType("D");

        if (teamsbytype == null || teamsbytype.isEmpty()) {
            System.out.println("No teams found for the given type.");
            return;
        }

        for (Team t : teamsbytype) {
            System.out.println("\n=========================\n");
            t.mostrarDetalle();
        }
    }

    public static void deletePlayer() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        implementationSQL.eliminarJugador("X620841H");
    }

    public static void DELETETEAM() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        implementationSQL.deleteTeam("FcBarcelona");
    }

    public static void PLAYSBYYEAR() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        String dateuser = ("2007-01-25");
        List<Player> playerlist = new ArrayList<>();

        try {
            playerlist = implementationSQL.getPlayerByBirthYear(sdf.parse(dateuser));

            for (Player play : playerlist) {
                System.out.println("\n=========================\n");
                play.mostrarJugDetalle();
            }

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void GETPLAYERSBYNAME() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerByName("Pedro");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }

    }

    public static void getPlayerBySurname() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerBySurname("Reyes");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }

    }

    public static void getPlayerBySurname_Ordbycognom() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerBySurname_ordCognom("Reyes");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }

    }

    public static void getPlayerBySurname_Orddatnaix() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerBySurname_ordDatnaix("Reyes");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }

    }

    public static void getAllCategories() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Category> catlist = new ArrayList<>();
        catlist = implementationSQL.getCategorys();
        for (Category cat : catlist) {
            cat.mostrarDetalle();
            System.out.println("\n");
        }
    }

    public static void ADDNEWTEAM() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        try {
            implementationSQL.addNewTeam("FcBarcelona", "D", "Juvenil", sdf.parse("2024-09-01"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public static void getTeamPlayers() {
//
//        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
//        List<Player> playerlist = new ArrayList<>();
//
//        playerlist = implementationSQL.getTeamPlayers("FcCanPalladesMIX");
//        for (Player play : playerlist) {
//            System.out.println("\n=========================\n");
//            play.mostrarJugDetalle();
//        }
//    }
    public static void getAllTeams() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Team> teamlist = new ArrayList<>();

        teamlist = implementationSQL.getAllTeams();
        for (Team team : teamlist) {
            team.mostrarDetalle();
        }
    }

    public static void getPlayers() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayers();
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayers_ordbycognom() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayers_ordCognom();
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayers_ordbybirthyear() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayers_ordDatnaix();
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayersCat() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayersByCat("Cadet");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayersCat_ordbycognom() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayeraByCat_ordCognom("Juvenil");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayersCat_ordbydatnaix() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayeraByCat_ordDatnaix("Juvenil");
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getPlayersByBirtYear() throws ParseException {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerByBirthYear(sdf.parse("2007-05-16"));
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getTeamsSeaon() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Team> teamlist = new ArrayList<>();
        try {
            teamlist = implementationSQL.getTeamsBySeason(sdf.parse("2024-09-01"));
        } catch (ParseException ex) {
            Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Team team : teamlist) {
            System.out.println("\n=========================\n");
            team.mostrarDetalle();
        }
    }

    public static void getPlayersByBirtYear_OrdbySurname() throws ParseException {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerByBirthYear_ordCognom(sdf.parse("2007-05-16"));
        for (Player play : playerlist) {
            System.out.println("\n=========================\n");
            play.mostrarJugDetalle();
        }
    }

    public static void getSeasons() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        List<Season> seasonslist = new ArrayList<>();

        seasonslist = implementationSQL.getSeasons();
        for (Season season : seasonslist) {
            System.out.println("\n=========================\n");
            season.mostrarDetalle();
        }
    }

    public static void getPlayerByLegalId() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        Player player = implementationSQL.getPlayerByLegalId("9999901J");
        player.mostrarJugDetalle();
    }

    public static void getTeamMembercount() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        int count = implementationSQL.getTeamMemCount("FcRoquetasMASC");
        System.out.println("COUNT: " + count);
    }

    public static void removeTeam() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        implementationSQL.removeTeamFromSeason("Fc Monalco");
    }

    public static void main(String[] args) {

        // addNewPlayer();
        //CREATEUSER();
        //VALIDATEUSER();
        //RESTOREPASS();
        //getPlayersByLegalId();
        //getPlayerByLegalId();
        //deletePlayer();
        //PLAYSBYYEAR();
        //GETPLAYERSBYNAME();
        //getPlayerBySurname();
        //getPlayerBySurname_Ordbycognom();
        // getPlayerBySurname_Orddatnaix();
        //GETALLCATEGORIES();
        //ADDNEWTEAM();
        //DELETETEAM();
        //GETTEAMSBYCAT();
        //getTeamsByType();
        //getTeamPlayers();
        //getPlayers();
        //getPlayers_ordbycognom();
        //getPlayers_ordbybirthyear();
        //getPlayersCat();
        //getPlayersCat_ordbycognom();
        //getPlayersCat_ordbydatnaix();
        /*  try {
            getPlayersByBirtYear();
            //getPlayersByBirtYear_OrdbySurname();
        } catch (ParseException ex) {
            System.out.println(ex);
        }*/
        // editPlayer();
        //getSeasons();
        //getTeamsSeaon();
        // getTeamMembercount();
        //removeTeam();
        //getAllTeams();
    }

}
