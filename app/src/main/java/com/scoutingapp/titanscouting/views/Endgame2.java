package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Endgame2 extends AppCompatActivity {
    Match match;
    MatchViewModel matchViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame2);

        EditText e = findViewById(R.id.comments);
        RadioGroup r = findViewById(R.id.parkPosition);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;

            // r.setSelection(stagePositions.indexOf(match.getEndgamePos()));
            r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton b = findViewById(checkedId);
                    match.setEndgamePos(b.getText().toString());
                }
            });

            ((RatingBar) (findViewById(R.id.ratingBar1))).setRating(match.getMechanicalReliability());
            ((RatingBar) (findViewById(R.id.ratingBar1))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setMechanicalReliability((int) (rating));
                }
            });
            ((RatingBar) (findViewById(R.id.ratingBar2))).setRating(match.getDefenseAbility());
            ((RatingBar) (findViewById(R.id.ratingBar2))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setDefenseAbility((int) (rating));
                }
            });
            ((RatingBar) (findViewById(R.id.ratingBar3))).setRating(match.getDriverQuality());
            ((RatingBar) (findViewById(R.id.ratingBar3))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setDriverQuality((int) (rating));
                }
            });
            ((RatingBar) (findViewById(R.id.ratingBar4))).setRating(match.getEfficiency());
            ((RatingBar) (findViewById(R.id.ratingBar4))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setEfficiency((int) (rating));
                }
            });

            e.setText(match.getNotes());

            ((EditText) (findViewById(R.id.comments))).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    match.setNotes(s.toString());
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        });
        View backButton = findViewById(R.id.backButton);
        View nextButton = findViewById(R.id.nextButton);
        backButton.setOnClickListener(v -> {
            Intent i = new Intent(Endgame2.this, Teleop.class);
            i.putExtra("matchNumber", match.getMatchNum());
            matchViewModel.addMatchInformation(match);
            startActivity(i);
        });
        nextButton.setOnClickListener(v -> {
            Intent i = new Intent(Endgame2.this, Summary.class);
            i.putExtra("matchNumber", match.getMatchNum());
            matchViewModel.addMatchInformation(match);
            startActivity(i);
        });
    }
}