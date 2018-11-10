package com.example.recap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button mRecapButton;
    private Button mThreeGoodThingsButton;
    private Button mCalendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        mRecapButton = (Button) findViewById(R.id.recap_button);
        mThreeGoodThingsButton = (Button) findViewById(R.id.three_good_things_button);
        mCalendarButton = (Button) findViewById(R.id.calendar_button);

        mRecapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecap();
            }
        });

        mThreeGoodThingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThreeGoodThings();
            }
        });
    }

    private void startRecap() {
        Intent intent = new Intent(this, RecapActivity.class);
        startActivity(intent);
    }
    private void startThreeGoodThings() {
        Intent intent = new Intent(this, ThreeGoodThingsActivity.class);
        startActivity(intent);
    }

}

