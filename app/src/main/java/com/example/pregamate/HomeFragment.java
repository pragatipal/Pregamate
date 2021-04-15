package com.example.pregamate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        CardView diets = root.findViewById(R.id.diets);
        CardView exercises = root.findViewById(R.id.exercises);
        CardView tests = root.findViewById(R.id.tests);
        CardView changesMum = root.findViewById(R.id.changesMum);
        CardView babyGrowth = root.findViewById(R.id.babyGrowth);
        CardView doDont = root.findViewById(R.id.doDont);

        TextView dietsTv = root.findViewById(R.id.dietsText);
        TextView exercisesTv = root.findViewById(R.id.exercisesText);
        TextView testsTv = root.findViewById(R.id.testsText);
        TextView changesMumTv = root.findViewById(R.id.changesMumText);
        TextView babyGrowthTv = root.findViewById(R.id.babyGrowthText);
        TextView doDontTv = root.findViewById(R.id.doDontText);


        TextView trimesterTitle = root.findViewById(R.id.trimesterTitle);
        TextView trimesterDesc = root.findViewById(R.id.trimesterDesc);

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

//        if (trimsPregnant==1){
//           trimesterTitle.setText(R.string.trim1);
//           trimesterDesc.setText(R.string.trim1Desc);
//        }
//        else if (trimsPregnant==2){
//            trimesterTitle.setText(R.string.trim2);
//            trimesterDesc.setText(R.string.trim2Desc);
//        }
//        else if (trimsPregnant==3){
//            trimesterTitle.setText(R.string.trim3);
//            trimesterDesc.setText(R.string.trim3Desc);
//        }

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

        return root;
    }

}