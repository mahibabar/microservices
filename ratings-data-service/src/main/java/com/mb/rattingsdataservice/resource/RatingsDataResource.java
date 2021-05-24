package com.mb.rattingsdataservice.resource;

import com.mb.rattingsdataservice.models.Rating;
import com.mb.rattingsdataservice.models.UserRating;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @GetMapping("/{movieId}")
    public ResponseEntity getMovieRating(@PathVariable("movieId") Long movieId) {
        Rating rating = new Rating(1L, 5);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getUserMovieRatings(@PathVariable("userId") Long userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating(1L, 5),
                new Rating(2L, 4)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);

        return ResponseEntity.ok(userRating);
    }
}
