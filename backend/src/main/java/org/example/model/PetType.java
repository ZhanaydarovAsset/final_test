package org.example.model;

public enum PetType {
    Cat,
    Dog,
    Humster;

    public static PetType getType(int typeId){
        switch (typeId){
            case 1:
                return PetType.Cat;
            case 2:
                return PetType.Dog;
            case 3:
                return PetType.Humster;
            default:
                return null;
        }
    }
}
