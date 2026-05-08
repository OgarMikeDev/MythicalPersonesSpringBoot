package org.example.model;

public class MythicalPerson extends Entity {
    private boolean isgod; //TODO Является ли Богом?
    private String superpower; //TODO Описание сверхспособности
    private MythicalAnimal mythicalanimal;

    public MythicalAnimal getMythicalanimal() {
        return mythicalanimal;
    }

    public void setMythicalanimal(MythicalAnimal mythicalanimal) {
        this.mythicalanimal = mythicalanimal;
    }

    public boolean isIsgod() {
        return isgod;
    }

    public void setIsgod(boolean isgod) {
        this.isgod = isgod;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                "\nAge: " + getAge() +
                "\nIs God: " + isIsgod() +
                "\nSuper power: " + getSuperpower() +
                "\nMythical Animal: " + getMythicalanimal();
    }
}
