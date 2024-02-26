package ControlWorkFinal.JAVA.animals.packanimals;

import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.PackAnimals;


public class Horse extends PackAnimals  implements Commands{
    public Horse(String name, String birthDate) {
        super(name, "Лошадь", birthDate);
    }
    public Horse() {
        super();
    }

}