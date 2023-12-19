package org.example.model;

public abstract class Creator {
    protected abstract BasePet creatNewPet(PetType type);

    public BasePet creatPet(PetType type, String name, String birthday){
        BasePet pet = creatNewPet(type);
        pet.setName(name);
        pet.setBirthday(birthday);
        return pet;
    }
}


