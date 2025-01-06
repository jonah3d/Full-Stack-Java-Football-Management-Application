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
        if (edisql != null) {
            edisql.connectDatasource("config.properties");
        } else {
            throw new EquipDataInterfaceException("edisql cannot be null");
        }
    }

    public static void closeDbConnection(EquipDataImplementationSQL edisql) {
        if (edisql != null) {
            try {
                edisql.disconnectDatasource();
            } catch (Exception e) {
                ErrorMsg(e);
            }
        } else {
            System.out.println("edisql instance is null. Cannot close connection.");
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

    public static void editPlayer(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.editarJugador(newPlayer());
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } finally {
            closeDbConnection(edisql);
        }

    }

    private static Blob createBlobFromInputStream(InputStream is) throws SQLException, IOException {

        byte[] bytes = is.readAllBytes();
        return new SerialBlob(bytes);
    }

    public static void createUser(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.createUser("admin", "joe", "admin");
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } finally {
            closeDbConnection(edisql);
        }
    }

    public static void validateUser(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            boolean result = edisql.validateUser("admin", "admin");
            if (result) {
                System.out.println("USER IS VALID");
            } else {
                System.out.println("Incorrect user");
            }
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void restorePassword(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.restorePassword("admin", "ADMIN");
        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getTeamsByCategory(EquipDataImplementationSQL edisql) {
        try {
            List<Team> teamsbycat = new ArrayList<>();

            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            teamsbycat = edisql.getTeamsByCategory("Cadet");

            for (Team t : teamsbycat) {
                System.out.println("\n=========================\n");
                t.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void ErrorMsg(Exception e) {
        System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
    }

    public static void deletePlayer(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.eliminarJugador("X620841H");
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void deleteTeam(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.deleteTeam("FcBarcelona");
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getAllCategories(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Category> catlist = new ArrayList<>();
            catlist = edisql.getCategorys();
            for (Category cat : catlist) {
                cat.mostrarDetalle();
                System.out.println("\n");
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void addNewTeam(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            edisql.addNewTeam("FcBarcelona", "D", "Juvenil", sdf.parse("2024-09-01"));
        } catch (Exception ex) {
            System.out.println("MENSAJE: " + ex.getMessage() + "\n" + "\nCAUSA: " + ex.getCause());
        } finally {
            closeDbConnection(edisql);
        }
    }

    public static void getTeamPlayers(EquipDataImplementationSQL edisql) {

        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Player> playerlist = new ArrayList<>();
            Date date = sdf.parse("2024-09-01");

            java.sql.Date oracldate = new java.sql.Date(date.getTime());
            System.out.println("ORCALE DATE: " + oracldate);
            playerlist = edisql.getTeamPlayers("Fc Olot Fem", oracldate);
            if (playerlist.isEmpty()) {
                System.out.println("list is empty");
            }
            for (Player play : playerlist) {
                System.out.println("\n=========================\n");
                play.mostrarJugDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getAllTeams(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Team> teamlist = new ArrayList<>();

            teamlist = edisql.getAllTeams();
            for (Team team : teamlist) {
                team.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getPlayers(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Player> playerlist = new ArrayList<>();

            playerlist = edisql.getPlayers();
            for (Player play : playerlist) {
                System.out.println("\n=========================\n");
                play.mostrarJugDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getTeamsSeaon(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Team> teamlist = new ArrayList<>();
            try {
                teamlist = edisql.getTeamsBySeason(sdf.parse("2024-09-01"));
            } catch (ParseException ex) {
                Logger.getLogger(TestSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Team team : teamlist) {
                System.out.println("\n=========================\n");
                team.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getSeasons(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            List<Season> seasonslist = new ArrayList<>();

            seasonslist = edisql.getSeasons();
            for (Season season : seasonslist) {
                System.out.println("\n=========================\n");
                season.mostrarDetalle();
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getPlayerByLegalId(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            Player player = edisql.getPlayerByLegalId("9999901J");
            player.mostrarJugDetalle();
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getTeamMemberCount(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            int count = edisql.getTeamMemCount("FcRoquetasMASC");
            System.out.println("COUNT: " + count);
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void removeTeam(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            edisql.removeTeamFromSeason("Fc Monalco");
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void checkPlayerHasTeam(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            boolean ans;
            ans = edisql.checkPlayerBelongsToTeam("9999902K");
            if (ans) {
                System.out.println("Player Belongs To A Team");
            } else {
                System.out.println("Player Is Not Part Of A Team");
            }
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void testGetPlayerTeam(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            Team team = edisql.getPlayerTeam("9999902K");
            team.mostrarDetalle();
        } catch (Exception e) {
            ErrorMsg(e);
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void filteredPlayersList(EquipDataImplementationSQL edisql) {
        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = sdf.parse("2016-04-03");

            List<Player> players = edisql.playerFilterSearch(null, null, null, "Juvenil", "birth_year");
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
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getTeamByName(EquipDataImplementationSQL edisql) {
        edisql = new EquipDataImplementationSQL();
        ConnectToDb(edisql);
        try {
            String dateString = "2024-09-01";
            Date date = sdf.parse(dateString);

            java.sql.Date oracldate = new java.sql.Date(date.getTime());
            Team team = edisql.getTeamByName("Fc Wildcats Masc", oracldate);
            team.mostrarDetalle();
        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        } finally {
            closeDbConnection(edisql);
        }

    }

    public static void getSeasonCatTeam(EquipDataImplementationSQL edisql) {

        try {
            edisql = new EquipDataImplementationSQL();
            ConnectToDb(edisql);
            String dateString = "2024-09-01";
            Date date = sdf.parse(dateString);
            List<Team> teams = edisql.getSeasonCategoryTeam("Cadet", date);
            for (Team team : teams) {
                System.out.println("---------------------------");
                team.mostrarDetalle();
            }

        } catch (Exception e) {
            System.out.println("MENSAJE: " + e.getMessage() + "\n" + "\nCAUSA: " + e.getCause());
        } finally {
            closeDbConnection(edisql);
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
                        createUser(edisql);
                        break;
                    case 3:
                        validateUser(edisql);
                        break;
                    case 4:
                        restorePassword(edisql);
                        break;
                    case 5:
                        getPlayerByLegalId(edisql);
                        break;
                    case 6:
                        deletePlayer(edisql);
                        break;
                    case 7:
                        getAllCategories(edisql);
                        break;
                    case 8:
                        addNewTeam(edisql);
                        break;
                    case 9:
                        deleteTeam(edisql);
                        break;
                    case 10:
                        getTeamsByCategory(edisql);
                        break;
                    case 11:
                        getTeamPlayers(edisql);
                        break;
                    case 12:
                        getPlayers(edisql);
                        break;
                    case 13:
                        editPlayer(edisql);
                        break;
                    case 14:
                        getSeasons(edisql);
                        break;
                    case 15:
                        getTeamsSeaon(edisql);
                        break;
                    case 16:
                        getTeamMemberCount(edisql);
                        break;
                    case 17:
                        removeTeam(edisql);
                        break;
                    case 18:
                        getAllTeams(edisql);
                        break;
                    case 19:
                        checkPlayerHasTeam(edisql);
                        break;
                    case 20:
                        testGetPlayerTeam(edisql);
                        break;
                    case 21:
                        filteredPlayersList(edisql);
                        break;
                    case 22:
                        getTeamByName(edisql);
                        break;
                    case 23:
                        getSeasonCatTeam(edisql);
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
