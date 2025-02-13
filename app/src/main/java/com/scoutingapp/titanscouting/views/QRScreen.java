package com.scoutingapp.titanscouting.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.scoutingapp.titanscouting.Homepage;
import com.scoutingapp.titanscouting.R;
import com.scoutingapp.titanscouting.database.Match;
import com.scoutingapp.titanscouting.database.MatchViewModel;
import com.scoutingapp.titanscouting.views.logs.Logs;

import java.util.Locale;

public class QRScreen extends AppCompatActivity {
    // LiveData to observe Match data
    LiveData<Match> liveDataMatch;
    // ViewModel to interact with Match data
    MatchViewModel matchViewModel;
    // Objects for generating QR codes
    MultiFormatWriter multiFormatWriter;
    BitMatrix bitMatrix;
    BarcodeEncoder barcodeEncoder;
    // String to hold the data to be encoded in the QR code
    String qrString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscreen);
        // Initialize UI components
        ImageView qrView = findViewById(R.id.qr_code);
        View backButton = findViewById(R.id.back_to_summary);
        View exitScouting = findViewById(R.id.exit_scouting_button);
        TextView matchText = findViewById(R.id.match_num_text_view);

        // Get the match number from the Intent that started this activity
        int matchNum = getIntent().getIntExtra("matchNumber", 0);
        // Initialize the ViewModel
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);
        // Observe LiveData to get the match details
        liveDataMatch = matchViewModel.getMatch(matchNum);

        liveDataMatch.observe(this, match -> {
            // Set the text for the match information
            matchText.setText(String.format(Locale.US, "Match %d  - %s (%s)",
                    match.getMatchNum(),
                    match.getPosition(),
                    match.getScouterName()));
            // Create the QR string from match details
            qrString = String.join("\n",
                    "GRITS",
                    String.valueOf(match.getTeamNumber()),
                    String.valueOf(match.getMatchNum()),
                    match.getScouterName(),
                    String.valueOf(match.getPosition()),
                    String.valueOf(match.getL1Count()),
                    String.valueOf(match.getL2Count()),
                    String.valueOf(match.getL3Count()),
                    String.valueOf(match.getL4Count()),
                    String.valueOf(match.getProcessorCount()),
                    String.valueOf(match.getNetCount()),
                    match.getEndgamePos(),
                    String.valueOf(match.getDriverQuality()),
                    String.valueOf(match.getDefenseAbility()),
                    String.valueOf(match.getMechanicalReliability()),
                    String.valueOf(match.getEfficiency()),
                    match.getNotes()
            );
            Log.d("match_num", String.valueOf(match.getMatchNum()));
            // Initialize MultiFormatWriter for QR code generation
            multiFormatWriter = new MultiFormatWriter();

            try {
                // Encode the QR string to BitMatrix
                bitMatrix = multiFormatWriter.encode(qrString, BarcodeFormat.QR_CODE, 500, 500);
                barcodeEncoder = new BarcodeEncoder();
                // Set the QR code image to the ImageView
                qrView.setImageBitmap(barcodeEncoder.createBitmap(bitMatrix));
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        });
        // Set onClickListener for the back button to go to Logs activity
        backButton.setOnClickListener(v -> {
            Intent i = new Intent(QRScreen.this, Logs.class);
            i.putExtra("matchNumber", matchNum);
            startActivity(i);
        });
        // Set onClickListener for the exit button to go to Homepage activity
        exitScouting.setOnClickListener(v -> {
            Intent i = new Intent(QRScreen.this, Homepage.class);
            startActivity(i);
        });




    }
}