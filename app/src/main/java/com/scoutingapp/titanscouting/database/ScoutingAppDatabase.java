package com.scoutingapp.titanscouting.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Match.class}, version = 3, exportSchema = false)

public abstract class ScoutingAppDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();

    private static volatile ScoutingAppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    //allows for async writing from the database since directly writing into the database
    //causes issues regarding performance -> background threads are used
    static final ExecutorService databaseWriteExectuer =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ScoutingAppDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (ScoutingAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ScoutingAppDatabase.class, "scouting_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
