package com.scoutingapp.titanscouting;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Match.class}, version = 1, exportSchema = false)

public abstract class ScoutingAppDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();

    private static volatile ScoutingAppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExectuer =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ScoutingAppDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (ScoutingAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ScoutingAppDatabase.class, "scouting_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
