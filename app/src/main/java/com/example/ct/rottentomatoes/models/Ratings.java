package com.example.ct.rottentomatoes.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cT on 04.02.2015.
 */
public class Ratings {
    @SerializedName("critics_rating")
    private String criticsRating;
    @SerializedName("critics_score")
    private int criticsScore;
    @SerializedName("audience_rating")
    private String audienceRating;
    @SerializedName("audience_score")
    private int audienceScore;

    public String getCriticsRating() {
        return criticsRating;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public int getAudienceScore() {
        return audienceScore;
    }
}
