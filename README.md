# Fullstack Java Based Team Management Application

During my second year associate degree in software development. We the students had to create
three projects through the course of the first year. This project is the first project and 
it is an individual project.

## Project Brief

This initial individual project, titled **EsportManager**, requires the development of a desktop application to manage a sports club. The application's main purpose is to handle player information, create teams for different seasons and categories, and assign players to those teams.

Key functional requirements for the application include:

* **Authentication**: Users must log in with a username and password. These credentials will be predefined in the database, with passwords encrypted using the SHA-1 hash algorithm.
* **Player Management**: The system will support full CRUD (Create, Read, Update, Delete) operations for player profiles.
    * Player data includes NIF, name, surname, date of birth, gender, address, medical check status, bank account, and a photograph.
    * The system must automatically determine a player's category (e.g., Benjamí, Aleví, Infantil) based on their date of birth.
    * A list view of players must be available, with options to filter by name, NIF, and date of birth, and to sort by last name or date of birth.
* **Team Management**: The application will allow for the creation, editing, and deletion of teams.
    * Teams are defined by a name and a category (e.g., Infantil femení, Aleví masculí).
    * The team list must be grouped by category and be filterable by season.
* **Player Assignment**: There are specific rules for assigning players to teams:
    * A player can be a member of multiple teams. However, they can only be a "titular" (main player) in one team within their own age category; in all other teams, they are designated as a "convidat" (guest).
    * The player's gender must be compatible with the team's gender designation (masculine, feminine, or mixed).
    * A player can be assigned to a team of their own category or one category higher, but never to a lower one.
* **Data Export and Reporting**:
    * The application must be able to export a complete list of players and their team memberships into XML and CSV formats.
    * A report generated with Jasper Reports is required, showing a list of teams and their players, which can be filtered by category.


## Architectural Overview
Inside the data folder, there is a photo file named VistaUML.png that contains the UML and dependencies of the P1-T7-Arthur Jonathan project. This file will provide you with a panoramic view of the entire project flow.

As I am a big fan of the MVC architecture, and because this is a CRUD* application, there was no alternative that would give me clean code and also the room to grow like MVC does. MVC works perfectly with dependency injection.

**The application's source code consists of 4 modules (projects).**
* Model
* Persistence Interface
* Oracle Data Access
* View

### Model

The P1-T7-Model-Arthur Jonathan project contains entity classes that are directly translated from the database tables and their columns. It provides getter and setter methods to restrict usage and correctly ensure that the right values are passed to each class, which in turn are translated to 
the database. This project also contains helper classes that assist in translating data to XML via JAXB annotations. A JavaDoc is provided in this project that gives detailed information about each class property and method.


### Persistence Interface

The interface project, named P1-T7-Interficie Persistencia, contains two classes that define the methods the application will use to interact with the database and the definition of the exception that will be thrown when something goes wrong. The methods are also documented to provide more 
information about the use and purpose of each method.

### Data Access

This application stores its data in a relational database using Oracle Database. This project, P1-T7-Capa Oracle-Arthur Jonathan, contains a class that implements the aforementioned interface to persist that data in Oracle. The database properties are stored in a properties file. All methods 
that use a PreparedStatement close their PreparedStatement after use, including any ResultSet that may be in use.

### View

This is the project that combines the other three projects to create the application. It is responsible for defining the creation of the controllers that the user interacts with, which in turn change the view. The view for this application is made with Java Swing.


## Setting Up The Project
The data folder contains the ddl and dml files that you can use to create the database and populate it with the initial data. The ddl file contains the tables and their columns, while the dml file contains the initial data that will be used to test the application.
The database is created in Oracle Database, so you will need to have it installed and configured on your machine. You can use the Oracle SQL Developer tool to run the ddl and dml files. If you 
want to use another database, you will need to modify the ddl and persistence interface and the data access project to use the appropriate database driver and connection string.
The project was made with Java 17 in Netbeans IDE. The Jars used in the project are in the Jars folder. You will need to add them to the project in order to run it. Flatlaf is used for the look and feel of the application, so you will need to add it to the project as well.

**Config.properties** contains the url, user, and password for the database connection. 
You will need to modify this file to match your database configuration.

Jasper.properties contains the path to the Jasper Reports template that is used to generate the report. 
You will need to modify this file to match your template path. Also the user and password.

## Running the Application Demo
[![Watch the video](https://img.youtube.com/vi/pzZ8VhWGeqs/maxresdefault.jpg)](https://youtu.be/pzZ8VhWGeqs)

### [Watch this video on YouTube](https://youtu.be/pzZ8VhWGeqs)
