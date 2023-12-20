package com.scoutingapp.titanscouting;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MatchDao {
    @Insert
    void insertPregameData(Match match);
}
