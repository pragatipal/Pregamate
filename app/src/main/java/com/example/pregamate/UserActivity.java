package com.example.pregamate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        clickListener();
    }

    private void clickListener() {
        Button doneBtn = findViewById(R.id.userDetailsDoneBtn);
        ImageButton numOneBtn = findViewById(R.id.numOneBtn);
        ImageButton numTwoBtn = findViewById(R.id.numTwoBtn);
        EditText detailsEt = findViewById(R.id.userDetailsEt);
        TextView detailsTv = findViewById(R.id.userDetailsTv);
        EditText numOneEt = findViewById(R.id.numOneEt);
        TextView numOneTv = findViewById(R.id.numOneTv);
        EditText numTwoEt = findViewById(R.id.numTwoEt);
        TextView numTwoTv = findViewById(R.id.numTwoTv);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details= detailsEt.getText().toString();
                detailsTv.setText(details);
                detailsTv.setVisibility(View.VISIBLE);
                detailsEt.setVisibility(View.GONE);
                doneBtn.setVisibility(View.GONE);
            }
        });
        numOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numOne= numOneEt.getText().toString();
                numOneTv.setText(numOne);
                numOneTv.setVisibility(View.VISIBLE);
                numOneEt.setVisibility(View.GONE);
                numOneBtn.setVisibility(View.GONE);
            }
        });
        numTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numTwo= numTwoEt.getText().toString();
                numTwoTv.setText(numTwo);
                numTwoTv.setVisibility(View.VISIBLE);
                numTwoEt.setVisibility(View.GONE);
                numTwoBtn.setVisibility(View.GONE);
            }
        });

    }
}