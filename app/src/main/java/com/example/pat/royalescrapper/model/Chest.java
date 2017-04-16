package com.example.pat.royalescrapper.model;

import java.io.Serializable;

/**
 * Created by Pat on 15/04/2017.
 */

public class Chest implements Serializable {

    private String name;
    private int position;

    public Chest() {

    }

    Chest(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString () {
        return "CHEST NAME: " + name + "\n" +
               "CHEST POSITION: " + position;
    }
}