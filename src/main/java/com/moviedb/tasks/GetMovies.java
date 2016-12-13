package com.moviedb.tasks;

import com.moviedb.builder.Movies;
import com.moviedb.database.DBConnection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 * Get Movie list & save to database
 * @author Falcon
 */
public class GetMovies implements Runnable {
    
    private static final Logger log = Logger.getLogger(GetMovies.class.getName());
    
    private final DBConnection db;

    
    public GetMovies(ServletContext context) {
        this.db = (DBConnection) context.getAttribute("db");
    }

    @Override
    public void run() {
        
        log.log(Level.INFO, "Task runner: {0}", new Date());
        
        List<Movies> mv = movieFetcher.fetch();
        
        db.prepareMvUpdate();
        db.updateMovies(mv);
    }
    
}
