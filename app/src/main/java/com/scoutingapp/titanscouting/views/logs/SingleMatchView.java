package com.scoutingapp.titanscouting.views.logs;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class SingleMatchView extends AppCompatActivity {

    private String matchNum;

    private LiveData<Match> matchLiveData;

    private MatchViewModel matchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_match_view);

        matchNum = getIntent().getStringExtra("matchNum");
        TextView textView = (TextView) findViewById(R.id.matchNumView);
        textView.setText("Match Number: " + matchNum);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);


        matchLiveData = matchViewModel.getMatch(Integer.parseInt(matchNum));


        matchLiveData.observe(this, match -> {
            if (match != null) {
                Log.d("mas", "paslas");
                ((TextView) findViewById(R.id.matchNumView)).setText(String.valueOf(match.getMatchNum()));
            }
        });

    }
}