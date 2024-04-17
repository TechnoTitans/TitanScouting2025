package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

import org.w3c.dom.Text;

public class Autonomous extends AppCompatActivity {
    private Match match;
    private MatchViewModel matchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        TextView speakerScoredText = findViewById(R.id.speakerScored);
        TextView speakerMissedText = findViewById(R.id.speakerMissed);
        TextView ampScoredText = findViewById(R.id.ampScored);
        TextView ampMissedText = findViewById(R.id.ampMissed);



        CheckBox movedCheckBox = findViewById(R.id.movedCheckbox);
        CheckBox sourceCheckBox = findViewById(R.id.startsSourceSide);
        CheckBox middleCheckBox = findViewById(R.id.startsMiddle);
        CheckBox ampCheckBox = findViewById(R.id.startsAmpSide);

        View back = findViewById(R.id.backToPregame);
        View next = findViewById(R.id.nextToTeleop);

        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;
            speakerScoredText.setText(String.valueOf(match.getAutoSpeakerScored()));
            speakerMissedText.setText(String.valueOf(match.getAutoSpeakerMissed()));
            ampScoredText.setText(String.valueOf(match.getAutoAmpScored()));
            ampMissedText.setText(String.valueOf(match.getAutoAmpMissed()));

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
            ((Button) (findViewById(R.id.addAmps))).setOnClickListener(v -> {
                int ampScored = Integer.parseInt(ampScoredText.getText().toString()) + 1;
                match.setAutoAmpScored(ampScored);
                matchViewModel.addMatchInformation(match);
                ampScoredText.setText(String.valueOf(ampScored));
            });
            ((Button) (findViewById(R.id.subtractAmp))).setOnClickListener(v -> {
                int ampScored = Integer.parseInt(ampScoredText.getText().toString()) - 1;
                if (ampScored < 0) {
                    ampScoredText.setText("0");
                            ampScored = 0;
                } else {
                    ampScoredText.setText(String.valueOf(ampScored));
                }
                match.setAutoAmpScored(ampScored);
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.addAmpsMissed))).setOnClickListener(v -> {
                int ampMissed = Integer.parseInt(ampMissedText.getText().toString()) + 1;
                match.setAutoAmpMissed(ampMissed);
                matchViewModel.addMatchInformation(match);
                ampMissedText.setText(String.valueOf(ampMissed));
            });
            ((Button) (findViewById(R.id.subtractAmpsMissed))).setOnClickListener(v -> {
                int ampMissed = Integer.parseInt(ampMissedText.getText().toString()) - 1;
                if (ampMissed < 0) {
                    ampMissedText.setText("0");
                    ampMissed = 0;
                } else {
                    ampMissedText.setText(String.valueOf(ampMissed));
                }
                match.setAutoAmpMissed(ampMissed);
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.addSpeaker))).setOnClickListener(v -> {
                int speakerScored = Integer.parseInt(speakerScoredText.getText().toString()) + 1;
                match.setAutoSpeakerScored(speakerScored);
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.subtractSpeaker))).setOnClickListener(v -> {
                int speakerScored = Integer.parseInt(speakerScoredText.getText().toString()) - 1;
                if (speakerScored < 0) {
                    speakerScoredText.setText("0");
                            speakerScored = 0;
                } else {
                    speakerScoredText.setText(String.valueOf(speakerScored));
                }
                match.setAutoSpeakerScored(speakerScored);
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.subtractSpeakersMissed))).setOnClickListener(v -> {
                int speakerMissed = Integer.parseInt(speakerMissedText.getText().toString()) - 1;
                if (speakerMissed < 0) {
                    speakerMissedText.setText("0");
                    speakerMissed = 0;
                } else {
                    speakerMissedText.setText(String.valueOf(speakerMissed));
                }
                match.setAutoSpeakerMissed(speakerMissed);
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.addSpeakersMissed))).setOnClickListener(v -> {
                int speakerMissed = Integer.parseInt(speakerMissedText.getText().toString()) + 1;
                speakerMissedText.setText(String.valueOf(speakerMissed));
                match.setAutoSpeakerMissed(speakerMissed);
                matchViewModel.addMatchInformation(match);
            });
             next.setOnClickListener(v -> {
                Intent i = new Intent(this, Teleop.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
            back.setOnClickListener(v -> {
                Intent i = new Intent(this, Pregame.class);
                i.putExtra("transition", "fromAutonomous");
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });
    }
}



