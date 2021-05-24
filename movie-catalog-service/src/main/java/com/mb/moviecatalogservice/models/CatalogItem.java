package com.mb.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String description;
    private int ratings;

    public CatalogItem() {
    }

    public CatalogItem(String name, String description, int ratings) {
        this.name = name;
        this.description = description;
        this.ratings = ratings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
