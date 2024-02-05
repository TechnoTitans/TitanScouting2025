package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

import kotlinx.coroutines.internal.CoroutineExceptionHandlerImpl_commonKt;

public class Autonomous extends AppCompatActivity {

    private Match match;

    private int matchNum;

    private MatchViewModel matchViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);

        match = new Match();
        matchNum = getIntent().getIntExtra("matchNumber", 0);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        match.setMatchNum(matchNum);

        Log.d("stage", String.valueOf(match.getMatchNum()));

        match.setPerformedLeave(false);
        CheckBox movedCheckBox = (CheckBox) (findViewById(R.id.moved));

        movedCheckBox.setOnClickListener(v -> {
            match.setPerformedLeave(!match.isPerformedLeave());
            matchViewModel.addMatchInformation(match);
        });

        CheckBox sourceCheckBox = (CheckBox) (findViewById(R.id.startsSourceSide));

        sourceCheckBox.setOnClickListener(v -> {
            match.setPosition("Source");
            matchViewModel.addMatchInformation(match);
        });

        CheckBox middleCheckBox = (CheckBox) (findViewById(R.id.startsMiddle));

        middleCheckBox.setOnClickListener(v -> {
            match.setPosition("Middle");
            matchViewModel.addMatchInformation(match);
        });

        CheckBox ampCheckBox = (CheckBox) (findViewById(R.id.startsAmpSide));

        middleCheckBox.setOnClickListener(v -> {
            match.setPosition("Amp");
            matchViewModel.addMatchInformation(match);
        });

    }

    public void subtractAmpScored(View v){
        TextView textView = (TextView) findViewById(R.id.ampsScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampScored < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(ampScored));
        }

        match.setAutoAmpScored(ampScored);

        matchViewModel.addMatchInformation(match);

    }



    public void subtractAmpMissed(View v){
        TextView textView = (TextView) findViewById(R.id.ampsMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampMissed < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(ampMissed));
        }

        match.setAutoAmpMissed(ampMissed);

        matchViewModel.addMatchInformation(match);

    }

    public void addAmpScored(View v){
        TextView textView = (TextView) findViewById(R.id.ampsScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        match.setAutoAmpScored(ampScored);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampScored));
    }

    public void addAmpMissed(View v){
        TextView textView = (TextView) findViewById(R.id.ampsMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) + 1;
        match.setAutoAmpMissed(ampMissed);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampMissed));
    }



    public void subtractSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.speakersScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) - 1;

        match.setAutoSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);

        if (speakerScored < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(speakerScored));
        }
    }

    public void subtractSpeakerMissed(View v){
        TextView textView = (TextView) findViewById(R.id.speakersMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) - 1;

        match.setAutoSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);

        if (speakerMissed < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(speakerMissed));
        }
    }

    public void addSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.speakersScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerScored));
        match.setAutoSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerMissed(View v){
        TextView textView = (TextView) findViewById(R.id.speakersMissed);
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
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }


}