package com.popcorn.api.moviesdb.delegates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.popcorn.api.moviesdb.dto.Movie;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SearchService {
    public static List<Movie> getResults(String searchString) {
        String URI = "https://api.themoviedb.org/3/search/movie?api_key=6d3b69e7a8589ed8558a414d661e7ee1&language=en-US&query=" + searchString + "&page=1&include_adult=false";
        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForEntity(URI, String.class).getBody();
        //Reason for using gson : The json object mapper in RestTemplate is not as easy as gson.
        Gson gson = new GsonBuilder().create();
        SearchResponse searchResponse = gson.fromJson(apiResponse, SearchResponse.class);
        List<Movie> results = searchResponse.getResults();
        int noOfMovies = results.size();
        return results.subList(0, noOfMovies > 25 ? 25 : noOfMovies);
    }

    private class SearchResponse {
        List<Movie> results;

        public SearchResponse(String page, String total_results, String total_pages, List<Movie> results) {
            this.results = results;
        }

        public List<Movie> getResults() {
            return results;
        }
    }
}
