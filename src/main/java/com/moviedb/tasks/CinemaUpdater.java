/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.tasks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.http.client.utils.URIBuilder;


/**
 *
 * @author Falcon
 */
public class CinemaUpdater  {
    
    static final Logger Log = Logger.getLogger(CinemaUpdater.class.getName());
    
    static String ENDPOINT = buildURL();
    static OkHttpClient client = new OkHttpClient();
    
    public static String update() throws IOException {
        
        Request request = new Request.Builder()
                .url(ENDPOINT)
                .build();
        
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    
    private static String buildURL() {
        
        try { 
            URIBuilder url = new URIBuilder("http://tgv.api.lb.appxtream.com/jsonFeed.action")
                    .addParameter("_dc", String.valueOf(Instant.now().toEpochMilli()))
                    .addParameter("service", "tgvMobileService")
                    .addParameter("action", "getCinemaList3")
                    .addParameter("mimeType", "application/json");
            
            return url.build().toString();
            
        } catch (URISyntaxException ex) {
            Log.log(Level.SEVERE, null, ex);
        }
        
        return null;

    }
}
