package com.moviedb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Falcon
 */
public class NowShowingMovies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/nowShowing.jsp");
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
