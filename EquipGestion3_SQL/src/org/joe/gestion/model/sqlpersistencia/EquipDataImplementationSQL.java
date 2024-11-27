/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joe.gestion.model.sqlpersistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import oracle.sql.BLOB;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleConnection;
import org.apache.commons.codec.digest.DigestUtils;
import org.joe.gestion.model.data.Category;
import org.joe.gestion.model.data.Player;
import org.joe.gestion.model.data.Team;
import org.joe.gestion.model.persistence.EquipDataInterface;
import org.joe.gestion.model.persistence.EquipDataInterfaceException;

/**
 *
 * @author jonah
 */
public class EquipDataImplementationSQL implements EquipDataInterface {
    
    Connection con;
    PreparedStatement userPreparedStatement;
    PreparedStatement uservalidation;
    PreparedStatement restorepassword;
    PreparedStatement getplaybyid;
    PreparedStatement addnewplayps;
    PreparedStatement deletplayer;
    PreparedStatement playersbyyear;
    PreparedStatement playerbyname;
    PreparedStatement editplayer;
    PreparedStatement newteam;
    PreparedStatement teambyCat;
    PreparedStatement teamtype;
    PreparedStatement teamSea;
    PreparedStatement teamPlyers;
    PreparedStatement delteam;
    PreparedStatement newSeasonDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    
    public EquipDataImplementationSQL(){
      this("config.properties");
    }
    
    public EquipDataImplementationSQL(String configurationfile){
        if(configurationfile == null || configurationfile.equals("")){
            throw new EquipDataInterfaceException("The Configuration File Name Does Not Exists Or Is Null");
        }
        
        boolean answer = connectDatasource(configurationfile);
        if(answer) System.out.println("Connection Established");
    }
    
    public boolean connectDatasource(String filename){
        
           Properties propfile = new Properties();
        
        try {
            propfile.load(new FileInputStream(filename));
            
        } catch (FileNotFoundException ex) {
           throw new EquipDataInterfaceException("The properties file " + filename + " wasn't found");
        } catch (IOException ex) {
            throw new EquipDataInterfaceException("Error loading the provided properties file");
        }
        
        String url = propfile.getProperty("url");
        String password = propfile.getProperty("password");
        String user = propfile.getProperty("username");
        

        try {
            con = DriverManager.getConnection(url, user, password);
          //  con.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable To Establish Connection To The Defined Database",ex.getCause());
        }

		return true;
    }
    
