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
            ((TextView) (findViewById(R.id.matchNumberSummary))).setText(String.valueOf(match.getMatchNum()));

            ((TextView) (findViewById(R.id.teamNumberSummary))).setText(String.valueOf(match.getTeamNumber()));

            ((TextView) (findViewById(R.id.teamPositionSummary))).setText(match.getPosition());

            ((TextView) (findViewById(R.id.scouterNameSummary))).setText(match.getScouterName());

            if (match.isNoShow()){
                ((TextView) (findViewById(R.id.noShowSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.noShowSummary))).setText("False");
            }

            if (match.isPerformedLeave()){
                ((TextView) (findViewById(R.id.performedLeaveSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.performedLeaveSummary))).setText("False");
            }

            ((TextView) (findViewById(R.id.l1Summary))).setText(match.getL1Count());

//            ((TextView) (findViewById(R.id.startingPositionSummary))).setText(match.getStartingPosition());
//
//            ((TextView) (findViewById(R.id.autoAmpScoredSummary))).setText(String.valueOf(match.getAutoAmpScored()));
//
//            ((TextView) (findViewById(R.id.autoAmpMissedSummary))).setText(String.valueOf(match.getAutoAmpMissed()));
//
//            ((TextView) (findViewById(R.id.autoSpeakerScoredSummary))).setText(String.valueOf(match.getAutoSpeakerScored()));
//
//            ((TextView) (findViewById(R.id.autoSpeakerMissedSummary))).setText(String.valueOf(match.getAutoSpeakerMissed()));

            ((TextView) (findViewById(R.id.l2Summary))).setText(String.valueOf(match.getL2Count()));

            ((TextView) (findViewById(R.id.l3Summary))).setText(String.valueOf(match.getL3Count()));

            ((TextView) (findViewById(R.id.l4Summary))).setText(String.valueOf(match.getL4Count()));

            ((TextView) (findViewById(R.id.processorCountSummary))).setText(String.valueOf(match.getProcessorCount()));

            ((TextView) (findViewById(R.id.netCountSummary))).setText(match.getNetCount());
            
            ((TextView) (findViewById(R.id.endgamePosSummary))).setText(match.getEndgamePos());
            
            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(match.getDriverQuality());

            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));
            
            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));

            ((TextView) (findViewById(R.id.efficiencySummary))).setText(match.getNetCount());
            
            ((TextView) (findViewById(R.id.notesSummary))).setText(match.getNotes());

            backButton.setOnClickListener(v -> {
                Intent i = new Intent(this, Logs.class);
                startActivity(i);
            });

            qrButton.setOnClickListener(v -> {
                Intent i = new Intent(this, QRScreen.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });



    }
}