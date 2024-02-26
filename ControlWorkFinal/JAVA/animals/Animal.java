package ControlWorkFinal.JAVA.animals;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Commands {

    protected String name;
    protected String type;
    protected String birthDate;
    protected List<String> commands;

    public Animal(String name, String type, String birthDate) {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public Animal() {

    }

    @Override
    public List<String> getCommands() {
        return commands;
    }

    @Override
    public void addCommand(String command) {
        commands.add(command);
    }


    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getType() {
        return type;
    }


}
