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

    void addPregameInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addPregameInformation(match);
        });
    }

    void addAutonomousInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addAutonomousInformation(match);
        });
    }
}
