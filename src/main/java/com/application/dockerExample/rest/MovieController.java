package com.application.dockerExample.rest;


import com.application.dockerExample.dto.MovieDto;
import com.application.dockerExample.persistence.model.Movie;
import com.application.dockerExample.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {
    private MovieService movieService;

    @PostMapping
    public ResponseEntity get(@RequestBody final MovieDto movieDto) {
        Movie movie = getMovieToCreate(movieDto);
        Movie createdMovie = movieService.create(movie);
        return ResponseEntity.ok(MovieDto.builder()
                .movieName(createdMovie.getMovieName())
                .category(createdMovie.getCategory())
                .build());
    }

    private Movie getMovieToCreate(MovieDto movieDto) {
        return Movie.builder()
                .movieName(movieDto.getMovieName())
                .category(movieDto.getCategory())
                .build();
    }
}
