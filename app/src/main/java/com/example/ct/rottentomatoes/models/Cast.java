package com.example.ct.rottentomatoes.models;

import java.util.List;

/**
 * Created by cT on 05.02.2015.
 */
public class Cast {
    private String name;
    private String id;
    private List<String> characters;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<String> getCharacters() {
        return characters;
    }
}
