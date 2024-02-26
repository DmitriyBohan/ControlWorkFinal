package ControlWorkFinal.JAVA;

import ControlWorkFinal.JAVA.animals.Animal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AnimalRegistryModel {
    private List<Animal> animals;

    public AnimalRegistryModel() {
        this.animals = new ArrayList<>();
    }

    public void saveToFile(String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(animals, writer);
            System.out.println("Данные успешно сохранены в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            Type animalListType = new TypeToken<ArrayList<Animal>>(){}.getType();
            List<Animal> loadedAnimals = gson.fromJson(reader, animalListType);
            animals.addAll(loadedAnimals);
            System.out.println("Данные успешно загружены из файла: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Животное " + animal.getName() + " успешно добавлено в реестр.");
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> getAnimalsByBirthDate(String birthDate) {
        List<Animal> animalsByBirthDate = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getBirthDate().equalsIgnoreCase(birthDate)) {
                animalsByBirthDate.add(animal);
            }
        }
        return animalsByBirthDate;
    }
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals);
    }

}