package ControlWorkFinal.JAVA.animals.packanimals;

import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.PackAnimals;


public class Camel extends PackAnimals implements Commands {
    public Camel(String name, String birthDate) {
        super(name, "Верблюд", birthDate);
    }
    public Camel() {
        super();
    }
}