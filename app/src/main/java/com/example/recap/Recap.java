package com.example.recap;
import java.lang.Object;
import java.sql.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recap {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "answers")
    public String answers;

    @ColumnInfo(name = "acknowledgment_1")
    public String acknowledgmentOne;

    @ColumnInfo(name = "acknowledgment_2")
    public String acknowledgmentTwo;

    @ColumnInfo(name = "acknowledgment_3")
    public String acknowledgmentThree;

    @ColumnInfo(name = "date")
    public Date date;
}
