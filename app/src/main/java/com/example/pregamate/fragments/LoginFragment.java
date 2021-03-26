package com.example.pregamate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pregamate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginFragment extends Fragment {

    private EditText emailEt2, passwordEt2;
    private TextView sigUpTv2, forgotPasswordTv;
    private Button loginBtn2;
    private ImageView googleLoginIv;
    private ProgressBar progressBar2;

    private FirebaseAuth auth;

    public LoginFragment() {
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

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailEt2.getText().toString();
                String password= passwordEt2.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (email.isEmpty() || !email.matches(emailPattern)){
                    emailEt2.setError("Please inpput valid email.");
                }
                if (password.isEmpty()|| password.length() < 6){
                    passwordEt2.setError("Please enter a valid 6 or more digit password");
                    return;
                }
                progressBar2.setVisibility(View.VISIBLE);

                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    

                                }
                                else {
                                    progressBar2.setVisibility(View.GONE);
                                    String exception = Objects.requireNonNull(task.getException()).getMessage();
                                    Toast.makeText(getContext(), "Error: "+ exception, Toast.LENGTH_SHORT).show();
                                }

                            }

                        });
            }
        });
    }

    private void init(View view){

        loginBtn2 = view.findViewById(R.id.loginBtn2);
        progressBar2= view.findViewById(R.id.progressBar2);
        sigUpTv2 =view.findViewById(R.id.signupTv2);
        googleLoginIv=view.findViewById(R.id.googleLoginIv);
        forgotPasswordTv= view.findViewById(R.id.forgotPasswordTv);
        emailEt2=view.findViewById(R.id.emailEt2);
        passwordEt2=view.findViewById(R.id.passwordEt2);
        auth = FirebaseAuth.getInstance();
    }
}