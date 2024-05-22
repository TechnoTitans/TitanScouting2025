package com.scoutingapp.titanscouting.views;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class AutonomousPath extends AppCompatActivity {
    private Match match;
    private MatchViewModel matchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous_path);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        ImageView noteA = (ImageView) (findViewById(R.id.noteA));
        ImageView noteB = (ImageView) (findViewById(R.id.noteB));
        ImageView noteC = (ImageView) (findViewById(R.id.noteC));
        ImageView noteD = (ImageView) (findViewById(R.id.noteD));
        ImageView noteE = (ImageView) (findViewById(R.id.noteE));
        ImageView noteF = (ImageView) (findViewById(R.id.noteF));
        ImageView noteG = (ImageView) (findViewById(R.id.noteG));
        ImageView noteH = (ImageView) (findViewById(R.id.noteH));
        Button clearButton = (Button) (findViewById(R.id.clearButton));
        TextView pathTextView = findViewById(R.id.pathTextView);
        View back = findViewById(R.id.backToPregame);
        View next = findViewById(R.id.nextToAuto);


        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;

            pathTextView.setText(match.getPath());

            if (match.getPath() != null && match.getPath().contains("A"))
            {
                noteA.setImageResource(R.drawable.fillednote);
            } else {
                noteA.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("B"))
            {
                noteB.setImageResource(R.drawable.fillednote);
            } else {
                noteB.setImageResource(R.drawable.note);

            }

            if (match.getPath() != null && match.getPath().contains("C"))
            {
                noteC.setImageResource(R.drawable.fillednote);
            } else {
                noteC.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("D"))
            {
                noteD.setImageResource(R.drawable.fillednote);
            } else {
                noteD.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("E"))
            {
                noteE.setImageResource(R.drawable.fillednote);
            } else {
                noteE.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("F"))
            {
                noteF.setImageResource(R.drawable.fillednote);
            } else {
                noteF.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("G"))
            {
                noteG.setImageResource(R.drawable.fillednote);
            } else {
                noteG.setImageResource(R.drawable.note);
            }

            if (match.getPath() != null && match.getPath().contains("H"))
            {
                noteH.setImageResource(R.drawable.fillednote);
            } else {
                noteH.setImageResource(R.drawable.note);
            }


            noteA.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "A"));
                noteA.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
                Log.d("path", match.getPath());
            });

            noteB.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "B"));
                noteB.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
                Log.d("path", match.getPath());
            });

            noteC.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "C"));
                noteC.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteD.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "D"));
                noteD.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteE.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "E"));
                noteE.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteF.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "F"));
                noteF.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteG.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "G"));
                noteG.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            noteH.setOnClickListener(v -> {
                match.setPath(addToEnd(match.getPath(), "H"));
                noteH.setImageResource(R.drawable.fillednote);
                matchViewModel.addMatchInformation(match);
            });

            clearButton.setOnClickListener(v -> {
                match.setPath("");
                matchViewModel.addMatchInformation(match);
                Log.d("path", match.getPath());
            });

             next.setOnClickListener(v -> {
                Intent i = new Intent(this, Autonomous.class);
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
            back.setOnClickListener(v -> {
                Intent i = new Intent(this, Pregame.class);
                i.putExtra("transition", "fromAutonomous");
                i.putExtra("matchNumber", match.getMatchNum());
                startActivity(i);
            });
        });
    }

    /**
     * Checks conditions and adds last entered letter into string
     * @param path existent path, which could be null
     * @param letter new letter to add to path
     * @return new path
     */
    private static String addToEnd(String path, String letter) {
        if (path == null) {
            return letter;
        }
        if (path.contains(letter)) {
            return path;
        }
        return path + letter;
    }
}



