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

// Inherit methods from AppCompatActivity
public class Pregame extends AppCompatActivity {
    // ViewModel to manage match-related data
    MatchViewModel matchViewModel;

    // Holds match data
    Match match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game); // Set the layout for the pregame screen

        // Initialize ViewModel to get the match data in MatchViewModel class
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        // Find input fields from the xml file by findViewById
        EditText matchNumberInput = findViewById(R.id.MatchNumberPregameResponse);
        EditText teamNumberInput = findViewById(R.id.TeamNumberResponsePregame);
        EditText scouterNameInput = findViewById(R.id.ScouterNamePregameResponse);
        CheckBox noShowCheckBox = findViewById(R.id.noShowCheckBox);

        // Assign views for team alliance colors (red and blue)
        View red1 = findViewById(R.id.Red1);
        View red2 = findViewById(R.id.Red2);
        View red3 = findViewById(R.id.Red3);
        View blue1 = findViewById(R.id.Blue1);
        View blue2 = findViewById(R.id.Blue2);
        View blue3 = findViewById(R.id.Blue3);


        // Check if the intent's "transition" extra equals "fromAutonomous"
        if (Objects.equals(getIntent().getStringExtra("transition"), "fromAutonomous")) {

            // Retrieve match data using match number from intent and observe changes
            matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {

                // Set the retrieved match details in the corresponding EditText fields
                ((EditText) (findViewById(R.id.MatchNumberPregameResponse))).setText(String.valueOf(match.getMatchNum()));
                ((EditText) (findViewById(R.id.TeamNumberResponsePregame))).setText(String.valueOf(match.getTeamNumber()));
                ((EditText) (findViewById(R.id.ScouterNamePregameResponse))).setText(String.valueOf(match.getScouterName()));

                // Add a TextWatcher to matchNumberInput to update match number when text changes
                matchNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // No action needed before text changes
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Ensure the input is not empty before updating the match number
                        if (!s.toString().isEmpty()) {
                            match.setMatchNum(Integer.parseInt(s.toString().trim())); // Update match number
                            matchViewModel.addMatchInformation(match); // Save updated match information

                            // Delay setting cursor position to the end of the input
                            matchNumberInput.postDelayed(() -> {
                                matchNumberInput.setSelection(matchNumberInput.length());
                            }, 0);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // No action needed after text changes
                    }
                });

                // Add a TextWatcher to teamNumberInput to update team number when text changes
                teamNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // No action needed before text changes
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Ensure the input is not empty before updating the team number
                        if (!s.toString().isEmpty()) {
                            match.setTeamNumber(Integer.parseInt(s.toString().trim())); // Update team number
                            matchViewModel.addMatchInformation(match); // Save updated match information

                            // Delay setting cursor position to the end of the input
                            teamNumberInput.postDelayed(() -> {
                                teamNumberInput.setSelection(teamNumberInput.length());
                            }, 0);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // No action needed after text changes
                    }
                });
                // Add a TextWatcher to scouterNameInput to update scouter name when text changes
                scouterNameInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // No action needed before text changes
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        match.setScouterName(s.toString()); // Update scouter name
                        matchViewModel.addMatchInformation(match); // Save updated match information

                        // Delay setting cursor position to the end of the input
                        teamNumberInput.postDelayed(() -> {
                            teamNumberInput.setSelection(teamNumberInput.length());
                        }, 0);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // No action needed after text changes
                    }
                });

// Set an OnClickListener for noShowCheckBox to toggle match no-show status
                noShowCheckBox.setOnClickListener(v -> {
                    match.setNoShow(!match.isNoShow()); // Toggle no-show status
                    matchViewModel.addMatchInformation(match); // Save updated match information
                });

// Set background colors based on match position
                red1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "R1".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "R2".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "R3".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "B1".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "B2".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this, "B3".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));

