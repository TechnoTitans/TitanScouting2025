package com.scoutingapp.titanscouting.views.logs;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AlertDialog;
import android.widget.EditText;
import android.widget.Toast;

import com.scoutingapp.titanscouting.Homepage;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Logs extends AppCompatActivity {

    private  MatchViewModel matchViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logs);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MatchListAdapter adapter = new MatchListAdapter(new MatchListAdapter.MatchDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        matchViewModel.getAllMatches().observe(this, adapter::submitList);

        Button b = findViewById(R.id.delete_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Logs.this);
                builder.setMessage("Are you sure you want to delete? ONLY CONTINUE IF YOU KNOW WHAT YOU'RE DOING!");
                builder.setTitle("Confirm Deletion");

                EditText passwordInput = new EditText(Logs.this);
                passwordInput.setHint("Enter password");
                passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(passwordInput);

                builder.setCancelable(false)
                        .setPositiveButton("Yes", (dialog, which) -> {
                            String enteredPassword = passwordInput.getText().toString();
                            String correctPassword = "1683FRC!"; // .-.

                            if (enteredPassword.equals(correctPassword)) {
                                matchViewModel.deleteAllMatches();
                                Toast.makeText(Logs.this, "All logs deleted!", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            } else {
                                Toast.makeText(Logs.this, "Incorrect password!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                        .show();
            }
        });


    }

    public void back(View v) {
        Intent i = new Intent(this, Homepage.class);
        startActivity(i);
    }


}