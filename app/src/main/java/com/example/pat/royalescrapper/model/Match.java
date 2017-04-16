package com.example.pat.royalescrapper.model;

import java.io.Serializable;

/**
 * Created by Pat on 15/04/2017.
 */

public class Match  implements Serializable {

    private String score;
    private String result;
    private Player player1;
    private Deck player1Deck;
    private Player player2;
    private Deck player2Deck;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Deck getPlayer1Deck() {
        return player1Deck;
    }

    public void setPlayer1Deck(Deck player1Deck) {
        this.player1Deck = player1Deck;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Deck getPlayer2Deck() {
        return player2Deck;
    }

    public void setPlayer2Deck(Deck player2Deck) {
        this.player2Deck = player2Deck;
    }

    public String toString () {
        return "SCORE: " + score
                + " (" + result + ")\n"
                + player1.getName() + " (" + player1.getLastKnownTrophies() + ")\n"
                + player1Deck.toString()
                + player2.getName() + "(" + player2.getLastKnownTrophies() + ")\n"
                + player2Deck.toString();
    }
}