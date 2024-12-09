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

// Class holding the homepage of the app.
public class Homepage extends AppCompatActivity {

    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View pregameButton = findViewById(R.id.button);
        View logsButton = findViewById(R.id.logs_btn);

        pregameButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Pregame.class);
            startActivity(i);
        });
        logsButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Logs.class);
            startActivity(i);
        });

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

//        matchViewModel.deleteAllMatches();
        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());

        matchViewModel.getAllMatches().observe(this, matches -> {
            adapter.submitList(matches);
        });


    }

}