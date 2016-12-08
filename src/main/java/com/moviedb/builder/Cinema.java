/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviedb.builder;

import java.io.Serializable;

/**
 *
 * @author Falcon
 */
public class Cinema implements Serializable {
    
  private final String id; // required
  private final String name; // required
  
  private final int halls;


  private Cinema(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.halls = builder.halls;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public int getHalls() {
      return halls;
  }


  public static class Builder {
    private final String id;
    private final String name;
    
    private int halls;

    public Builder(String id, String name) {
      this.id = id;
      this.name = name;
    }
    
    public Builder halls(int hall) {
        this.halls = hall;
        return this;
    }

    public Cinema build() {
      return new Cinema(this);
    }

  }
    
}
