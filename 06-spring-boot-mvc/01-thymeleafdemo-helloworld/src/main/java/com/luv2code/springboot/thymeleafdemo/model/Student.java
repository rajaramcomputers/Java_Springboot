package com.luv2code.springboot.thymeleafdemo.model;

public class Student {
    private String firstname;
    private String lastname;

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
