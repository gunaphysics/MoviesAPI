package com.popcorn.api.moviesdb.dto;

public class Crew {
    String department;
    int id;
    String name;
    String profile_path;

    public Crew(String department, int id, String name, String profile_path) {
        this.department = department;
        this.id = id;
        this.name = name;
        this.profile_path = profile_path;
    }

    public Crew() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

