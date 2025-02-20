package com.scoutingapp.titanscouting.views.logs;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.views.Endgame2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Teleop2 extends AppCompatActivity {

    // UI elements (buttons and TextViews)
    private Button inc1, dec1, inc2, dec2, inc3, dec3, inc4, dec4, inc5, dec5, inc6, dec6;
    private TextView L1_score, L2_score, L3_score, L4_score, Net_score, Processor_score;

    // Database helper instance
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop_2);

        // Initialize the database helper
        dbHelper = new DBHelper(this);

        // Find views by their ID
        inc1 = findViewById(R.id.inc_1);
        dec1 = findViewById(R.id.dec_1);
        inc2 = findViewById(R.id.inc_2);
        dec2 = findViewById(R.id.dec_2);
        inc3 = findViewById(R.id.inc_3);
        dec3 = findViewById(R.id.dec_3);
        inc4 = findViewById(R.id.inc_4);
        dec4 = findViewById(R.id.dec_4);
        inc5 = findViewById(R.id.inc_5);
        dec5 = findViewById(R.id.dec_5);
        inc6 = findViewById(R.id.inc_6);
        dec6 = findViewById(R.id.dec_6);

        L1_score = findViewById(R.id.L1_score);
        L2_score = findViewById(R.id.L2_score);
        L3_score = findViewById(R.id.L3_score);
        L4_score = findViewById(R.id.L4_score);
        Net_score = findViewById(R.id.Net_score);
        Processor_score = findViewById(R.id.Processor_score);

        // Optionally initialize TextViews with stored values from the database.
        // For example, initializing one TextView:
        L1_score.setText(String.valueOf(dbHelper.getButtonValue("inc_4"))); // example

        // Set up button click listeners.
        // Each click updates a score and saves the value to the database.
        inc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L4_score, "inc_1", 1);
            }
        });
        dec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L4_score, "dec_1", -1);
            }
        });
        inc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L3_score, "inc_2", 1);
            }
        });
        dec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L3_score, "dec_2", -1);
            }
        });
        inc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L2_score, "inc_3", 1);
            }
        });
        dec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L2_score, "dec_3", -1);
            }
        });
        inc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L1_score, "inc_4", 1);
            }
        });
        dec4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(L1_score, "dec_4", -1);
            }
        });
        inc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(Net_score, "inc_5", 1);
            }
        });
        dec5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(Net_score, "dec_5", -1);
            }
        });
        inc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(Processor_score, "inc_6", 1);
            }
        });
        dec6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateScore(Processor_score, "dec_6", -1);
            }
        });
    }

    /**
     * Update the displayed score and store the new value in the database.
     *
     * @param scoreView TextView showing the score.
     * @param buttonId  Unique identifier for the button (e.g., "inc_1", "dec_1").
     * @param delta     Change to apply (positive for increment, negative for decrement).
     */
    private void updateScore(TextView scoreView, String buttonId, int delta) {
        int currentScore = Integer.parseInt(scoreView.getText().toString());
        int newScore = currentScore + delta;
        scoreView.setText(String.valueOf(newScore));
        dbHelper.updateButtonValue(buttonId, newScore);
    }

    /**
     * DBHelper manages the SQLite database used to store button values.
     */
    public static class DBHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "Teleop.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "Teleop";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_BUTTON = "button_id";
        private static final String COLUMN_VALUE = "value";

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create table for button values.
            String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_BUTTON + " TEXT UNIQUE, " +
                    COLUMN_VALUE + " INTEGER)";
            db.execSQL(CREATE_TABLE);

            // Pre-populate table with default values (0) for each button.
            String[] buttonIds = {"inc_1", "dec_1", "inc_2", "dec_2", "inc_3", "dec_3", "inc_4", "dec_4", "inc_5", "dec_5", "inc_6", "dec_6"};
            for (String id : buttonIds) {
                ContentValues cv = new ContentValues();
                cv.put(COLUMN_BUTTON, id);
                cv.put(COLUMN_VALUE, 0);
                db.insert(TABLE_NAME, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Simple upgrade policy: drop the table and recreate it.
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        /**
         * Update the stored value for a given button.
         *
         * @param buttonId Identifier of the button.
         * @param value    New value to store.
         */
        public void updateButtonValue(String buttonId, int value) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_VALUE, value);
            int rows = db.update(TABLE_NAME, cv, COLUMN_BUTTON + " = ?", new String[]{buttonId});
            if (rows == 0) {
                // If no entry exists, insert one.
                cv.put(COLUMN_BUTTON, buttonId);
                db.insert(TABLE_NAME, null, cv);
            }
            db.close();
        }

        /**
         * Retrieve the stored value for a given button.
         *
         * @param buttonId Identifier of the button.
         * @return The stored integer value.
         */
        public int getButtonValue(String buttonId) {
            int value = 0;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_VALUE},
                    COLUMN_BUTTON + "=?", new String[]{buttonId}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                value = cursor.getInt(cursor.getColumnIndex(COLUMN_VALUE));
                cursor.close();
            }
            db.close();
            return value;
        }
    }

    public void launchEndgame2(View v) {
        Intent i = new Intent(this, Endgame2.class);
        startActivity(i);
    }



}
