/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.database;

import com.moviedb.builder.Movies;
import com.moviedb.listener.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 *
 * @author Falcon
 */
public class DBConnection {
    
    final Logger logger = Logger.getLogger(this.getClass().getName());
    
    private final DataSource dataStore;
    
    public DBConnection(ServletContext context){
        this.dataStore = Config.getInstance(context).getDataSource();
    }
    
    public String testConnection() {
        
        String name = "NaN";
        
        try (
                Connection con = dataStore.getConnection();
                PreparedStatement ps = PreparedStatements.getAllCinema(con);
                ResultSet rs = ps.executeQuery();
                
                ) {
            
            while (rs.next()) {
                name = rs.getString(1);
                logger.log(Level.INFO, "ID : {0}{1}", new Object[]{rs.getString(1), rs.getString(2)});
            }
            
            
        } catch (Exception e) {}
        
        return name;
    }
    
    public void prepareMvUpdate() {
        
        try (
                Connection con = dataStore.getConnection();
                PreparedStatement ps = PreparedStatements.setNowShowing(con);
                
            ) {
            
            int rs = ps.executeUpdate();
            
            if (rs == 0) {
                System.out.println("No rows affected");
            }
            
        } catch (Exception e) {}
    }
    
    public void updateMovies(List<Movies> mv) {
        
        for (Movies movie: mv) {
            
            
            try (
                    Connection con = dataStore.getConnection();
                    PreparedStatement ps = PreparedStatements.insertMovie(con, 
                            movie.getName(), movie.getInternalId(), 
                            movie.getRating(), movie.getPosterURL(),
                            movie.getCast(), movie.getDirector(),
                            movie.getGenre(), movie.getLang(), movie.getPlot(),
                            movie.getReleaseDate(), movie.getRuntime(),
                            movie.getTrailerId());
                    
                ) {
                
                int rs = ps.executeUpdate();
                
                if (rs == 0) {
                    System.out.println("No movies inserted");
                } else {
                    //System.out.println(rs + " rows inserted");
                }
                
            } catch (Exception e) { System.out.println(e.getMessage()); }
            
            
        }
        
    }
    
    public List<Movies> getNowShowing() {
        List<Movies> movies = new ArrayList<>();
        
        try (
                Connection con = dataStore.getConnection();
                PreparedStatement ps = PreparedStatements.getMovies(con);
                ResultSet rs = ps.executeQuery();
            ) {
            
            while (rs.next()) {
                Movies mv = new Movies.Builder(rs.getString("name"))
                        .LANG(rs.getString("language"))
                        .rating(rs.getString("rating"))
                        .plot(rs.getString("plot"))
                        .director(rs.getString("director"))
                        .posterURL(rs.getString("poster_url"))
                        .genre(rs.getString("genre"))
                        .releaseDate(rs.getString("release_date"))
                        .runtime(rs.getString("runtime"))
                        .trailerId(rs.getString("trailer"))
                        .cast(rs.getString("cast"))
                        .internalId(rs.getString("internal_name"))
                        .build();
                movies.add(mv);
            }
            
            return movies;
        
        } catch (Exception e) {}
        
        return null;
    }
    
}
