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
public class MovieUpdater implements Runnable {
    
    private static final Logger log = Logger.getLogger(MovieUpdater.class.getName());
    
    private final DBConnection db;

    
    public MovieUpdater(ServletContext context) {
        this.db = (DBConnection) context.getAttribute("db");
    }

    @Override
    public void run() {
        
        log.log(Level.INFO, "Task runner: {0}", new Date());
        
        List<Movies> mv = Data.fetchMovies();
        
        db.prepareMvUpdate();
        db.updateMovies(mv);
    }
    
}
