package com.example.pregamate.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pregamate.R;

import java.time.LocalDate;


public class WelcomeFragment extends Fragment {

    private CalendarView calendarView;
    private static final String TAG = "CalendarActivity";
    private int trimsPregnant;
    private long diffYear, diffMonth;
    private Button startButton;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
        trimsPregnant =getTimePregnant();
        letsStart();
    }

    private void letsStart() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

//    private void moveToHomeActivity(int trimsPregnant) {
//
//    }

    private int getTimePregnant() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                LocalDate date1 = LocalDate.now();
                diffYear = date1.getYear()-year;
                if (date1.getYear()!=year){
                    diffMonth = 12- date1.getMonthValue()+month;
                }
                else {
                   diffMonth = date1.getMonthValue()-month;
                }
            }
        });
        return (int) ((diffYear*12+diffMonth));
    }




    private void init() {
        calendarView = getView().findViewById(R.id.calendarView);
        startButton = getView().findViewById(R.id.startBtn);

    }
}