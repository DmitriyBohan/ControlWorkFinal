package ControlWorkFinal.JAVA;

import ControlWorkFinal.JAVA.animals.Animal;


import java.util.ArrayList;
import java.util.List;

public class AnimalRegistryModel {
    private List<Animal> animals;

    public AnimalRegistryModel() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Животное " + animal.getName() + " успешно добавлено в реестр.");
    }

}