    public boolean disconnectDatasource(){
     
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
               throw new EquipDataInterfaceException("Datasource Wasn't Able To close");
                
            }finally{
                con = null;
            }
        }
        
        return true;
    }
    
    private Player getPlayer(ResultSet rs){
        
        try {
            if (rs.next()) {
                Integer playerid = rs.getInt("id");
                
                String name = rs.getString("name");
                if(rs.wasNull()){
                    name = "";
                }
                
                String surname = rs.getString("surname");
                if(rs.wasNull()){
                    surname = "";
                }
                
                String legalId = rs.getString("legal_id");
                if(rs.wasNull()){
                    legalId = "";
                }
                String sexe =  rs.getString("sex");
                if(rs.wasNull()){
                    sexe = "";
                }
                Date datebirth = rs.getDate("birth_year");
                if(rs.wasNull()){
                    datebirth = null;
                }
                
                String iban = rs.getString("iban");
                if(rs.wasNull()){
                    iban = "";
                }
                
                String address = rs.getString("address");
                if(address==null){
                    address = "";
                }
                
                Date medicalfin = rs.getDate("medical_rev_fin");
                if(rs.wasNull()){
                    medicalfin = null;
                }
               
                Blob photo = rs.getBlob("photo");
                if(rs.wasNull()){
                    photo = null;
                }
                
                return new Player(name, surname, sexe, datebirth, legalId, iban, address, photo, medicalfin);
            }else{
                throw new EquipDataInterfaceException("Query returned with zero players");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable To get Player(s)");
        }
    }
    private List<Player> getPlayers(ResultSet rs){
        
        List<Player> players = new ArrayList<>();
        
                try {
           while(rs.next()) {
                Integer playerid = rs.getInt("id");
                
                String name = rs.getString("name");
                if(rs.wasNull()){
                    name = "";
                }
                
                String surname = rs.getString("surname");
                if(rs.wasNull()){
                    surname = "";
                }
                
                String legalId = rs.getString("legal_id");
                if(rs.wasNull()){
                    legalId = "";
                }
                String sexe =  rs.getString("sex");
                if(rs.wasNull()){
                    sexe = "";
                }
                Date datebirth = rs.getDate("birth_year");
                if(rs.wasNull()){
                    datebirth = null;
                }
                
                String iban = rs.getString("iban");
                if(rs.wasNull()){
                    iban = "";
                }
                
                String address = rs.getString("address");
                if(address==null){
                    address = "";
                }
                
                Date medicalfin = rs.getDate("medical_rev_fin");
                if(rs.wasNull()){
                    medicalfin = null;
                }
               
                Blob photo = rs.getBlob("photo");
                if(rs.wasNull()){
                    photo = null;
                }
                
                 Player play = new Player(name, surname, sexe, datebirth, legalId, iban, address, photo, medicalfin);
                 players.add(play);
                 
                 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable To get Players");
        }
                return players;
    }
    
private List<Team> getTeams(ResultSet rs) {
    List<Team> teams = new ArrayList<>();
    try {
        while (rs.next()) {  
            Integer teamId = rs.getInt("ID");
            String teamName = rs.getString("NAME");
            String teamType = rs.getString("TEAM_TYPE");
            String teamCatName = rs.getString("CATEGORY_NAME");
            Date teamSeason = rs.getDate("SEASON_YEAR");

           
            teamName = teamName == null ? "" : teamName;
            teamType = teamType == null ? "" : teamType;
            teamCatName = teamCatName == null ? "" : teamCatName;

           
            Team nteam = new Team(teamName, teamSeason, teamCatName, teamType);
            teams.add(nteam);
        }

        if (teams.isEmpty()) {
            System.out.println("No teams found in ResultSet.");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new EquipDataInterfaceException("Unable to get teams.");
    }
    return teams;
}

    
    private Team getTeam(ResultSet rs){
        
        try{
            
          if(rs.next()){
              
            Integer teamid =  rs.getInt("ID");
            if(rs.wasNull()){
                teamid = null;
            }
            
            String teamname = rs.getString("Name");
            if(rs.wasNull()){
                teamname = "";
            }
              String teamType = rs.getString("TEAM_TYPE");
                if(rs.wasNull()){
                    teamType = "";
                }
                String teamCatName = rs.getString("CATEGORY_NAME");
                if(rs.wasNull()){
                    teamCatName = "";
                }
                Date teamSeason = rs.getDate("Season_year");
                if(rs.wasNull()){
                    teamSeason = null;
                }
                
              Team nteam = new Team(teamname, teamSeason, teamCatName, teamType);
              nteam.setId(teamid);
              return nteam;
              
          }else{
                throw new EquipDataInterfaceException("Query returned with no team");
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable To get Player(s)");
        }
    }

@Override
public boolean createUser(String username, String name,String password) {

    String hashedPassword = DigestUtils.sha1Hex(password);
    String query = "INSERT INTO USERMG (USERNAME,NAME, PASSWORD) VALUES (?, ?,?)";

    
    try  {
        userPreparedStatement = con.prepareStatement(query); 
        userPreparedStatement.setString(1, username);
        userPreparedStatement.setString(2, name);
        userPreparedStatement.setString(3, hashedPassword);

        userPreparedStatement.executeUpdate();
        return true;
      
        
    } catch (SQLException ex) {
       
        System.out.println(ex.getMessage());
        throw new EquipDataInterfaceException("Failed To Insert New User");
    }


}


@Override
public boolean validateUser(String username, String password) {
    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
        throw new EquipDataInterfaceException("The username or password entered is null or empty");
    }

    String hashedPassword = DigestUtils.sha1Hex(password); 
   

    String query = "SELECT username, password FROM usermg WHERE username = ?";

    try {
        uservalidation = con.prepareStatement(query);
        uservalidation.setString(1, username);
        ResultSet rs = uservalidation.executeQuery();

       
        if (rs.next()) {
            String storedPassword = rs.getString("password");

            if (hashedPassword.equals(storedPassword)) {
                return true;  
            } else {
                throw new EquipDataInterfaceException("Invalid Password");
            }
        } else {
            throw new EquipDataInterfaceException("Invalid Username");
        }
    } catch (SQLException ex) {
        
        System.err.println("Error executing query: " + ex.getMessage());
        throw new EquipDataInterfaceException("Database error during validation", ex);
    }
}



@Override
public void restorePassword(String username, String password) {
    if (username == null || username.isBlank()) {
        throw new EquipDataInterfaceException("The username is null or empty");
    }

    
   String hashedpasString = DigestUtils.sha1Hex(password); 

    String query = "UPDATE USERMG SET PASSWORD = ? WHERE USERNAME = ?";

    try  {
        restorepassword = con.prepareStatement(query);
        restorepassword.setString(1, hashedpasString);
        restorepassword.setString(2, username);

        int result = restorepassword.executeUpdate();

        if (result > 0) {
            System.out.println("Password Restored Successfully");
        } else {
          
            throw new EquipDataInterfaceException("Username not found. Password restore failed.");
        }

    } catch (SQLException ex) {
        
        System.err.println("Error while restoring password: " + ex.getMessage());
        throw new EquipDataInterfaceException("Couldn't restore password. Please try again later.", ex);
    }
}


     @Override
public Player getPlayerByLegalId(String legalID) {
  
    if (legalID == null || legalID.isEmpty()) {
        throw new EquipDataInterfaceException("The legal ID provided is null or empty");
    }

 
    String query = "SELECT * FROM player WHERE legal_id = ?";

    try {
        getplaybyid = con.prepareStatement(query);
        getplaybyid.setString(1, legalID);
        
 

        ResultSet rs = getplaybyid.executeQuery();
            if (rs.next()) {
                Integer playerid = rs.getInt("id");
                
                String name = rs.getString("name");
                if(rs.wasNull()){
                    name = "";
                }
                
                String surname = rs.getString("surname");
                if(rs.wasNull()){
                    surname = "";
                }
                
                String legalId = rs.getString("legal_id");
                 if(rs.wasNull()){
                    legalId = "";
                }
                  String sexe =  rs.getString("sex");
                 if(rs.wasNull()){
                     sexe = "";
                 }
                Date datebirth = rs.getDate("birth_year");
                if(rs.wasNull()){
                   datebirth = null;
                }
                
                String iban = rs.getString("iban");
                if(rs.wasNull()){
                    iban = "";
                }
                
                String address = rs.getString("address");
                if(address==null){
                    address = "";
                }
                
                Date medicalfin = rs.getDate("medical_rev_fin");
                if(rs.wasNull()){
                    medicalfin = null;
                }
               
                Blob photo = rs.getBlob("photo");
                if(rs.wasNull()){
                    photo = null;
                }
                
                return new Player(name, surname, sexe, datebirth, legalId, iban, address, photo, medicalfin);
            }else{
               throw new EquipDataInterfaceException("Supplied ID Doesn't Correspond To An ID Of Any Player");
            }
        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        throw new EquipDataInterfaceException("Unable to retrieve player by legal ID");
    }

  

}

 

    @Override
    public List<Player> getPlayersByCat(String cat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Player> getPlayerByBirthYear(Date date) {
       
        if(date==null){
            throw new EquipDataInterfaceException("Date Can't Be Null");
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        
        String query = "SELECT * FROM PLAYER WHERE EXTRACT(YEAR FROM BIRTH_YEAR) = ?"
                + " ORDER BY BIRTH_YEAR";
        
        try {
            playersbyyear = con.prepareStatement(query);
            playersbyyear.setInt(1, year);
            
            ResultSet rs =  playersbyyear.executeQuery();
             return getPlayers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Error Trying To Retrieve The Players");
        }
        
    }

    @Override
    public List<Player> getPlayerByName(String Name) {
        if(Name.equals("") || Name == null){
              throw new EquipDataInterfaceException("Name Can't Be Null or Empty");
        }
        
        String query = "SELECT * FROM PLAYER WHERE UPPER(NAME) = UPPER(?) ORDER BY SURNAME ASC";
        
        try {
            playerbyname = con.prepareStatement(query);
            playerbyname.setString(1, Name);
            
            ResultSet rs = playerbyname.executeQuery();
            
            return getPlayers(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             throw new EquipDataInterfaceException("Error Trying To Retrieve The Players");
        }
    }
    
    @Override
    public List<Player> getPlayerBySurname(String surname){
               if(surname.equals("") || surname == null){
              throw new EquipDataInterfaceException("Surname Can't Be Null or Empty");
        }
        
        String query = "SELECT * FROM PLAYER WHERE UPPER(SURNAME) = UPPER(?) ORDER BY NAME ASC";
        
        try {
            playerbyname = con.prepareStatement(query);
            playerbyname.setString(1, surname);
            
            ResultSet rs = playerbyname.executeQuery();
            
            return getPlayers(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             throw new EquipDataInterfaceException("Error Trying To Retrieve The Players");
        }
    }

    @Override
    public void addNewPlayer(Player player) {
             if(player == null ){
          throw new EquipDataInterfaceException("The Player Is Null");
      }
      
      String newplayerQuery = "Insert into Player (name,surname,sex,birth_year,"
              + "legal_id,iban,address,photo,medical_rev_fin) values "
              + "(?,?,?,?,?,?,?,?,?)";
      
        try {
          addnewplayps = con.prepareStatement(newplayerQuery);
                    
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable to create prepared statement for new player");
        }
        
        try {
            addnewplayps.setString(1, player.getName());
            addnewplayps.setString(2, player.getSurname());
            addnewplayps.setString(3, String.valueOf(player.getSex()));
            
            java.util.Date utilDate = player.getBirth_year();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            addnewplayps.setDate(4, sqlDate);
            
            addnewplayps.setString(5, player.getLegal_id());
            addnewplayps.setString(6, player.getIban());
            addnewplayps.setString(7, player.getAddress());
           
           Blob imageBlob = player.getImage();
            if (imageBlob != null) {
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                OracleConnection oracleCon = (OracleConnection) con; 
                BLOB oracleBlob = BLOB.createTemporary(oracleCon, true, BLOB.DURATION_SESSION);
                oracleBlob.setBytes(1, imageBytes);
                addnewplayps.setBlob(8, oracleBlob);
            }

            utilDate = player.getMedical_rev_fin();
            sqlDate =new java.sql.Date(utilDate.getTime());
            addnewplayps.setDate(9,sqlDate);
 
            int result = addnewplayps.executeUpdate();
            if(result>1){
                System.out.println("Player Added Successfully");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Unable To Insert New Player");
        } 
        
        
    }

    @Override
    public void eliminarJugador(String legalID) {
         if(legalID == null ){
          throw new EquipDataInterfaceException("The ID Field Can't Be Null");
         }
         
         String query  = "DELETE FROM PLAYER WHERE LEGAL_ID = ?";
         
        try {
            deletplayer = con.prepareStatement(query);
            deletplayer.setString(1, legalID);
           int results =  deletplayer.executeUpdate();
           
           
        if (results > 0) {
            System.out.println("Player with legal ID " + legalID + " has been successfully deleted.");
        } else {
            throw new EquipDataInterfaceException("No player found with legal ID " + legalID);
        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Somthing Went Wrong Trying To Create The Delete Statement");
        }
        
        
        
         
    }

    @Override
    public void editarJugador(String legalID) {
         if(legalID == null ){
          throw new EquipDataInterfaceException("The ID Field Can't Be Null");
         }
         
         String query = "UPDATE PLAYER";
         
        try {
            editplayer = con.prepareStatement(query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Error Trying Update Player");
        }
    }

    @Override
    public List<Category> getCategorys(){
        List<Category> categories = new ArrayList<>();
        
        try {
            String query = "Select * from category";
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                
                Integer catId = rs.getInt("id");
                
                String catname = rs.getString("name");
                if(catname == null){
                    catname = "";
                }
               
                Integer catminage = rs.getInt("min_age");
               if(catminage==0){
                    catminage=null;
                }
                
                Integer catmaxage = rs.getInt("max_age");
                 if(catmaxage==0){
                    catmaxage=null;
                }
                  
                  Category cat = new Category(catname, catminage.intValue(), catmaxage.intValue());
                  cat.setId(catId);
                  categories.add(cat);
            }
            
            return categories;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Couldn't Retrieve The Categories");
        }
    }
    
    @Override
    public List<Team> getTeamsByCategory(String cat) {
        
        
          if(cat.equals("") || cat == null){
              throw new EquipDataInterfaceException("Category Can't Be Null or Empty");
        }
          String query = "SELECT * FROM Team WHERE UPPER(CATEGORY_NAME) = UPPER(?)";
          
            try {
            teambyCat = con.prepareStatement(query);
            teambyCat.setString(1, cat);
            
            ResultSet rs = teambyCat.executeQuery();
            
            return getTeams(rs);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             throw new EquipDataInterfaceException("Error Trying To Retrieve The Teams By Categories");
        }
            
    }

    @Override
public List<Team> getTeamsByType(String type) {
   
    if (type == null || type.length() > 1) {
        throw new EquipDataInterfaceException("Introduced Type Is Null Or More Than 1 Character");
    }

   
String query = "SELECT * FROM TEAM WHERE TEAM_TYPE = '" + type + "'";
    ResultSet rs = null;
    try {

        Statement stm = con.createStatement();
       rs = stm.executeQuery(query);
       return getTeams(rs);
   

      
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        throw new EquipDataInterfaceException("Error Getting Teams By Type " + type);
    }
}



    @Override
    public void addNewTeam(String name, String teamtype, String cat_name, Date  seasondate) {
       if(name==null || name.isBlank() || cat_name == null || seasondate == null 
             ){
           throw new EquipDataInterfaceException("Invalid Input For Creating A new Team");
       }
       
       String query = "Insert into team(name,team_type,category_name,season_year)"
               + " values (?,?,?,?)";
       
        try {
            newteam = con.prepareStatement(query);
            newteam.setString(1, name);
            newteam.setString(2, teamtype);
            newteam.setString(3, cat_name);
            
            java.util.Date utildate = seasondate;
            java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
            newteam.setDate(4,sqldate);
            
            int result = newteam.executeUpdate();
            if(result==1){
                System.out.println("Team Added Successfully");
            }else{
                System.out.println("Failed To Add  Team");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Error Making A New Team");
        }

    }

    @Override
    public List<Player> getTeamPlayers(String teamName) {
        if(teamName == null){
              throw new EquipDataInterfaceException("team name Can't Be Null or Empty");
        }        
        String query = "SELECT p.* " +
               "FROM PLAYERTEAM pt " +
               "JOIN PLAYER p ON pt.player = p.id " +
               "JOIN TEAM t ON pt.team = t.id " +
               "WHERE t.name = ?";

        try {
            teamPlyers = con.prepareStatement(query);
            teamPlyers.setString(1, teamName);
            ResultSet rs = teamPlyers.executeQuery();
            
            return getPlayers(rs);

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        throw new EquipDataInterfaceException("Error Getting Players Of Team " + teamName);
        }
   
    }

    @Override
    public void addPlayerToTeam(String LegalID) {
        
    }

    @Override
    public void deletePlayerFromTeam(String legalID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteTeam(String name) {
              if(name == null ){
          throw new EquipDataInterfaceException("The Name Field Can't Be Null");
         }
         
         String query  = "DELETE FROM TEAM WHERE NAME = ?";
         
        try {
            delteam = con.prepareStatement(query);
            delteam.setString(1, name);
           int results =  delteam.executeUpdate();
           
           
        if (results > 0) {
            System.out.println("Team with name " + name + " has been successfully deleted.");
        } else {
            throw new EquipDataInterfaceException("No player found with legal ID " + name);
        }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new EquipDataInterfaceException("Somthing Went Wrong Trying To Create The Delete Statement");
        }
        
        
    }

   @Override
public void addNewSeason(String season_n, Date date) {

    if (season_n == null || season_n.isEmpty()) {
        throw new EquipDataInterfaceException("Season name can't be null or empty.");
    }
    if (date == null) {
        throw new EquipDataInterfaceException("Season date can't be null.");
    }

   
    String query = "INSERT INTO SEASON (season_year) VALUES (?)";

    try {
       
         newSeasonDate = con.prepareStatement(query);
            newSeasonDate.setDate(1, (java.sql.Date) date);

        
        newSeasonDate.executeUpdate();
        System.out.println("New season " + season_n + " added successfully with date " + date);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        throw new EquipDataInterfaceException("Error adding new season " + season_n);
    }
}


    @Override
    public void removeSeason(String season_n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeTeamFromSeason(String t_name) {
        
    }

    @Override
    public List<Team> getSeasonTeams(String season_n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
