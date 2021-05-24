package com.mb.moviecatalogservice.dto;

public class Movie {
    private Long id;
    private String name;
    private String description;
    private String language;

    public Movie() {
    }

    public Movie(String name, String description, String language) {
        this.name = name;
        this.description = description;
        this.language = language;
    }

    public Movie(Long id, String name, String description, String language) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
