package com.scoutingapp.titanscouting.views.logs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.scoutingapp.titanscouting.R;

public class recyclerview_item extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_item);
    }

    public void singleMatchViewTransition(View v){
        Log.d("mas", "paslas1");
        Intent i = new Intent(this, SingleMatchView.class);
        Button button = (Button) findViewById(R.id.match_button);
        Log.d("mas", "paslas2");
        i.putExtra("matchNum", button.getText().toString());
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, SingleMatchView.class);
        i.putExtra("matchNumber", ((Button)(findViewById(R.id.match_button))).
                getText().toString());

        startActivity(i);
    }
}