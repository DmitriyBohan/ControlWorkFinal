package ControlWorkFinal.JAVA.animals.pets;


import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.Pets;

public class Cat extends Pets  implements Commands{
    public Cat(String name, String birthDate) {
        super(name, "Кошка", birthDate);
    }
    public Cat() {
        super();
    }
}