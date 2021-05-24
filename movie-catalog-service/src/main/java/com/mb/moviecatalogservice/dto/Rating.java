package com.mb.moviecatalogservice.dto;

public class Rating {
    private Long movieId;
    private int rating;

    public Rating() {
    }

    public Rating(Long movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
