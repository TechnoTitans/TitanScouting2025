package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.MainActivity;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Pregame extends AppCompatActivity {

    MatchViewModel viewModel;

    Match match;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);

        viewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        match = new Match();

        if (getIntent().getStringExtra("transition").equals("fromAuto")){

            viewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, backwardsMatch -> {
                match = backwardsMatch;
            });

            ((EditText) (findViewById(R.id.MatchNumberPregameResponse))).setText(match.getMatchNum());

            ((EditText) (findViewById(R.id.TeamNumberResponsePregame))).setText(match.getTeamNumber());

            ((EditText) (findViewById(R.id.ScouterNamePregameResponse))).setText(match.getScouterName());
        }

        EditText matchNumberInput = findViewById(R.id.MatchNumberPregameResponse);
        matchNumberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                match.setMatchNum(Integer.parseInt(s.toString()));
                viewModel.addMatchInformation(match);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        EditText teamNumberInput = findViewById(R.id.TeamNumberResponsePregame);
        teamNumberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                match.setTeamNumber(Integer.parseInt(s.toString()));
                viewModel.addMatchInformation(match);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        EditText scouterNameInput = findViewById(R.id.ScouterNamePregameResponse);
        scouterNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                match.setScouterName(s.toString());
                viewModel.addMatchInformation(match);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        match.setPerformedLeave(false);
        CheckBox noShowCheckBox = findViewById(R.id.noShowCheckBox);
        noShowCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.setNoShow(!match.isNoShow());
                viewModel.addMatchInformation(match);
            }
        });

    }

    public void red1CLicked(View v ){
        match.setPosition("R1");
        viewModel.addMatchInformation(match);
    }

    public void red2CLicked(View v ){
        match.setPosition("R2");
        viewModel.addMatchInformation(match);
    }

    public void red3CLicked(View v ){
        match.setPosition("R3");
        viewModel.addMatchInformation(match);
    }

    public void blue1CLicked(View v ){
        match.setPosition("B1");
        viewModel.addMatchInformation(match);
    }

    public void blue2CLicked(View v ){
        match.setPosition("B2");
        viewModel.addMatchInformation(match);
    }

    public void blue3CLicked(View v ){
        match.setPosition("B3");
        viewModel.addMatchInformation(match);
    }


    public void autonomous(View v){
        Intent i = new Intent(this, Autonomous.class);
        i.putExtra("matchNumber", match.getMatchNum());
        Log.d("transition", "Autonomous transition");
        startActivity(i);
    }

    public void back(View v) {
        Intent i = new Intent(this, MainActivity.class);
        Log.d("transition", "Homepage transition");
        startActivity(i);
    }
}