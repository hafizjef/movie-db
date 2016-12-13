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
    private final String internalId;
    private final String posterURL;
    private final String rating;
    
    
    private Movies(Builder builder) {
        this.name = builder.name;
        this.internalId = builder.internalId;
        this.posterURL = builder.posterURL;
        this.rating = builder.rating;
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
    
    
    
    
    public static class Builder {
        
        private final String name;
        
        private String posterURL;
        private String internalId;
        private String rating;
        
        public Builder(String name) {
            this.name = name;
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
