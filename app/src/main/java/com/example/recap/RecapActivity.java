package com.example.recap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecapActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;

    private int mAnswers[] = new int[mQuestionLibrary.getQuestionListLength()];
    private int mTotalScore = 0;
    private int mQuestionNumber = 0;

    private Storage mStorage = new Storage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.answer1);
        mButtonChoice2 = (Button) findViewById(R.id.answer2);
        mButtonChoice3 = (Button) findViewById(R.id.answer3);
        mButtonChoice4 = (Button) findViewById(R.id.answer4);
        mButtonChoice5 = (Button) findViewById(R.id.answer5);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(1);
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(2);
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(3);
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(4);
            }
        });
        mButtonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerClicked(5);
            }
        });

        mStorage.isExternalStorageReadable();
        mStorage.isExternalStorageWritable();
    }

    private void answerClicked(int score) {
        // Add score to answer array
        mAnswers[mQuestionNumber-1] = score;

        // Add score to total
        mTotalScore += score;

        // If final answer, go to Complete screen
        if(mQuestionLibrary.getQuestionListLength() == mQuestionNumber) {
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

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mQuestionNumber++;
    }
}
