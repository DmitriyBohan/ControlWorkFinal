package ControlWorkFinal.JAVA;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import ControlWorkFinal.JAVA.animals.Animal;
import ControlWorkFinal.JAVA.animals.packanimals.Camel;
import ControlWorkFinal.JAVA.animals.packanimals.Donkey;
import ControlWorkFinal.JAVA.animals.packanimals.Horse;
import ControlWorkFinal.JAVA.animals.pets.Cat;
import ControlWorkFinal.JAVA.animals.pets.Dog;
import ControlWorkFinal.JAVA.animals.pets.Hamster;

public class AnimalRegistryController {
    private final AnimalRegistryModel animalRegistryModel;

    public AnimalRegistryController() {
        this.animalRegistryModel = new AnimalRegistryModel();
        loadFromFile();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд для животного");
            System.out.println("3. Обучить новой команде");
            System.out.println("4. Список животных по дате рождения");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("6. Удалить животное");
            System.out.println("0. Выйти");
            System.out.print("Введите ваш выбор: ");


            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewAnimal(scanner);
                        break;
                    case 2:
                        listCommandsForAnimal(scanner);
                        break;
                    case 3:
                        trainNewCommand(scanner);
                        break;
                    case 4:
                        listAnimalsByBirthDate(scanner);
                        break;
                    case 5:
                        displayTotalCount();
                        break;
                    case 6:
                        removeAnimal(scanner);
                        break;
                }
            } else {
                System.out.println("Некорректный ввод. Введите число.");
                scanner.nextLine();
            }

        } while (choice != 0);
        saveToFile();
    }

    private void addNewAnimal(Scanner scanner) {
        System.out.println("Выберите тип животного:");
        System.out.println("1. Домашнее животное");
        System.out.println("2. Вьючное животное");
        System.out.print("Введите номер выбора: ");

        if (scanner.hasNextInt()) {
            int animalTypeChoice = scanner.nextInt();
            scanner.nextLine();

            switch (animalTypeChoice) {
                case 1:
                    addPetsAnimal(scanner);
                    break;
                case 2:
                    addPackAnimal(scanner);
                    break;
                default:
                    System.out.println("Некорректный выбор типа животного.");
            }
        } else {
            System.out.println("Некорректный ввод. Введите число.");
            scanner.nextLine();
        }
    }

    private void addPetsAnimal(Scanner scanner) {
        System.out.println("Выберите домашнее животное:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.print("Введите номер выбора: ");

        if (scanner.hasNextInt()) {
            int petsTypeChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите имя животного: ");
            String name = scanner.nextLine();

            System.out.print("Введите дату рождения животного: ");
            String birthDate = scanner.nextLine();

            switch (petsTypeChoice) {
                case 1:
                    Animal dog = new Dog(name, birthDate);
                    animalRegistryModel.addAnimal(dog);
                    break;
                case 2:
                    Animal cat = new Cat(name, birthDate);
                    animalRegistryModel.addAnimal(cat);
                    break;
                case 3:
                    Animal hamster = new Hamster(name, birthDate);
                    animalRegistryModel.addAnimal(hamster);
                    break;
                default:
                    System.out.println("Неверный выбор домашнего животного.");
            }
        } else {
            System.out.println("Некорректный ввод. Введите число.");
            scanner.nextLine();
        }
        saveToFile();
    }

    private void addPackAnimal(Scanner scanner) {
        System.out.println("Выберите вьючное животное:");
        System.out.println("1. Лошадь");
        System.out.println("2. Верблюд");
        System.out.println("3. Осел");
        System.out.print("Введите номер выбора: ");

        if (scanner.hasNextInt()) {
            int packAnimalTypeChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите имя животного: ");
            String name = scanner.nextLine();

            System.out.print("Введите дату рождения животного: ");
            String birthDate = scanner.nextLine();

            switch (packAnimalTypeChoice) {
                case 1:
                    Animal horse = new Horse(name, birthDate);
                    animalRegistryModel.addAnimal(horse);
                    break;
                case 2:
                    Animal camel = new Camel(name, birthDate);
                    animalRegistryModel.addAnimal(camel);
                    break;
                case 3:
                    Animal donkey = new Donkey(name, birthDate);
                    animalRegistryModel.addAnimal(donkey);
                    break;
                default:
                    System.out.println("Неверный выбор вьючного животного.");
            }
        } else {
            System.out.println("Некорректный ввод. Введите число.");
            scanner.nextLine();
        }
        saveToFile();
    }

    private void listCommandsForAnimal(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = animalRegistryModel.findAnimalByName(name);

        if (animal != null) {
            System.out.println("Список команд для животного " + name + ":");
            for (String command : animal.getCommands()) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void trainNewCommand(Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = animalRegistryModel.findAnimalByName(name);

        if (animal != null) {
            System.out.print("Введите новую команду для животного " + name + ": ");
            String newCommand = scanner.nextLine();
            animal.addCommand(newCommand);
            System.out.println("Команда успешно добавлена.");
            saveToFile();
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void listAnimalsByBirthDate(Scanner scanner) {
        List<Animal> allAnimals = animalRegistryModel.getAllAnimals();

        if (allAnimals.isEmpty()) {
            System.out.println("Реестр животных пуст.");
            return;
        }

        Collections.sort(allAnimals, Comparator.comparing(animal -> {
            String birthDate = animal.getBirthDate();
            return (birthDate != null) ? birthDate : "";
        }));

        System.out.println("Список всех животных отсортированный по дате рождения:");
        for (Animal animal : allAnimals) {
            System.out.println("Имя: " + animal.getName() + ", Тип: " + animal.getType() + ", Дата рождения: " + animal.getBirthDate());
        }
    }

    private void displayTotalCount() {
        System.out.println("Общее количество животных: " + animalRegistryModel.getTotalCount());
    }

    private void removeAnimal(Scanner scanner) {
        System.out.print("Введите имя животного, которое вы хотите удалить: ");
        String nameToRemove = scanner.nextLine();

        if (animalRegistryModel.removeAnimalByName(nameToRemove)) {
            System.out.println("Животное " + nameToRemove + " успешно удалено.");
        } else {
            System.out.println("Животное с именем " + nameToRemove + " не найдено.");
        }
    }

    private void loadFromFile() {
        animalRegistryModel.loadFromFile("animal_registry.json");
    }

    private void saveToFile() {
        animalRegistryModel.saveToFile("animal_registry.json");
    }
}
