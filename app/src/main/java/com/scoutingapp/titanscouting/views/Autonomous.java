package com.scoutingapp.titanscouting.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;

import com.scoutingapp.titanscouting.R;

import java.util.Objects;

public class Autonomous extends AppCompatActivity {
    Match match;
    MatchViewModel matchViewModel;
    @Override
    //Just determine what layout to choose based off what color was choosen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Objects.equals(getIntent().getStringExtra("color"), "B")) {
            setContentView(R.layout.activity_autonomous_blue); /* connects xml to the class file */
        }  else {
            setContentView(R.layout.activity_autonomous_red); /* connects xml to the class file */
        }
        //All below of this is just setting up UI elements (Buttons, TextViews, CheckBoxes)
        //This block is just for the coral buttons.
        Button a = findViewById(R.id.branch_a);
        Button b = findViewById(R.id.branch_b);
        Button c = findViewById(R.id.branch_c);
        Button d = findViewById(R.id.branch_d);
        Button e = findViewById(R.id.branch_e);
        Button f = findViewById(R.id.branch_f);
        Button g = findViewById(R.id.branch_g);
        Button h = findViewById(R.id.branch_h);
        Button i = findViewById(R.id.branch_i);
        Button j = findViewById(R.id.branch_j);
        Button k = findViewById(R.id.branch_k);
        Button l = findViewById(R.id.branch_l);

        // Buttons to handle (NET,Processer, and cs1,cs2)
        Button lollipopNet = findViewById(R.id.lollipop1);
        Button lollipopMiddle = findViewById(R.id.lollipop2);
        Button lollipopProcessor = findViewById(R.id.lollipop3);

        Button processor = findViewById(R.id.processor_button);
        Button net = findViewById(R.id.net_button);
        Button cs1 = findViewById(R.id.cs1_button);
        Button cs2 = findViewById(R.id.cs2_button);

        Button resetButton = findViewById(R.id.reset_button); //button

        TextView autoText = findViewById(R.id.autoDisplay); // Displays the current auto path

        CheckBox leave = findViewById(R.id.leaveCheckbox); // Indicates if the robot left the starting area

        Button toPregame = findViewById(R.id.back_to_pregame); // Button to go back to pregame activity
        Button toTeleop = findViewById(R.id.to_teleop); // Button to go to teleop activity
        // Initialize ViewModel to access match data.
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        matchViewModel.getMatch(getIntent().getIntExtra("matchNumber", 0)).observe(this, match -> {
            this.match = match;
            // Reset button functionality and just clears the auto path or keeps leave nothing changed
            resetButton.setOnClickListener(v -> {
                match.setAutoPath(match.getAutoPath().startsWith("LEAVE ") ? "LEAVE " : "");
                autoText.setText(match.getAutoPath());
            });
            // Setting the checkbox state based on the current auto path
            if (match.getAutoPath() == null) {
                leave.setChecked(false);
            } else if (match.getAutoPath().startsWith("LEAVE ")) {
                leave.setChecked(true);
            } else {
                leave.setChecked(false);
            }
            // Display the current auto path in the TextView
            autoText.setText(match.getAutoPath());
            // Click listeners for the action buttons (Net, Processor, Lollipop, CS1, CS2)
            a.setOnClickListener(v -> {
                branchPopup(a, "A", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            b.setOnClickListener(v -> {
                branchPopup(b, "B", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            c.setOnClickListener(v -> {
                branchPopup(c, "C", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            d.setOnClickListener(v -> {
                branchPopup(d, "D", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            e.setOnClickListener(v -> {
                branchPopup(e, "E", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            f.setOnClickListener(v -> {
                branchPopup(f, "F", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            g.setOnClickListener(v -> {
                branchPopup(g, "G", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            h.setOnClickListener(v -> {
                branchPopup(h, "H", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            i.setOnClickListener(v -> {
                branchPopup(i, "I", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            j.setOnClickListener(v -> {
                branchPopup(j, "J", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            k.setOnClickListener(v -> {
                branchPopup(k, "K", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });
            l.setOnClickListener(v -> {
                branchPopup(l, "L", result -> {
                    match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + result);
                    autoText.setText(match.getAutoPath());
                });
            });

            // Navigation to Pregame Activity
            toPregame.setOnClickListener(v -> {
                Intent intent = new Intent(Autonomous.this, Pregame.class);
                intent.putExtra("transition", "fromAutonomous");
                intent.putExtra("teamNumber", match.getTeamNumber());
                intent.putExtra("scouterName", match.getScouterName());
                intent.putExtra("position", match.getPosition());
                intent.putExtra("matchNumber", match.getMatchNum());
                matchViewModel.addMatchInformation(match);
                startActivity(intent);
            });
            // Navigation to Telop Activity
            toTeleop.setOnClickListener(v -> {
                Intent intent = new Intent(Autonomous.this,Teleop.class);
                intent.putExtra("matchNumber", match.getMatchNum());
                matchViewModel.addMatchInformation(match);
                startActivity(intent);
            });
            // Click listeners for other action buttons (Net, Processor, Lollipop, CS1, CS2)
            net.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "N");
                autoText.setText(match.getAutoPath());
            });

            processor.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "P");
                autoText.setText(match.getAutoPath());
            });

            lollipopNet.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "Q1");
                autoText.setText(match.getAutoPath());
            });
            lollipopMiddle.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "Q2");
                autoText.setText(match.getAutoPath());
            });
            lollipopProcessor.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "Q3");
                autoText.setText(match.getAutoPath());
            });

            cs1.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "CS1");
                autoText.setText(match.getAutoPath());
            });

            cs2.setOnClickListener(v -> {
                match.setAutoPath((match.getAutoPath() == null ? "" : match.getAutoPath()) + "CS2");
                autoText.setText(match.getAutoPath());
            });
            // Checkbox listener to handle "LEAVE" functionality.
            leave.setOnClickListener(v -> {
                if (leave.isChecked()) {
                    match.setAutoPath("LEAVE " + (match.getAutoPath() == null ? "" : match.getAutoPath()));
                } else {
                    match.setAutoPath(match.getAutoPath().substring(6));
                }
                autoText.setText(match.getAutoPath());
            });

        });

    }

    public void branchPopup(Button a, String branch, ResultCallback callback) {
        // Define the options for the radio buttons
        String[] levels = {"L4", "L3", "L2", "L1"};
        final int[] selectedPosition = {-1}; // Initialize with default value
        final boolean[] isChecked = {false}; // Track checkbox state

        // Create AlertDialog Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set the title
        builder.setTitle("Select Level");

        // Create custom layout for both radio buttons and checkbox
        View customLayout = LayoutInflater.from(this).inflate(R.layout.branch_popup_layout, null);

        // Get references to our views
        final RadioGroup radioGroup = customLayout.findViewById(R.id.radio_group);
        final CheckBox checkBox = customLayout.findViewById(R.id.checkbox);

        // Add radio buttons programmatically
        for (String level : levels) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(level);
            radioButton.setId(View.generateViewId()); // Generate unique ID
            radioGroup.addView(radioButton);

            // Handle radio button clicks
            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedPosition[0] = radioGroup.indexOfChild(v);
                }
            });
        }

        // Handle checkbox clicks
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheckedValue) {
                isChecked[0] = isCheckedValue;
            }
        });

        // Set the custom layout
        builder.setView(customLayout);

        // Add confirm button
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if (selectedPosition[0] != -1) {
                    String selectedLevel = levels[selectedPosition[0]];

                    // Handle checkbox state
                    if (isChecked[0]) {
                        Toast.makeText(Autonomous.this,
                                "Confirmed: " + selectedLevel + " (with checkbox enabled)",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Autonomous.this,
                                "Confirmed: " + selectedLevel,
                                Toast.LENGTH_SHORT).show();
                    }

                    callback.onResult(branch + (4 - selectedPosition[0]) + (isChecked[0] ? "M" : "S"));
                } else {
                    Toast.makeText(Autonomous.this, "No level selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Add cancel button
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        // Show the dialog
        builder.create().show();
    }



    // Callback interface to return result asynchronously
    public interface ResultCallback {
        void onResult(String result);
    }


}