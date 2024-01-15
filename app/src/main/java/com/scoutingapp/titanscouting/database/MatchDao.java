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

    @Query("UPDATE scouting_database " +
            "SET performedLeave = :leave, startingPosition = :startingPosition, " +
            "autoAmpScored = :autoAmpScored, autoAmpMissed = :autoAmpMissed, autoSpeakerScored = :autoSpeakerScored," +
            "autoSpeakerMissed = :autoSpeakerMissed WHERE matchNum = :matchNumber")
    void addAutonomousInformation(
            int matchNumber,
            boolean leave,
            String startingPosition,
            int autoAmpScored,
            int autoAmpMissed,
            int autoSpeakerScored,
            int autoSpeakerMissed);
    @Query("SELECT * FROM scouting_database")
    LiveData<List<Match>> getMatches();

    @Query("SELECT * FROM scouting_database WHERE matchNum = :matchNumber")
    LiveData<Match> getMatch(int matchNumber);
}
