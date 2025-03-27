package com.scoutingapp.titanscouting.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scoutingapp.titanscouting.Homepage;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Summary extends AppCompatActivity {

    LiveData<Match> liveDataMatch;

    Match match;

    MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Called when the activity is first created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary); // Sets the layout for the activity

// Finds views by their ID
        View submit = findViewById(R.id.submit);
        View toEndgameButton = findViewById(R.id.back);

// Initializes match object and ViewModel
        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

// Retrieves match data based on match number passed in the intent
        liveDataMatch = matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0));

// Observes the match LiveData and updates the UI when data changes
        liveDataMatch.observe(this, match -> {
            this.match = match;
            ((TextView) (findViewById(R.id.matchNumberSummary))).setText(String.valueOf(match.getMatchNum()));

            ((TextView) (findViewById(R.id.teamNumberSummary))).setText(String.valueOf(match.getTeamNumber()));

            ((TextView) (findViewById(R.id.teamPositionSummary))).setText(match.getPosition());

            ((TextView) (findViewById(R.id.scouterNameSummary))).setText(match.getScouterName());

            if (match.isNoShow()){
                ((TextView) (findViewById(R.id.noShowSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.noShowSummary))).setText("False");
            }


            ((TextView) (findViewById(R.id.l1Summary))).setText(String.format("%d/%d", match.getL1Count(), match.getL1MissedCount()));

            ((TextView) (findViewById(R.id.l2Summary))).setText(String.format("%d/%d", match.getL2Count(), match.getL2MissedCount()));

            ((TextView) (findViewById(R.id.l3Summary))).setText(String.format("%d/%d", match.getL3Count(), match.getL3MissedCount()));

            ((TextView) (findViewById(R.id.l4Summary))).setText(String.format("%d/%d", match.getL4Count(), match.getL4MissedCount()));

            ((TextView) (findViewById(R.id.processorCountSummary))).setText(String.format("%d/%d", match.getProcessorCount(), match.getProcessorMissedCount()));

            ((TextView) (findViewById(R.id.netCountSummary))).setText(String.format("%d/%d", match.getNetCount(), match.getNetMissedCount()));

            ((TextView) (findViewById(R.id.endgamePosSummary))).setText(match.getEndgamePos());

            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(String.valueOf(match.getDriverQuality()));

            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));

            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));

            ((TextView) (findViewById(R.id.efficiencySummary))).setText(String.valueOf(match.getEfficiency()));

            ((TextView) (findViewById(R.id.notesSummary))).setText(match.getNotes());

            // Sets click listener for submit button to navigate to Homepage
            submit.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Homepage.class);
                startActivity(i);
            });

            // Sets click listener for back button to navigate to Endgame2 with match number
            toEndgameButton.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Endgame2.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });

    }

}