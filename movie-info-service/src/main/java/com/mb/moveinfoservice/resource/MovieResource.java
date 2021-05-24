package com.mb.moveinfoservice.resource;

import com.mb.moveinfoservice.models.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @GetMapping("/{movieId}")
    public ResponseEntity getMovieInfo(@PathVariable("movieId") Long movieId) {

        Movie movie = new Movie(1L, "Mauli", "Devotional movie where Ritesh deshmukh played a role of Mauli", "Marathi");

        switch (movieId.toString()) {
            case "1":
                movie = new Movie(1L, "Mauli", "Devotional movie where Ritesh deshmukh played a role of Mauli", "Marathi");
                break;
            case "2":
                movie = new Movie(2L, "Balumama", "Devotional movie on God BaluMaMa", "Marathi");
                break;
        }

        return ResponseEntity.ok(movie);
    }
}
