package ru.milovanov.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @Min(value = 0, message = "Year, the book was written, should be greater than 0")
    private int year;
    @NotEmpty(message = "Author name should not be empty")
    @Size(min = 2, max = 100, message = "Author name should be between 2 and 100 characters")
    private String author;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String name;

    public Book(){
    }
    public Book(int id, int year, String author, String name) {
        this.id = id;
        this.year = year;
        this.author = author;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
