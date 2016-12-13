/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Falcon
 */
public class PreparedStatements {
    
    protected static PreparedStatement getAllCinema(Connection con) throws SQLException {
        String sql = "SELECT * FROM cinema";
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }
    
    protected static PreparedStatement setNowShowing(Connection con) throws SQLException {
        String sql = "UPDATE movies SET now_showing = 0";
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }
    
    protected static PreparedStatement insertMovie(Connection con, String name, String internalName,
                        String rating, String posterURL) throws SQLException {
        
        String sql = "INSERT INTO movies(name, internal_name, rating, poster_url, now_showing)"
                + " VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE now_showing = VALUES(now_showing)";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, internalName);
        ps.setString(3, rating);
        ps.setString(4, posterURL);
        ps.setInt(5, 1);
        
        return ps;
    }
    
}
