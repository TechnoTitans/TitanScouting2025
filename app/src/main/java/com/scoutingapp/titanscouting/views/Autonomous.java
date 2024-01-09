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

public class Autonomous extends AppCompatActivity {

    private Match match;

    private int matchNum;

    private LiveData<Match> matchLiveData;

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

        matchLiveData = matchViewModel.getMatch(matchNum);

        matchLiveData.observe(this, currentMatch -> {
            if (match != null){
                match.setTeamNumber(currentMatch.getTeamNumber());
                match.setTeamNumber(currentMatch.getTeamNumber());
                match.setTeamNumber(currentMatch.getTeamNumber());
            }
        });
    }

    public void subtractAmpsScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpScoredNumberView);
        int ampScored = Integer.parseInt(textView.getText().toString()) - 1;

        if (ampScored < 0) {
            textView.setText("0");
        } else {
            textView.setText(String.valueOf(ampScored));
        }

    }

    public void addAmpsScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfAmpScoredNumberView);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(ampScored));
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

    public void addSpeakerScored(View v){
        TextView textView = (TextView) findViewById(R.id.numberOfSpeakerScoredNumberView);
        int speakerScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerScored));
    }

    public void teleOp(View v){
        TextView numOfAmpsTextView = (TextView) findViewById(R.id.numberOfAmpScoredNumberView);
        int ampScored = Integer.parseInt(numOfAmpsTextView.getText().toString());


        TextView numOfSpeakerTextView = (TextView) findViewById(R.id.numberOfSpeakerScoredNumberView);
        int speakerScored = Integer.parseInt(numOfSpeakerTextView.getText().toString());


        match.setAutoAmpScored(ampScored);
        match.setAutoSpeakerScored(speakerScored);

        matchViewModel.addAutonomousInformation(match);
        Intent i = new Intent(this, Teleop.class);
        startActivity(i);
    }


}