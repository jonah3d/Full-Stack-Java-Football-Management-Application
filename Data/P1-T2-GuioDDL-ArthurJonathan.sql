
drop table category cascade constraints;
drop table player cascade constraints;
drop table playerteam cascade constraints;
drop table season cascade constraints;
drop table usermg cascade constraints;
drop table team cascade constraints;

DROP DIRECTORY IMAGE_DIR;
drop table DefaultImages cascade constraints;
DROP FUNCTION GetDefaultPlayerImage;






CREATE TABLE USERMG (
  username VARCHAR2(50 CHAR),
  name VARCHAR2(50 CHAR),
  password VARCHAR2(40 CHAR),

  CONSTRAINT user_pk_usname PRIMARY KEY (username)
);

CREATE TABLE SEASON (
season_name VARCHAR2(10 CHAR),
  season_year DATE,

  CONSTRAINT season_pk_year PRIMARY KEY (season_year)
);


CREATE TABLE CATEGORY (
  id NUMBER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  name VARCHAR2(50 CHAR) UNIQUE,
  min_age NUMBER,
  max_age NUMBER,

  CONSTRAINT cat_pk_id PRIMARY KEY (id),
  CONSTRAINT chk_age CHECK (min_age <= NVL(max_age, 9999)),
  CONSTRAINT chk_min_age CHECK (min_age >= 0),
  CONSTRAINT chk_max_age CHECK (max_age >= 0)
);


CREATE TABLE TEAM (
  id NUMBER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  name VARCHAR2(50 CHAR),
  team_type VARCHAR2(1 CHAR),
  CATEGORY_name VARCHAR2(50 CHAR),
  season_year DATE,

  CONSTRAINT team_pk_id PRIMARY KEY (id),
  CONSTRAINT team_fk_cat FOREIGN KEY (CATEGORY_name) REFERENCES CATEGORY(name),
  CONSTRAINT team_fk_season FOREIGN KEY (season_year) REFERENCES SEASON(season_year),
  CONSTRAINT team_unique_name_season UNIQUE (name, season_year),
  CONSTRAINT chk_type CHECK (team_type IN ('H', 'D', 'M'))
);


CREATE TABLE PLAYER (
  id NUMBER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  name VARCHAR2(50 CHAR),
  surname VARCHAR2(50 CHAR),
  sex VARCHAR2(1 CHAR),
  birth_year Date,
  legal_id VARCHAR2(10 CHAR) UNIQUE,
  iban VARCHAR2(30 CHAR),
  direcion VARCHAR2(50 CHAR),
  codigo_postal VARCHAR2(10 CHAR),
  localidad VARCHAR2(30 CHAR),
  provincia VARCHAR2(30 CHAR),
  pais VARCHAR2(50 CHAR),
  photo BLOB,
  medical_rev_fin NUMBER(1),

  CONSTRAINT play_pk_id PRIMARY KEY (id),
  CONSTRAINT chk_sexe CHECK (sex IN ('H', 'D')),
  CONSTRAINT chk_med_rev CHECK (medical_rev_fin IN(0,1))
);


CREATE TABLE PLAYERTEAM (
  player NUMBER,
  team NUMBER,
  tit_con VARCHAR2(1 CHAR),
  season DATE,

  CONSTRAINT plyteam_pk PRIMARY KEY (player, team),
  CONSTRAINT plyteam_fk_player FOREIGN KEY (player) REFERENCES PLAYER(id),
  CONSTRAINT plyteam_fk_team FOREIGN KEY (team) REFERENCES TEAM(id),
  CONSTRAINT plyteam_fk_season FOREIGN KEY (season) REFERENCES SEASON(season_year)
);


CREATE INDEX idx_playertteam_player ON PLAYERTEAM(player);
CREATE INDEX idx_playertteam_team ON PLAYERTEAM(team);
CREATE INDEX idx_playertteam_player_season ON PLAYERTEAM(player, season);


CREATE OR REPLACE TRIGGER equip_elim_jug
BEFORE DELETE ON TEAM
FOR EACH ROW
DECLARE
  num_players NUMBER;
BEGIN
  SELECT COUNT(*) INTO num_players FROM PLAYERTEAM WHERE team = :OLD.id;
  IF num_players > 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'No Se Puede Eliminar Equipos Con Jugadores Asignadas.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER equip_jug_gen
BEFORE INSERT OR UPDATE ON PLAYERTEAM
FOR EACH ROW
DECLARE
  v_team_type VARCHAR(2 CHAR);
  v_player_sex VARCHAR(2 CHAR);
BEGIN
  SELECT team_type INTO v_team_type FROM TEAM WHERE id = :NEW.team;
  SELECT sex INTO v_player_sex FROM PLAYER WHERE id = :NEW.player;

  IF (v_team_type = 'H' AND v_player_sex != 'H') OR (v_team_type = 'D' AND v_player_sex != 'D') THEN
    RAISE_APPLICATION_ERROR(-20002, 'Jugador No Coincide Con El Tipo De Equipo.');
  END IF;
