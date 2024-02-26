package ControlWorkFinal.JAVA.animals.pets;


import ControlWorkFinal.JAVA.animals.Commands;
import ControlWorkFinal.JAVA.animals.Pets;


public class Hamster extends Pets  implements Commands{
    private static final long serialVersionUID = 1L;
    public Hamster(String name, String birthDate) {
        super(name, "Хомяк", birthDate);
    }
    public Hamster() {
        super();
    }
}