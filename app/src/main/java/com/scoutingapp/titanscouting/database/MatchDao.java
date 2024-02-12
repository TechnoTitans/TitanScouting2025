package com.scoutingapp.titanscouting.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface MatchDao {
    @Upsert
    void addMatchInformation(Match match);



    @Query("SELECT * FROM scouting_database")
    LiveData<List<Match>> getMatches();

    @Query("SELECT * FROM scouting_database WHERE matchNum = :matchNumber")
    LiveData<Match> getMatch(int matchNumber);


}
