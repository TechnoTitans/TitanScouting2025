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


        if (getIntent().getIntExtra("matchNumber", 0) != 0){

            Log.d("monkey", "onkey");

            Match backwardsMatch = viewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).getValue();

            Log.d("monkey", "onkey");
            assert backwardsMatch != null;
            ((EditText) (findViewById(R.id.MatchNumberPregameResponse))).setHint(backwardsMatch.getMatchNum());

            ((EditText) (findViewById(R.id.TeamNumberResponsePregame))).setHint(backwardsMatch.getTeamNumber());

            ((EditText) (findViewById(R.id.ScouterNamePregameResponse))).setHint(backwardsMatch.getScouterName());
        }

        EditText matchNumberInput = (EditText) (findViewById(R.id.MatchNumberPregameResponse));
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



        EditText teamNumberInput = (EditText) (findViewById(R.id.TeamNumberResponsePregame));
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

        EditText scouterNameInput = (EditText) (findViewById(R.id.ScouterNamePregameResponse));
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
        CheckBox noShowCheckBox = (CheckBox) (findViewById(R.id.noShowCheckBox));
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
        Log.d("stage", "Entering Teleop");
        Intent i = new Intent(this, Autonomous.class);
        i.putExtra("matchNumber", match.getMatchNum());
        startActivity(i);
    }

    public void back(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}