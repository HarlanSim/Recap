package com.example.recap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;

import androidx.appcompat.app.AppCompatActivity;

public class RecapActivity extends AppCompatActivity {

    private final QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mQuestionView;

    private String mAnswerText[] = new String[]{"None of the time", "Rarely", "Sometime", "Often", "All of the time"};
    private int mAnswers[] = new int[mQuestionLibrary.getQuestionListLength()];
    private int mTotalScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        mQuestionView = findViewById(R.id.question);
        Button buttonChoice1 = findViewById(R.id.answerNone);
        Button buttonChoice2 = findViewById(R.id.answerRarely);
        Button buttonChoice3 = findViewById(R.id.answerSometime);
        Button buttonChoice4 = findViewById(R.id.answerOften);
        Button buttonChoice5 = findViewById(R.id.answerAll);

        buttonChoice1.setText(mAnswerText[0]);
        buttonChoice2.setText(mAnswerText[1]);
        buttonChoice3.setText(mAnswerText[2]);
        buttonChoice4.setText(mAnswerText[3]);
        buttonChoice5.setText(mAnswerText[4]);

        updateQuestion();

        buttonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(1);
            }
        });
        buttonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(2);
            }
        });
        buttonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(3);
            }
        });
        buttonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(4);
            }
        });
        buttonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(5);
            }
        });
    }

    private void answerClicked(int score) {
        // Add score to answer array
        mAnswers[mQuestionNumber-1] = score;

        // Add score to total
        mTotalScore += score;

        // If final answer, go to Complete screen
        if(mQuestionLibrary.getQuestionListLength() == mQuestionNumber) {
            saveRecap();
            Intent intent = new Intent(this, RecapCompleteActivity.class);
            intent.putExtra("total_score", Integer.toString(mTotalScore));
            startActivity(intent);
            finish();
        }

        // Else, next question
        else {
            updateQuestion();
        }
    }

    private void saveRecap(){
        RecapApplication app = (RecapApplication) getApplicationContext();
        RecapDatabase db = app.getRecapDatabase();

        String todayDate = getTodayDate();
        String answerString = parseAnswers();
        Recap recap = db.recapDao().getFromDate(todayDate);

        if(recap == null) {
            recap = new Recap();
            recap.answers = answerString;
            recap.date = todayDate;
            db.recapDao().insert(recap);
        } else {
            db.recapDao().updateRecapWithAnswers(recap.uid, answerString);
        }
    }

    private String parseAnswers() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mAnswers.length; i++) {
            sb.append(mAnswers[i]);
            if(i+1 < mAnswers.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String getTodayDate() {
        // Offset it by 4 hours so records after midnight count for previous day
        LocalDateTime today = LocalDateTime.now().minusHours(4);
        LocalDate todayDate = today.toLocalDate();
        return todayDate.toString();
    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mQuestionNumber++;
    }
}
