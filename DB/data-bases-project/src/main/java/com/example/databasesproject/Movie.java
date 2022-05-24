package com.example.databasesproject;

public class Movie {
    String name;
    String director;
    String genre;
    Integer length;
    Integer availableCopies;

    public Movie(String name, String director, String genre, Integer length, Integer availableCopies) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.length = length;
        this.availableCopies = availableCopies;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }
}
