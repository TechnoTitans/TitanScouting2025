package com.scoutingapp.titanscouting.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "scouting_database")
public class Match {
    @PrimaryKey
    @ColumnInfo(name = "matchNum")
    private int matchNum;

    @ColumnInfo(name = "teamNumber", defaultValue = "1683")
    private int teamNumber;

    @ColumnInfo(name = "position", defaultValue = "R1")
    private String position;

    @ColumnInfo(name = "disqualified", defaultValue = "0")
    private boolean disqualified;

    @ColumnInfo(name = "scoringType", defaultValue = "N/A")
    private boolean scoringType;

    @ColumnInfo(name = "penalitiesIncurred", defaultValue = "0")
    private boolean penaltiesIncured;

    @ColumnInfo(name = "goodCollaboration", defaultValue = "0")
    private boolean goodCollaboration;

    @ColumnInfo(name = "driverQualtiy", defaultValue = "1")
    private int driverQuality;

    @ColumnInfo(name = "defenseAbility", defaultValue = "1")
    private int defenseAbility;

    @ColumnInfo(name = "mechanicalReliability", defaultValue = "1")
    private int mechanicalReliability;

    @ColumnInfo(name = "notes", defaultValue = "")
    private String notes;


    @ColumnInfo(name = "dropsPiecesOften", defaultValue = "0")
    private boolean dropsPiecesOften;

    public int getMatchNum(){
        return this.matchNum;
    }

    public void setMatchNum(int matchNum) {
        this.matchNum = matchNum;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public boolean isScoringType() {
        return scoringType;
    }


    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }

    public boolean isPenaltiesIncured() {
        return penaltiesIncured;
    }

    public void setPenaltiesIncured(boolean penaltiesIncured) {
        this.penaltiesIncured = penaltiesIncured;
    }

    public boolean isGoodCollaboration() {
        return goodCollaboration;
    }

    public void setGoodCollaboration(boolean goodCollaboration) {
        this.goodCollaboration = goodCollaboration;
    }

    public int getDriverQuality() {
        return driverQuality;
    }

    public void setDriverQuality(int driverQuality) {
        this.driverQuality = driverQuality;
    }

    public int getDefenseAbility() {
        return defenseAbility;
    }

    public void setDefenseAbility(int defenseAbility) {
        this.defenseAbility = defenseAbility;
    }

    public int getMechanicalReliability() {
        return mechanicalReliability;
    }

    public void setMechanicalReliability(int mechanicalReliability) {
        this.mechanicalReliability = mechanicalReliability;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isDropsPiecesOften() {
        return dropsPiecesOften;
    }

    public void setDropsPiecesOften(boolean dropsPiecesOften) {
        this.dropsPiecesOften = dropsPiecesOften;
    }

    public void setScoringType(boolean scoringType) {
        this.scoringType = scoringType;
    }

}
