package org.example.model;

import java.util.ArrayList;

public abstract class BasePet {
    protected int petId;
    protected String name;
    protected String birthday;
    //private ArrayList<String> comands;

//    public BasePet(int petId, String name, String birthday) {
//        this.petId = petId;
//        this.name = name;
//        this.birthday = birthday;
//        //this.comands = new ArrayList<>();
//    }

    public int getPetId(){
        return petId;
    }

    public String getName(){
        return  name;
    }

    public String getBirthday(){
        return birthday;
    }

//    public ArrayList<String> getCommands(){
//        return comands;
//    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setBirthday(String newBirthday) {
        this.birthday = newBirthday;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, name: %s", getPetId(), getName());
    }
}
