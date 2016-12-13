/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import com.utils.url.URL;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Falcon
 */
public class urltest {
    
    private URL testurl;
    
    @Before
    public void setup() {
        testurl = URL.Cinema;
    }
    
    
    @Test
    public void testURL() {
        Assert.assertEquals("Assert", testurl, URL.Cinema);
    }
}
