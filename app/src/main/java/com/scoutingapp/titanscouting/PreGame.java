package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class PreGame extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Match match = new Match();
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

    @Override
    public void onStop(){
        super.onStop();

        match.matchNum = Integer.parseInt((findViewById(R.id.editMatchNumber)).toString());
        match.teamNumber = Integer.parseInt((findViewById(R.id.editTeamNumber)).toString());
    }



    public void homePage(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}