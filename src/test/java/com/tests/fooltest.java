/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Falcon
 */
public class fooltest {
    private int value;
    
    @Before
    public void setup(){
        value = 5;
    }
    
    @Test
    public void testPlus(){
        Assert.assertEquals("EQ", 15, (value+5));
    }
}
