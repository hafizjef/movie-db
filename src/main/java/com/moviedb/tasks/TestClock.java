/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.tasks;

import java.util.Date;

/**
 *
 * @author Falcon
 */
public class TestClock implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello there! " + new Date().toString());
    }
    
}
