package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;
public class Autonomous extends AppCompatActivity {

    private Match match;

    private MatchViewModel matchViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);


        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {

            this.match = match;

            ((TextView) findViewById(R.id.speakerScored)).setText(String.valueOf(match.getAutoSpeakerScored()));

            ((TextView) findViewById(R.id.speakerMissed)).setText(String.valueOf(match.getAutoSpeakerMissed()));

            ((TextView) findViewById(R.id.ampScored)).setText(String.valueOf(match.getAutoAmpScored()));

            ((TextView) findViewById(R.id.ampMissed)).setText(String.valueOf(match.getAutoAmpMissed()));


            CheckBox movedCheckBox = findViewById(R.id.movedCheckbox);

            CheckBox sourceCheckBox = findViewById(R.id.startsSourceSide);

            CheckBox middleCheckBox = findViewById(R.id.startsMiddle);

            CheckBox ampCheckBox = findViewById(R.id.startsAmpSide);



            if (match.isPerformedLeave()) {
                movedCheckBox.setChecked(true);
            }

            if (match.getStagePosition() != null) {
                switch (match.getStagePosition()) {
                    case "Source":
                        sourceCheckBox.setChecked(true);
                        break;
                    case "Amp":
                        ampCheckBox.setChecked(true);
                        break;
                    case "Middle":
                        middleCheckBox.setChecked(true);
                        break;
                }
            }


            movedCheckBox.setOnClickListener(v -> {
                match.setPerformedLeave(!match.isPerformedLeave());
                matchViewModel.addMatchInformation(match);
            });

            sourceCheckBox.setOnClickListener(v -> {
                match.setStartingPosition("Source");
                ampCheckBox.setChecked(false);
                middleCheckBox.setChecked(false);
                matchViewModel.addMatchInformation(match);
            });



            middleCheckBox.setOnClickListener(v -> {
                match.setStartingPosition("Middle");
                ampCheckBox.setChecked(false);
                sourceCheckBox.setChecked(false);
                matchViewModel.addMatchInformation(match);
            });



            ampCheckBox.setOnClickListener(v -> {
                match.setStartingPosition("Amp");
                sourceCheckBox.setChecked(false);
                middleCheckBox.setChecked(false);
                matchViewModel.addMatchInformation(match);
            });
        });

    }

    public void subtractAmpScored(View v){
        TextView textView = findViewById(R.id.ampScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampScored < 0) {
            textView.setText("0");
            ampScored = 0;
        } else {
            textView.setText(String.valueOf(ampScored));
        }

        match.setAutoAmpScored(ampScored);

        matchViewModel.addMatchInformation(match);

    }



    public void subtractAmpMissed(View v){
        TextView textView = findViewById(R.id.ampMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampMissed < 0) {
            textView.setText("0");
            ampMissed = 0;
        } else {
            textView.setText(String.valueOf(ampMissed));
        }

        match.setAutoAmpMissed(ampMissed);

        matchViewModel.addMatchInformation(match);

    }

    public void addAmpScored(View v){
        TextView textView = findViewById(R.id.ampScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        match.setAutoAmpScored(ampScored);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampScored));
    }

    public void addAmpMissed(View v){
        TextView textView = findViewById(R.id.ampMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) + 1;
        match.setAutoAmpMissed(ampMissed);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampMissed));
    }



    public void subtractSpeakerScored(View v){
        TextView textView = findViewById(R.id.speakerScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) - 1;


        if (speakerScored < 0) {
            textView.setText("0");
            speakerScored = 0;
        } else {
            textView.setText(String.valueOf(speakerScored));
        }

        match.setAutoSpeakerScored(speakerScored);

        matchViewModel.addMatchInformation(match);
    }

    public void subtractSpeakerMissed(View v){
        TextView textView = findViewById(R.id.speakerMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) - 1;

        if (speakerMissed < 0) {
            textView.setText("0");
            speakerMissed = 0;
        } else {
            textView.setText(String.valueOf(speakerMissed));
        }

        match.setAutoSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerScored(View v){
        TextView textView = findViewById(R.id.speakerScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerScored));
        match.setAutoSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerMissed(View v){
        TextView textView = findViewById(R.id.speakerMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerMissed));
        match.setAutoSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);
    }

    public void teleOp(View v){
        Intent i = new Intent(this, Teleop.class);
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }

    public void preGame(View v){
        Intent i = new Intent(this, Pregame.class);
        i.putExtra("transition", "fromAuto");
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }


}