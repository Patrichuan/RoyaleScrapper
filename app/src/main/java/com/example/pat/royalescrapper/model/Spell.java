package com.example.pat.royalescrapper.model;

import java.io.Serializable;

/**
 * Created by Pat on 16/04/2017.
 */

public class Spell  implements Serializable {

    private String name;
    private int cost;
    private int level;

    public Spell(String name, int cost, int level) {
        this.name = name;
        this.cost = cost;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString () {
        return name + " - " + cost + " - " + level;
    }
}