END;
/
CREATE OR REPLACE TRIGGER EQUIP_JUG_ANO
BEFORE INSERT OR UPDATE ON PLAYERTEAM
FOR EACH ROW
DECLARE
    v_age NUMBER;
    v_category_expected VARCHAR2(50);
    v_category_actual VARCHAR2(50);
    v_team_type CHAR(1);
    v_season_start DATE;
BEGIN

    SELECT t.category_name, t.team_type
    INTO v_category_actual, v_team_type
    FROM TEAM t
    WHERE t.id = :NEW.team;

    SELECT s.season_year
    INTO v_season_start
    FROM SEASON s
    WHERE s.season_year = :NEW.season;


    SELECT FLOOR(MONTHS_BETWEEN(v_season_start, p.birth_year) / 12)
    INTO v_age
    FROM PLAYER p
    WHERE p.id = :NEW.player;


    IF v_age BETWEEN 7 AND 8 THEN
        v_category_expected := 'Benjamí';
    ELSIF v_age BETWEEN 9 AND 11 THEN
        v_category_expected := 'Aleví';
    ELSIF v_age BETWEEN 12 AND 13 THEN
        v_category_expected := 'Infantil';
    ELSIF v_age BETWEEN 14 AND 15 THEN
        v_category_expected := 'Cadet';
    ELSIF v_age BETWEEN 16 AND 17 THEN
        v_category_expected := 'Juvenil';
    ELSIF v_age BETWEEN 18 AND 21 THEN
        v_category_expected := 'Senior';
    ELSE
        RAISE_APPLICATION_ERROR(-20003, 'Jugador No Tiene La Edad Requerida');
    END IF;


    IF v_category_expected != v_category_actual THEN
        RAISE_APPLICATION_ERROR(-20003, 'Jugador No Pertenece a La Categoría Esperada');
    END IF;
END;
/



CREATE OR REPLACE TRIGGER equip_tit
BEFORE INSERT OR UPDATE ON PLAYERTEAM
FOR EACH ROW
DECLARE
  v_count NUMBER;
  v_team_category_name VARCHAR2(50 CHAR);
  v_existing_team_category_name VARCHAR2(50 CHAR);
BEGIN

  SELECT CATEGORY_name INTO v_team_category_name
  FROM TEAM
  WHERE id = :NEW.team;

  BEGIN
    SELECT t.CATEGORY_name INTO v_existing_team_category_name
    FROM TEAM t
    WHERE t.id = (
      SELECT pt.team
      FROM PLAYERTEAM pt
      WHERE pt.player = :NEW.player
        AND pt.season = :NEW.season
        AND pt.tit_con = 'T'
      FETCH FIRST ROW ONLY
    );
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      v_existing_team_category_name := NULL;
  END;


  IF v_existing_team_category_name IS NULL THEN
    RETURN;
  END IF;


  IF :NEW.tit_con = 'T' THEN

    SELECT COUNT(*) INTO v_count
    FROM PLAYERTEAM pt
    JOIN TEAM t ON pt.team = t.id
    WHERE pt.player = :NEW.player
      AND pt.season = :NEW.season
      AND pt.tit_con = 'T'
      AND t.CATEGORY_name = v_team_category_name;

    IF v_count > 0 THEN
      RAISE_APPLICATION_ERROR(-20004, 'Jugador solo puede ser titular en un solo equipo de la misma categoria en la temporada.');
    END IF;
  END IF;


  IF :NEW.tit_con = 'C' THEN

    IF v_team_category_name < v_existing_team_category_name THEN
      RAISE_APPLICATION_ERROR(-20005, 'Un jugador solo puede ser convocado en equipos de la misma categoria o superior.');
    END IF;
  END IF;
END;
/

CREATE OR REPLACE DIRECTORY IMAGE_DIR AS 'C:\Users\isard\Documents\RecursosOracle';
GRANT READ ON DIRECTORY IMAGE_DIR TO PUBLIC;

CREATE TABLE DefaultImages (
  id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR2(50 CHAR),
  photo BLOB
);

DECLARE
  l_blob BLOB;
  l_bfile BFILE := BFILENAME('IMAGE_DIR', 'cat.png');
BEGIN
  INSERT INTO DefaultImages (name, photo)
  VALUES ('DefaultPlayerImage', EMPTY_BLOB())
  RETURNING photo INTO l_blob;

  DBMS_LOB.FILEOPEN(l_bfile, DBMS_LOB.FILE_READONLY);
  DBMS_LOB.LOADFROMFILE(l_blob, l_bfile, DBMS_LOB.GETLENGTH(l_bfile));
  DBMS_LOB.FILECLOSE(l_bfile);

  COMMIT;
END;
/
CREATE OR REPLACE FUNCTION GetDefaultPlayerImage RETURN BLOB IS
  l_photo BLOB;
BEGIN
  -- Attempt to fetch the photo
  SELECT photo INTO l_photo
  FROM DefaultImages
  WHERE name = 'DefaultPlayerImage';

  -- Return the photo if found
  RETURN l_photo;

EXCEPTION
  WHEN NO_DATA_FOUND THEN

    RAISE_APPLICATION_ERROR(-20001, 'Default player image not found.');
  WHEN OTHERS THEN

    RETURN NULL;
 
END;
   
/
    COMMIT;

