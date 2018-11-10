package com.example.recap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AcknowledgmentsActivity extends AppCompatActivity {

    private EditText mAcknowledgmentEditText;
    private EditText mAcknowledgment2EditText;
    private EditText mAcknowledgment3EditText;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgments);

        // TODO: Extract acknowledgments from EditTexts
        mAcknowledgmentEditText = findViewById(R.id.acknowledgmentEditText);
        mAcknowledgment2EditText = findViewById(R.id.acknowledgmentEditText2);
        mAcknowledgment3EditText = findViewById(R.id.acknowledgmentEditText3);
        mSubmitButton = findViewById(R.id.acknowledgmentSubmitButton);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSavedMessage();
                // TODO: Save data
                startHomeActivity();
            }
        });
    }

    private void showSavedMessage() {
        Toast.makeText(AcknowledgmentsActivity.this, "Saved", Toast.LENGTH_LONG).show();
    }

    private void startHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
