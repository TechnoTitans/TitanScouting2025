package com.scoutingapp.titanscouting.views;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import com.scoutingapp.titanscouting.Homepage;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import java.util.Objects;
public class Pregame extends AppCompatActivity {
    MatchViewModel matchViewModel;
    Match match;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        //all elements
        EditText matchNumberInput = findViewById(R.id.MatchNumberPregameResponse);
        EditText teamNumberInput = findViewById(R.id.TeamNumberResponsePregame);
        EditText scouterNameInput = findViewById(R.id.ScouterNamePregameResponse);
        CheckBox noShowCheckBox = findViewById(R.id.noShowCheckBox);

        View red1 = findViewById(R.id.Red1);
        View red2 = findViewById(R.id.Red2);
        View red3 = findViewById(R.id.Red3);
        View blue1 = findViewById(R.id.Blue1);
        View blue2 = findViewById(R.id.Blue2);
        View blue3 = findViewById(R.id.Blue3);

        if (Objects.equals(getIntent().getStringExtra("transition"), "fromAutonomous"))
        {
            matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
                ((EditText) (findViewById(R.id.MatchNumberPregameResponse))).setText(String.valueOf(match.getMatchNum()));
                ((EditText) (findViewById(R.id.TeamNumberResponsePregame))).setText(String.valueOf(match.getTeamNumber()));
                ((EditText) (findViewById(R.id.ScouterNamePregameResponse))).setText(String.valueOf(match.getScouterName()));
                matchNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!s.toString().isEmpty()) {
                            match.setMatchNum(Integer.parseInt(s.toString().trim()));
                            matchViewModel.addMatchInformation(match);
                            matchNumberInput.postDelayed(() -> {
                                matchNumberInput.setSelection(matchNumberInput.length());
                            }, 0);
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                teamNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!s.toString().isEmpty()) {
                            match.setTeamNumber(Integer.parseInt(s.toString().trim()));
                            matchViewModel.addMatchInformation(match);
                            teamNumberInput.postDelayed(() -> {
                                teamNumberInput.setSelection(teamNumberInput.length());
                            }, 0);
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                scouterNameInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        match.setScouterName(s.toString());
                        matchViewModel.addMatchInformation(match);
                        teamNumberInput.postDelayed(() -> {
                            teamNumberInput.setSelection(teamNumberInput.length());
                        }, 0);
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                noShowCheckBox.setOnClickListener(v -> {
                    match.setNoShow(!match.isNoShow());
                    matchViewModel.addMatchInformation(match);
                });

                red1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R1".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R2".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R3".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B1".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B2".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B3".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));



                red1.setOnClickListener(v -> {
                    match.setPosition("R1");
                    Log.d("background_color", Objects.requireNonNull(v.getBackgroundTintList()).toString());
                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });
                red2.setOnClickListener(v -> {
                    match.setPosition("R2");

                });
                red3.setOnClickListener(v -> {
                    match.setPosition("R3");

                });
                blue1.setOnClickListener(v -> {
                    match.setPosition("B1");

                });
                blue2.setOnClickListener(v -> {
                    match.setPosition("B2");

                });
                blue3.setOnClickListener(v -> {
                    match.setPosition("B3");

                });
                ((Button) (findViewById(R.id.BackButtonPregame))).setOnClickListener(v -> {
                    Intent i = new Intent(Pregame.this, Homepage.class);
                    Log.d("transition", "working3");
                    startActivity(i);
                });
                ((Button) (findViewById(R.id.NextButtonPregame))).setOnClickListener(v -> {
                    if (match.isNoShow()) {
                        Intent i = new Intent(Pregame.this, Summary.class);
                        i.putExtra("matchNumber", match.getMatchNum());
                        Log.d("transition", "working1");
                                startActivity(i);
                    } else {
                        Intent i = new Intent(Pregame.this, Endgame2.class);
                        i.putExtra("matchNumber", match.getMatchNum());
                        Log.d("transition", "working2");
                        startActivity(i);
                    }
                });
            });
        } else {
            match = new Match();
            matchNumberInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!s.toString().isEmpty()) {
                        match.setMatchNum(Integer.parseInt(s.toString().trim()));
                        matchViewModel.addMatchInformation(match);
                        matchNumberInput.postDelayed(() -> {
                            matchNumberInput.setSelection(matchNumberInput.length());
                        }, 0);
                    }
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            teamNumberInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!s.toString().isEmpty()) {
                        match.setTeamNumber(Integer.parseInt(s.toString().trim()));
                        matchViewModel.addMatchInformation(match);
                        teamNumberInput.postDelayed(() -> {
                            teamNumberInput.setSelection(teamNumberInput.length());
                        }, 0);
                    }
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            scouterNameInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    match.setScouterName(s.toString());
                    matchViewModel.addMatchInformation(match);
                    scouterNameInput.postDelayed(() -> {
                        scouterNameInput.setSelection(scouterNameInput.length());
                    }, 0);
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            noShowCheckBox.setOnClickListener(v -> {
                match.setNoShow(!match.isNoShow());

            });

            red1.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "R1".equals(match.getPosition()) ? R.color.light_red : R.color.red));
            red2.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "R2".equals(match.getPosition()) ? R.color.light_red : R.color.red));
            red3.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "R3".equals(match.getPosition()) ? R.color.light_red : R.color.red));
            blue1.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "B1".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
            blue2.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "B2".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
            blue3.setBackgroundTintList(ContextCompat.getColorStateList(
                    this,
                    "B3".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));


            ((Button) (findViewById(R.id.Red1))).setOnClickListener(v -> {
                match.setPosition("R1");

                Log.d("background_color", Objects.requireNonNull(v.getBackgroundTintList()).toString());
                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.Red2))).setOnClickListener(v -> {
                match.setPosition("R2");

                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.Red3))).setOnClickListener(v -> {
                match.setPosition("R3");

                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.Blue1))).setOnClickListener(v -> {
                match.setPosition("B1");

                red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.Blue2))).setOnClickListener(v -> {
                match.setPosition("B2");

                red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.Blue3))).setOnClickListener(v -> {
                match.setPosition("B3");

                red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
            });
            ((Button) (findViewById(R.id.BackButtonPregame))).setOnClickListener(v -> {
                Intent i = new Intent(Pregame.this, Homepage.class);
                Log.d("transition", "working3");
                startActivity(i);
            });
            ((Button) (findViewById(R.id.NextButtonPregame))).setOnClickListener(v -> {
                if (match.isNoShow()) {
                    matchViewModel.addMatchInformation(match);
                    Intent i = new Intent(Pregame.this, Summary.class);
                    i.putExtra("matchNumber", match.getMatchNum());
                    Log.d("transition", "working1");
                    startActivity(i);
                } else {
                    matchViewModel.addMatchInformation(match);

                    Intent i = new Intent(Pregame.this, Endgame2.class);
                    i.putExtra("matchNumber", match.getMatchNum());
                    Log.d("transition", "working2");
                    startActivity(i);
                }
            });


        }


    }

}