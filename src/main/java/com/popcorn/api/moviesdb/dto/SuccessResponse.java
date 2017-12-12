package com.popcorn.api.moviesdb.dto;

public class SuccessResponse extends ValidationResponse {
    private String message;

    public SuccessResponse(String message) {
        super();
        this.message = message;
    }

    public SuccessResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
