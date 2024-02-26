package ControlWorkFinal.JAVA.animals.pets;


import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.Pets;


public class Dog extends Pets  implements Commands{
    public Dog(String name, String birthDate) {
        super(name, "Собака", birthDate);
    }
    public Dog() {
        super();
    }
}