package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
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

        ImageView noteA = (ImageView) (findViewById(R.id.noteA));
        ImageView noteB = (ImageView) (findViewById(R.id.noteB));
        ImageView noteC = (ImageView) (findViewById(R.id.noteC));
        ImageView noteD = (ImageView) (findViewById(R.id.noteD));
        ImageView noteE = (ImageView) (findViewById(R.id.noteE));
        ImageView noteF = (ImageView) (findViewById(R.id.noteF));
        ImageView noteG = (ImageView) (findViewById(R.id.noteG));
        ImageView noteH = (ImageView) (findViewById(R.id.noteH));
        Button clearButton = (Button) (findViewById(R.id.clearButton));

        CheckBox movedCheckBox = (CheckBox) (findViewById(R.id.movedCheckbox));

        View back = findViewById(R.id.backToPregame);
        View next = findViewById(R.id.nextToTeleop);

        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;

            if (match.isPerformedLeave()) {
                movedCheckBox.setChecked(true);
            }

            movedCheckBox.setOnClickListener(v -> {
                match.setPerformedLeave(!match.isPerformedLeave());
                matchViewModel.addMatchInformation(match);
            });

            noteA.setOnClickListener(v -> {
                match.setPath(match.getPath() + "A");
                noteA.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteB.setOnClickListener(v -> {
                match.setPath(match.getPath() + "B");
                noteB.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteC.setOnClickListener(v -> {
                match.setPath(match.getPath() + "C");
                noteC.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteD.setOnClickListener(v -> {
                match.setPath(match.getPath() + "D");
                noteD.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteE.setOnClickListener(v -> {
                match.setPath(match.getPath() + "E");
                noteE.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteF.setOnClickListener(v -> {
                match.setPath(match.getPath() + "F");
                noteF.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteG.setOnClickListener(v -> {
                match.setPath(match.getPath() + "G");
                noteG.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteH.setOnClickListener(v -> {
                match.setPath(match.getPath() + "H");
                noteH.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            clearButton.setOnClickListener(v -> {
                match.setPath("");
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



