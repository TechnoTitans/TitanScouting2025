package com.scoutingapp.titanscouting.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.scoutingapp.titanscouting.R;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }

//    public void teleOp(View v){
//        Intent i = new Intent(this, Teleop.class);
//        i.putExtra("matchNumber", match.getMatchNum());
//        startActivity(i);
//    }
//
//    public void preGame(View v){
//        Intent i = new Intent(this, Pregame.class);
//        i.putExtra("matchNumber", match.getMatchNum());
//        startActivity(i);
//    }
}