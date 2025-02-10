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

            ((TextView) (findViewById(R.id.driverQualitySummary))).setText(String.valueOf(match.getDriverQuality()));

            ((TextView) (findViewById(R.id.defenseAbilitySummary))).setText(String.valueOf(match.getDefenseAbility()));

            ((TextView) (findViewById(R.id.mechanicalReliabilitySummary))).setText(String.valueOf(match.getMechanicalReliability()));
            ((TextView) (findViewById(R.id.notesSummary))).setText(match.getNotes());

            submit.setOnClickListener(v -> {
                Intent i = new Intent(Summary.this, Homepage.class);
                startActivity(i);
            });

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