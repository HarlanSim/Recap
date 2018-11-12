package com.example.recap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalDateTime;

import androidx.appcompat.app.AppCompatActivity;

public class AcknowledgmentsActivity extends AppCompatActivity {

    private EditText mAcknowledgment1EditText;
    private EditText mAcknowledgment2EditText;
    private EditText mAcknowledgment3EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgments);

        // TODO: Extract acknowledgments from EditTexts
        mAcknowledgment1EditText = findViewById(R.id.acknowledgmentEditText);
        mAcknowledgment2EditText = findViewById(R.id.acknowledgmentEditText2);
        mAcknowledgment3EditText = findViewById(R.id.acknowledgmentEditText3);
        Button mSubmitButton = findViewById(R.id.acknowledgmentSubmitButton);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSavedMessage();
                saveAcknowledgments();
                startHomeActivity();
            }
        });
    }

    private void saveAcknowledgments(){
        RecapApplication app = (RecapApplication) getApplicationContext();
        RecapDatabase db = app.getRecapDatabase();

        String todayDate = getTodayDate();
        Recap recap = db.recapDao().getFromDate(todayDate);

        String ackOne = mAcknowledgment1EditText.getText().toString();
        String ackTwo = mAcknowledgment2EditText.getText().toString();
        String ackThree = mAcknowledgment3EditText.getText().toString();


        if(recap == null) {
            recap = new Recap();
            recap.acknowledgmentOne = ackOne;
            recap.acknowledgmentTwo = ackTwo;
            recap.acknowledgmentThree = ackThree;
            recap.date = todayDate;
            db.recapDao().insert(recap);
        } else {
            db.recapDao().updateRecapWithAcknowledgements(recap.uid, ackOne, ackTwo, ackThree);
        }
    }

    private String getTodayDate() {
        // TODO: Put this in a helper file
        // Offset it by 4 hours so records after midnight count for previous day
        LocalDateTime today = LocalDateTime.now().minusHours(4);
        LocalDate todayDate = today.toLocalDate();
        return todayDate.toString();
    }

    private void showSavedMessage() {
        Toast.makeText(AcknowledgmentsActivity.this, "Saved", Toast.LENGTH_LONG).show();
    }

    private void startHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
