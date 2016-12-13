/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.controller;

import com.moviedb.builder.Cinema;
import com.moviedb.builder.Movies;
import com.moviedb.database.DBConnection;
import com.moviedb.tasks.Fetcher;
import com.moviedb.tasks.movieFetcher;
import com.utils.url.URL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Falcon
 */
public class CinemaView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        
        
        Cinema cine1 = new Cinema.Builder("UID", "Seri Utama")
                .halls(4)
                .build();
        
        DBConnection db = (DBConnection) getServletContext().getAttribute("db");
        
        db.testConnection();
        
        
        request.setAttribute("cinemas", cine1);
        //request.setAttribute("test", Fetcher.fetchCinemaData());
        
        //Data.save(Fetcher.fetch(URL.Cinema.toString()));
        
        List<Movies> mv = movieFetcher.fetch();
        
        for(Movies elem: mv) {
            System.out.println(elem.getName());
        }
        
        request.setAttribute("data", Fetcher.fetch(URL.Movie));
        
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/cinemaView.jsp");
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
