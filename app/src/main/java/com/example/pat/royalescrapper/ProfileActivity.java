package com.example.pat.royalescrapper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pat.royalescrapper.adapters.HorizontalChestAdapter;
import com.example.pat.royalescrapper.adapters.VerticalMatchAdapter;
import com.example.pat.royalescrapper.model.Profile;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView horizontal_chestrecycler_view;
    private RecyclerView vertical_matchrecycler_view;
    private HorizontalChestAdapter horizontalChestAdapter;
    private VerticalMatchAdapter verticalMatchAdapter;

    Profile myProfile;

    View profileInclude;
    TextView playerLeveltv, playerNametv;
    TextView clantv, highestTrophiestv, lastKnownTrophiestv;
    TextView challengeCardsWontv, tournamentsCardsWontv, totalDonationstv;
    TextView bestSeasonRanktv, previousSeasonRanktv, legendaryTrophiestv;

    View chestsInclude;
    View matchesInclude;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_profile);
        instanceViews();

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            myProfile = (Profile) bundle.getSerializable("myProfile");
            setProfileFields(myProfile);
            setChestFields(myProfile);
            setMatchFields(myProfile);
        }
    }

    private void setProfileFields(Profile myProfile) {
        playerLeveltv.setText(String.valueOf(myProfile.getPlayer().getLevel()));
        playerNametv.setText(myProfile.getPlayer().getName());
        clantv.setText(myProfile.getPlayer().getClan());
        highestTrophiestv.setText(String.valueOf(myProfile.getPlayer().getHighestTrophies()));
        lastKnownTrophiestv.setText(String.valueOf(myProfile.getPlayer().getLastKnownTrophies()));
        challengeCardsWontv.setText(String.valueOf(myProfile.getPlayer().getChallengeCardsWon()));
        tournamentsCardsWontv.setText(String.valueOf(myProfile.getPlayer().getTournamentCardsWon()));
        totalDonationstv.setText(String.valueOf(myProfile.getPlayer().getTotalDonations()));
        bestSeasonRanktv.setText(String.valueOf(myProfile.getPlayer().getBestSeasonRank()));
        previousSeasonRanktv.setText(String.valueOf(myProfile.getPlayer().getPreviousSeasonRank()));
        legendaryTrophiestv.setText(String.valueOf(myProfile.getPlayer().getLegendaryTrophies()));
    }

    private void setChestFields(Profile profile) {
        horizontalChestAdapter =new HorizontalChestAdapter(this, profile.getChestSequence());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_chestrecycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_chestrecycler_view.setAdapter(horizontalChestAdapter);
        horizontalLayoutManager.scrollToPosition(2);
    }

    private void setMatchFields(Profile profile) {
        verticalMatchAdapter =new VerticalMatchAdapter(this, profile.getMatches());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        vertical_matchrecycler_view.setLayoutManager(horizontalLayoutManager);
        vertical_matchrecycler_view.setAdapter(verticalMatchAdapter);
    }

    private void instanceViews() {
        // PROFILE VIEWS
        profileInclude = findViewById(R.id.profileInclude);
        playerLeveltv = (TextView) profileInclude.findViewById(R.id.playerLeveltv);
        playerNametv = (TextView) profileInclude.findViewById(R.id.playerNametv);
        clantv = (TextView) profileInclude.findViewById(R.id.clantv);
        highestTrophiestv = (TextView) profileInclude.findViewById(R.id.highestTrophiestv);
        lastKnownTrophiestv = (TextView) profileInclude.findViewById(R.id.lastKnownTrophiestv);
        challengeCardsWontv = (TextView) profileInclude.findViewById(R.id.challengeCardsWontv);
        tournamentsCardsWontv = (TextView) profileInclude.findViewById(R.id.tournamentsCardsWontv);
        totalDonationstv = (TextView) profileInclude.findViewById(R.id.totalDonationstv);
        bestSeasonRanktv = (TextView) profileInclude.findViewById(R.id.bestSeasonRanktv);
        previousSeasonRanktv = (TextView) profileInclude.findViewById(R.id.previousSeasonRanktv);
        legendaryTrophiestv = (TextView) profileInclude.findViewById(R.id.legendaryTrophiestv);

        // CHEST VIEWS
        chestsInclude = findViewById(R.id.chestsInclude);
        horizontal_chestrecycler_view = (RecyclerView) chestsInclude.findViewById(R.id.horizontal_chestrecycler_view);

        // MATCH VIEWS
        matchesInclude = findViewById(R.id.matchesInclude);
        vertical_matchrecycler_view = (RecyclerView) matchesInclude.findViewById(R.id.vertical_matchesrecycler_view);
    }
}