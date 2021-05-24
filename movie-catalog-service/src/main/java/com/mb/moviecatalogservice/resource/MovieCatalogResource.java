package com.mb.moviecatalogservice.resource;

import com.mb.moviecatalogservice.dto.Movie;
import com.mb.moviecatalogservice.dto.UserRating;
import com.mb.moviecatalogservice.models.CatalogItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/catalog")
public class MovieCatalogResource {
    private static Logger logger = LoggerFactory.getLogger(MovieCatalogResource.class);
    private final RestTemplate movieInfoTemplate;
    private final RestTemplate ratingsTemplate;
    private final WebClient.Builder movieInfoWebclientBuilder;

    @Autowired
    public MovieCatalogResource(RestTemplate movieInfoTemplate, RestTemplate ratingsTemplate,
            WebClient.Builder movieInfoWebclientBuilder) {
        this.movieInfoTemplate = movieInfoTemplate;
        this.ratingsTemplate = ratingsTemplate;
        this.movieInfoWebclientBuilder = movieInfoWebclientBuilder;
    }

    @GetMapping("/{userName}")
    public ResponseEntity getCatalog(@PathVariable("userName") String userName) {

        // Movie ratings API call to get all the movies user watched and has ratings information associated
        UserRating userRating = ratingsTemplate
                .getForObject(String.format("http://ratings-data-service/ratingsdata/users/%s", userName), UserRating.class);

        return ResponseEntity.ok(userRating.getRatings()
                .stream()
                .map(rating -> {

                    // API call using WebClient, this is part of spring-boot-starter-webflux dependency
                    /*Movie movie = movieInfoWebclientBuilder.build().get().uri(String.format("/movies/%d", rating.getMovieId()))
                            .retrieve().bodyToMono(Movie.class).block();*/

                    // Movie info service API call using rest template
                    Movie movie = movieInfoTemplate.getForObject(String.format("http://movie-info-service/movies/%d", rating.getMovieId()), Movie.class);
                    CatalogItem catalogItem = new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                    return catalogItem;

                }).collect(Collectors.toList()));
    }
}
