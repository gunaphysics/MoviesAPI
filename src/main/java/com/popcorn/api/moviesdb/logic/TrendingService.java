package com.popcorn.api.moviesdb.logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.popcorn.api.moviesdb.dto.Trend;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TrendingService {

    public static List<Trend> getTrends(){
        String URI = "https://api.themoviedb.org/3/discover/movie?api_key=6d3b69e7a8589ed8558a414d661e7ee1&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&year=2017";
        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForEntity(URI, String.class).getBody();
        //Reason for using gson : The json object mapper in RestTemplate is not as easy as gson.
        Gson gson = new GsonBuilder().create();
         TrendingResponse trendingResponse = gson.fromJson(apiResponse, TrendingResponse.class);
        return trendingResponse.getResults().subList(0,8);
    }

    private class TrendingResponse {
        public TrendingResponse(String page, String total_results, String total_pages, List<Trend> results) {
            this.results = results;
        }
        public List<Trend> getResults() {
            return results;
        }
        public void setResults(List<Trend> results) {
            this.results = results;
        }
        List<Trend> results;
    }
}
