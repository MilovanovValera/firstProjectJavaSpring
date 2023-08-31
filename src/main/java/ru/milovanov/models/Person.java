package ru.milovanov.models;

import javax.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message = "Full name should not be empty")
    @Size(min = 2, max = 100, message = "Full name should be between 2 and 100 characters")
    private String name;

    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    private int yearOfBirth;


    public Person() {

    }

    public Person(int id, String name, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}