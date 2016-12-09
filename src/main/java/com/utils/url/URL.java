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
    
    public URL(String value) {
        this.value = value;
    }
    
    public static final URL Cinema = new URL("cinema");
    public static final URL Movie = new URL("movie");
    

    @Override
    public final String toString(){
        
        switch(value) {
            
            case "cinema":
                return cinemaURL();
            case "movie":    
                return movieURL();
                
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
}
