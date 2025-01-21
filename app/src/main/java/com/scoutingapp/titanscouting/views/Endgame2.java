package com.scoutingapp.titanscouting.views;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.scoutingapp.titanscouting.R;

public class Endgame2 extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    RatingBar ratingBar1, ratingBar2, ratingBar3, ratingBar4;
    EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame2);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);

        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2= findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);
        ratingBar4 = findViewById(R.id.ratingBar4);

        comments = findViewById(R.id.comments);
    }
}
