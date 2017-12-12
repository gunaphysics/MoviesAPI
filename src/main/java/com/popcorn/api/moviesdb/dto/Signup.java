package com.popcorn.api.moviesdb.dto;

public class Signup {
    private String email;
    private String password;

    public Signup(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Signup() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
