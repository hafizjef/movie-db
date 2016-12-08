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
    
}
