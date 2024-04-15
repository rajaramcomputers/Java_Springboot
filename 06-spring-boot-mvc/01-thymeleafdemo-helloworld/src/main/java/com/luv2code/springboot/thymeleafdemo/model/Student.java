package com.luv2code.springboot.thymeleafdemo.model;

public class Student {
    private String firstname;
    private String lastname;

    private String country;

    private String favouritelanguage;

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
