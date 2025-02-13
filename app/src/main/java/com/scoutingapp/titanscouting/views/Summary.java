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
    //Allows us update the match as much as user wants to
    LiveData<Match> liveDataMatch;
    //
    Match match;

    MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Setting the layout we are using for the data
        setContentView(R.layout.activity_summary);

        // This just sets the buttons for submiting and going back
        View submit = findViewById(R.id.submit);
        View toEndgameButton = findViewById(R.id.back);

        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        // Retrieve Match object using match number from Intent
        liveDataMatch = matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0));
        // Observe changes in LiveData and update data accordingly
        liveDataMatch.observe(this, match -> {
            ((TextView) (findViewById(R.id.matchNumberSummary))).setText(String.valueOf(match.getMatchNum()));

            ((TextView) (findViewById(R.id.teamNumberSummary))).setText(String.valueOf(match.getTeamNumber()));

            ((TextView) (findViewById(R.id.teamPositionSummary))).setText(match.getPosition());

            ((TextView) (findViewById(R.id.scouterNameSummary))).setText(match.getScouterName());
            // Set no show status
            if (match.isNoShow()){
                ((TextView) (findViewById(R.id.noShowSummary))).setText("True");
            }

            // Set other match details for general match data by ids of data fields and uses get methods from the database
            ((TextView) findViewById(R.id.NetAlgae)).setText(match.getNetCount());

            ((TextView) findViewById(R.id.AlgaeProcessor)).setText(match.getProcessorCount());

            ((TextView) findViewById(R.id.CoralL1scored)).setText(match.getL1Count());

            ((TextView) findViewById(R.id.CoralL2scored)).setText(match.getL2Count());

            ((TextView) findViewById(R.id.CoralL3scored)).setText(match.getL3Count());

            ((TextView) findViewById(R.id.CoraL4scored)).setText(match.getL4Count());

            ((TextView) findViewById(R.id.ChainPostion)).setText(match.getEndgamePos());

            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(String.valueOf(match.getDriverQuality()));

            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));

            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));

            ((TextView) (findViewById(R.id.notesSummary))).setText(match.getNotes());


            // Click listener for submit button to navigate to Homepage
            submit.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Homepage.class);
                startActivity(i);
            });
            // Click listener for back button to navigate to Endgame2 activity
            toEndgameButton.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Endgame2.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });


    }

//    public void endgame(View v){
//        Intent i = new Intent(this, QRScreen.class);
//        i.putExtra("matchNumber", match.getMatchNum());
//        startActivity(i);
//    }
//
//    public void pregame(View v){
//        Intent i = new Intent(this, Endgame.class);
//        i.putExtra("matchNumber", match.getMatchNum());
//        startActivity(i);
//    }
}