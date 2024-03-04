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

public class QRScreen extends AppCompatActivity {

    LiveData<Match> liveDataMatch;

    MatchViewModel matchViewModel;
    MultiFormatWriter multiFormatWriter;
    BitMatrix bitMatrix;
    BarcodeEncoder barcodeEncoder;

    String qrString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscreen);

        ImageView qrView = findViewById(R.id.qr_code);
        View backButton = findViewById(R.id.back_to_summary);
        View exitScouting = findViewById(R.id.exit_scouting_button);


        int matchNum = getIntent().getIntExtra("matchNumber", 0);
        matchViewModel = new ViewModelProvider(this).get(MatchViewModel.class);

        liveDataMatch = matchViewModel.getMatch(matchNum);

        liveDataMatch.observe(this, match -> {

            qrString = String.join("\n",
                    String.valueOf(match.getTeamNumber()),
                    String.valueOf(match.getMatchNum()),
                    match.getScouterName(),
                    String.valueOf(match.getPosition()),
                    String.valueOf(match.isPerformedLeave()),
                    match.getStartingPosition(),
                    String.valueOf(match.getAutoAmpScored()),
                    String.valueOf(match.getAutoAmpMissed()),
                    String.valueOf(match.getAutoSpeakerScored()),
                    String.valueOf(match.getAutoSpeakerMissed()),
                    String.valueOf(match.getTeleopAmpScored()),
                    String.valueOf(match.getTeleopAmpMissed()),
                    String.valueOf(match.getTeleopSpeakerScored()),
                    String.valueOf(match.getTeleopSpeakerMissed()),
                    match.getStagePosition(),
                    String.valueOf(match.isNoteInTrapScored()),
                    String.valueOf(match.isDisqualified()),
                    String.valueOf(match.isPenaltiesIncured()),
                    String.valueOf(match.getDriverQuality()),
                    String.valueOf(match.getDefenseAbility()),
                    String.valueOf(match.getMechanicalReliability()),
                    String.valueOf(match.isDropsPiecesOften()),
                    String.valueOf(match.isPickRingsFromGround()),
                    match.getNotes()

            );
            Log.d("match_num", String.valueOf(match.getMatchNum()));
            multiFormatWriter = new MultiFormatWriter();

            try {
                bitMatrix = multiFormatWriter.encode(qrString, BarcodeFormat.QR_CODE, 300, 300);
                barcodeEncoder = new BarcodeEncoder();

                qrView.setImageBitmap(barcodeEncoder.createBitmap(bitMatrix));
            } catch (WriterException e) {
                throw new RuntimeException(e);
            }
        });

        backButton.setOnClickListener(v -> {
            Intent i = new Intent(QRScreen.this, Summary.class);
            i.putExtra("matchNumber", matchNum);
            startActivity(i);
        });

        exitScouting.setOnClickListener(v -> {
            Intent i = new Intent(QRScreen.this, Homepage.class);
            startActivity(i);
        });




    }
}