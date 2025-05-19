package domus.challenge.service;

import domus.challenge.model.Movie;
import domus.challenge.model.MovieApiResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieApiService {

    @Autowired
    RestTemplate restTemplate;

    private final String baseUrl = "https://challenge.iugolabs.com/api/movies/search";

    public List<Movie> getAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        int currentPage = 1;
        int totalPages;

        do {
            MovieApiResponse response = fetchPage(currentPage);
            allMovies.addAll(response.getData());
            totalPages = response.getTotal_pages();
            currentPage++;
        } while (currentPage <= totalPages);

        return allMovies;
    }

    private MovieApiResponse fetchPage(int page) {
        String url = baseUrl + "?page=" + page;
        return restTemplate.getForObject(url, MovieApiResponse.class);
    }
}