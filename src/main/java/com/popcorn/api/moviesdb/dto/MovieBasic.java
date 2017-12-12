package com.popcorn.api.moviesdb.dto;

import java.util.List;

public class MovieBasic {
    String adult;
    String backdrop_path;
    List<MovieBasic.Genres> genres;
    int id;
    String imdb_id;
    String overview;
    String poster_path;
    String release_date;
    String title;

    private class Genres {
        String id;
        String name;


        public Genres(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Genres() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}