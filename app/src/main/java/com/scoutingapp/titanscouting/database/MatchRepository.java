package com.scoutingapp.titanscouting.database;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MatchRepository {

    private MatchDao dao;
    private LiveData<List<Match>> allMatches;

    MatchRepository(Application application) {
        ScoutingAppDatabase db = ScoutingAppDatabase.getDatabase(application);
        Log.d("database", "database has started");
        dao = db.matchDao();
        allMatches = dao.getMatches();
    }

    LiveData<List<Match>> getAllMatches() {

        return allMatches;
    }

    LiveData<Match> getMatch(int matchNumber) {
        return dao.getMatch(matchNumber);
    }

    void addMatchInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addMatchInformation(match);
        });
    }

    void addAutonomousInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addAutonomousInformation(
                    match.getMatchNum(),
                    match.isPerformedLeave(),
                    match.getStartingPosition(),
                    match.getAutoAmpScored(),
                    match.getAutoAmpMissed(),
                    match.getAutoSpeakerScored(),
                    match.getAutoSpeakerMissed());
        });
    }

    void addTeleopInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addTeleopInformation(
                    match.getMatchNum(),
                    match.getTeleopAmpScored(),
                    match.getTeleopAmpMissed(),
                    match.getTeleopSpeakerScored(),
                    match.getTeleopSpeakerMissed());
        });
    }

    void addEndgameInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addEnggameInformation(
                    match.getMatchNum(),
                    match.isNoteInTrapScored(),
                    match.isDisqualified(),
                    match.isPenaltiesIncured(),
                    match.isGoodCollaboration(),
                    match.getDriverQuality(),
                    match.getDefenseAbility(),
                    match.getMechanicalReliability(),
                    match.isDropsPiecesOften(),
                    match.isPickRingsFromGround(),
                    match.isKitBot(),
                    match.isPancake(),
                    match.getNotes()
            );
        });
    }

}
