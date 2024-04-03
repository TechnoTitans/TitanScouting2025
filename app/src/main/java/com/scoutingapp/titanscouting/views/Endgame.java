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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.stagePositions,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ((Spinner) (findViewById(R.id.stagePositionSpinner))).setAdapter(adapter);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;
            ((Spinner) (findViewById(R.id.stagePositionSpinner))).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    match.setStagePosition((String) parent.getItemAtPosition(position));
                    matchViewModel.addMatchInformation(match);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
            ((CheckBox) (findViewById(R.id.noteInTrapCheckBox))).setChecked(match.isNoteInTrapScored());
            ((CheckBox) (findViewById(R.id.noteInTrapCheckBox))).setOnClickListener(v -> {
                match.setNoteInTrapScored(!match.isNoteInTrapScored());
                matchViewModel.addMatchInformation(match);
            });
            ((CheckBox) (findViewById(R.id.subwooferCheckbox))).setChecked(match.isShootsFromSubwoofer());
            ((CheckBox) (findViewById(R.id.subwooferCheckbox))).setOnClickListener(v -> {
                match.setShootsFromSubwoofer(!match.isShootsFromSubwoofer());
                matchViewModel.addMatchInformation(match);
            });
            ((RatingBar) (findViewById(R.id.driverQualityRatingBar))).setRating(match.getDriverQuality());
            ((RatingBar) (findViewById(R.id.driverQualityRatingBar))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setDriverQuality((int) (rating));
                    matchViewModel.addMatchInformation(match);
                }
            });
            ((CheckBox) (findViewById(R.id.dropsPiecesOftenCheckBox))).setChecked(match.isDropsPiecesOften());
            ((CheckBox) (findViewById(R.id.dropsPiecesOftenCheckBox))).setOnClickListener(v -> {
                match.setDropsPiecesOften(!match.isDropsPiecesOften());
                matchViewModel.addMatchInformation(match);
            });
            ((CheckBox) (findViewById(R.id.pickRingsFromGroundCheckBox))).setChecked(match.isPickRingsFromGround());
            ((CheckBox) (findViewById(R.id.pickRingsFromGroundCheckBox))).setOnClickListener(v -> {
                match.setPickRingsFromGround(!match.isPickRingsFromGround());
                matchViewModel.addMatchInformation(match);
            });
            ((CheckBox) (findViewById(R.id.penaltiesIncurredCheckBox))).setChecked(match.isPenaltiesIncured());
            ((CheckBox) (findViewById(R.id.penaltiesIncurredCheckBox))).setOnClickListener(v -> {
                match.setPenaltiesIncured(!match.isPenaltiesIncured());
                matchViewModel.addMatchInformation(match);
            });
            ((RatingBar) (findViewById(R.id.defenseAbilityRatingBar))).setRating(match.getDefenseAbility());
            ((RatingBar) (findViewById(R.id.defenseAbilityRatingBar))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setDefenseAbility((int) (rating));
                    matchViewModel.addMatchInformation(match);
                }
            });
            ((RatingBar) (findViewById(R.id.mechanicalReliabilityRatingBar))).setRating(match.getMechanicalReliability());
            ((RatingBar) (findViewById(R.id.mechanicalReliabilityRatingBar))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setMechanicalReliability((int) (rating));
                    matchViewModel.addMatchInformation(match);
                }
            });
            ((EditText) (findViewById(R.id.commentsEditText))).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    match.setNotes(s.toString());
                    matchViewModel.addMatchInformation(match);
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            ((RatingBar) (findViewById(R.id.driverQualityRatingBar))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setDriverQuality((int) (rating));
                    matchViewModel.addMatchInformation(match);
                }
            });
        });
        View backButton = findViewById(R.id.backButton);
        View nextButton = findViewById(R.id.nextButton);
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