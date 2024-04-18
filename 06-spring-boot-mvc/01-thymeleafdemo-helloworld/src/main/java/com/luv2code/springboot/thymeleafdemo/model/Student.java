package com.luv2code.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {
    private String firstname;
    private String lastname;

    private String country;

    private String favouritelanguage;

    private List<String> favouriteSystem;

    public List<String> getFavouriteSystem() {
        return favouriteSystem;
    }

    public void setFavouriteSystem(List<String> favouriteSystem) {
        this.favouriteSystem = favouriteSystem;
    }

    public String getFavouritelanguage() {
        return favouritelanguage;
    }

    public void setFavouritelanguage(String favouritelanguage) {
        this.favouritelanguage = favouritelanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student() {
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
