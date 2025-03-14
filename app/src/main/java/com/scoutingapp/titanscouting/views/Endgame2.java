package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.activity_endgame2); /* connects xml to the class file */

        EditText e = findViewById(R.id.comments); /*assigns variable e to what is typed in the comments (id)*/
        RadioGroup r = findViewById(R.id.parkPosition); /*assigns variable r to which park position is chosen (id)*/

        RadioButton parkRadio = findViewById(R.id.parkRadio);
        RadioButton deepCageRadio = findViewById(R.id.deepCageRadio);
        RadioButton attemptedDeepRadio = findViewById(R.id.attemptedDeepRadio);
        RadioButton shallowCageRadio = findViewById(R.id.shallowCageRadio);
        RadioButton attemptedShallowRadio = findViewById(R.id.attemptedShallowRadio);
        RadioButton noneRadio = findViewById(R.id.noneRadio);


        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;

            if (match.getEndgamePos()!=null) {
                switch (match.getEndgamePos()) {
                    case "Park":
                        r.check(R.id.parkRadio);
                        break;
                    case "Deep Cage":
                        r.check(R.id.deepCageRadio);
                        break;
                    case "Attempted Deep Cage":
                        r.check(R.id.attemptedDeepRadio);
                        break;
                    case "Shallow Cage":
                        r.check(R.id.shallowCageRadio);
                        break;
                    case "Attempted Shallow Cage":
                        r.check(R.id.attemptedShallowRadio);
                        break;
                    case "None":
                        r.check(R.id.noneRadio);
                        break;
                    default:
                        r.check(R.id.noneRadio);
                }
            }
            // r.setSelection(stagePositions.indexOf(match.getEndgamePos()));
            r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton b = findViewById(checkedId);
                    match.setEndgamePos(b.getText().toString()); /* set match game to a string */
                }
            });

            ((RatingBar) (findViewById(R.id.ratingBar1))).setRating(match.getMechanicalReliability());
            ((RatingBar) (findViewById(R.id.ratingBar1))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) { /*set constructor for mechanical reliabilty*/
                    match.setMechanicalReliability((int) (rating));
                }
            });
            ((RatingBar) (findViewById(R.id.ratingBar2))).setRating(match.getDefenseAbility()); /* fetch ID for defesne ability rating bar*/
            ((RatingBar) (findViewById(R.id.ratingBar2))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) { /*set constructor for defense reliabilty*/
                    match.setDefenseAbility((int) (rating));
                }
            }); /*fetch ID for driver quality rating bar*/
            ((RatingBar) (findViewById(R.id.ratingBar3))).setRating(match.getDriverQuality());
            ((RatingBar) (findViewById(R.id.ratingBar3))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) { /*set constructur for driver quality*/
                    match.setDriverQuality((int) (rating));
                }
            }); /*fetch ID for efficiency rating bar*/
            ((RatingBar) (findViewById(R.id.ratingBar4))).setRating(match.getEfficiency());
            ((RatingBar) (findViewById(R.id.ratingBar4))).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                /* set ID for each rating bar */
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    match.setEfficiency((int) (rating)); /*set constructor for effeciency */
                }
            });

            e.setText(match.getNotes());

            ((EditText) (findViewById(R.id.comments))).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) { /*set constructor for notes before changes*/

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) { /*set constructor for notes when text changes*/
                    match.setNotes(s.toString()); /*set match notes to string*/
                }
                @Override
                public void afterTextChanged(Editable s) { /*allow text to be edited*/
                }
            });
            /* move to previous activity when pressing back/next button*/
        });
        View backButton = findViewById(R.id.back_to_teleop);
        View nextButton = findViewById(R.id.to_summary);

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

    public void backTeleop(View v) {

        Intent i = new Intent (this, Teleop2.class);
        i.putExtra("matchNumber", match.getMatchNum());
        matchViewModel.addMatchInformation(match);
        startActivity(i);
    }
}