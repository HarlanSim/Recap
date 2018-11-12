package com.example.recap;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RecapCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap_complete);

        TextView totalScoreView = findViewById(R.id.totalScore);
        ProgressBar totalScoreProgressBar = findViewById(R.id.progressBar);
        Button backButton = findViewById(R.id.backButton);

        // Extract the score from the intent
        Intent intent = getIntent();
        String total = intent.getStringExtra("total_score");

        // Set total text
        totalScoreView.setText(String.format("%s/70", total));

        // Set progress on progress bar
        int percentage = 100 * Integer.parseInt(total) / 70;
        totalScoreProgressBar.setProgress(percentage);

        // Alter the default size and colour of progress bar
        Drawable progressDrawable = totalScoreProgressBar.getProgressDrawable().mutate();
        progressDrawable.setColorFilter(Color.parseColor("#3e5898"), android.graphics.PorterDuff.Mode.SRC_IN);
        totalScoreProgressBar.setProgressDrawable(progressDrawable);
        totalScoreProgressBar.setScaleY(2f);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });

        showSavedMessage();
    }

    private void goHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void showSavedMessage() {
        Toast.makeText(RecapCompleteActivity.this, "Saved", Toast.LENGTH_LONG).show();
    }
}
