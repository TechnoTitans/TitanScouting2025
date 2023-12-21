package com.scoutingapp.titanscouting;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MatchRepository {

    private MatchDao dao;
    private LiveData<List<Match>> allMatches;

    MatchRepository(Application application) {
        ScoutingAppDatabase db = ScoutingAppDatabase.getDatabase(application);
        dao = db.matchDao();
        allMatches = dao.getMatches();
    }

    LiveData<List<Match>> getAllMatches() {
        return allMatches;
    }

    void addPregameInformation(Match match) {
        ScoutingAppDatabase.databaseWriteExectuer.execute(() -> {
            dao.addPregameInformation(match);
        });
    }
}
