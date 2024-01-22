package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.database.MatchListAdapter;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import com.scoutingapp.titanscouting.views.logs.Logs;
import com.scoutingapp.titanscouting.views.Pregame;

public class MainActivity extends AppCompatActivity {

    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());

        matchViewModel.getAllMatches().observe(this, matches -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(matches);
        });
    }

    public void pregame(View v) {
        Intent i = new Intent(this, Pregame.class);
        startActivity(i);
        Log.d("Pregame", "PreGame page has been reached");
    }

    public void logs(View v){
        Intent i = new Intent(this, Logs.class);
        startActivity(i);
        Log.d("Logs", "Logs screen has been reached");
    }
}