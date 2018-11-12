package com.example.recap;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Recap.class}, version = 1, exportSchema = false)
public abstract class RecapDatabase extends RoomDatabase {
    public abstract RecapDao recapDao();
}
