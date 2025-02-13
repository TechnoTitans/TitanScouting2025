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
            // Sets match number summary
            ((TextView) (findViewById(R.id.matchNumberSummary))).setText(String.valueOf(match.getMatchNum()));

            // Sets team number summary
            ((TextView) (findViewById(R.id.teamNumberSummary))).setText(String.valueOf(match.getTeamNumber()));

            // Sets team position summary
            ((TextView) (findViewById(R.id.teamPositionSummary))).setText(match.getPosition());

            // Sets scouter name summary
            ((TextView) (findViewById(R.id.scouterNameSummary))).setText(match.getScouterName());

            // Checks if the team was a no-show
            if (match.isNoShow()){
                ((TextView) (findViewById(R.id.noShowSummary))).setText("True");
            }

            // Checks if the team performed leave
            if (match.isPerformedLeave()){
                ((TextView) (findViewById(R.id.performedLeaveSummary))).setText("True");
            }

            // Sets starting position summary
            ((TextView) (findViewById(R.id.startingPositionSummary))).setText(match.getStartingPosition());

            // Sets path summary
            ((TextView) (findViewById(R.id.pathSummary))).setText(match.getPath());

            // Sets teleop scores and misses
            ((TextView) (findViewById(R.id.teleopAmpScoredSummary))).setText(String.valueOf(match.getTeleopAmpScored()));
            ((TextView) (findViewById(R.id.teleopAmpMissedSummary))).setText(String.valueOf(match.getTeleopAmpMissed()));
            ((TextView) (findViewById(R.id.teleopSpeakerScoredSummary))).setText(String.valueOf(match.getTeleopSpeakerScored()));
            ((TextView) (findViewById(R.id.teleopSpeakerMissedSummary))).setText(String.valueOf(match.getTeleopSpeakerMissed()));

            // Sets stage position summary
            ((TextView) (findViewById(R.id.stagePositionSummary))).setText(match.getStagePosition());

            // Checks if a note was scored in trap
            if (match.isNoteInTrapScored()){
                ((TextView) (findViewById(R.id.noteInTrapScoredSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.noteInTrapScoredSummary))).setText("False");
            }

            // Checks if shots were made from subwoofer
            if (match.isShootsFromSubwoofer()){
                ((TextView) (findViewById(R.id.subwooferSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.subwooferSummary))).setText("False");
            }

            // Sets penalties incurred summary
            ((TextView) (findViewById(R.id.penaltiesIncurredSummary))).setText(String.valueOf(match.getPenaltiesIncurred()));

            // Sets driver quality, defense ability, and mechanical reliability
            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(String.valueOf(match.getDriverQuality()));
            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));
            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));

            // Checks if the team drops pieces often
            if (match.isDropsPiecesOften()){
                ((TextView) (findViewById(R.id.dropsPiecesOftenSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.dropsPiecesOftenSummary))).setText("False");
            }

            // Checks if the team can pick rings from the ground
            if (match.isPickRingsFromGround()){
                ((TextView) (findViewById(R.id.canPickFromGroundSummary))).setText("True");
            } else {
                ((TextView) (findViewById(R.id.canPickFromGroundSummary))).setText("False");
            }

            // Sets notes summary

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

    // Method to navigate to QRScreen activity for endgame
    public void endgame(View v){
        // Creates an Intent to start the QRScreen activity
        Intent i = new Intent(this, QRScreen.class);

        // Passes the match number to the QRScreen activity
        i.putExtra("matchNumber", match.getMatchNum());

        // Starts the QRScreen activity
        startActivity(i);
    }

    // Method to navigate to Endgame activity for pregame
    public void pregame(View v){
        // Creates an Intent to start the Endgame activity
        Intent i = new Intent(this, Endgame.class);

        // Passes the match number to the Endgame activity
        i.putExtra("matchNumber", match.getMatchNum());

        // Starts the Endgame activity
        startActivity(i);
    }

}