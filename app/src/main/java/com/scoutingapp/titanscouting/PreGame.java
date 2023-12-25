package com.scoutingapp.titanscouting;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class PreGame extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MatchViewModel viewModel;

    Match match;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(

                this,
                R.array.team_chices,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        viewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        match = new Match();


    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    //gets the input from the dropdown menu
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String choice = parent.getItemAtPosition(pos).toString();
        Log.d("choice", choice);


        match.position = choice;
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    public void teleOP(View v){

        match.matchNum = Integer.parseInt(((EditText) (findViewById(R.id.editMatchNumber))).getText().toString());
        match.teamNumber = Integer.parseInt(((EditText) findViewById(R.id.editTeamNumber)).getText().toString());
        viewModel.addPregameInformation(match);
        Log.d("pas", "las");


    }
}