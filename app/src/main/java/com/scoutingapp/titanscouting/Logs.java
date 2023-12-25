package com.scoutingapp.titanscouting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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



}