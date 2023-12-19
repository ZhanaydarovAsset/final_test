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
    public static void main(String[] args) {


        PetRepository petRepository = new PetRepository();
        petRepository.printAllPets();
    }
}