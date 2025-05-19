package domus.challenge.service;

import domus.challenge.model.DirectorResponse;
import domus.challenge.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DirectorService {

    @Autowired
    private MovieApiService movieApiService;

    public DirectorResponse getDirectors(Integer threshold) {
        if (threshold < 0) {
            return new DirectorResponse();
        }

        DirectorResponse response = new DirectorResponse();

        List<Movie> allMovies = movieApiService.getAllMovies();

        Map<String, Long> directorMovieCount = allMovies.stream()
                .filter(movie -> movie.getDirector() != null && !movie.getDirector().isBlank())
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting())); // movies count p/director

        List<String> directors = directorMovieCount.entrySet().stream()
                .filter(entry -> entry.getValue() > threshold) // Filter directors above the threshold
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());

        response.setDirectors(directors);
        return response;
    }
}