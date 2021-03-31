package com.example.pregamate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pregamate.R;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordFragment extends Fragment {

    private Button recoverBtn;
    private EditText emailEt3;
    private FirebaseAuth auth;
    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        clickListener();
    }

    private void clickListener() {
        recoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailEt3.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.isEmpty() || !email.matches(emailPattern)){
                    emailEt3.setError("Please inpput valid email.");
                }
                auth.sendPasswordResetEmail(email);
            }
        });
    }


    private void init(View view) {
        auth = FirebaseAuth.getInstance();
        recoverBtn = getView().findViewById(R.id.startBtn);
        emailEt3 = getView().findViewById(R.id.emailEt3);
    }


}