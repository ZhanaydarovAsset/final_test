package org.example.model;

public class Creator {
    public  BasePet createPet(String type, String name, String birthday, String commands) {
        switch (type.toLowerCase()) {
            case "cat":
                return new Cat( 0, name, birthday, commands);
            case "dog":
                return new Dog(0, name, birthday, commands);
            case "hamster":
                return new Hamster(0, name, birthday, commands);
            // Добавьте другие типы животных при необходимости
            default:
                throw new IllegalArgumentException("Unsupported pet type: " + type);
        }
    }
}


