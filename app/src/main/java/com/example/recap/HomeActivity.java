package com.example.recap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Button mRecapButton = findViewById(R.id.recap_button);
        Button mAcknowledgmentsButton = findViewById(R.id.acknowledgments_button);
        Button mCalendarButton = findViewById(R.id.calendar_button);

        mRecapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecapActivity();
            }
        });

        mAcknowledgmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAcknowledgmentsActivity();
            }
        });
        mCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCalendarActivity();
            }
        });
    }
    private void startClassActivity(Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void startRecapActivity() {
        startClassActivity(RecapActivity.class);
    }

    private void startAcknowledgmentsActivity() {
        startClassActivity(AcknowledgmentsActivity.class);
    }

    private void startCalendarActivity() {
        startClassActivity(CalendarActivity.class);
    }
}

