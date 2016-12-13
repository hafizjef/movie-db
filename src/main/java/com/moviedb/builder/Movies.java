/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.builder;

import java.io.Serializable;

/**
 *
 * @author Falcon
 */
public class Movies implements Serializable {
    
    private final String name;
    private final String cast;
    private final String director;
    private final String genre;
    private final String LANG;
    private final String plot;
    private final String releaseDate;
    private final String runtime;
    private final String trailerId;
    private final String internalId;
    private final String posterURL;
    private final String rating;
    
    
    private Movies(Builder builder) {
        this.name = builder.name;
        this.internalId = builder.internalId;
        this.posterURL = builder.posterURL;
        this.rating = builder.rating;
        this.cast = builder.cast;
        this.director = builder.director;
        this.genre = builder.genre;
        this.LANG = builder.LANG;
        this.plot = builder.plot;
        this.releaseDate = builder.releaseDate;
        this.runtime = builder.runtime;
        this.trailerId = builder.trailerId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getInternalId() {
        return internalId;
    }
    
    public String getPosterURL() {
        return posterURL;
    }
    
    public String getRating() {
        return rating;
    }
    
    public String getCast() {
        return cast;
    }
    
    public String getDirector() {
        return director;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getLang() {
        return LANG;
    }
    
    public String getTrailerId() {
        return trailerId;
    }
    
    public String getPlot() {
        return plot;
    }
    
    public String getReleaseDate() {
        return releaseDate;
    }
    
    public String getRuntime() {
        return runtime;
    }
   
    
    public static class Builder {
        
        private final String name;
        
        
        private String cast;
        private String director;
        private String genre;
        private String LANG;
        private String plot;
        private String releaseDate;
        private String runtime;
        private String trailerId;
        private String posterURL;
        private String internalId;
        private String rating;
        
        public Builder(String name) {
            this.name = name;
        }
        
        public Builder cast(String cast) {
            this.cast = cast;
            return this;
        }
        
        public Builder director(String director) {
            this.director = director;
            return this;
        }
        
        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }
        
        public Builder LANG(String lang) {
            this.LANG = lang;
            return this;
        }
        
        public Builder plot(String plot) {
            this.plot = plot;
            return this;
        }
        
        public Builder releaseDate(String date) {
            this.releaseDate = date;
            return this;
        }
        
        public Builder runtime(String runtime) {
            this.runtime = runtime;
            return this;
        }
        
        public Builder trailerId(String id) {
            this.trailerId = id;
            return this;
        }
        
        public Builder internalId(String iName) {
            this.internalId = iName;
            return this;
        }
        
        public Builder posterURL(String url) {
            this.posterURL = url;
            return this;
        }
        
        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }
        
        public Movies build() {
            return new Movies(this);
        }
    }
}
