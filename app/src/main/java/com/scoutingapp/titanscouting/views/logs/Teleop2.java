package com.scoutingapp.titanscouting.views.logs;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Teleop2 extends AppCompatActivity {

    LiveData<Match> liveDataMatch;
    private Match match;
    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_2); // Ensure you have the correct layout

        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        liveDataMatch = matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0));

        liveDataMatch.observe(this, match -> {
            this.match = match;
            ((TextView) findViewById(R.id.speakerScored)).setText(String.valueOf(match.getTeleopSpeakerScored()));
            ((TextView) findViewById(R.id.speakerMissed)).setText(String.valueOf(match.getTeleopSpeakerMissed()));
            ((TextView) findViewById(R.id.ampScored)).setText(String.valueOf(match.getTeleopAmpScored()));
            ((TextView) findViewById(R.id.ampMissed)).setText(String.valueOf(match.getTeleopAmpMissed()));
        });
    }

    public void subtractAmpScored(View v) {
        TextView textView = findViewById(R.id.ampScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) - 1;
        if (ampScored < 0) {
            textView.setText("0");
            ampScored = 0;
        } else {
            textView.setText(String.valueOf(ampScored));
        }
        match.setTeleopAmpScored(ampScored);
        matchViewModel.addMatchInformation(match);
    }

    public void subtractAmpMissed(View v) {
        TextView textView = findViewById(R.id.ampMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) - 1;
        if (ampMissed < 0) {
            textView.setText("0");
            ampMissed = 0;
        } else {
            textView.setText(String.valueOf(ampMissed));
        }
        match.setTeleopAmpMissed(ampMissed);
        matchViewModel.addMatchInformation(match);
    }

    public void addAmpScored(View v) {
        TextView textView = findViewById(R.id.ampScored);
        int ampScored = Integer.parseInt(textView.getText().toString()) + 1;
        match.setTeleopAmpScored(ampScored);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampScored));
    }

    public void addAmpMissed(View v) {
        TextView textView = findViewById(R.id.ampMissed);
        int ampMissed = Integer.parseInt(textView.getText().toString()) + 1;
        match.setTeleopAmpMissed(ampMissed);
        matchViewModel.addMatchInformation(match);
        textView.setText(String.valueOf(ampMissed));
    }

    public void subtractSpeakerScored(View v) {
        TextView textView = findViewById(R.id.speakerScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) - 1;
        if (speakerScored < 0) {
            textView.setText("0");
            speakerScored = 0;
        } else {
            textView.setText(String.valueOf(speakerScored));
        }
        match.setTeleopSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);
    }

    public void subtractSpeakerMissed(View v) {
        TextView textView = findViewById(R.id.speakerMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) - 1;
        if (speakerMissed < 0) {
            textView.setText("0");
            speakerMissed = 0;
        } else {
            textView.setText(String.valueOf(speakerMissed));
        }
        match.setTeleopSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerScored(View v) {
        TextView textView = findViewById(R.id.speakerScored);
        int speakerScored = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerScored));
        match.setTeleopSpeakerScored(speakerScored);
        matchViewModel.addMatchInformation(match);
    }

    public void addSpeakerMissed(View v) {
        TextView textView = findViewById(R.id.speakerMissed);
        int speakerMissed = Integer.parseInt(textView.getText().toString()) + 1;
        textView.setText(String.valueOf(speakerMissed));
        match.setTeleopSpeakerMissed(speakerMissed);
        matchViewModel.addMatchInformation(match);
    }
}