package com.example.ct.rottentomatoes.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieDetail extends Movie {
    private List<String> genres;
    @SerializedName("abridged_directors")
    private AbridgedDirector abridgedDirector;
    private String studio;

    public MovieDetail(Poster posters, String title, Ratings ratings, List<Cast> abridgedCast) {
        super(posters, title, ratings, abridgedCast);
    }

    public List<String> getGenres() {
        return genres;
    }

    public AbridgedDirector getAbridgedDirector() {
        return abridgedDirector;
    }

    public String getStudio() {
        return studio;
    }
}
