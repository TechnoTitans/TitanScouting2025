package com.scoutingapp.titanscouting.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.lang.reflect.Method;
import java.util.List;

//The layer that interacts with the views
public class MatchViewModel extends AndroidViewModel {
    // Repository instance to interact with data operations
    private final MatchRepository matchRepository;
    // LiveData to observe the list of matches
    private final LiveData<List<Match>> allMatches;
    // Match instance for storing match information
    private final Match match;
    // Constructor to initialize the ViewModel
    public MatchViewModel (Application application) {
        super(application);
        matchRepository = new MatchRepository(application);
        allMatches = matchRepository.getAllMatches();
        match = new Match();
    }
    // Getter method to retrieve all matches
    public LiveData<List<Match>> getAllMatches() {
        return allMatches;
    }

    // Getter method to retrieve a specific match by match number
    public LiveData<Match> getMatch(int matchNumber) {
        return matchRepository.getMatch(matchNumber);
    }

    // Method to add match information to the repository
    public void addMatchInformation(Match match) {
        matchRepository.addMatchInformation(match);
    }
    // Method to delete all matches from the repository
    public void deleteAllMatches() {
        matchRepository.deleteAllMatches();
    }
}
