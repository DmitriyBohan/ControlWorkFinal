package ControlWorkFinal.JAVA.animals;

public class PackAnimals extends Animal {

    private String homeType;

    public PackAnimals(String name, String type,String birthDate) {
        super(name,type,birthDate);
        this.homeType = homeType;
    }

    public PackAnimals() {
        super();
    }

    public String getHomeType() {
        return homeType;
    }

}