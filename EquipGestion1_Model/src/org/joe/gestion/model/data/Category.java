package org.joe.gestion.model.data;


public class Category {
    private int id;
    private String name;
    private int minimum_age;
    private int maximum_age;
    
    public Category(){}
    
    public Category(String name,int minimum_age,int maximum_age){
        setName(name);
        setMinimum_age(minimum_age);
        setMaximum_age(maximum_age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimum_age() {
        return minimum_age;
    }

    public void setMinimum_age(int minimum_age) {
        this.minimum_age = minimum_age;
    }

    public int getMaximum_age() {
        return maximum_age;
    }

    public void setMaximum_age(int maximum_age) {
        this.maximum_age = maximum_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void mostrarDetalle(){
        System.out.println("ID:      " + getId());
        System.out.println("NAME:    " + getName());
        System.out.println("MIN AGE: " + getMinimum_age());
        System.out.println("MAX AGE: " + getMaximum_age());
    }
    
}
