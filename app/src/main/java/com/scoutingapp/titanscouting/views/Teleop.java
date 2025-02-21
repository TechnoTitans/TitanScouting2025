package com.scoutingapp.titanscouting.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Teleop extends AppCompatActivity {

    LiveData<Match> liveDataMatch;
    Match match;
    MatchViewModel matchViewModel;

    View l4AddButton = findViewById(R.id.inc_1);
    View l3AddButton = findViewById(R.id.inc_2);
    View l2AddButton = findViewById(R.id.inc_3);
    View l1AddButton = findViewById(R.id.inc_4);
    View l4RemoveButton = findViewById(R.id.dec_1);
    View l3RemoveButton = findViewById(R.id.dec_2);
    View l2RemoveButton = findViewById(R.id.dec_3);
    View l1RemoveButton = findViewById(R.id.dec_4);

    View addNetButton = findViewById(R.id.inc_5);
    View addProcessorButton = findViewById(R.id.inc_6);
    View removeNetButton = findViewById(R.id.dec_5);
    View removeProcessButton = findViewById(R.id.dec_6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_2);

        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        liveDataMatch.observe(this, match -> {

        });
    }

    public void increaseLevelCount(View v) {
        if (v.getId() == R.id.inc_1) {
            TextView l4Text = findViewById(R.id.l4Score);
            int l4Score = Integer.parseInt(l4Text.getText().toString()) + 1;
            match.setL4Count(l4Score);
            matchViewModel.addMatchInformation(match);
            l4Text.setText(String.valueOf(l4Score));
        } else if (v.getId() == R.id.inc_2) {
            TextView l3Text = findViewById(R.id.l3Score);
            int l3Score = Integer.parseInt(l3Text.getText().toString()) + 1;
            match.setL4Count(l3Score);
            matchViewModel.addMatchInformation(match);
            l3Text.setText(String.valueOf(l3Score));
        } else if (v.getId() == R.id.inc_3) {
            TextView l2Text = findViewById(R.id.l2Score);
            int l2Score = Integer.parseInt(l2Text.getText().toString()) + 1;
            match.setL2Count(l2Score);
            matchViewModel.addMatchInformation(match);
            l2Text.setText(String.valueOf(l2Score));
        } else if (v.getId() == R.id.inc_4) {
            TextView l1Text = findViewById(R.id.l1Score);
            int l1Score = Integer.parseInt(l1Text.getText().toString()) + 1;
            match.setL4Count(l1Score);
            matchViewModel.addMatchInformation(match);
            l1Text.setText(String.valueOf(l1Score));
        }
    }

//    public void decreaseLevelCount(View v) {
//        if (v.getId() == R.id.dec_1) {
//            TextView l4Text = findViewById(R.id.l4Score);
//        }
//    }
}