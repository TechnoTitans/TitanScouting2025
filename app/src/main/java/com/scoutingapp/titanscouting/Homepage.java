package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.scoutingapp.titanscouting.database.ScoutingAppDatabase;
import com.scoutingapp.titanscouting.views.Pregame;
import com.scoutingapp.titanscouting.views.logs.MatchListAdapter;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import com.scoutingapp.titanscouting.views.logs.Logs;
import com.scoutingapp.titanscouting.views.QRScreen;


//Homepage class represents the main screen of the app.
public class Homepage extends AppCompatActivity {

    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the xml file for the homepage
        setContentView(R.layout.activity_main);

        // Initialize buttons by findViewById from the xml file
        View pregameButton = findViewById(R.id.button);
        View logsButton = findViewById(R.id.logs_btn);

        // Set onClickListener method for the pregameButton to navigate to Pregame activity
        pregameButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Pregame.class);
            startActivity(i);
        });

        // Set onClickListener method for the logsButton to navigate to Logs activity
        logsButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Logs.class);
            startActivity(i);
        });

        // Initialize matchViewModel to manage match data
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        // Uncomment the bottom line to delete all matches
        // matchViewModel.deleteAllMatches();

        // Create an adapter to handle displaying match data
        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());

        // Observe the match data in MatchViewModel class and submit the adapter when data changes
        matchViewModel.getAllMatches().observe(this, matches -> {
            adapter.submitList(matches);
        });
    }
}
