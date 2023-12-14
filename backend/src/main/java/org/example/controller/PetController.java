package org.example.controller;

import org.example.model.BasePet;

import java.sql.*;

public class PetController {
    private Connection connection;

    public PetController(Connection connection) {
        this.connection = connection;
    }
    // Метод для создания нового животного
    public void createPet(BasePet pet) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO pets (0, name, birthday) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getName());
            statement.setString(3, pet.getBirthday());
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Не удалось создать домашнее животное, строки не затронуты.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int petId = generatedKeys.getInt(1);
                    pet.setPetId(petId);
                } else {
                    throw new SQLException("Creating pet failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте исключение соответствующим образом в вашем приложении
        }
    }

    // Метод для удаления животного
    public void deletePet(int petId) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM pets WHERE petId = ?")) {
            statement.setInt(1, petId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработайте исключение соответствующим образом в вашем приложении
        }
    }
//
//    // Метод для изменения данных животного
//    public void updatePet(int petId, String newName, String newBirthday) {
//        // Здесь вы можете добавить логику для обновления данных животного в базе данных
//        for (BasePet pet : pets) {
//            if (pet.getPetId() == petId) {
//                pet.setName(newName);
//                pet.setBirthday(newBirthday);
//                break;
//            }
//        }
//    }
//
//    // Метод для получения списка команд животного
//    public List<String> getCommands(int petId) {
//
//        for (BasePet pet : pets) {
//            if (pet.getPetId() == petId) {
//                // Здесь вы можете добавить логику для получения команд животного из базы данных
//                // В примере возвращается список команд, разделенных запятыми
//                String commands = String.join(", ", pet.getCommands());
//                return commands != null ? List.of(commands.split(", ")) : new ArrayList<>();
//            }
//        }
//        return new ArrayList<>();
//    }
//
//    // Метод для получения списка имен животных
//    public List<String> getPetNames() {
//        List<String> petNames = new ArrayList<>();
//        for (BasePet pet : pets) {
//            petNames.add(pet.getName());
//        }
//        return petNames;
//    }

}

