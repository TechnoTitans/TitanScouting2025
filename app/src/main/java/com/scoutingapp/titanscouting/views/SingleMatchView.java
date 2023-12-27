package com.scoutingapp.titanscouting.views;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.scoutingapp.titanscouting.R;

public class SingleMatchView extends AppCompatActivity {

    private String matchNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_match_view);

        matchNum = getIntent().getStringExtra("matchNum");

        TextView textView = (TextView) findViewById(R.id.matchNumView);
        textView.setText(String.valueOf(matchNum));
    }
}