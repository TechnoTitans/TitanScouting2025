package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Teleop extends AppCompatActivity {

    LiveData<Match> liveDataMatch;

    private Match match;

    private int matchNum;

    private MatchViewModel matchViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        match = new Match();
        matchNum = getIntent().getIntExtra("matchNumber", 0);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        liveDataMatch = matchViewModel.getMatch(matchNum);

        liveDataMatch.observe(this, match -> {
            this.match = match;
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

        match.setTeleopAmpScored(ampScored);

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

        match.setTeleopAmpMissed(ampMissed);

        matchViewModel.addMatchInformation(match);

    }

    public void addAmpScored(View v){
        TextView textView = (TextView) findViewById(R.id.ampsScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        match.setTeleopAmpScored(ampScored);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampScored));
    }

    public void addAmpMissed(View v){
        TextView textView = (TextView) findViewById(R.id.ampsMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) + 1;
        match.setTeleopAmpMissed(ampMissed);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampMissed));
    }



    public void subtractSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.speakersScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) - 1;

        match.setTeleopSpeakerScored(speakerScored);
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

        match.setTeleopSpeakerMissed(speakerMissed);
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
        match.setTeleopSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerMissed(View v){
        TextView textView = (TextView) findViewById(R.id.speakersMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerMissed));
        match.setTeleopSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);
    }

    public void autonomous(View v){
        Intent i = new Intent(this, Autonomous.class);
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }

    public void endGame(View v){
        Intent i = new Intent(this, Endgame.class);
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }
}