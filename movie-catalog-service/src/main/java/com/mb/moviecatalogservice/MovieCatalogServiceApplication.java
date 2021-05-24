package com.mb.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication public class MovieCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

    // LoadBalanced annotation is used to let this restTemplate know to use service discovery using eureka client while making API call
    @LoadBalanced
    @Bean(name = "movieInfoTemplate")
    public RestTemplate getMovieInfoTemplate() {
        return new RestTemplate();
    }

    // LoadBalanced annotation is used to let this restTemplate know to use service discovery using eureka client while making API call
    @LoadBalanced
    @Bean(name = "ratingsTemplate")
    public RestTemplate getRatingsTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "movieInfoWebclientBuilder")
    public WebClient.Builder getMovieInfoWebclientBuilder() {
        WebClient.Builder builder = WebClient.builder();
        builder.baseUrl("http://localhost:8081");
        return builder;
    }

}
