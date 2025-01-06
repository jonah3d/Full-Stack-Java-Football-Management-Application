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
import java.util.Scanner;
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
    private static EquipDataImplementationSQL edisql = null;

    public static void ConnectToDb(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        edisql.connectDatasource("config.properties");
    }

    public static void closeDbConnection(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        try {
            edisql.disconnectDatasource();
        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        }

    }

    public static void addNewPlayer(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);

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
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
            throw new EquipDataInterfaceException("unable to load image");
        } catch (SQLException ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } catch (IOException ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }

        p1.mostrarJugDetalle();

        try {
            edisql.addNewPlayer(p1);
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } finally {
            closeDbConnection(edisql);
        }
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
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
            throw new EquipDataInterfaceException("unable to load image");
        } catch (SQLException ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } catch (IOException ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }
        return p1;
    }

    public static void editPlayer() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
        try {
            isql.editarJugador(newPlayer());
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }

    }

    private static Blob createBlobFromInputStream(InputStream is) throws SQLException, IOException {

        byte[] bytes = is.readAllBytes();
        return new SerialBlob(bytes);
    }

    public static void createUser() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        try {
            implementationSQL.createUser("admin", "joe", "admin");
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }
    }

    public static void validateUser() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
        try {
            boolean result = isql.validateUser("admin", "admin");
            if (result) {
                System.out.println("USER IS VALID");
            } else {
                System.out.println("Incorrect user");
            }
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }
    }

    public static void restorePassword() {
        EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
        try {
            isql.restorePassword("admin", "ADMIN");
        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        }

    }

    public static void getTeamsByCategory() {
        try {
            List<Team> teamsbycat = new ArrayList<>();

            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            teamsbycat = implementationSQL.getTeamsByCategory("Cadet");

            for (Team t : teamsbycat) {
                System.out.println("\n=========================\n");
                t.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void ErrorMsg(Exception e) {
        System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
    }

    public static void deletePlayer() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        try {
            implementationSQL.eliminarJugador("X620841H");
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void deleteTeam() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        try {
            implementationSQL.deleteTeam("FcBarcelona");
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getAllCategories() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            List<Category> catlist = new ArrayList<>();
            catlist = implementationSQL.getCategorys();
            for (Category cat : catlist) {
                cat.mostrarDetalle();
                System.out.println("\n");
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void addNewTeam() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        try {
            implementationSQL.addNewTeam("FcBarcelona", "D", "Juvenil", sdf.parse("2024-09-01"));
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        }
    }

    public static void getTeamPlayers() {

        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            List<Player> playerlist = new ArrayList<>();
            Date date = sdf.parse("2024-09-01");

            java.sql.Date oracldate = new java.sql.Date(date.getTime());
            System.out.println("ORCALE DATE: " + oracldate);
            playerlist = implementationSQL.getTeamPlayers("Fc Olot Fem", oracldate);
            if (playerlist.isEmpty()) {
                System.out.println("list is empty");
            }
            for (Player play : playerlist) {
                System.out.println("\n=========================\n");
                play.mostrarJugDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getAllTeams() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            List<Team> teamlist = new ArrayList<>();

            teamlist = implementationSQL.getAllTeams();
            for (Team team : teamlist) {
                team.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getPlayers() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            List<Player> playerlist = new ArrayList<>();

            playerlist = implementationSQL.getPlayers();
            for (Player play : playerlist) {
                System.out.println("\n=========================\n");
                play.mostrarJugDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getTeamsSeaon() {
        try {
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
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getSeasons() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            List<Season> seasonslist = new ArrayList<>();

            seasonslist = implementationSQL.getSeasons();
            for (Season season : seasonslist) {
                System.out.println("\n=========================\n");
                season.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getPlayerByLegalId() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            Player player = implementationSQL.getPlayerByLegalId("9999901J");
            player.mostrarJugDetalle();
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getTeamMemberCount() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            int count = implementationSQL.getTeamMemCount("FcRoquetasMASC");
            System.out.println("COUNT: " + count);
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void removeTeam() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            implementationSQL.removeTeamFromSeason("Fc Monalco");
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void checkPlayerHasTeam() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            boolean ans;
            ans = implementationSQL.checkPlayerBelongsToTeam("9999902K");
            if (ans) {
                System.out.println("Player Belongs To A Team");
            } else {
                System.out.println("Player Is Not Part Of A Team");
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void testGetPlayerTeam() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            Team team = implementationSQL.getPlayerTeam("9999902K");
            team.mostrarDetalle();
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void filteredPlayersList() {
        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = sdf.parse("2016-04-03");

            List<Player> players = implementationSQL.playerFilterSearch(null, null, null, "Juvenil", "birth_year");
            if (players.isEmpty()) {
                System.out.println("Query returned no results.");
            } else {
                System.out.println("Query returned results:");
                for (Player play : players) {
                    System.out.println("----------------------------------------------");
                    play.mostrarJugDetalle();
                }
            }
        } catch (Exception e) {
            ErrorMsg(e);
        }

    }

    public static void getTeamByName() {
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        try {
            String dateString = "2024-09-01";
            Date date = sdf.parse(dateString);

            java.sql.Date oracldate = new java.sql.Date(date.getTime());
            Team team = implementationSQL.getTeamByName("Fc Wildcats Masc", oracldate);
            team.mostrarDetalle();
        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        }

    }

    public static void getSeasonCatTeam() throws ParseException {

        try {
            EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
            String dateString = "2024-09-01";
            Date date = sdf.parse(dateString);
            List<Team> teams = implementationSQL.getSeasonCategoryTeam("Cadet", date);
            for (Team team : teams) {
                System.out.println("---------------------------");
                team.mostrarDetalle();
            }

        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EquipDataImplementationSQL edisql = new EquipDataImplementationSQL();

        System.out.println(
                "\t \t \t = = = = AREA DE TEST = = = = = ");
        System.out.println(
                " Los metodos aqui son unicamente los metodos utilizados en el producto final. Cualquier otro \n"
                + " metodo innecesario que fue escrito durante el desarrollo de esta aplicación ha sido eliminado.");

        while (true) {

            System.out.println("\nSelecciona una opción:");
            System.out.println("1. addNewPlayer()");
            System.out.println("2. createUser()");
            System.out.println("3. validateUser()");
            System.out.println("4. restorePassword()");
            System.out.println("5. getPlayerByLegalId()");
            System.out.println("6. deletePlayer()");
            System.out.println("7. getAllCategories()");
            System.out.println("8. addNewTeam()");
            System.out.println("9. deleteTeam()");
            System.out.println("10. getTeamsByCategory()");
            System.out.println("11. getTeamPlayers()");
            System.out.println("12. getPlayers()");
            System.out.println("13. editPlayer()");
            System.out.println("14. getSeasons()");
            System.out.println("15. getTeamsSeason()");
            System.out.println("16. getTeamMemberCount()");
            System.out.println("17. removeTeam()");
            System.out.println("18. getAllTeams()");
            System.out.println("19. checkPlayerHasTeam()");
            System.out.println("20. testGetPlayerTeam()");
            System.out.println("21. filteredPlayersList()");
            System.out.println("22. getTeamByName()");
            System.out.println("23. getSeasonCatTeam()");

            System.out.println("0. Salir");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addNewPlayer(edisql);
                        break;
                    case 2:
                        createUser();
                        break;
                    case 3:
                        validateUser();
                        break;
                    case 4:
                        restorePassword();
                        break;
                    case 5:
                        getPlayerByLegalId();
                        break;
                    case 6:
                        deletePlayer();
                        break;
                    case 7:
                        getAllCategories();
                        break;
                    case 8:
                        addNewTeam();
                        break;
                    case 9:
                        deleteTeam();
                        break;
                    case 10:
                        getTeamsByCategory();
                        break;
                    case 11:
                        getTeamPlayers();
                        break;
                    case 12:
                        getPlayers();
                        break;
                    case 13:
                        editPlayer();
                        break;
                    case 14:
                        getSeasons();
                        break;
                    case 15:
                        getTeamsSeaon();
                        break;
                    case 16:
                        getTeamMemberCount();
                        break;
                    case 17:
                        removeTeam();
                        break;
                    case 18:
                        getAllTeams();
                        break;
                    case 19:
                        checkPlayerHasTeam();
                        break;
                    case 20:
                        testGetPlayerTeam();
                        break;
                    case 21:
                        filteredPlayersList();
                        break;
                    case 22:
                        getTeamByName();
                        break;
                    case 23:
                        getSeasonCatTeam();
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        closeDbConnection(edisql);
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción entre 0 y 24.");
                }
            } catch (Exception ex) {
                System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
            }
        }

    }

}
