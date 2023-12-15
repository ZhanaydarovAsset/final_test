package org.example;

import org.example.model.BasePet;
import org.example.repository.PetRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        List<BasePet> pets = PetRepository.getAll();
        System.out.printf(pets.toString());


    }
}