package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Teleop extends AppCompatActivity {

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

        match.setMatchNum(matchNum);

        Log.d("stage", String.valueOf(match.getMatchNum()));
    }

    public void subtractAmpScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpScoredNumberView);
        int ampScored = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampScored < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(ampScored));
        }

    }



    public void subtractAmpMissed(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpMissedNumberView);
        int ampMissed = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampMissed < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(ampMissed));
        }

    }

    public void addAmpScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpScoredNumberView);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(ampScored));
    }

    public void addAmpMissed(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpMissedNumberView);
        int ampMissed = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(ampMissed));
    }



    public void subtractSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfSpeakerScoredNumberView);
        int speakerScored = Integer.parseInt(textView.getText().toString()) - 1;

        if (speakerScored < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(speakerScored));
        }
    }

    public void subtractSpeakerMissed(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfSpeakerMissedNumberView);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) - 1;

        if (speakerMissed < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(speakerMissed));
        }
    }



    public void addSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfSpeakerScoredNumberView);
        int speakerScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerScored));
    }

    public void addSpeakerMissed(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfSpeakerMissedNumberView);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerMissed));
    }

    public void teleOp(View v){
        int ampScored = Integer.parseInt(((TextView) findViewById(R.id.numberOfAmpScoredNumberView)).getText().toString());
        int ampMissed = Integer.parseInt(((TextView) findViewById(R.id.numberOfAmpMissedNumberView)).getText().toString());

        int speakerScored = Integer.parseInt(((TextView) findViewById(R.id.numberOfSpeakerScoredNumberView)).getText().toString());
        int speakerMissed = Integer.parseInt(((TextView) findViewById(R.id.numberOfSpeakerMissedNumberView)).getText().toString());

        match.setTeleopAmpScored(ampScored);
        match.setTeleopAmpMissed(ampMissed);

        match.setTeleopSpeakerScored(speakerScored);
        match.setTeleopSpeakerMissed(speakerMissed);

        matchViewModel.addTeleopInformation(match);

        Intent i = new Intent(this, Endgame.class);
        startActivity(i);
    }
}