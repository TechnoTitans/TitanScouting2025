package com.scoutingapp.titanscouting.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "performedLeave", defaultValue = "0")
    private boolean performedLeave;

    @ColumnInfo(name = "startingPosition", defaultValue = "0")
    private String startingPosition;

    @ColumnInfo(name = "autoAmpScored", defaultValue = "0")
    private int autoAmpScored;

    @ColumnInfo(name = "autoAmpMissed", defaultValue = "0")
    private int autoAmpMissed;

    @ColumnInfo(name = "autoSpeakerScored", defaultValue = "0")
    private int autoSpeakerScored;

    @ColumnInfo(name = "autoSpeakerMissed", defaultValue = "0")
    private int autoSpeakerMissed;

    @ColumnInfo(name = "teleopAmpScored", defaultValue = "0")
    private int teleopAmpScored;

    @ColumnInfo(name = "teleopAmpMissed", defaultValue = "0")
    private int teleopAmpMissed;

    @ColumnInfo(name = "teleopSpeakerScored", defaultValue = "0")
    private int teleopSpeakerScored;

    @ColumnInfo(name = "teleopSpeakerMissed", defaultValue = "0")
    private int teleopSpeakerMissed;

    @ColumnInfo(name = "stagePosition", defaultValue = "0")
    private String stagePosition;

    @ColumnInfo(name = "noteInTrapScored", defaultValue = "0")
    private boolean noteInTrapScored;

    @ColumnInfo(name = "disqualified", defaultValue = "0")
    private boolean disqualified;
    @ColumnInfo(name = "penaltiesIncurred", defaultValue = "0")
    private boolean penaltiesIncured;

    @ColumnInfo(name = "goodCollaboration", defaultValue = "0")
    private boolean goodCollaboration;

    @ColumnInfo(name = "driverQuality", defaultValue = "1")
    private int driverQuality;

    @ColumnInfo(name = "defenseAbility", defaultValue = "1")
    private int defenseAbility;

    @ColumnInfo(name = "mechanicalReliability", defaultValue = "1")
    private int mechanicalReliability;
    @ColumnInfo(name = "dropsPiecesOften", defaultValue = "0")
    private boolean dropsPiecesOften;

    @ColumnInfo(name = "canPickRingsFromGround", defaultValue = "0")
    private boolean pickRingsFromGround;

    @ColumnInfo(name = "isKitBot", defaultValue = "0")
    private boolean isKitBot;

    @ColumnInfo(name = "isPancake", defaultValue = "0")
    private boolean isPancake;

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

    public boolean isPerformedLeave() {
        return performedLeave;
    }

    public void setPerformedLeave(boolean performedLeave) {
        this.performedLeave = performedLeave;
    }

    public String getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(String startingPosition) {
        this.startingPosition = startingPosition;
    }

    public int getAutoAmpScored() {
        return autoAmpScored;
    }

    public void setAutoAmpScored(int autoAmpScored) {
        this.autoAmpScored = autoAmpScored;
    }

    public int getAutoAmpMissed() {
        return autoAmpMissed;
    }

    public void setAutoAmpMissed(int autoAmpMissed) {
        this.autoAmpMissed = autoAmpMissed;
    }

    public int getAutoSpeakerScored() {
        return autoSpeakerScored;
    }

    public void setAutoSpeakerScored(int autoSpeakerScored) {
        this.autoSpeakerScored = autoSpeakerScored;
    }

    public int getAutoSpeakerMissed() {
        return autoSpeakerMissed;
    }

    public void setAutoSpeakerMissed(int autoSpeakerMissed) {
        this.autoSpeakerMissed = autoSpeakerMissed;
    }

    public int getTeleopAmpScored() {
        return teleopAmpScored;
    }

    public void setTeleopAmpScored(int teleopAmpScored) {
        this.teleopAmpScored = teleopAmpScored;
    }

    public int getTeleopAmpMissed() {
        return teleopAmpMissed;
    }

    public void setTeleopAmpMissed(int teleopAmpMissed) {
        this.teleopAmpMissed = teleopAmpMissed;
    }

    public int getTeleopSpeakerScored() {
        return teleopSpeakerScored;
    }

    public void setTeleopSpeakerScored(int teleopSpeakerScored) {
        this.teleopSpeakerScored = teleopSpeakerScored;
    }

    public int getTeleopSpeakerMissed() {
        return teleopSpeakerMissed;
    }

    public void setTeleopSpeakerMissed(int teleopSpeakerMissed) {
        this.teleopSpeakerMissed = teleopSpeakerMissed;
    }

    public String getStagePosition() {
        return stagePosition;
    }

    public void setStagePosition(String stagePosition) {
        this.stagePosition = stagePosition;
    }

    public boolean isNoteInTrapScored() {
        return noteInTrapScored;
    }

    public void setNoteInTrapScored(boolean noteInTrapScored) {
        this.noteInTrapScored = noteInTrapScored;
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

    public boolean isDropsPiecesOften() {
        return dropsPiecesOften;
    }

    public void setDropsPiecesOften(boolean dropsPiecesOften) {
        this.dropsPiecesOften = dropsPiecesOften;
    }

    public boolean isPickRingsFromGround() {
        return pickRingsFromGround;
    }

    public void setPickRingsFromGround(boolean pickRingsFromGround) {
        this.pickRingsFromGround = pickRingsFromGround;
    }

    public boolean isKitBot() {
        return isKitBot;
    }

    public void setKitBot(boolean kitBot) {
        isKitBot = kitBot;
    }

    public boolean isPancake() {
        return isPancake;
    }

    public void setPancake(boolean pancake) {
        isPancake = pancake;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}