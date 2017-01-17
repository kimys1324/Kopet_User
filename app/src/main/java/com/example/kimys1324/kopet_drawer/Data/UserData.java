package com.example.kimys1324.kopet_drawer.Data;

/**
 * Created by kimys1324 on 7/4/16.
 */
public class UserData {

    String imagePath;
    String email;
    String name;
    boolean gender;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    String address;
    String contact;

    public UserData(String imagePath, String email, String name, boolean gender, String address, String contact) {
        this.imagePath = imagePath;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
    }

    public UserData(String imagePath)
    {
        this.imagePath = imagePath;
    }

}
