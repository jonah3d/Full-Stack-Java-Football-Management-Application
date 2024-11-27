
package org.joe.gestion.model.data;
import java.io.FileInputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player {
    private int id;
    protected String name;
    protected String surname;
    protected String sex;
    protected Date birth_year;
    protected String legal_id;
    protected String iban;
    protected String address;
    protected Blob image;
    protected Date medical_rev_fin;

    public Player() {
    }

            public Player(String name, String surname, String sex, Date birth_year) {
        setName(name);
        setSurname(surname);
        setSex(sex);
        setBirth_year(birth_year);
    }

    public Player(String name, String surname, String sex, Date birth_year, String legal_id, String iban, String address, Blob image, Date medical_rev_fin) {
        setName(name);
        setSurname(surname);
        setSex(sex);
        setBirth_year(birth_year);
        setLegal_id(legal_id);
        setIban(iban);
        setAddress(address);
        setImage(image);
        setMedical_rev_fin(medical_rev_fin);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth_year() {
        return birth_year;
    }

    public String getLegal_id() {
        return legal_id;
    }

    public String getIban() {
        return iban;
    }

    public String getAddress() {
        return address;
    }

    public Blob getImage() {
        return image;
    }

    public Date getMedical_rev_fin() {
        return medical_rev_fin;
    }

    public void setName(String name) {
        if(!name.isEmpty() || name != null){
            this.name = name;
        }else{
            throw new RuntimeException("The Name Field Can't Be Empty Or Null");
        }
    }

    public void setSurname(String surname) {
        if(!surname.isEmpty() || surname != null){
            this.surname = surname;
        }else{
            throw new RuntimeException("The Surname Field Can't Be Empty Or Null");
        }
    }

    public void setSex(String sex) {
        
     if(sex.toUpperCase().equals("H") || sex.toUpperCase().equals("D")){
         this.sex = sex;
     }
      else{
          throw new RuntimeException("The Sex Of The Character Must Either be H or D");
      }
    }

    public void setBirth_year(Date birth_year) {
       if(birth_year == null){
           throw new RuntimeException("Birth Year Is null");
       }
       
       this.birth_year = birth_year;
    }


    public void setLegal_id(String legal_id) {
        if(!legal_id.isEmpty()){
            this.legal_id = legal_id;
        }else{
            throw new RuntimeException("Legal ID Can't Be Empty");
        }
    }

    public void setIban(String iban) {
        if(!iban.isEmpty() || iban.length() == 24  ){
            this.iban = iban;
        }else{
            throw new RuntimeException("The IBAN Must Be 24 Digits");
        }
    }

    public void setAddress(String address) {
        if(!address.isEmpty()){
            this.address = address;
        }else{
            throw new RuntimeException("Address Field Can't Be Empty");
        }
    }

    public void setImage(Blob image) {
        
        this.image = image;
    }

    public void setMedical_rev_fin(Date medical_rev_fin) { 
        this.medical_rev_fin = medical_rev_fin;
    }

    public void mostrarJugDetalle(){
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getName());
        System.out.println("Apellido: " + getSurname());
        System.out.println("Sexo: " + getSex());
        System.out.println("Año Nacimiento: " + getBirth_year());
        System.out.println("ID Legal: " + getLegal_id());
        System.out.println("Iban: " + getIban());
        System.out.println("Ubicación: " + getAddress());
        System.out.println("Photo: " + getImage());
        System.out.println("Medical Revision Fin: " + getMedical_rev_fin());

    }

}
