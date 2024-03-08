package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
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
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                noShowCheckBox.setOnClickListener(v -> {
                    match.setNoShow(!match.isNoShow());
                    matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Red1))).setOnClickListener(v -> {
                    match.setPosition("R1");
                            matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Red2))).setOnClickListener(v -> {
                    match.setPosition("R2");
                    matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Red3))).setOnClickListener(v -> {
                    match.setPosition("R3");
                            matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Blue1))).setOnClickListener(v -> {
                    match.setPosition("B1");
                    matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Blue2))).setOnClickListener(v -> {
                    match.setPosition("B2");
                            matchViewModel.addMatchInformation(match);
                });
                ((Button) (findViewById(R.id.Blue3))).setOnClickListener(v -> {
                    match.setPosition("B3");
                    matchViewModel.addMatchInformation(match);
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
                        Intent i = new Intent(Pregame.this, Autonomous.class);
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
                }
                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            noShowCheckBox.setOnClickListener(v -> {
                match.setNoShow(!match.isNoShow());
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Red1))).setOnClickListener(v -> {
                match.setPosition("R1");
                        matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Red2))).setOnClickListener(v -> {
                match.setPosition("R2");
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Red3))).setOnClickListener(v -> {
                match.setPosition("R3");
                        matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Blue1))).setOnClickListener(v -> {
                match.setPosition("B1");
                matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Blue2))).setOnClickListener(v -> {
                match.setPosition("B2");
                        matchViewModel.addMatchInformation(match);
            });
            ((Button) (findViewById(R.id.Blue3))).setOnClickListener(v -> {
                match.setPosition("B3");
                matchViewModel.addMatchInformation(match);
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
                    Intent i = new Intent(Pregame.this, Autonomous.class);
                    i.putExtra("matchNumber", match.getMatchNum());
                    Log.d("transition", "working2");
                    startActivity(i);
                }
            });
        }
    }
}