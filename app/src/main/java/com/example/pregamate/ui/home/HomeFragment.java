package com.example.pregamate.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pregamate.R;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        cardClickListener();
        return root;

    }

    private void cardClickListener() {

        CardView diets = requireView().findViewById(R.id.diets);
        CardView exercises = requireView().findViewById(R.id.exercises);
        CardView tests = requireView().findViewById(R.id.tests);
        CardView changesMum = requireView().findViewById(R.id.changesMum);
        CardView babyGrowth = requireView().findViewById(R.id.babyGrowth);
        CardView doDont = requireView().findViewById(R.id.doDont);

        TextView dietsTv = requireView().findViewById(R.id.dietsText);
        TextView exercisesTv = requireView().findViewById(R.id.exercisesText);
        TextView testsTv = requireView().findViewById(R.id.testsText);
        TextView changesMumTv = requireView().findViewById(R.id.changesMumText);
        TextView babyGrowthTv = requireView().findViewById(R.id.babyGrowthText);
        TextView doDontTv = requireView().findViewById(R.id.doDontText);

//        Intent intent = getIntent();
//        int trimsPregnant = intent.getIntExtra("trimsPregnant", 1);

        TextView trimesterTitle = requireView().findViewById(R.id.trimesterTitle);
        TextView trimesterDesc = requireView().findViewById(R.id.trimesterDesc);

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        DocumentReference docRef = db.collection("Trimesters").document("First");
//
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        dietsTv.setText(document.getString("Diets"));
//                    }
//                    else {
//                        Toast.makeText(getApplicationContext(), "No such field", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        if (trimsPregnant==1){
//            trimesterTitle.setText(R.string.trim1);
//            trimesterDesc.setText(R.string.trim1Desc);
//        }
//        else if (trimsPregnant==2){
//            trimesterTitle.setText(R.string.trim2);
//            trimesterDesc.setText(R.string.trim2Desc);
//        }
//        else if (trimsPregnant==3){
//            trimesterTitle.setText(R.string.trim3);
//            trimesterDesc.setText(R.string.trim3Desc);
//        }

        trimesterTitle.setText(R.string.trim1);
        trimesterDesc.setText(R.string.trim1Desc);

        diets.setOnClickListener(v -> {
            if (dietsTv.getVisibility()== View.GONE){
                dietsTv.setVisibility(View.VISIBLE);
            }
            else {
                dietsTv.setVisibility(View.GONE);
            }
        });
        exercises.setOnClickListener(v -> {
            if (exercisesTv.getVisibility()== View.GONE){
                exercisesTv.setVisibility(View.VISIBLE);
            }
            else {
                exercisesTv.setVisibility(View.GONE);
            }
        });
        tests.setOnClickListener(v -> {
            if (testsTv.getVisibility()== View.GONE){
                testsTv.setVisibility(View.VISIBLE);
            }
            else {
                testsTv.setVisibility(View.GONE);
            }
        });
        changesMum.setOnClickListener(v -> {
            if (changesMumTv.getVisibility()== View.GONE){
                changesMumTv.setVisibility(View.VISIBLE);
            }
            else {
                changesMumTv.setVisibility(View.GONE);
            }
        });
        babyGrowth.setOnClickListener(v -> {
            if (babyGrowthTv.getVisibility()== View.GONE){
                babyGrowthTv.setVisibility(View.VISIBLE);
            }
            else {
                babyGrowthTv.setVisibility(View.GONE);
            }
        });
        doDont.setOnClickListener(v -> {
            if (doDontTv.getVisibility()== View.GONE){
                doDontTv.setVisibility(View.VISIBLE);
            }
            else {
                doDontTv.setVisibility(View.GONE);
            }
        });

    }
}