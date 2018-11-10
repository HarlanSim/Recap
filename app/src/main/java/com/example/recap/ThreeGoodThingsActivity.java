package com.example.recap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThreeGoodThingsActivity extends AppCompatActivity {

    private EditText mGoodThingEditText;
    private TextView mGoodThingsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_good_things);

        mGoodThingsTitle = (TextView) findViewById(R.id.goodThingsTitleTextView);
        

        mGoodThingEditText = (EditText) findViewById(R.id.goodThingEditText);


        mGoodThingEditText.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){}

            @Override
            public void afterTextChanged(Editable s){
                if(s != null && s.length() > 0 && s.charAt(s.length() - 1) == '\n'){
                    updateActivity(s.subSequence(0, s.length() - 1));
                }
            }
        });

    }

    private void updateActivity(CharSequence s) {
        mGoodThingEditText.setText("");
        Toast.makeText(ThreeGoodThingsActivity.this, s, Toast.LENGTH_LONG).show();
    }

    private
}
