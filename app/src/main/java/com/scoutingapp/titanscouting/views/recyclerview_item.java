package com.scoutingapp.titanscouting.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.scoutingapp.titanscouting.R;

public class recyclerview_item extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_item);
    }

    public void singleMatchViewTransition(View v){
        Intent i = new Intent(this, SingleMatchView.class);
        Button button = (Button) findViewById(R.id.match_button);
        i.putExtra("matchNum", button.getText().toString());
        startActivity(i);
    }
}