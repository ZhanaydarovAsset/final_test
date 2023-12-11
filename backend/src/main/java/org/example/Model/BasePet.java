package org.example.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BasePet {
    private int petId;
    private String name;
    private String birthday;
    private ArrayList<String> comands;

    public BasePet(int petId, String name, String birthday) {
        this.petId = petId;
        this.name = name;
        this.birthday = birthday;
        this.comands = new ArrayList<>();
    }

    public int getPetId(){
        return petId;
    }

    public String getName(){
        return  name;
    }

    public String getBirthday(){
        return birthday;
    }

    public ArrayList<String> getComands(){
        return comands;
    }

}
