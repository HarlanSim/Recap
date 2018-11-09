package com.example.recap;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RecapCompleteActivity extends AppCompatActivity {

    private TextView mTotalScoreView;
    private ProgressBar mTotalScoreProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_complete);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String total = intent.getStringExtra("total_score");

        mTotalScoreView = (TextView) findViewById(R.id.totalScore);
        mTotalScoreView.setText(String.format("%s/70", total));

        mTotalScoreProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        int percentage = 100 * Integer.parseInt(total) / 70;
        mTotalScoreProgressBar.setProgress(percentage);

        Drawable progressDrawable = mTotalScoreProgressBar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(Color.parseColor("#3e5898"), android.graphics.PorterDuff.Mode.SRC_IN);
        mTotalScoreProgressBar.setProgressDrawable(progressDrawable);
        mTotalScoreProgressBar.setScaleY(2f);

    }
}
