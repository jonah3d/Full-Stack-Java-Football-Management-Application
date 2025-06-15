INSERT INTO SEASON (season_name,season_year) VALUES ('22/23',TO_DATE('01-09-2022', 'DD-MM-YYYY'));
INSERT INTO SEASON (season_name,season_year) VALUES ('23/24',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO SEASON (season_name,season_year) VALUES ('24/25',TO_DATE('01-09-2024', 'DD-MM-YYYY'));


INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Benjamí', 7, 8);
INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Aleví', 9, 11);
INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Infantil', 12, 13);
INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Cadet', 14, 15);
INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Juvenil', 16, 17);
INSERT INTO CATEGORY (name, min_age, max_age) VALUES ('Senior', 18, 21);



--2022
--NO TEAMS

-- 2023/2024
-- TEAMS
                                                        -- Benjami
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Wildcats Masc', 'H', 'Benjamí', TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Brighstars Fem', 'D', 'Benjamí', TO_DATE('01-09-2023', 'DD-MM-YYYY'));

                                                        -- Alevi
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Skylarks Masc', 'H', 'Aleví', TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Pioneers Mix', 'M', 'Aleví', TO_DATE('01-09-2023', 'DD-MM-YYYY'));

                                                        -- Infantil
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Lighting Mix', 'M', 'Infantil', TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Moonwalkers Fem', 'D', 'Infantil', TO_DATE('01-09-2023', 'DD-MM-YYYY'));

                                                        -- Cadet
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Starfighters Masc', 'H', 'Cadet', TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Blizzards Mix', 'M', 'Cadet', TO_DATE('01-09-2023', 'DD-MM-YYYY'));

                                                        -- Juvenil
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Hurricanes Masc', 'H', 'Juvenil', TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Aguadulce Mix', 'M', 'Juvenil', TO_DATE('01-09-2023', 'DD-MM-YYYY'));

                                                        -- Senior
                                                        --[ NO TEAM ]

-- PLAYERS
                                                         -- Benjami
                                                         -- FC WILDCATS MASC
INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Javier', 'López', 'H', TO_DATE('2015-10-15', 'YYYY-MM-DD'), '9999901K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Marcus', 'Fernandez', 'H', TO_DATE('2016-07-21', 'YYYY-MM-DD'), '9999902K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sabestian', 'Lisandro', 'H', TO_DATE('2015-11-05', 'YYYY-MM-DD'), '9999903K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);


                                                        -- Fc Brighstars Fem
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Ana', 'García', 'D', TO_DATE('2016-04-03', 'YYYY-MM-DD'), '9999904K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Valeria', 'Fernandez', 'D', TO_DATE('2016-01-01', 'YYYY-MM-DD'), '9999905K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Ruth', 'Sitché', 'D', TO_DATE('2015-12-23', 'YYYY-MM-DD'), '9999906K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);


														 -- Alevi
														 -- Fc Skywalkers Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Hugo', 'Pérez', 'H', TO_DATE('2013-06-18', 'YYYY-MM-DD'), '9999907K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Diego', 'Horta', 'H', TO_DATE('2012-12-11', 'YYYY-MM-DD'), '9999908K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);


                                                            -- Fc Pioneers Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Paula', 'Sánchez', 'D', TO_DATE('2012-12-30', 'YYYY-MM-DD'), '9999909K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Carla', 'González', 'D', TO_DATE('2014-02-25', 'YYYY-MM-DD'), '9999910K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Roc', 'Ollé', 'H', TO_DATE('2013-09-06', 'YYYY-MM-DD'), '9999911K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);



                                                         -- Infantil
                                                        -- Fc Lighting Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Lucas', 'Martínez', 'H', TO_DATE('2010-11-07', 'YYYY-MM-DD'), '9999912K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sofía', 'Ruíz', 'D', TO_DATE('2011-03-12', 'YYYY-MM-DD'), '9999913K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Alejandro', 'Torres', 'H', TO_DATE('2011-08-29', 'YYYY-MM-DD'), '9999914K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);


                                                        -- Fc Moonwalkers Fem
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Mariana', 'Sancho', 'D', TO_DATE('2011-05-05', 'YYYY-MM-DD'), '9999915K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Ivet', 'Curros', 'D', TO_DATE('2011-02-17', 'YYYY-MM-DD'), '9999916K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sandra', 'Boltá', 'D', TO_DATE('2010-10-02', 'YYYY-MM-DD'), '9999917K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);



                                                        -- Cadet
                                                        -- Fc Starfighters Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Daniel', 'Morales', 'H', TO_DATE('2008-09-19', 'YYYY-MM-DD'), '9999918K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Nathan', 'Castro', 'H', TO_DATE('2009-05-11', 'YYYY-MM-DD'), '9999919K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sergio', 'Jiménez', 'H', TO_DATE('2009-07-04', 'YYYY-MM-DD'), '9999920K','ES7612345678910123456819', 'Calle del Campo 16', '04740', 'Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);


                                                        -- Fc Blizzards Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Álvaro', 'García', 'H', TO_DATE('2009-05-28', 'YYYY-MM-DD'), '9999921K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740', 'Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Luis', 'Hernández', 'H', TO_DATE('2009-07-05', 'YYYY-MM-DD'), '9999922K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Eva', 'Matéo', 'D', TO_DATE('2009-02-13', 'YYYY-MM-DD'), '9999923K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);



                                                        -- Juvenil
                                                        -- Fc Hurricanes Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Miguel', 'Guitiérrez', 'H', TO_DATE('2006-11-28', 'YYYY-MM-DD'), '9999924K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Andrían', 'Romero', 'H', TO_DATE('2007-08-22', 'YYYY-MM-DD'), '9999925K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('David', 'Peréz', 'H', TO_DATE('2007-01-05', 'YYYY-MM-DD'), '9999926K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);



                                                        -- Fc Aguadulce Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Claudia', 'Delgado', 'D', TO_DATE('2007-03-16', 'YYYY-MM-DD'), '9999927K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Raúl', 'Jimenez', 'H', TO_DATE('2007-02-10', 'YYYY-MM-DD'), '9999928K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Sergio', 'Hernández', 'H', TO_DATE('2007-07-02', 'YYYY-MM-DD'), '9999929K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GetDefaultPlayerImage(),1);



                                                    -- Senior
                                                    -- [NO PLAYERS]

