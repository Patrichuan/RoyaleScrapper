package com.example.pat.royalescrapper.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pat on 15/04/2017.
 */

public class Profile  implements Serializable {

    private Player player;
    private ArrayList<Chest> chestSequence;
    private ArrayList<Match> matches;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Chest> getChestSequence() {
        return chestSequence;
    }

    public void setChestSequence(ArrayList<Chest> chestSequence) {
        this.chestSequence = chestSequence;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }
}