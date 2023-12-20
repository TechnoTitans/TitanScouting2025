package com.scoutingapp.titanscouting;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Match {
    @PrimaryKey
    public int matchNum;

    @ColumnInfo(name = "teamNumber", defaultValue = "1683")
    public int teamNumber;

    @ColumnInfo(name = "position")
    public String position;

    @ColumnInfo(name = "autoPoints")
    public int autoPoints;

    @ColumnInfo(name = "autoEndStage")
    public String autoEndStage;

    @ColumnInfo(name = "mobility")
    public boolean mobility;

    @ColumnInfo(name = "teleopPoints")
    public int teleopPoints;

    @ColumnInfo(name = "disqualified")
    public boolean disqualified;

    @ColumnInfo(name = "substationType")
    public String substationType;

    @ColumnInfo(name = "penaltiesIncured")
    public boolean penaltiesIncured;

    @ColumnInfo(name = "goodCollaboration")
    public boolean goodCollaboration;

    @ColumnInfo(name = "driverQualtiy")
    public int driverQuality;

    @ColumnInfo(name = "defenseAbility")
    public int defenseAbility;

    @ColumnInfo(name = "mechanicalReliability")
    public int mechanicalReliability;

    @ColumnInfo(name = "teleopEndgameState")
    public String teleopEndgameState;

    @ColumnInfo(name = "isParked")
    public boolean isParked;

    @ColumnInfo(name = "notes")
    public String notes;

    @ColumnInfo(name = "canPickUpTippedCones")
    public boolean canPickUpTippedCones;

    @ColumnInfo(name = "dropsPiecesOften")
    public boolean dropsPiecesOften;
}
