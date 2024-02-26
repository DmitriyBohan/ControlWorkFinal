package ControlWorkFinal.JAVA.animals.packanimals;

import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.PackAnimals;



public class Donkey extends PackAnimals  implements Commands{
    public Donkey(String name, String birthDate) {
        super(name, "Осел", birthDate);
    }
    public Donkey() {
        super();
    }
}
