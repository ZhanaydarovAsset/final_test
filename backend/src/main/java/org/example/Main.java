package org.example;

import org.example.model.BasePet;
import org.example.model.Creator;
import org.example.model.PetCreator;
import org.example.model.PetType;
import org.example.repository.PetRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Creator creator = new PetCreator();
        BasePet dog = creator.creatPet(PetType.Dog, "baron", "01.01.2022");
    }
}