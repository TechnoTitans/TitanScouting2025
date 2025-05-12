package com.scoutingapp.titanscouting.database;

import static com.scoutingapp.titanscouting.database.ScoutingAppDatabase.databaseWriteExecutor;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MatchRepository {

    private final MatchDao dao;
    private final LiveData<List<Match>> allMatches;

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
        databaseWriteExecutor.execute(() -> dao.addMatchInformation(match));
    }

    void deleteAllMatches() {
        databaseWriteExecutor.execute(dao::deleteAllMatches);
    }

    void deleteMatch(int matchNum) {
        databaseWriteExecutor.execute(() -> {
            dao.deleteMatch(matchNum);
        });
    }
}
