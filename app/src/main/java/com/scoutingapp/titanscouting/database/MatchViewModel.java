package com.scoutingapp.titanscouting.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MatchViewModel extends AndroidViewModel {
    private MatchRepository matchRepository;

    private final LiveData<List<Match>> allMatches;

    private final Match match;

    public MatchViewModel (Application application) {
        super(application);
        matchRepository = new MatchRepository(application);
        allMatches = matchRepository.getAllMatches();
        match = new Match();
    }

    public LiveData<List<Match>> getAllMatches() {

        return allMatches;
    }

    public LiveData<Match> getMatch(int matchNumber) {
        return matchRepository.getMatch(matchNumber);
    }

    public void addPregameInformation(Match match) {

        matchRepository.addPregameInformation(match);
    }

    public void addAutonomousInformation(Match match) {
        matchRepository.addAutonomousInformation(match);
    }
}
