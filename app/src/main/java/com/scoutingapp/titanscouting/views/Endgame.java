package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.ToggleButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;
public class Endgame extends AppCompatActivity {
    Match match;
    MatchViewModel matchViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);

        Spinner stagePositionSpinner = findViewById(R.id.stagePositionSpinner);
        CheckBox noteInTrapCheckbox = findViewById(R.id.noteInTrapCheckBox);
        CheckBox subwooferCheckbox = findViewById(R.id.subwooferCheckbox);
        RatingBar driverQualityRatingBar = findViewById(R.id.driverQualityRatingBar);
        CheckBox dropsPiecesCheckbox = findViewById(R.id.dropsPiecesOftenCheckBox);
        CheckBox picksRingsFromGroundCheckbox = findViewById(R.id.pickRingsFromGroundCheckBox);
        SeekBar penaltiesSeekbar = findViewById(R.id.penaltiesSeekBar);
        RatingBar defenseAbilityRatingBar = findViewById(R.id.defenseAbilityRatingBar);
        RatingBar mechanicalReliabilityRatingBar = findViewById(R.id.mechanicalReliabilityRatingBar);
        EditText commentsInput = findViewById(R.id.commentsEditText);

        View backButton = findViewById(R.id.backButton);
        View nextButton = findViewById(R.id.nextButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.stagePositions,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stagePositionSpinner.setAdapter(adapter);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;
            stagePositionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    match.setStagePosition((String) parent.getItemAtPosition(position));
                    matchViewModel.addMatchInformation(match);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    match.setStagePosition((String) parent.getItemAtPosition(0));
                    matchViewModel.addMatchInformation(match);
                }
            });

            noteInTrapCheckbox.setChecked(match.isNoteInTrapScored());
            noteInTrapCheckbox.setOnClickListener(v -> {
                match.setNoteInTrapScored(!match.isNoteInTrapScored());
                matchViewModel.addMatchInformation(match);
            });

            subwooferCheckbox.setChecked(match.isShootsFromSubwoofer());
            subwooferCheckbox.setOnClickListener(v -> {
                match.setShootsFromSubwoofer(!match.isShootsFromSubwoofer());
                matchViewModel.addMatchInformation(match);
            });

            driverQualityRatingBar.setRating(match.getDriverQuality());
            driverQualityRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
                match.setDriverQuality((int) (rating));
                matchViewModel.addMatchInformation(match);
            });
            dropsPiecesCheckbox.setChecked(match.isDropsPiecesOften());
            dropsPiecesCheckbox.setOnClickListener(v -> {
                match.setDropsPiecesOften(!match.isDropsPiecesOften());
                matchViewModel.addMatchInformation(match);
            });
            picksRingsFromGroundCheckbox.setChecked(match.isPickRingsFromGround());
            picksRingsFromGroundCheckbox.setOnClickListener(v -> {
                match.setPickRingsFromGround(!match.isPickRingsFromGround());
                matchViewModel.addMatchInformation(match);
            });
            penaltiesSeekbar.setProgress(match.getPenaltiesIncurred());
            penaltiesSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    match.setPenaltiesIncurred(progress);
                    matchViewModel.addMatchInformation(match);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}
            });
            defenseAbilityRatingBar.setRating(match.getDefenseAbility());
            defenseAbilityRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
                match.setDefenseAbility((int) (rating));
                matchViewModel.addMatchInformation(match);
            });
            mechanicalReliabilityRatingBar.setRating(match.getMechanicalReliability());
            mechanicalReliabilityRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
                match.setMechanicalReliability((int) (rating));
                matchViewModel.addMatchInformation(match);
            });
            commentsInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    match.setNotes(s.toString());
                    matchViewModel.addMatchInformation(match);
                    commentsInput.postDelayed(() -> {
                        commentsInput.setSelection(commentsInput.length());
                    }, 0);
                }
                @Override
                public void afterTextChanged(Editable s) {}
            });
        });

        backButton.setOnClickListener(v -> {
            Intent i = new Intent(Endgame.this, Teleop.class);
            i.putExtra("matchNumber", match.getMatchNum());
            startActivity(i);
        });
        nextButton.setOnClickListener(v -> {
            Intent i = new Intent(Endgame.this, Summary.class);
            i.putExtra("matchNumber", match.getMatchNum());
            startActivity(i);
        });
    }
}