package com.scoutingapp.titanscouting.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MatchDao {
    @Insert
    void addPregameInformation(Match match);

    @Update
    void addAutonomousInformation(Match match);

    @Query("SELECT * FROM scouting_database")
    LiveData<List<Match>> getMatches();

    @Query("SELECT * FROM scouting_database WHERE matchNum = :matchNumber")
    LiveData<Match> getMatch(int matchNumber);
}
