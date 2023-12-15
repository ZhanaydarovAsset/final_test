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
    private static   String query;
    private static Creator petCreat;
    private static final Connection connection;

    static {
        try {
            connection = MyConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PetRepository() throws SQLException, IOException {
        this.petCreat = new Creator();
    }

    public static List<BasePet> getAll(){
        List<BasePet> petList = new ArrayList<>();
        BasePet pet;

        query = "SELECT Name, Birthday, Commands FROM cats\n" +
                "UNION SELECT  Name, Birthday, Commands FROM dogs;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){

                    String name = resultSet.getString("name");
                    String birthday = resultSet.getString("birthday");
                    String commands = resultSet.getString("commands");

                pet = petCreat.createPet("cat", name, birthday,commands);

                    petList.add(pet);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return petList;
    }
}
