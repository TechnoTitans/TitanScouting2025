package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.scoutingapp.titanscouting.Homepage;
import com.scoutingapp.titanscouting.R;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        Button backButton = findViewById(R.id.back_button_schedule);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(Schedule.this, Homepage.class);
            startActivity(intent);
            finish();
        });


        ImageView scheduleImage = findViewById(R.id.schedule_image);

    }
}
