package com.scoutingapp.titanscouting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void pregame(View v) {
        Intent i = new Intent(this, PreGame.class);
        startActivity(i);
        Log.d("Pregame", "PreGame page has been reached");
    }

    public void logs(View v){
        Intent i = new Intent(this, Logs.class);
        startActivity(i);
        Log.d("Logs", "Logs screen has been reached");
    }

}