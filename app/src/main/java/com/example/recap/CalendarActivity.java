package com.example.recap;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final CompactCalendarView compactCalendar = findViewById(R.id.compactcalendar_view);
        String example = "13-11-2018";
        Date date = new Date();
        try {
             date = new SimpleDateFormat("dd/MM/yyyy").parse(example);
        } catch (ParseException e) {
            // TODO: make exception
        }
        long milliseconds = date.getTime();
        Event ev1 = new Event(Color.GREEN, milliseconds, "Some extra data that I want to store.");

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
                                        @Override
                                        public void onDayClick(Date dateClicked) {
                                            List<Event> events = compactCalendar.getEvents(dateClicked);
                                            Log.d("INFO", "Day was clicked: " + dateClicked + " with events " + events);
                                        }

                                        @Override
                                        public void onMonthScroll(Date firstDayOfNewMonth) {
                                            Log.d("INFO", "Month was scrolled to: " + firstDayOfNewMonth);
                                        }
                                    });


        compactCalendar.addEvent(ev1);
    }


}
