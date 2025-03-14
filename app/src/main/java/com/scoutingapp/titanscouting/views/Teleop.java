package com.scoutingapp.titanscouting.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Teleop extends AppCompatActivity {

    Match match;
    MatchViewModel matchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_2);

        Button l4inc = findViewById(R.id.inc_l4);
        Button l4dec = findViewById(R.id.dec_l4);
        TextView l4 = findViewById(R.id.l4_score);
        Button l3inc = findViewById(R.id.inc_l3);
        Button l3dec = findViewById(R.id.dec_l3);
        TextView l3 = findViewById(R.id.l3_score);
        Button l2inc = findViewById(R.id.inc_l2);
        Button l2dec = findViewById(R.id.dec_l2);
        TextView l2 = findViewById(R.id.l2_score);
        Button l1inc = findViewById(R.id.inc_l1);
        Button l1dec = findViewById(R.id.dec_l1);
        TextView l1 = findViewById(R.id.l1_score);
        Button netInc = findViewById(R.id.inc_net);
        Button netDec = findViewById(R.id.dec_net);
        TextView net = findViewById(R.id.net_score);
        Button procInc = findViewById(R.id.inc_proc);
        Button procDec = findViewById(R.id.dec_proc);
        TextView proc = findViewById(R.id.proc_score);
        Button backToAuto = findViewById(R.id.back_to_auto);
        Button toEndgame = findViewById(R.id.to_endgame);

        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;


            l4.setText(String.valueOf(match.getL4Count()));
            l3.setText(String.valueOf(match.getL3Count()));
            l2.setText(String.valueOf(match.getL2Count()));
            l1.setText(String.valueOf(match.getL1Count()));
            net.setText(String.valueOf(match.getNetCount()));
            proc.setText(String.valueOf(match.getProcessorCount()));

            l4inc.setOnClickListener(v -> {
                match.setL4Count(match.getL4Count() + 1);
                l4.setText("" + match.getL4Count());
                matchViewModel.addMatchInformation(match);
            });
            l4dec.setOnClickListener(v -> {
                match.setL4Count(match.getL4Count() == 0 ? 0 : match.getL4Count() - 1);
                matchViewModel.addMatchInformation(match);
                l4.setText("" + match.getL4Count());
            });
            l3inc.setOnClickListener(v -> {
                match.setL3Count(match.getL3Count() + 1);
                l3.setText("" + match.getL3Count());
                matchViewModel.addMatchInformation(match);
            });
            l3dec.setOnClickListener(v -> {
                match.setL3Count(match.getL3Count() == 0 ? 0 : match.getL3Count() - 1);
                l3.setText("" + match.getL3Count());
                matchViewModel.addMatchInformation(match);
            });
            l2inc.setOnClickListener(v -> {
                match.setL2Count(match.getL2Count() + 1);
                l2.setText("" + match.getL2Count());
                matchViewModel.addMatchInformation(match);
            });
            l2dec.setOnClickListener(v -> {
                match.setL2Count(match.getL2Count() == 0 ? 0 : match.getL2Count() - 1);
                l2.setText("" + match.getL2Count());
                matchViewModel.addMatchInformation(match);
            });
            l1inc.setOnClickListener(v -> {
                match.setL1Count(match.getL1Count() + 1);
                l1.setText("" + match.getL1Count());
                matchViewModel.addMatchInformation(match);
            });
            l1dec.setOnClickListener(v -> {
                match.setL1Count(match.getL1Count() == 0 ? 0 : match.getL1Count() - 1);
                l1.setText("" + match.getL1Count());
                matchViewModel.addMatchInformation(match);
            });
            procInc.setOnClickListener(v -> {
                match.setProcessorCount(match.getProcessorCount() + 1);
                proc.setText("" + match.getProcessorCount());
                matchViewModel.addMatchInformation(match);
            });
            procDec.setOnClickListener(v -> {
                match.setProcessorCount(match.getProcessorCount() == 0 ? 0 : match.getProcessorCount() - 1);
                proc.setText("" + match.getProcessorCount());
                matchViewModel.addMatchInformation(match);
            });
            netInc.setOnClickListener(v -> {
                match.setNetCount(match.getNetCount() + 1);
                net.setText("" + match.getNetCount());
                matchViewModel.addMatchInformation(match);
            });
            netDec.setOnClickListener(v -> {
                match.setNetCount(match.getNetCount() == 0 ? 0 : match.getNetCount() - 1);
                net.setText("" + match.getNetCount());
                matchViewModel.addMatchInformation(match);
            });

            backToAuto.setOnClickListener(v -> {
                Intent i = new Intent(Teleop.this, Autonomous.class);
                i.putExtra("matchNumber", match.getMatchNum());
                matchViewModel.addMatchInformation(match);
                startActivity(i);
            });

            toEndgame.setOnClickListener(v -> {
                Intent i = new Intent(Teleop.this, Endgame2.class);
                i.putExtra("matchNumber", match.getMatchNum());
                matchViewModel.addMatchInformation(match);
                startActivity(i);
            });


        });

    }
}