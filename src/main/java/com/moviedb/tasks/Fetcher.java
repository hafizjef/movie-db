package com.moviedb.tasks;

import com.utils.url.URL;
import java.io.IOException;
import java.util.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



/**
 *
 * @author Falcon
 */
public class Fetcher  {
    
    static final Logger Log = Logger.getLogger(Fetcher.class.getName());
    static OkHttpClient client = new OkHttpClient();
    
    
    public static String fetch(URL url) throws IOException {
        
        Request request = new Request.Builder()
                .url(url.toString())
                .build();
        
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
