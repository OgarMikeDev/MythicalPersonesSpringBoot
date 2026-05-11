package org.example.dto;

public class MythicalAnimalFullDto extends EntityDto {
    private String color;
    private String gender;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() +
                "\nAge: " + getAge() +
                "\nColor: " + getColor()+
                "\nGender: " + getGender() ;
    }
}
