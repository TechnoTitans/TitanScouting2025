package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scoutingapp.titanscouting.MainActivity;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.MatchListAdapter;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Logs extends AppCompatActivity {

    private MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        matchViewModel.getAllMatches().observe(this, matches -> {
            adapter.submitList(matches);
        });


    }

    public void back(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void singleMatchViewTransition(View v){
        Intent i = new Intent(this, SingleMatchView.class);
        Button button = (Button) findViewById(R.id.match_button);
        i.putExtra("matchNum", button.getText().toString());
        startActivity(i);
    }
}