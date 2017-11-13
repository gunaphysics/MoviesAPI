package com.popcorn.api.moviesdb.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TrendResponse implements Serializable {
    public TrendResponse(String page, String total_results, String total_pages, List<Trend> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_results() {
        return total_results;
    }

    public void setTotal_results(String total_results) {
        this.total_results = total_results;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<Trend> getResults() {
        return results;
    }

    public void setResults(List<Trend> results) {
        this.results = results;
    }
    String page;
    String total_results;
    String total_pages;
    List<Trend> results;

}
