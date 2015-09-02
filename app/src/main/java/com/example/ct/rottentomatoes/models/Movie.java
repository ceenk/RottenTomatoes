package com.example.ct.rottentomatoes.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Movie {

    private String id;
    private String title;
    private int year;
    @SerializedName("mpaa_rating")
    private String mpaaRating;
    private String runtime;
    @SerializedName("critics_consensus")
    private String criticsConsensus;
    @SerializedName("release_dates")
    private ReleaseDates releaseDates;
    private Ratings ratings;
    private String synopsis;
    private Poster posters;
    @SerializedName("abridged_cast")
    private List<Cast> abridgedCast;
    @SerializedName("alternate_ids")
    private AlternateId alternateIds;
    private Links links;

    public Movie(Poster posters, String title, Ratings ratings, List<Cast> abridgedCast) {
        this.posters = posters;
        this.title = title;
        this.ratings = ratings;
        this.abridgedCast = abridgedCast;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public ReleaseDates getReleaseDates() {
        return releaseDates;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Poster getPosters() {
        return posters;
    }

    public List<Cast> getAbridgedCast() {
        return abridgedCast;
    }

    public AlternateId getAlternateIds() {
        return alternateIds;
    }

    public Links getLinks() {
        return links;
    }
}
