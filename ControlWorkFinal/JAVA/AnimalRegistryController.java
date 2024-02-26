package ControlWorkFinal.JAVA;
import java.util.Scanner;

public class AnimalRegistryController {
    private final AnimalRegistryModel animalRegistryModel;

    public AnimalRegistryController() {
        this.animalRegistryModel = new AnimalRegistryModel();
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
    }
    private void loadFromFile() {
        animalRegistryModel.loadFromFile("animal_registry.json");
    }

    private void saveToFile() {
        animalRegistryModel.saveToFile("animal_registry.json");
    }
}
