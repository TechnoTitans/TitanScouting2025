package com.scoutingapp.titanscouting.views.logs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import com.scoutingapp.titanscouting.views.QRScreen;

public class SingleMatchView extends AppCompatActivity {

    LiveData<Match> liveDataMatch;

    Match match;

    MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_match_view);

        View backButton = findViewById(R.id.back);
        View qrButton = findViewById(R.id.submit);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        liveDataMatch = matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0));

        liveDataMatch.observe(this, match -> {
            if (match != null) {
                // Handling TextViews for match properties
                ((TextView) findViewById(R.id.matchNumberSummary)).setText(String.valueOf(match.getMatchNum()));
                ((TextView) findViewById(R.id.teamNumberSummary)).setText(String.valueOf(match.getTeamNumber()));

                // Handling position and scouterName (String values)
                ((TextView) findViewById(R.id.teamPositionSummary)).setText(match.getPosition() != null ? match.getPosition() : "N/A");
                ((TextView) findViewById(R.id.scouterNameSummary)).setText(match.getScouterName() != null ? match.getScouterName() : "N/A");

                if (match.isNoShow()) {
                    ((TextView) findViewById(R.id.noShowSummary)).setText("True");
                } else {
                    ((TextView) findViewById(R.id.noShowSummary)).setText("False");
                }

                // Handling int values (assuming they're not null)
                ((TextView) findViewById(R.id.l1Summary)).setText(String.valueOf(match.getL1Count()));  // int field
                ((TextView) findViewById(R.id.l2Summary)).setText(String.valueOf(match.getL2Count()));  // int field
                ((TextView) findViewById(R.id.l3Summary)).setText(String.valueOf(match.getL3Count()));  // int field
                ((TextView) findViewById(R.id.l4Summary)).setText(String.valueOf(match.getL4Count()));  // int field
                ((TextView) findViewById(R.id.processorCountSummary)).setText(String.valueOf(match.getProcessorCount())); // int field
                ((TextView) findViewById(R.id.netCountSummary)).setText(String.valueOf(match.getNetCount()));  // int field

                // Handling string fields with potential null values
                ((TextView) findViewById(R.id.endgamePosSummary)).setText(match.getEndgamePos() != null ? match.getEndgamePos() : "N/A");
                ((TextView) findViewById(R.id.driverQualitySummary)).setText(String.valueOf(match.getDriverQuality()));
                ((TextView) findViewById(R.id.defenseAbilitySummary)).setText(String.valueOf(match.getDefenseAbility())); // Assuming this is an int or float
                ((TextView) findViewById(R.id.mechanicalReliabilitySummary)).setText(String.valueOf(match.getMechanicalReliability())); // Assuming this is an int or float
                ((TextView) findViewById(R.id.efficiencySummary)).setText(String.valueOf(match.getEfficiency())); // Assuming this is an int or float

                // Handling the notes field (String value)
                ((TextView) findViewById(R.id.notesSummary)).setText(match.getNotes() != null ? match.getNotes() : "N/A");

                // Setting up button actions
                backButton.setOnClickListener(v -> {
                    Intent i = new Intent(this, Logs.class);
                    startActivity(i);
                });

                qrButton.setOnClickListener(v -> {
                    Intent i = new Intent(this, QRScreen.class);
                    i.putExtra("matchNumber", match.getMatchNum());
                    startActivity(i);
                });
            }
        });
    }
}
