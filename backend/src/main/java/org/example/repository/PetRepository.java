package org.example.repository;

import org.example.model.BasePet;
import org.example.model.Creator;
import org.example.services.MyConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetRepository {
    private final Connection connection = MyConnection.getConnection();

    public List<BasePet> getAll(){
        List<BasePet> petList = new ArrayList<>();
        BasePet pet;
        String query = "SELECT petId, name, birthday, commands, type FROM pets";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    int petId = resultSet.getInt("petId");
                    String name = resultSet.getString("name");
                    String birthday = resultSet.getString("birthday");
                    String commands = resultSet.getString("commands");

                    pet = BasePet createPet(String type, String name, String birthday, String commands);

                    petList.add(pet);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
