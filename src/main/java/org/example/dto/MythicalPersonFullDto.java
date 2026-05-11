package org.example.dto;

public class MythicalPersonFullDto extends EntityDto {
    private boolean isgod; //TODO Является ли Богом?
    private String superpower; //TODO Описание сверхспособности
    private MythicalAnimalFullDto mythicalanimalfulldto;

    public MythicalAnimalFullDto getMythicalanimal() {
        return mythicalanimalfulldto;
    }

    public void setMythicalanimal(MythicalAnimalFullDto mythicalanimal) {
        this.mythicalanimalfulldto = mythicalanimal;
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
