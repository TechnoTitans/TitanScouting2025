package com.scoutingapp.titanscouting.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import java.util.List;

//The layer that interacts with the database itself
@Dao
public interface MatchDao {

    //the universal method that first creates a match and then updates it
    @Upsert
    void addMatchInformation(Match match);
    @Query("SELECT * FROM scouting_database ORDER BY matchNum DESC")
    LiveData<List<Match>> getMatches();

    @Query("SELECT * FROM scouting_database WHERE matchNum = :matchNumber")
    LiveData<Match> getMatch(int matchNumber);

    @Query("DELETE FROM scouting_database")
    void deleteAllMatches();
}
