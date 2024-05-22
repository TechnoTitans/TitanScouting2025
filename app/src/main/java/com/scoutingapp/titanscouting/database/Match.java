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

    @ColumnInfo(name = "performedLeave", defaultValue = "0")
    private boolean performedLeave;
    @ColumnInfo(name = "startingPosition", defaultValue = "null")
    private String startingPosition;
    @ColumnInfo(name = "path", defaultValue = "")
    private String path;

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

    @ColumnInfo(name = "shootsFromSubwoofer", defaultValue = "0")
    private boolean shootsFromSubwoofer;
    @ColumnInfo(name = "penaltiesIncurred", defaultValue = "0")
    private int penaltiesIncurred;

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

    @ColumnInfo(name = "notes", defaultValue = "0")
    private String notes;

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    @ColumnInfo(name = "submitted", defaultValue = "0")
    private boolean submitted;

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

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
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

    public boolean isShootsFromSubwoofer() {
        return shootsFromSubwoofer;
    }

    public void setShootsFromSubwoofer(boolean shootsFromSubwoofer) {
        this.shootsFromSubwoofer = shootsFromSubwoofer;
    }

    public int getPenaltiesIncurred() {
        return penaltiesIncurred;
    }

    public void setPenaltiesIncurred(int penaltiesIncurred) {
        this.penaltiesIncurred = penaltiesIncurred;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isNoShow() {
        return noShow;
    }

    public void setNoShow(boolean noShow) {
        this.noShow = noShow;
    }
}