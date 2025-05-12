package com.scoutingapp.titanscouting.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// ViewModel class that acts as a bridge between the UI (View) and the data repository.
// It is responsible for preparing and managing the data for the UI.
public class MatchViewModel extends AndroidViewModel {

    // Repository that handles data operations
    private final MatchRepository matchRepository;

    // LiveData that holds a list of all matches, observed by the UI to reflect changes automatically
    private final LiveData<List<Match>> allMatches;

    // A single Match object, used for creating new match instances
    private final Match match;

    // Constructor: initializes the repository and LiveData objects
    public MatchViewModel(Application application) {
        super(application);
        matchRepository = new MatchRepository(application); // Initialize repository to interact with database
        allMatches = matchRepository.getAllMatches(); // Fetch all matches from repository
        match = new Match(); // Create a new empty match object
    }

    // Method to return all matches as LiveData, so the UI updates automatically when data changes
    public LiveData<List<Match>> getAllMatches() {
        return allMatches;
    }

    // Method to fetch a specific match by its match number
    public LiveData<Match> getMatch(int matchNumber) {
        return matchRepository.getMatch(matchNumber);
    }

    // Method to add a new match to the database
    public void addMatchInformation(Match match) {
        matchRepository.addMatchInformation(match);
    }

    // Method to delete all match records from the database
    public void deleteAllMatches() {
        matchRepository.deleteAllMatches();
    }

    public void deleteMatch(int matchNum) {
        matchRepository.deleteMatch(matchNum);
    }
}
