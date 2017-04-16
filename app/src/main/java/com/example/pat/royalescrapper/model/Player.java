package com.example.pat.royalescrapper.model;

import java.io.Serializable;

/**
 * Created by Pat on 15/04/2017.
 */

public class Player  implements Serializable {

    private String reference;
    private String name;
    private int level;
    private String clan;
    private int highestTrophies;
    private int lastKnownTrophies;
    private int challengeCardsWon;
    private int tournamentCardsWon;
    private int totalDonations;
    private int bestSeasonRank;
    private int previousSeasonRank;
    private int legendaryTrophies;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getHighestTrophies() {
        return highestTrophies;
    }

    public void setHighestTrophies(int highestTrophies) {
        this.highestTrophies = highestTrophies;
    }

    public int getLastKnownTrophies() {
        return lastKnownTrophies;
    }

    public void setLastKnownTrophies(int lastKnownTrophies) {
        this.lastKnownTrophies = lastKnownTrophies;
    }

    public int getChallengeCardsWon() {
        return challengeCardsWon;
    }

    public void setChallengeCardsWon(int challengeCardsWon) {
        this.challengeCardsWon = challengeCardsWon;
    }

    public int getTournamentCardsWon() {
        return tournamentCardsWon;
    }

    public void setTournamentCardsWon(int tournamentCardsWon) {
        this.tournamentCardsWon = tournamentCardsWon;
    }

    public int getTotalDonations() {
        return totalDonations;
    }

    public void setTotalDonations(int totalDonations) {
        this.totalDonations = totalDonations;
    }

    public int getBestSeasonRank() {
        return bestSeasonRank;
    }

    public void setBestSeasonRank(int bestSeasonRank) {
        this.bestSeasonRank = bestSeasonRank;
    }

    public int getPreviousSeasonRank() {
        return previousSeasonRank;
    }

    public void setPreviousSeasonRank(int previousSeasonRank) {
        this.previousSeasonRank = previousSeasonRank;
    }

    public int getLegendaryTrophies() {
        return legendaryTrophies;
    }

    public void setLegendaryTrophies(int legendaryTrophies) {
        this.legendaryTrophies = legendaryTrophies;
    }





    public String toString() {
        return  "REFERENCE: " + reference + "\n" +
                "NAME: " + name + "\n" +
                "LEVEL: " + level + "\n" +
                "CLAN: " + clan + "\n" +
                "HIGHEST TROPHIES: " + highestTrophies + "\n" +
                "LAST KNOWN TROPHIES: " + lastKnownTrophies + "\n" +
                "CHALLENGE CARDS WON: " + challengeCardsWon + "\n" +
                "TOURNAMENTS CARDS WON: " + tournamentCardsWon + "\n" +
                "TOTAL DONATIONS: " + totalDonations + "\n" +
                "BEST SEASON RANK: " + bestSeasonRank + "\n" +
                "PREVIOUS SEASON RANK: " + previousSeasonRank + "\n" +
                "LEGENDARY TROPHIES: " + legendaryTrophies;
    }
}