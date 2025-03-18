package com.scoutingapp.titanscouting.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//The schema for our database; each @ColumnInfo is a column in the db
@Entity(tableName = "scouting_database")
public class Match {
    @PrimaryKey
    @ColumnInfo(name = "matchNum")
    private int matchNum;
    @ColumnInfo(name = "teamNumber", defaultValue = "00000")
    private int teamNumber;
    @ColumnInfo(name = "position", defaultValue = "R1")
    private String position;
    @ColumnInfo(name = "scouterName", defaultValue = "0")
    private String scouterName;
    @ColumnInfo(name = "noShow", defaultValue = "0")
    private boolean noShow;
    @ColumnInfo(name="autoPath", defaultValue = "0")
    private String autoPath;
    @ColumnInfo(name = "l1Count", defaultValue = "0")
    private int l1Count;
    @ColumnInfo(name = "l2Count", defaultValue = "0")
    private int l2Count;
    @ColumnInfo(name = "l3Count", defaultValue = "0")
    private int l3Count;
    @ColumnInfo(name = "l4Count", defaultValue = "0")
    private int l4Count;
    @ColumnInfo(name = "processorCount", defaultValue = "0")
    private int processorCount;
    @ColumnInfo(name = "netCount", defaultValue = "0")
    private int netCount;
    @ColumnInfo(name = "endgamePos", defaultValue = "None")
    private String endgamePos;
    @ColumnInfo(name = "driverQuality", defaultValue = "1")
    private int driverQuality;
    @ColumnInfo(name = "defenseAbility", defaultValue = "1")
    private int defenseAbility;
    @ColumnInfo(name = "mechanicalReliability", defaultValue = "1")
    private int mechanicalReliability;
    @ColumnInfo(name = "efficiency", defaultValue = "1")
    private int efficiency;
    @ColumnInfo(name = "notes", defaultValue = "0")
    private String notes;

    public int getMatchNum() {
        return matchNum;
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

    public String getScouterName() {
        return scouterName;
    }

    public void setScouterName(String scouterName) {
        this.scouterName = scouterName;
    }

    public boolean isNoShow() {
        return noShow;
    }

    public void setNoShow(boolean noShow) {
        this.noShow = noShow;
    }

    public String getAutoPath() { return autoPath; }

    public void setAutoPath(String autoPath) { this.autoPath = autoPath; }

    public int getL1Count() {
        return l1Count;
    }

    public void setL1Count(int l1Count) {
        this.l1Count = l1Count;
    }

    public int getL2Count() {
        return l2Count;
    }

    public void setL2Count(int l2Count) {
        this.l2Count = l2Count;
    }

    public int getL3Count() {
        return l3Count;
    }

    public void setL3Count(int l3Count) {
        this.l3Count = l3Count;
    }

    public int getL4Count() {
        return l4Count;
    }

    public void setL4Count(int l4Count) {
        this.l4Count = l4Count;
    }

    public int getProcessorCount() {
        return processorCount;
    }

    public void setProcessorCount(int processorCount) {
        this.processorCount = processorCount;
    }

    public int getNetCount() {
        return netCount;
    }

    public void setNetCount(int netCount) {
        this.netCount = netCount;
    }

    public String getEndgamePos() {
        return endgamePos;
    }

    public void setEndgamePos(String endgamePos) {
        this.endgamePos = endgamePos;
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

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}