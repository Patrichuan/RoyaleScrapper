package com.example.pat.royalescrapper;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pat.royalescrapper.model.Chest;
import com.example.pat.royalescrapper.model.Deck;
import com.example.pat.royalescrapper.model.Match;
import com.example.pat.royalescrapper.model.Player;
import com.example.pat.royalescrapper.model.Profile;
import com.example.pat.royalescrapper.model.Spell;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://statsroyale.com/profile/";
    private String playerRef = "";
    private Profile myProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText referenceEt = (EditText) findViewById(R.id.referenceEt);
        Button Scrapbtn = (Button) findViewById(R.id.Scrapbtn);
        Scrapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRef = referenceEt.getText().toString();
                new ParseURL().execute();
            }
        });
    }


    private Profile getProfile (Document doc) {
        myProfile = new Profile();
        setProfilePlayer(myProfile, doc);
        setProfileChests(myProfile, doc);
        setProfileMatches(myProfile, doc);
        return myProfile;
    }

    private void setProfilePlayer (Profile profile, Document doc) {
        String description = "";
        Player player = new Player();

        player.setReference(playerRef);

        String playerName = doc.select("div.playerlevel").get(0).parent().parent().select("span.supercell").get(1).text();
        player.setName(playerName);

        int playerLevel = Integer.valueOf(doc.select("div.playerlevel").get(0).text());
        player.setLevel(playerLevel);

        // Selecciona todos los div con class=nicebox
        Elements niceboxDivs = doc.select("div.nicebox");
        for (Element nicebox : niceboxDivs) {
            Elements elements = nicebox.children();
            for (Element element : elements) {
                if (element.className().contains("description")) {
                    description = element.text();
                }

                if (element.className().contains("content")) {
                    switch (description) {
                        case "Clan":
                            if (element.className().contains("content")) {
                                player.setClan(element.text());
                            }
                            break;
                        case "Highest Trophies":
                            if (element.className().contains("content")) {
                                player.setHighestTrophies(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Last Known Trophies":
                            if (element.className().contains("content")) {
                                player.setLastKnownTrophies(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Challenge Cards Won":
                            if (element.className().contains("content")) {
                                player.setChallengeCardsWon(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Tournament Cards Won":
                            if (element.className().contains("content")) {
                                player.setTournamentCardsWon(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Total Donations":
                            if (element.className().contains("content")) {
                                player.setTotalDonations(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Best Season Rank":
                            if (element.className().contains("content")) {
                                player.setBestSeasonRank(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Previous Season Rank":
                            if (element.className().contains("content")) {
                                player.setPreviousSeasonRank(Integer.valueOf(element.text()));
                            }
                            break;
                        case "Legendary Trophies":
                            if (element.className().contains("content")) {
                                player.setLegendaryTrophies(Integer.valueOf(element.text()));
                            }
                            break;
                    }
                }
            }
        }
        profile.setPlayer(player);
    }

    private void setProfileChests (Profile profile, Document doc) {
        ArrayList<Chest> chestSequence = new ArrayList<>();
        Chest chest;
        Elements chestDivs = doc.select("div.chest");
        for (Element chestElement : chestDivs) {
            Elements elements = chestElement.children();
            chest = new Chest();
            for (Element element : elements) {
                if (!element.attr("src").isEmpty()) {
                    chest.setName(element.attr("title"));
                }

                if (element.className().contains("chestnumber")) {
                    String posStr = element.text().replace("\n", "").replace(" ", "");
                    int position = posStr.equals("Next")?0:Integer.valueOf(posStr);
                    chest.setPosition(position);
                }
            }
            chestSequence.add(chest);
        }
        profile.setChestSequence(chestSequence);
    }

    private void setProfileMatches (Profile profile, Document doc) {
        addResultsToMatches(profile, doc);
        addPairingsToMatches(profile, doc);
        addDecksToMatches(profile, doc);
    }

    private void addResultsToMatches(Profile profile, Document doc) {
        ArrayList<Match> matches = new ArrayList<>();
        Match match;

        Elements recentMatchResults = doc.select("div.panel-title").select("div.supercell");
        for (Element recentResult : recentMatchResults) {
            match = new Match();
            match.setResult(recentResult.select("div.col-sm-3").get(0).text());
            match.setScore(recentResult.select("span").get(0).text());
            matches.add(match);
        }
        profile.setMatches(matches);
    }

    private void addPairingsToMatches(Profile profile, Document doc) {
        Elements recentMatchPlayers = doc.select("table.supercell");
        Player player;
        String name;
        String clan;
        String ref;
        String lastKnownTrophies;

        ArrayList<Match> matches = myProfile.getMatches();
        int matchNumber = 0;

        for (Element recentPlayers : recentMatchPlayers) {
            Elements rows = recentPlayers.select("tr");
            // Cada row es un match: primera iteración YO, segunda iteración OPONENTE
            for (Element row : rows) {
                Elements columns = row.select("td");
                for (Element col: columns) {
                    if (!col.select("a").attr("href").isEmpty()) {
                        player = new Player();

                        ref = col.select("a").attr("href").replace("/profile/", "");
                        player.setReference(ref);

                        lastKnownTrophies = col.select("span").text();
                        player.setLastKnownTrophies(Integer.valueOf(lastKnownTrophies));

                        clan = col.ownText();
                        player.setClan(clan);

                        name = col.select("a").text();
                        player.setName(name);

                        // Sí soy yo
                        if (playerRef.equals(ref)) {
                            matches.get(matchNumber).setPlayer1(player);
                        } else {
                            matches.get(matchNumber).setPlayer2(player);
                            matchNumber++;
                        }
                    }
                }
            }
        }
        profile.setMatches(matches);
    }

    private void addDecksToMatches(Profile profile, Document doc) {
        Elements recentMatchesDecks = doc.select("ul.deck");
        ArrayList<Match> matches = myProfile.getMatches();
        int matchNumber = 0;

        Deck deck1 = null;
        Deck deck2;

        for (Element matchesDeck : recentMatchesDecks) {
            Elements spells = matchesDeck.select("li.spell");
            if (deck1==null) {
                deck1 = new Deck();
                for (Element element : spells) {
                    String name = element.select("img").attr("src").replace("/images/cards/", "").replace(".png", "");
                    int cost = Integer.valueOf(element.select("div.elixir").select("img").attr("src").replace("/images/elixir/", "").replace(".png", ""));
                    int level = Integer.valueOf(element.select("div.change").text().replace("level ", ""));
                    deck1.addSpell(new Spell(name, cost, level));
                }
                matches.get(matchNumber).setPlayer1Deck(deck1);
            } else {
                deck2 = new Deck();
                for (Element element : spells) {
                    String name = element.select("img").attr("src").replace("/images/cards/", "").replace(".png", "");
                    int cost = Integer.valueOf(element.select("div.elixir").select("img").attr("src").replace("/images/elixir/", "").replace(".png", ""));
                    int level = Integer.valueOf(element.select("div.change").text().replace("level ", ""));
                    deck2.addSpell(new Spell(name, cost, level));
                }
                matches.get(matchNumber).setPlayer2Deck(deck2);
                deck1 = null;
                matchNumber++;
            }
        }
        profile.setMatches(matches);
    }



    private class ParseURL extends AsyncTask<Void, Void, Profile> {
        @Override
        protected void onPreExecute() {
            // Here you can show progress bar or something on the similar lines.
            // Since you are in a UI thread here.
            super.onPreExecute();
        }

        @Override
        protected Profile doInBackground(Void... params) {
            // Here you are in the worker thread and you are not allowed to access UI thread from here.
            // Here you can perform network operations or any heavy operations you want.
            String siteUrl = BASE_URL.concat(playerRef);
            try {
                Log.d("JSwa", "Connecting to ["+siteUrl+"]");
                Document doc  = Jsoup.connect(siteUrl).get();
                Log.d("JSwa", "Connected to ["+siteUrl+"]");
                myProfile = getProfile(doc);
            } catch(Throwable t) {
                t.printStackTrace();
            }
            return myProfile;
        }

        @Override
        protected void onPostExecute(Profile profile) {
            // After completing execution of given task, control will return here.
            // Hence if you want to populate UI elements with fetched data, do it here.
            super.onPostExecute(profile);

            Bundle bundle = new Bundle();
            bundle.putSerializable("myProfile", profile);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
