package org.example.model;

public class PetCreator extends Creator {

    @Override
    protected BasePet creatNewPet(PetType type) {
        switch (type){
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Humster:
                return new Hamster();
        }
        return null;
    }
}
