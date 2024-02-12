package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Endgame extends AppCompatActivity {

    Match match;

    MatchViewModel matchViewModel;

    int matchNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);

        match = new Match();
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchNum = getIntent().getIntExtra("matchNumber", 0);

        match.setMatchNum(matchNum);
    }

    public void scoredInTrap(View v){
        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton));
        String state = button.getText().toString();

        if (state.equals("off")){
            match.setNoteInTrapScored(true);
        } else if (state.equals("on")){
            match.setNoteInTrapScored(false);
        }
    }

    public void disqualified(View v){
        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton2));
        String state = button.getText().toString();

        if (state.equals("off")){
            match.setDisqualified(true);
        } else if (state.equals("on")){
            match.setDisqualified(false);
        }
    }

    public void penaltiesIncurred(View v){
        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton3));
        String state = button.getText().toString();

        if (state.equals("off")){
            match.setPenaltiesIncured(true);
        } else if (state.equals("on")){
            match.setPenaltiesIncured(false);
        }
    }

//    public void goodCollaboration(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton4));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setGoodCollaboration(true);
//        } else if (state.equals("on")){
//            match.setGoodCollaboration(false);
//        }
//    }

    public void dropsPieces(View v){
        ToggleButton button = (ToggleButton) (findViewById(R.id.dropsPiecesToggle));
        String state = button.getText().toString();

        if (state.equals("off")){
            match.setDropsPiecesOften(true);
        } else if (state.equals("on")){
            match.setDropsPiecesOften(false);
        }
    }

    public void canPickFromGround(View v){
        ToggleButton button = (ToggleButton) (findViewById(R.id.canPickFromGroundToggle));
        String state = button.getText().toString();

        if (state.equals("off")){
            match.setPickRingsFromGround(true);
        } else if (state.equals("on")){
            match.setPickRingsFromGround(false);
        }
    }

//    public void isKitBot(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.kitBot));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setKitBot(true);
//        } else if (state.equals("on")){
//            match.setKitBot(false);
//        }
//    }
//
//    public void isPancake(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.pancake));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setPancake(true);
//        } else if (state.equals("on")){
//            match.setPancake(false);
//        }
//    }

    public void summaryPage(View v){
        SeekBar mechanicalBar = (SeekBar) (findViewById(R.id.seekBar1));
        int mechanicalPoints = mechanicalBar.getProgress();

        match.setMechanicalReliability(mechanicalPoints);

        SeekBar defenseBar = (SeekBar) (findViewById(R.id.seekBar2));
        int defensePoints = defenseBar.getProgress();

        match.setDefenseAbility(defensePoints);

        SeekBar driverQualityBar = (SeekBar) (findViewById(R.id.seekBar3));
        int driverQualityPoints = driverQualityBar.getProgress();

        match.setDriverQuality(driverQualityPoints);

        matchViewModel.addMatchInformation(match);

        Intent i = new Intent(this, Summary.class);
        i.putExtra("matchNumber", matchNum);
        startActivity(i);
    }




}