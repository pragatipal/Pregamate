package com.example.pregamate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserFragment extends Fragment {


    //    Firebase
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseDatabase db;
    private DatabaseReference ref;



    public UserFragment() {
//       Required public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_user, container, false);

        Button doneBtn = root.findViewById(R.id.userDetailsDoneBtn);
        ImageButton numOneBtn = root.findViewById(R.id.numOneBtn);
        ImageButton numTwoBtn = root.findViewById(R.id.numTwoBtn);
        EditText detailsEt = root.findViewById(R.id.userDetailsEt);
        TextView detailsTv = root.findViewById(R.id.userDetailsTv);
        EditText numOneEt = root.findViewById(R.id.numOneEt);
        TextView numOneTv = root.findViewById(R.id.numOneTv);
        EditText numTwoEt = root.findViewById(R.id.numTwoEt);
        TextView numTwoTv = root.findViewById(R.id.numTwoTv);


        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details = detailsEt.getText().toString();
                detailsTv.setText(details);
                detailsTv.setVisibility(View.VISIBLE);
                detailsEt.setVisibility(View.GONE);
                doneBtn.setVisibility(View.GONE);
            }
        });
        numOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numOne = numOneEt.getText().toString();
                numOneTv.setText(numOne);
                numOneTv.setVisibility(View.VISIBLE);
                numOneEt.setVisibility(View.GONE);
                numOneBtn.setVisibility(View.GONE);
            }
        });
        numTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numTwo = numTwoEt.getText().toString();
                numTwoTv.setText(numTwo);
                numTwoTv.setVisibility(View.VISIBLE);
                numTwoEt.setVisibility(View.GONE);
                numTwoBtn.setVisibility(View.GONE);
            }
        });

        return root;
    }
}