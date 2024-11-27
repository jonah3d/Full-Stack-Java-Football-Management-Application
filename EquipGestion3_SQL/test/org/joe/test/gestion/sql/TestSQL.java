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
import org.joe.gestion.model.data.Team;

/**
 *
 * @author jonah
 */
public class TestSQL {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void ADDNEWPLAYER(){
           EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
         Player p1 = new Player();
         p1.setName("Santiago");
         p1.setSurname("lopez");
         p1.setSex("H");
        try {
            p1.setBirth_year(sdf.parse("2001-09-05"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        p1.setLegal_id("ID895");
        p1.setIban("ES76 1234 5555 9520 2345 6820");
        p1.setAddress("Travessia del valles 11");
        try {
            p1.setMedical_rev_fin(sdf.parse("2025-09-15"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
       
             try{
        FileInputStream fis = new FileInputStream(new File("testfoto.png"));
        
        Blob blob = createBlobFromInputStream(fis);
        
         p1.setImage(blob);
         }catch (FileNotFoundException ex) {
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
    private static Blob createBlobFromInputStream(InputStream is) throws SQLException, IOException {
        byte[] bytes = is.readAllBytes();
        return new SerialBlob(bytes);
    }
    

    
    public static void CREATEUSER(){
         EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
         implementationSQL.createUser("admin", "joe","admin");
    }
    
    public static void VALIDATEUSER(){
         EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
         
         boolean result = isql.validateUser("admin", "admin");
         if(result){
             System.out.println("USER IS VALID");
         }else{
             System.out.println("Incorrect user");
         }
    }
    
    public static void RESTOREPASS(){
            EquipDataImplementationSQL isql = new EquipDataImplementationSQL();
            isql.restorePassword("admin", "ADMIN");
            
    }
    
    public static void GETPLAYERBYLEGALIID(){
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        Player player = implementationSQL.getPlayerByLegalId("ID018");
        
       player.mostrarJugDetalle();
    }
    

           public static void GETTEAMSBYCAT(){
           List<Team> teamsbycat = new ArrayList<>();
           
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        teamsbycat = implementationSQL.getTeamsByCategory("Cadet");
        
        for(Team t : teamsbycat){
           System.out.println("\n=========================\n");
              t.mostrarDetalle();
        }
        
      
    }
       
public static void GETTEAMSBYTYE() {
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

    
    public static void DELETEPLAYER(){
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        
        implementationSQL.eliminarJugador("ID01");
    }
    
     public static void DELETETEAM(){
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        
        implementationSQL.deleteTeam("FcBarcelona");
    }
    
    public static void PLAYSBYYEAR(){
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        String dateuser = ("2007-01-25");
        List<Player> playerlist = new ArrayList<>();
        
        try {
          playerlist =   implementationSQL.getPlayerByBirthYear(sdf.parse(dateuser));
          
          for(Player play:playerlist){
              System.out.println("\n=========================\n");
              play.mostrarJugDetalle();
          }
          
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void GETPLAYERSBYNAME(){
       EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
       List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerByName("Pedro");
            for(Player play:playerlist){
              System.out.println("\n=========================\n");
              play.mostrarJugDetalle();
          }
        

    }
    
    public static void GETPLAYERSBYSURNAME(){
       EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
       List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getPlayerBySurname("Lopez");
            for(Player play:playerlist){
              System.out.println("\n=========================\n");
              play.mostrarJugDetalle();
          }
        

    }
    
   public static void GETALLCATEGORIES(){
      EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
       List<Category> catlist = new ArrayList<>();
     catlist = implementationSQL.getCategorys();
      for(Category cat:catlist){
          cat.mostrarDetalle();
          System.out.println("\n");
      }
   }     
   
   public  static void ADDNEWTEAM(){
        EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
        try {
            implementationSQL.addNewTeam("FcBarcelona", "D", "Juvenil", sdf.parse("2024-09-01"));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
   }
   
   public static void PLAYERSTEAM(){
       
           EquipDataImplementationSQL implementationSQL = new EquipDataImplementationSQL();
       List<Player> playerlist = new ArrayList<>();

        playerlist = implementationSQL.getTeamPlayers("FcCanPalladesMIX");
            for(Player play:playerlist){
              System.out.println("\n=========================\n");
              play.mostrarJugDetalle();
          }
   }
        
    public static void main(String[] args) {
          
     
        
        
     //ADDNEWPLAYER();
      //CREATEUSER();
      //VALIDATEUSER();
      //RESTOREPASS();
      //GETPLAYERBYLEGALIID();
     // DELETEPLAYER();
      //PLAYSBYYEAR();
      //GETPLAYERSBYNAME();
      //GETPLAYERSBYSURNAME();
     //GETALLCATEGORIES();
     //ADDNEWTEAM();
     DELETETEAM();
     //GETTEAMSBYCAT();
     //GETTEAMSBYTYE();
     //PLAYERSTEAM();
    }


    
}
