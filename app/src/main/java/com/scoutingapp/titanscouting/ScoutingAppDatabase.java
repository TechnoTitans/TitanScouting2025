package com.scoutingapp.titanscouting;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Match.class}, version = 1)

public abstract class ScoutingAppDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();
}
