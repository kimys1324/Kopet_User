package com.example.kimys1324.kopet_drawer.Data;

/**
 * Created by kimys1324 on 7/4/16.
 */
public class PetData {
    String name;
    boolean gender;
    String imagePath;
    int age;

    public PetData(String name, boolean gender, int age, String imagePath) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.imagePath = imagePath;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
