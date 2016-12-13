/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.tasks;

import com.moviedb.builder.Movies;
import com.utils.url.URL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Falcon
 */
public class Data {
    
    public static List fetchMovies(){
        
        List<Movies> movies = new ArrayList<>();
        JSONParser parser = new JSONParser();
        
        
        try {
            Object rawMovieData = parser.parse(Fetcher.fetch(URL.Movie));
            JSONObject jsonMovie = (JSONObject) rawMovieData;
            JSONArray movieList = (JSONArray) jsonMovie.get("movies");
            
            Iterator movie = movieList.iterator();

            while(movie.hasNext()) {
                JSONObject mv = (JSONObject) movie.next();
                
                Movies moviedata = new Movies.Builder(mv.get("internalMovieName").toString())
                        .internalId(mv.get("internalMovieId").toString())
                        .posterURL(mv.get("movieImageUrl").toString())
                        .rating(mv.get("rating").toString())
                        .build();
                
                movies.add(moviedata);
            }
            
            return movies;
            
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
