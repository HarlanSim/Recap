package com.example.recap;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Hashtable;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    RecapDatabase m_Db;
    Hashtable m_RecapHashtable;
    int m_Month;
    int m_Year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final CompactCalendarView compactCalendar = findViewById(R.id.compactcalendar_view);

        RecapApplication app = (RecapApplication) getApplicationContext();
        m_Db = app.getRecapDatabase();
        m_RecapHashtable = new Hashtable();
        m_Month = new Date().getMonth() + 1;
        m_Year = new Date().getYear() + 1900;
        loadHashTable();

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                String date = dateFormat.format(dateClicked);
                Recap r = (Recap) m_RecapHashtable.get(date);
                if (r != null) {
                    Toast.makeText(CalendarActivity.this, "Recap:" + r.answers, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                m_Month = firstDayOfNewMonth.getMonth() + 1;
                m_Year = firstDayOfNewMonth.getYear() + 1900;
                loadHashTable();
            }
        });
    }
        private void loadHashTable() {
            List<Recap> recapList = m_Db.recapDao().getFromMonth(m_Month, m_Year);
            Recap r;
            for(int i=0; i<recapList.size(); i++) {
                r = recapList.get(i);
                m_RecapHashtable.put(r.date, r);
            }
        }



}
