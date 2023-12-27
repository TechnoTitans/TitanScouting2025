package com.scoutingapp.titanscouting.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MatchViewModel extends AndroidViewModel {
    private MatchRepository matchRepository;

    private final LiveData<List<Match>> allMatches;

    public MatchViewModel (Application application) {
        super(application);
        matchRepository = new MatchRepository(application);
        allMatches = matchRepository.getAllMatches();
    }

    public LiveData<List<Match>> getAllMatches() {
        return allMatches;
    }

    public void addPregameInformation(Match match) {
        matchRepository.addPregameInformation(match);
    }
}
