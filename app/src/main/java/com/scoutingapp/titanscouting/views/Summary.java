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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        View submit = findViewById(R.id.submit);
        View toEndgameButton = findViewById(R.id.back);

        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        liveDataMatch = matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0));

        liveDataMatch.observe(this, match -> {
            ((TextView) (findViewById(R.id.matchNumberSummary))).setText(String.valueOf(match.getMatchNum()));

            ((TextView) (findViewById(R.id.teamNumberSummary))).setText(String.valueOf(match.getTeamNumber()));

            ((TextView) (findViewById(R.id.teamPositionSummary))).setText(match.getPosition());

            ((TextView) (findViewById(R.id.scouterNameSummary))).setText(match.getScouterName());

            if (match.isNoShow()){
                ((TextView) (findViewById(R.id.noShowSummary))).setText("True");
            }

            if (match.isPerformedLeave()){
                ((TextView) (findViewById(R.id.performedLeaveSummary))).setText("True");
            }

            ((TextView) (findViewById(R.id.startingPositionSummary))).setText(match.getStartingPosition());

            ((TextView) (findViewById(R.id.autoAmpScoredSummary))).setText(String.valueOf(match.getAutoAmpScored()));

            ((TextView) (findViewById(R.id.autoAmpMissedSummary))).setText(String.valueOf(match.getAutoAmpMissed()));

            ((TextView) (findViewById(R.id.autoSpeakerScoredSummary))).setText(String.valueOf(match.getAutoSpeakerScored()));

            ((TextView) (findViewById(R.id.autoSpeakerMissedSummary))).setText(String.valueOf(match.getAutoSpeakerMissed()));

            ((TextView) (findViewById(R.id.teleopAmpScoredSummary))).setText(String.valueOf(match.getTeleopAmpScored()));

            ((TextView) (findViewById(R.id.teleopAmpMissedSummary))).setText(String.valueOf(match.getTeleopAmpMissed()));

            ((TextView) (findViewById(R.id.teleopSpeakerScoredSummary))).setText(String.valueOf(match.getTeleopSpeakerScored()));

            ((TextView) (findViewById(R.id.teleopSpeakerMissedSummary))).setText(String.valueOf(match.getTeleopSpeakerMissed()));

            ((TextView) (findViewById(R.id.stagePositionSummary))).setText(match.getStagePosition());

            if (match.isNoteInTrapScored()){
                ((TextView) (findViewById(R.id.noteInTrapScoredSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.noteInTrapScoredSummary))).setText("False");
            }

            if (match.isShootsFromSubwoofer()){
                ((TextView) (findViewById(R.id.subwooferSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.subwooferSummary))).setText("False");
            }

            ((TextView) (findViewById(R.id.penaltiesIncurredSummary))).setText(String.valueOf(match.getPenaltiesIncurred()));

            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(String.valueOf(match.getDriverQuality()));

            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));

            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));

            if (match.isDropsPiecesOften()){
                ((TextView) (findViewById(R.id.dropsPiecesOftenSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.dropsPiecesOftenSummary))).setText("False");
            }

            if (match.isPickRingsFromGround()){
                ((TextView) (findViewById(R.id.canPickFromGroundSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.canPickFromGroundSummary))).setText("False");
            }

            ((TextView) (findViewById(R.id.notesSummary))).setText("Notes: " + match.getNotes());

            submit.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Homepage.class);
                startActivity(i);
            });

            toEndgameButton.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Endgame.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });


    }
}