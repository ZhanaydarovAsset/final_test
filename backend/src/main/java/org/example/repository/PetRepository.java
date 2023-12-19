package org.example.repository;

import org.example.model.BasePet;
import org.example.model.Creator;
import org.example.model.PetCreator;
import org.example.model.PetType;
import org.example.services.MyConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetRepository {
    private Creator petCreat;
    private Statement sqlSt;
    private ResultSet resultSet;
    private String query;

    public PetRepository(){
        this.petCreat = new PetCreator();
    }

    public List <BasePet> getAll(){
        List<BasePet> pets = new ArrayList<BasePet>();
        BasePet pet;

        try (Connection dbConnect = MyConnection.getConnection()){
            sqlSt = dbConnect.createStatement();
            query = "SELECT Genus_id, Id, Name, Birthday FROM cats\n" +
                    "UNION \n" +
                    "SELECT Genus_id, Id, Name, Birthday FROM dogs\n" +
                    "UNION\n" +
                    "SELECT Genus_id, Id, Name, Birthday FROM hamsters;";
            resultSet = sqlSt.executeQuery(query);
            while (resultSet.next()){
                PetType type = PetType.getType(resultSet.getInt(1));
                int id = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String birthday = resultSet.getString(4);

                pet = petCreat.creatPet(type, name, birthday);
                pet.setPetId(id);
                pets.add(pet);
            }
            return pets;

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void printAllPets() {
        List<BasePet> pets = getAll();

        for (BasePet pet : pets) {
            System.out.println(pet);
        }
    }
}
