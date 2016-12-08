/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.database;

import com.moviedb.listener.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
}
