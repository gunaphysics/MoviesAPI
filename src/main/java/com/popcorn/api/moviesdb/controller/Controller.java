package com.popcorn.api.moviesdb.controller;

import com.popcorn.api.moviesdb.delegates.SearchService;
import com.popcorn.api.moviesdb.delegates.TrendingService;
import com.popcorn.api.moviesdb.dto.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/")
@RestController
public class Controller {

    @RequestMapping(value = "/trends", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Trend> getTrendingMovies() {
        return TrendingService.getTrends();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SearchMovie> searchMovie(final HttpServletRequest request) {
        return SearchService.getResults(request.getParameter("text"));
    }

    @RequestMapping(value = "/getMoviedetails", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getMovieDetails(final HttpServletRequest request) {
        return "function not implemented yet";
        //return GetMovieDetailsService.getResults(request.getParameter("id"));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ValidationResponse signUp(@RequestBody Signup signup) throws SQLException {
        return Account.signUp(signup.getEmail(), signup.getPassword());

    }

    @RequestMapping(value = "/login/verify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ValidationResponse verifyLogin(@RequestBody Login login) throws SQLException {
        return Account.verifyLogin(login.getEmail(), login.getPassword());
    }
}

/*

    Implement an API that makes use of below 2 APIs and returns mentioned properties of a movie. If possible sort Cast and Crew info based on release date (desc)

        Example Input: 30344(movieId)
        TMDB movie info API: https://api.themoviedb.org/3/movie/'+ movieId +'?api_key=6d3b69e7a8589ed8558a414d661e7ee1&language=en-US'
        TMDB movie cast and credits API: https://api.themoviedb.org/3/movie/'+ movieId +'/credits?api_key=6d3b69e7a8589ed8558a414d661e7ee1


        {
        adult: boolean;
        backdrop_path: string;
        genres: [{
        id: number;
        name: string;}
        ]
        id: number;
        imdb_id: string;
        overview: string;
        poster_path: string;
        release_date: string;
        title: string;
        cast: [{
        character: string;
        id: number;
        name: string;
        profile_path: string;
        }
        ];
        crew: [{
        department: string;
        id: number;
        name: string;
        profile_path: string;
        }];
        }*/