--2023/2024 PLAYERTEAM
                                                        -- BENJAMI
-- Fc Wildcats Masc

INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (1,1,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (2,1,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (3,1,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


--Fc Brightsras Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (4,2,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (5,2,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (6,2,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


                                                        --ALEVI
-- Fc Skywalkers Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (7,3,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (8,3,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


-- Fc Pioneers Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (9,4,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (10,4,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (11,4,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));



                                                        --Infantil
 -- Fc Lighting Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (12,5,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (13,5,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (14,5,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));

-- Fc Moonwalkers Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (15,6,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (16,6,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (17,6,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));



                                                        --Cadet
-- Fc Starfighters Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (18,7,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (19,7,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (20,7,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


  -- Fc Blizzards Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (21,8,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (22,8,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (23,8,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));



                                                -- JUVENIL
 -- Fc Hurricanes Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (24,9,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (25,9,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (26,9,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


-- Fc Aguadulce Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (27,10,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (28,10,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (29,10,'T',TO_DATE('01-09-2023', 'DD-MM-YYYY'));


                                                -- SENIOR
                                                -- NO PLAYER TEAM


-- 2024/2025
-- TEAMS
                                                        -- Benjami
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Prostars Mix', 'M', 'Benjamí', TO_DATE('01-09-2024', 'DD-MM-YYYY'));

                                                        -- Alevi
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Snowpiercer Masc', 'H', 'Aleví', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Rising Mix', 'M', 'Aleví', TO_DATE('01-09-2024', 'DD-MM-YYYY'));

                                                        -- Infantil
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Igualada Fem', 'D', 'Infantil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Martorell Mix', 'M', 'Infantil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Montbui Masc', 'H', 'Infantil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));

                                                        -- Cadet
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Can Pallades Mix', 'M', 'Cadet', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Olot Fem', 'D', 'Cadet', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Olot Masc', 'H', 'Cadet', TO_DATE('01-09-2024', 'DD-MM-YYYY'));

                                                        -- Juvenil
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Roquetas Masc', 'H', 'Juvenil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc ElEjido Fem', 'D', 'Juvenil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));


                                                        -- SENIOR
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Tigers Masc', 'H', 'Senior', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Divas Fem', 'D', 'Senior', TO_DATE('01-09-2024', 'DD-MM-YYYY'));

                                                            -- Benjami team correction
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Wildcats Masc', 'H', 'Benjamí', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Brighstars Fem', 'D', 'Benjamí', TO_DATE('01-09-2024', 'DD-MM-YYYY'));
--Fc Aguilas Mix Correction
INSERT INTO TEAM(name,team_type,category_name,season_year) VALUES ('Fc Aguadulce Mix', 'M', 'Juvenil', TO_DATE('01-09-2024', 'DD-MM-YYYY'));



-- PLAYERS
                                                         -- Benjami
                                                         -- FC WILDCATS MASC
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Álvaro', 'Castillo', 'H', TO_DATE('2016-09-23', 'YYYY-MM-DD'), '9999930K','ES7612345678910123456819', 'Calle del Campo 16', '04740', 'Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Pablo', 'Serrano', 'H', TO_DATE('2017-06-30', 'YYYY-MM-DD'), '9999931K', 'ES7612345678910123456819','Calle del Campo 16', '04740', 'Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Santiago', 'Compostela', 'H', TO_DATE('2016-11-18', 'YYYY-MM-DD'), '9999932K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                        -- Fc Brighstars Fem
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Elena', 'Romeu', 'D', TO_DATE('2017-03-14', 'YYYY-MM-DD'), '9999933K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Silvia', 'Serrano', 'D', TO_DATE('2017-01-28', 'YYYY-MM-DD'), '9999934K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Mariona', 'Tinto', 'D', TO_DATE('2016-09-28', 'YYYY-MM-DD'), '9999935K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                -- Fc Prostars MIx
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Winifred', 'Akuah', 'D', TO_DATE('2017-02-14', 'YYYY-MM-DD'), '9999936K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Samuel', 'Annan', 'H', TO_DATE('2016-09-08', 'YYYY-MM-DD'), '9999937K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Angel', 'Reese', 'D', TO_DATE('2017-05-05', 'YYYY-MM-DD'), '9999938K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);



                                                            -- Alevi
                                                            -- Fc Snowpiercer Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Iván', 'Domínguez', 'H', TO_DATE('2014-07-01', 'YYYY-MM-DD'), '9999939K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Andrés', 'Molina', 'H', TO_DATE('2015-04-17', 'YYYY-MM-DD'), '9999940K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Carlos', 'López', 'H', TO_DATE('2013-10-18', 'YYYY-MM-DD'), '9999941K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Rising Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Claudía', 'Rivera', 'D', TO_DATE('2013-11-14', 'YYYY-MM-DD'), '9999942K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Elena', 'Mendoza', 'D', TO_DATE('2015-01-27', 'YYYY-MM-DD'), '9999943K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Miguel', 'Alonso', 'H', TO_DATE('2014-03-27', 'YYYY-MM-DD'), '9999944K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);



                                                            --INFANTIL
                                                            -- Fc Igualada Fem
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Laura', 'Herrera', 'D', TO_DATE('2012-04-30', 'YYYY-MM-DD'), '9999945K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Mari Carmen', 'Maldonado', 'D', TO_DATE('2011-12-14', 'YYYY-MM-DD'), '9999946K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Raquél', 'Pérez', 'D', TO_DATE('2012-02-10', 'YYYY-MM-DD'), '9999947K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Martorell Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Diego', 'Prieto', 'H', TO_DATE('2011-10-18', 'YYYY-MM-DD'), '9999948K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Natalia', 'García', 'D', TO_DATE('2012-06-22', 'YYYY-MM-DD'), '9999949K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Martina', 'Sanchez', 'D', TO_DATE('2012-07-05', 'YYYY-MM-DD'), '9999950K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Montbui Masc
                                                            -- [ NO PLAYERS ]


                                                            -- Cadet
                                                            -- Fc Can Pallades Mix
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Alba', 'Gil', 'D', TO_DATE('2009-10-10', 'YYYY-MM-DD'), '9999951K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Javier', 'Ortíz', 'H', TO_DATE('2010-03-25', 'YYYY-MM-DD'), '9999952K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Maria', 'Rojas', 'D', TO_DATE('2010-06-15', 'YYYY-MM-DD'), '9999953K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Olot Fem
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sara', 'Pardo', 'D', TO_DATE('2010-04-15', 'YYYY-MM-DD'), '9999954K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Silvia', 'Cortés', 'D', TO_DATE('2010-01-07', 'YYYY-MM-DD'), '9999955K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Teresa', 'Lozano', 'D', TO_DATE('2009-10-07', 'YYYY-MM-DD'), '9999956K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Olot Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Manuel', 'Alonso', 'H', TO_DATE('2009-09-18', 'YYYY-MM-DD'), '9999957K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Rafael', 'Ramos', 'H', TO_DATE('2009-12-31', 'YYYY-MM-DD'), '9999958K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Rizza', 'Romero', 'H', TO_DATE('2009-12-27', 'YYYY-MM-DD'), '9999959K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);



                                                            -- Juvenil
                                                            -- Fc Roquetas Masc
 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Raúl', 'Vargas', 'H', TO_DATE('2007-10-22', 'YYYY-MM-DD'), '9999960K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Tomás', 'Vega', 'H', TO_DATE('2008-08-12', 'YYYY-MM-DD'), '9999961K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Carlos', 'Martínez', 'H', TO_DATE('2007-12-27', 'YYYY-MM-DD'), '9999962K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc ElEjido Fem
  INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Carmen', 'Sintia', 'D', TO_DATE('2007-11-12', 'YYYY-MM-DD'), '9999963K','ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Laura', 'Márquez', 'D', TO_DATE('2008-04-17', 'YYYY-MM-DD'), '9999964K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

 INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('María', 'Rivas', 'D', TO_DATE('2008-06-07', 'YYYY-MM-DD'), '9999965K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Aguadulce Mix
INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Nuria', 'Medina', 'D', TO_DATE('2007-09-18', 'YYYY-MM-DD'), '9999966K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Sandra', 'Aguirre', 'D', TO_DATE('2008-01-07', 'YYYY-MM-DD'), '9999967K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('Luis', 'Figo', 'H', TO_DATE('2008-04-14', 'YYYY-MM-DD'), '9999968K','ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);



                                                            -- Senior
                                                            -- Fc Tigers Masc
INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais, PHOTO,medical_rev_fin)
VALUES ('David', 'Protonoy', 'H', TO_DATE('2004-05-02', 'YYYY-MM-DD'), '9999969K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Mariano', 'Cristea', 'H', TO_DATE('2003-09-15', 'YYYY-MM-DD'), '9999970K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Ferdinad', 'Gómez', 'H', TO_DATE('2005-12-19', 'YYYY-MM-DD'), '9999971K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


                                                            -- Fc Divas Fem
INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Laura', 'Tibidabo', 'D', TO_DATE('2004-07-30', 'YYYY-MM-DD'), '9999972K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Cristina', 'Carmona', 'D', TO_DATE('2005-03-14', 'YYYY-MM-DD'), '9999973K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);

INSERT INTO PLAYER (name, surname, sex, birth_year, legal_id, iban, direcion,codigo_postal,localidad,provincia,pais,PHOTO, medical_rev_fin)
VALUES ('Tina', 'Navarro', 'D', TO_DATE('2006-06-01', 'YYYY-MM-DD'), '9999974K', 'ES7612345678910123456819', 'Calle del Campo 16', '04740','Roquetas De Mar','Almeria','Spain',GETDEFAULTPLAYERIMAGE(),1);


--2024/2025 PLAYERTEAM
                                                            -- BENJAMI
-- Fc Wildcats Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (30,24,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (31,24,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (32,24,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

-- Fc Brighstars Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (33,25,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (34,25,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (35,25,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

--Fc Prostars Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (36,11,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (37,11,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (38,11,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));


                                                        -- ALEVI
-- Fc Snowpiercer Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (39,12,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (40,12,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (41,12,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));


-- Fc Rising Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (42,13,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (43,13,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (44,13,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));



                                                    -- INFANTIL
-- Fc Igualada Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (45,14,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (46,14,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (47,14,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

-- Fc Martorrel Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (48,15,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (49,15,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (50,15,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

-- Fc Montbui Mas
-- [Sense jugadores]



                                                    --CADET
--Fc Can Pallades Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (51,17,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (52,17,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (53,17,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

--Fc Olot FEM
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (54,18,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (55,18,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (56,18,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

-- Fc Olot Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (57,19,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (58,19,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (59,19,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));



                                                    -- Juvenil
--Fc Roquetas Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (60,20,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (61,20,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (62,20,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

--Fc Eljido Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (63,21,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (64,21,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (65,21,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

--Fc Aguadulce Mix
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (66,26,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (67,26,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (68,26,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));



                                                    --SENIOR
--Fc Tigers Masc
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (69,22,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (70,22,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (71,22,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

-- Fc Divas Fem
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (72,23,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (73,23,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));
INSERT INTO PLAYERTEAM (PLAYER, TEAM, TIT_CON, SEASON) VALUES (74,23,'T',TO_DATE('01-09-2024', 'DD-MM-YYYY'));

commit;