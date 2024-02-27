package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
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

//        ((Button) (findViewById(R.id.trap))).setOnClickListener(v -> {
//            Log.d("trapped", "trapped");
//        });
//
//        ((Button) (findViewById(R.id.attempt_trap))).setOnClickListener(v -> {
//            Log.d("attempted trapped", "attempted trapped");
//        });
//
//        ((ToggleButton) (findViewById(R.id.park_button))).setOnClickListener(v -> {
//            Log.d("parked", "parked");
//        });
//
//        ((Button) (findViewById(R.id.attempt_onstage))).setOnClickListener(v -> {
//            Log.d("attempted onstage", "attempted onstage");
//        });
//        ((Button) (findViewById(R.id.Onstage))).setOnClickListener(v -> {
//            Log.d("onstage", "onstage");
//        });
//        ((Button) (findViewById(R.id.attempt_harmony))).setOnClickListener(v -> {
//            Log.d("attempted harmony", "attempted harmony");
//        });
//        ((Button) (findViewById(R.id.harmony_button))).setOnClickListener(v -> {
//            Log.d("harmony", "harmony");
//        });
//        ((ToggleButton) (findViewById(R.id.drop_pieces_button))).setOnClickListener(v -> {
//            Log.d("dropped pieces", "dropped pieces");
//        });
//        ((Button) (findViewById(R.id.human_attempt))).setOnClickListener(v -> {
//            Log.d("human attempted", "human attempted");
//        });
//        ((Button) (findViewById(R.id.human_made))).setOnClickListener(v -> {
//            Log.d("human made", "human made");
//        });
//        ((ToggleButton) (findViewById(R.id.collaboration_button))).setOnClickListener(v -> {
//            Log.d("collaboration done", "collaboration done");
//        });
//        ((ToggleButton) (findViewById(R.id.pick_up_from_ground_button))).setOnClickListener(v -> {
//            Log.d("picked up from ground", "picked up from ground");
//        });
//        Log.d("can pick up from ground", "can pick up from ground");
//
//        RatingBar driver_quality_bar = (RatingBar) findViewById(R.id.driver_quality_bar);
//        int numberOfStars = driver_quality_bar.getNumStars();
//
//        Log.d(String.valueOf(numberOfStars), String.valueOf(numberOfStars));
//        RatingBar defense_bar = (RatingBar) findViewById(R.id.defense_bar);
//        int numberOfStars1 = driver_quality_bar.getNumStars();
//        Log.d(String.valueOf(numberOfStars1), String.valueOf(numberOfStars1));
    }

//    public void scoredInTrap(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setNoteInTrapScored(true);
//        } else if (state.equals("on")){
//            match.setNoteInTrapScored(false);
//        }
//    }
//
//    public void disqualified(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton2));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setDisqualified(true);
//        } else if (state.equals("on")){
//            match.setDisqualified(false);
//        }
//    }
//
//    public void penaltiesIncurred(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton3));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setPenaltiesIncured(true);
//        } else if (state.equals("on")){
//            match.setPenaltiesIncured(false);
//        }
//    }
//
////    public void goodCollaboration(View v){
////        ToggleButton button = (ToggleButton) (findViewById(R.id.toggleButton4));
////        String state = button.getText().toString();
////
////        if (state.equals("off")){
////            match.setGoodCollaboration(true);
////        } else if (state.equals("on")){
////            match.setGoodCollaboration(false);
////        }
////    }
//
//    public void dropsPieces(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.dropsPiecesToggle));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setDropsPiecesOften(true);
//        } else if (state.equals("on")){
//            match.setDropsPiecesOften(false);
//        }
//    }
//
//    public void canPickFromGround(View v){
//        ToggleButton button = (ToggleButton) (findViewById(R.id.canPickFromGroundToggle));
//        String state = button.getText().toString();
//
//        if (state.equals("off")){
//            match.setPickRingsFromGround(true);
//        } else if (state.equals("on")){
//            match.setPickRingsFromGround(false);
//        }
//    }
//
////    public void isKitBot(View v){
////        ToggleButton button = (ToggleButton) (findViewById(R.id.kitBot));
////        String state = button.getText().toString();
////
////        if (state.equals("off")){
////            match.setKitBot(true);
////        } else if (state.equals("on")){
////            match.setKitBot(false);
////        }
////    }
////
////    public void isPancake(View v){
////        ToggleButton button = (ToggleButton) (findViewById(R.id.pancake));
////        String state = button.getText().toString();
////
////        if (state.equals("off")){
////            match.setPancake(true);
////        } else if (state.equals("on")){
////            match.setPancake(false);
////        }
////    }
//
    public void summaryPage(View v){
//        SeekBar mechanicalBar = (SeekBar) (findViewById(R.id.seekBar1));
//        int mechanicalPoints = mechanicalBar.getProgress();
//
//        match.setMechanicalReliability(mechanicalPoints);
//
//        SeekBar defenseBar = (SeekBar) (findViewById(R.id.seekBar2));
//        int defensePoints = defenseBar.getProgress();
//
//        match.setDefenseAbility(defensePoints);
//
//        SeekBar driverQualityBar = (SeekBar) (findViewById(R.id.seekBar3));
//        int driverQualityPoints = driverQualityBar.getProgress();
//
//        match.setDriverQuality(driverQualityPoints);
//
//        matchViewModel.addMatchInformation(match);

        Intent i = new Intent(this, Summary.class);
        i.putExtra("matchNumber", matchNum);
        startActivity(i);
    }




}