package com.popcorn.api.moviesdb.controller;

import com.popcorn.api.moviesdb.delegates.TrendingServiceLogic;
import com.popcorn.api.moviesdb.dto.Trend;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/")
@RestController
public class Controller {

    @RequestMapping(value = "/trends", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Trend> getTrendingMovies() {
        return TrendingServiceLogic.getTrends();
    }
}
