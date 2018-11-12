package com.example.recap;

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
    Recap getFromDate(String date);

    @Query("UPDATE recap SET acknowledgment_1 = (:ackOne), acknowledgment_2 = (:ackTwo), " +
            "acknowledgment_3 = (:ackThree) WHERE uid = (:id)")
    void updateRecapWithAcknowledgements(int id, String ackOne, String ackTwo, String ackThree);

    @Query("UPDATE recap SET answers = (:ans) WHERE uid = (:id)")
    void updateRecapWithAnswers(int id, String ans);

    @Insert
    void insert(Recap recap);

    @Delete
    void delete(Recap recap);

    @Query("DELETE FROM recap")
    void nukeTable();
}