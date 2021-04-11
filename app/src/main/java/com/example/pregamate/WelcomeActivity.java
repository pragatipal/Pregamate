package com.example.pregamate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class WelcomeActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private static final String TAG = "CalendarActivity";
    private int trimsPregnant;
    private long diffYear, diffMonth;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        calendarView = findViewById(R.id.calendarView);
        startBtn = findViewById(R.id.startBtn);

        letsStart();
    }

    private void letsStart() {
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("trimsPregnant", getTimePregnant());
                startActivity(intent);
            }
        });
    }


    private int getTimePregnant() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                LocalDate date = LocalDate.now();
                diffYear = date.getYear()-year;
                if (date.getYear()!=year){
                    diffMonth = 12- date.getMonthValue()+month;
                }
                else {
                    diffMonth = date.getMonthValue()-month;
                }
            }
        });
        return (int) ((diffYear*12+diffMonth));
    }
}