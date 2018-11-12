package com.example.recap;

import android.app.Application;

import androidx.room.Room;

public class RecapApplication extends Application {

    private RecapDatabase mRecapDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mRecapDatabase = Room.databaseBuilder(getApplicationContext(), RecapDatabase.class, "database").allowMainThreadQueries().build();
    }

    public RecapDatabase getRecapDatabase() {
        return mRecapDatabase;
    }
}
