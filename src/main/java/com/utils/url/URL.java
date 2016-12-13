package com.utils.url;

import java.net.URISyntaxException;
import java.time.Instant;
import org.apache.http.client.utils.URIBuilder;

/**
 * Generate URL for selected API Endpoints 
 * @author Falcon
 */
public class URL {
    
    private final String value;
    private static String param;
    
    public URL(String value) {
        this.value = value;
    }
    
    public URL(String value, String param) {
        this.value = value;
        URL.param = param;
    }
    
    public static final URL Cinema = new URL("cinema");
    public static final URL Movie = new URL("movie");
    
    
    public static final URL getMovieInfo(String movieTitle) {
        URL mv = new URL("movieInfo", movieTitle);
        URL.param = mv.movieInfoURL(movieTitle);
        return mv;
    }
    

    @Override
    public final String toString(){
        
        switch(value) {
            
            case "cinema":
                return cinemaURL();
            case "movie":    
                return movieURL();
            case "movieInfo":
                return URL.param;
                
            default:
                return null;
        }
    }
    
    
    
    
    /**
     * URL Builder methods
     * will return URL for corresponding API
     * @return String URL
     */
    
    private String cinemaURL(){
        try { 
                URIBuilder url = new URIBuilder("http://tgv.api.lb.appxtream.com/jsonFeed.action")
                        .addParameter("_dc", String.valueOf(Instant.now().toEpochMilli()))
                        .addParameter("service", "tgvMobileService")
                        .addParameter("action", "getCinemaList3")
                        .addParameter("mimeType", "application/json");
                
                return url.build().toString();
            
            } catch (URISyntaxException ex) { }
        
        return null;
    }
    
    private String movieURL() {
        try { 
                URIBuilder url = new URIBuilder("http://tgv.api.lb.appxtream.com/jsonFeed.action")
                        .addParameter("_dc", String.valueOf(Instant.now().toEpochMilli()))
                        .addParameter("service", "tgvMobileService")
                        .addParameter("action", "getMovieList4")
                        .addParameter("mimeType", "application/json");
                
                return url.build().toString();
            
            } catch (URISyntaxException ex) { }
        
        return null;
    }
    
    private String movieInfoURL(String internalMovieName) {
        try { 
                URIBuilder url = new URIBuilder("http://tgv.api.lb.appxtream.com/jsonFeed.action")
                        .addParameter("_dc", String.valueOf(Instant.now().toEpochMilli()))
                        .addParameter("service", "tgvMobileService")
                        .addParameter("action", "getMovieDetail2")
                        .addParameter("mimeType", "application/json")
                        .addParameter("p1", internalMovieName);
                
                return url.build().toString();
            
            } catch (URISyntaxException ex) { }
        
        return null;
    }
}
