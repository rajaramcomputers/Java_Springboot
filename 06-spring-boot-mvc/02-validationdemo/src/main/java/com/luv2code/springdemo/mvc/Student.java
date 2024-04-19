package com.luv2code.springdemo.mvc;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

public class Student {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1,message = "Insufficient length")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "Enter value >= 0")
    @Max(value = 10,message = "Enter value <= 10")
    private Integer freePasses;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "Only 5 characters are required")
    private String postalCode;

    @CourseCode(value="TOPS",message = "must start with TOPS")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFreePasses(Integer freePasses) {
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
