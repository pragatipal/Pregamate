package com.example.pregamate.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pregamate.FragmentReplacerActivity;
import com.example.pregamate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupFragment extends Fragment {

    private EditText nameEt, emailEt,  passwordEt, confirm_passwordEt;
    private TextView loginTv;
    private Button signUpBtn;
    private FirebaseAuth auth;

    public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);

        clickListener();
    }

    private void clickListener() {
        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((FragmentReplacerActivity) getActivity()).setFragment(new LoginFragment());
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= nameEt.getText().toString();
                String email= emailEt.getText().toString();
                String password= passwordEt.getText().toString();
                String confirmPassword= confirm_passwordEt.getText().toString();

                if (name.isEmpty()|| name.equals(" ")){
                    nameEt.setError("Please enter a valid name");
                    return;

                }
                if (email.isEmpty()|| !email.matches(EMAIL_REGEX)){
                    emailEt.setError("Please enter a valid email");
                    return;

                }
                if (password.isEmpty()|| password.length() < 6){
                    passwordEt.setError("Please enter a valid password");
                    return;
                }
                if (!confirmPassword.equals(password)){
                    confirm_passwordEt.setError("Password not matched");
                    return;
                }

                createAccount(name, email, password);
            }
        });
    }

    private void createAccount(String name, String email, String password) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                        }else {
                            String execption = task.getException().getMessage();
                            Toast.makeText(getContext(), "Error: "+ execption, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void init(View view){

        nameEt=view.findViewById(R.id.nameEt);
        emailEt=view.findViewById(R.id.emailEt);
        passwordEt=view.findViewById(R.id.passwordEt);
        confirm_passwordEt=view.findViewById(R.id.confirm_passwordEt);

        auth = FirebaseAuth.getInstance();
    }
}