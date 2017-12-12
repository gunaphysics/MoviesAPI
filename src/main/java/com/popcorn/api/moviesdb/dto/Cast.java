package com.popcorn.api.moviesdb.dto;

public class Cast {
    String character;
    int id;
    String name;
    String profile_path;

    public Cast(String character, int id, String name, String profile_path) {
        this.character = character;
        this.id = id;
        this.name = name;
        this.profile_path = profile_path;
    }

    public Cast() {
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }
}
