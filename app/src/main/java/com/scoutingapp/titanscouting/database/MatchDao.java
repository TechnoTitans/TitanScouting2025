package com.scoutingapp.titanscouting.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MatchDao {
    @Insert
    void addPregameInformation(Match match);

    @Query("SELECT * FROM scouting_database")
    LiveData <List<Match>> getMatches();
}