// Set OnClickListeners for position selection buttons
                red1.setOnClickListener(v -> {
                    match.setPosition("R1"); // Set match position to R1
                    Log.d("background_color", Objects.requireNonNull(v.getBackgroundTintList()).toString());
                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

// Similar click listeners for other position buttons
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

// Set OnClickListener for Back button to navigate to Homepage
                ((Button) (findViewById(R.id.BackButtonPregame))).setOnClickListener(v -> {
                    Intent i = new Intent(Pregame.this, Homepage.class);
                    Log.d("transition", "working3");
                    startActivity(i);
                });

// Set OnClickListener for Next button to navigate based on match no-show status
                ((Button) (findViewById(R.id.NextButtonPregame))).setOnClickListener(v -> {
                    if (match.isNoShow()) {
                        Intent i = new Intent(Pregame.this, Summary.class);
                        i.putExtra("matchNumber", match.getMatchNum());
                        Log.d("transition", "working1");
                        startActivity(i);
                    }
                });

// Initialize a new Match object if no transition data is provided
                match = new Match();

// Add TextWatcher to matchNumberInput to update match number
                matchNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!s.toString().isEmpty()) {
                            match.setMatchNum(Integer.parseInt(s.toString().trim())); // Update match number
                            matchViewModel.addMatchInformation(match); // Save match info
                            matchNumberInput.postDelayed(() -> {
                                matchNumberInput.setSelection(matchNumberInput.length());
                            }, 0);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

// Add TextWatcher to teamNumberInput to update team number
                teamNumberInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!s.toString().isEmpty()) {
                            match.setTeamNumber(Integer.parseInt(s.toString().trim())); // Update team number
                            matchViewModel.addMatchInformation(match); // Save match info
                            teamNumberInput.postDelayed(() -> {
                                teamNumberInput.setSelection(teamNumberInput.length());
                            }, 0);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

// Add TextWatcher to scouterNameInput to update scouter name
                scouterNameInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        match.setScouterName(s.toString()); // Update scouter name
                        matchViewModel.addMatchInformation(match); // Save match info
                        scouterNameInput.postDelayed(() -> {
                            scouterNameInput.setSelection(scouterNameInput.length());
                        }, 0);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

// Set OnClickListener for noShowCheckBox to toggle match no-show status
                noShowCheckBox.setOnClickListener(v -> {
                    match.setNoShow(!match.isNoShow()); // Toggle no-show status
                });


                // Set background color for red alliance buttons based on match position
                red1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R1".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R2".equals(match.getPosition()) ? R.color.light_red : R.color.red));
                red3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "R3".equals(match.getPosition()) ? R.color.light_red : R.color.red));

                // Set background color for blue alliance buttons based on match position
                blue1.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B1".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue2.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B2".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));
                blue3.setBackgroundTintList(ContextCompat.getColorStateList(
                        this,
                        "B3".equals(match.getPosition()) ? R.color.techno_titans : R.color.darkblue));

                // Set onClickListener for Red1 button
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

                // Set onClickListener for Red2 button
                ((Button) (findViewById(R.id.Red2))).setOnClickListener(v -> {
                    match.setPosition("R2");

                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                    red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

                // Set onClickListener for Red3 button
                ((Button) (findViewById(R.id.Red3))).setOnClickListener(v -> {
                    match.setPosition("R3");

                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.light_red));
                    red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

                // Set onClickListener for Blue1 button
                ((Button) (findViewById(R.id.Blue1))).setOnClickListener(v -> {
                    match.setPosition("B1");

                    red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

                // Set onClickListener for Blue2 button
                ((Button) (findViewById(R.id.Blue2))).setOnClickListener(v -> {
                    match.setPosition("B2");

                    red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

                // Set onClickListener for Blue3 button
                ((Button) (findViewById(R.id.Blue3))).setOnClickListener(v -> {
                    match.setPosition("B3");

                    red1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    red3.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.red));
                    v.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.techno_titans));
                    blue1.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                    blue2.setBackgroundTintList(ContextCompat.getColorStateList(Pregame.this, R.color.darkblue));
                });

                // Set onClickListener for Back button to navigate to Homepage
                ((Button) (findViewById(R.id.BackButtonPregame))).setOnClickListener(v -> {
                    Intent i = new Intent(Pregame.this, Homepage.class);
                    Log.d("transition", "working3");
                    startActivity(i);
                });

                // Set onClickListener for Next button to navigate based on match status
                ((Button) (findViewById(R.id.NextButtonPregame))).setOnClickListener(v -> {
                    if (match.isNoShow()) {
                        matchViewModel.addMatchInformation(match);
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
//                else {
//                    matchViewModel.addMatchInformation(match);
//                    Intent i = new Intent(Pregame.this, AutonomousPath.class);
//                    i.putExtra("matchNumber", match.getMatchNum());
//                    Log.d("transition", "working2");
//                    startActivity(i);
//                }
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
