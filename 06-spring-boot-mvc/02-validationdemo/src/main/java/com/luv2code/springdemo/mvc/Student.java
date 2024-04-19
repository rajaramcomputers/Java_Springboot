package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Student {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "Insufficient length")
    private String lastName;
    @Min(value = 0,message = "Enter value >= 0")
    @Max(value = 10,message = "Enter value <= 10")
    private int freePasses;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Only 5 characters are required")
    private String postalCode;
    public int getFreePasses() {
        return freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
