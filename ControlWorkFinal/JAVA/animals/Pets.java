package ControlWorkFinal.JAVA.animals;
public class Pets extends Animal {

    private String homeType;

    public Pets(String name,String type,String birthDate) {
        super(name, type,birthDate);
        this.homeType = homeType;
    }

    public Pets() {

    }

    public String getHomeType() {
        return homeType;
    }


}