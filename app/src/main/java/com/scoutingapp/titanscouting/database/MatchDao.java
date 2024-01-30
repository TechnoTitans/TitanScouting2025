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

    @Query("UPDATE scouting_database " +
            "SET teleopAmpScored = :teleopAmpScored, teleopAmpMissed = :teleopAmpMissed, " +
            "teleopSpeakerScored = :teleopSpeakerScored, teleopSpeakerMissed = :teleopSpeakerMissed " +
            "WHERE matchNum = :matchNumber")
    void addTeleopInformation(
            int matchNumber,
            int teleopAmpScored,
            int teleopAmpMissed,
            int teleopSpeakerScored,
            int teleopSpeakerMissed);

    @Query("UPDATE scouting_database " +
            "SET noteInTrapScored = :noteInTrapScored, disqualified = :disqualified, " +
            "penaltiesIncurred = :penaltiesIncurred, goodCollaboration = :goodCollaboration, " +
            "driverQuality = :driverQuality, defenseAbility = :defenseAbility, " +
            "mechanicalReliability = :mechanicalReliability, dropsPiecesOften = :dropsPiecesOften, " +
            "canPickRingsFromGround = :canPickRingsFromGround, isKitBot = :isKitBot, isPancake = :isPancake, " +
            "notes = :notes WHERE matchNum = :matchNumber")
    void addEnggameInformation(
            int matchNumber,
            boolean noteInTrapScored,
            boolean disqualified,
            boolean penaltiesIncurred,
            boolean goodCollaboration,
            int driverQuality,
            int defenseAbility,
            int mechanicalReliability,
            boolean dropsPiecesOften,
            boolean canPickRingsFromGround,
            boolean isKitBot,
            boolean isPancake,
            String notes
    );

    @Query("SELECT * FROM scouting_database")
    LiveData<List<Match>> getMatches();

    @Query("SELECT * FROM scouting_database WHERE matchNum = :matchNumber")
    LiveData<Match> getMatch(int matchNumber);
}
