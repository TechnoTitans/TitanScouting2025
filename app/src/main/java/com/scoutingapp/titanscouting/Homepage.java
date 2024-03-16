package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.views.Pregame;
import com.scoutingapp.titanscouting.views.logs.MatchListAdapter;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import com.scoutingapp.titanscouting.views.logs.Logs;
import com.scoutingapp.titanscouting.views.QRScreen;


public class Homepage extends AppCompatActivity {

    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View pregameButton = findViewById(R.id.button);
        pregameButton.setOnClickListener(v -> {
            Intent i = new Intent(this, Pregame.class);
            startActivity(i);
            Log.d("Pregame", "Pregame page has been reached");
        });

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());

        matchViewModel.getAllMatches().observe(this, matches -> {
            adapter.submitList(matches);
        });

//        matchViewModel.deleteEverything();

    }

    public void preGame(View v) {
        Intent i = new Intent(this, Pregame.class);
        i.putExtra("transition", "fromHomepage");
        startActivity(i);
        Log.d("Pregame", "Pregame page has been reached");
    }

    public void logs(View v){
        Intent i = new Intent(this, Logs.class);
        Log.d("transition", "Logs transition");
        i.putExtra("transition", "fromHomePage");
        startActivity(i);
    }
}