package com.popcorn.api.moviesdb.delegates;

import com.popcorn.api.moviesdb.dto.Cast;
import com.popcorn.api.moviesdb.dto.Crew;
import com.popcorn.api.moviesdb.dto.MovieBasic;

import java.util.List;

public class GetMovieDetailsService {
    public static MovieWithCastAndCrew getResults(String id) {
        MovieWithCastAndCrew temp;

        return null;

    }

    private class MovieWithCastAndCrew {
        MovieBasic basic;
        List<Cast> cast;
        List<Crew> crew;

        public MovieWithCastAndCrew(MovieBasic basic, List<Cast> cast, List<Crew> crew) {
            this.basic = basic;
            this.cast = cast;
            this.crew = crew;
        }

        public MovieWithCastAndCrew() {
        }

        public MovieBasic getBasic() {
            return basic;
        }

        public void setBasic(MovieBasic basic) {
            this.basic = basic;
        }

        public List<Cast> getCast() {
            return cast;
        }

        public void setCast(List<Cast> cast) {
            this.cast = cast;
        }

        public List<Crew> getCrew() {
            return crew;
        }

        public void setCrew(List<Crew> crew) {
            this.crew = crew;
        }
    }

}
