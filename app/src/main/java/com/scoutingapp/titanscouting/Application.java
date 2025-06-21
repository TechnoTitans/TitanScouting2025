package com.scoutingapp.titanscouting;

import androidx.appcompat.app.AppCompatDelegate;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        // Initialize any global state or libraries here
        // For example, you can initialize logging, crash reporting, etc.
    }
}
