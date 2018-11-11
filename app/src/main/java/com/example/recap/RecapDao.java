package com.example.recap;

import java.sql.Date;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface RecapDao {
    @Query("SELECT * FROM recap")
    List<Recap> getAll();

    @Query("SELECT * FROM recap WHERE date = (:date)")
    Recap getFromDate(Date date);

    @Insert
    void insert(Recap recap);

    @Delete
    void delete(Recap recap);
}