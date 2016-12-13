/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.tasks;

import com.moviedb.database.DBConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Falcon
 */

@WebListener
public class TaskRunner implements ServletContextListener{
    private ScheduledExecutorService scheduler;
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        
        // Initialize Database
        ServletContext sc = event.getServletContext();
        DBConnection db = new DBConnection(sc);
        sc.setAttribute("db", db);
        
        
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new GetMovies(sc), 0, 20, TimeUnit.MINUTES);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdownNow();
    }
}

