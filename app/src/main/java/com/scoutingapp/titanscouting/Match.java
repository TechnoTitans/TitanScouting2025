package com.scoutingapp.titanscouting;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Match {
    @PrimaryKey
    @ColumnInfo(name = "matchNum")
    public int matchNum;

    @ColumnInfo(name = "teamNumber", defaultValue = "1683")
    public int teamNumber;

    @ColumnInfo(name = "position", defaultValue = "R1")
    public String position;

    @ColumnInfo(name = "autoPoints" , defaultValue = "0")
    public int autoPoints;

    @ColumnInfo(name = "autoEndStage" , defaultValue = "DNA")
    public String autoEndStage;

    @ColumnInfo(name = "mobility", defaultValue = "0")
    public boolean mobility;

    @ColumnInfo(name = "teleopPoints", defaultValue = "0")
    public int teleopPoints;

    @ColumnInfo(name = "disqualified", defaultValue = "0")
    public boolean disqualified;

    @ColumnInfo(name = "substationType", defaultValue = "S")
    public String substationType;

    @ColumnInfo(name = "penaltiesIncured", defaultValue = "0")
    public boolean penaltiesIncured;

    @ColumnInfo(name = "goodCollaboration", defaultValue = "0")
    public boolean goodCollaboration;

    @ColumnInfo(name = "driverQualtiy", defaultValue = "1")
    public int driverQuality;

    @ColumnInfo(name = "defenseAbility", defaultValue = "1")
    public int defenseAbility;

    @ColumnInfo(name = "mechanicalReliability", defaultValue = "1")
    public int mechanicalReliability;

    @ColumnInfo(name = "teleopEndgameState", defaultValue = "DNA")
    public String teleopEndgameState;

    @ColumnInfo(name = "isParked", defaultValue = "0")
    public boolean isParked;

    @ColumnInfo(name = "notes", defaultValue = "")
    public String notes;

    @ColumnInfo(name = "canPickUpTippedCones", defaultValue = "0")
    public boolean canPickUpTippedCones;

    @ColumnInfo(name = "dropsPiecesOften", defaultValue = "0")
    public boolean dropsPiecesOften;

    public int getMatchNum(){
        return this.matchNum;
    }
}
