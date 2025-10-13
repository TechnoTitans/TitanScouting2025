package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.scoutingapp.titanscouting.views.Pregame;
import com.scoutingapp.titanscouting.views.logs.Logs;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Load the main layout
        setContentView(R.layout.activity_main);

        // Initialize buttons from main layout
        Button pregameButton = findViewById(R.id.button);
        Button logsButton = findViewById(R.id.logs_btn);
        Button buttonNext = findViewById(R.id.button2);

        // pregameButton opens Pregame activity
        pregameButton.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, Pregame.class));
        });

        // logsButton opens Logs activity
        logsButton.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, Logs.class));
        });

        // buttonNext swaps layout to schedule.xml (just shows screenshot)
        buttonNext.setOnClickListener(v -> {
            setContentView(R.layout.schedule);
        });
    }

    // Optional: back button in schedule.xml to return to main layout

}
