package com.example.pat.royalescrapper.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pat on 16/04/2017.
 */

public class Deck  implements Serializable {

    private ArrayList<Spell> spells;

    public Deck() {
        spells = new ArrayList<>();
    }

    public void addSpell (Spell spell) {
        spells.add(spell);
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    public String toString () {
        String result = "Deck\n" + "----\n";
        for (Spell spell : spells) {
            result += spell.toString().concat("\n");
        }
        return result;
    }
}