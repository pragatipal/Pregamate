package com.example.pregamate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.pregamate.fragments.LoginFragment;
import com.example.pregamate.fragments.SignupFragment;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    TextView signupTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn= findViewById(R.id.loginBtn);
        signupTv=findViewById(R.id.signupTv);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginBtn.setVisibility(View.GONE);
                signupTv.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer, new LoginFragment()).commit();
            }
        });

        signupTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupTv.setVisibility(View.GONE);
                loginBtn.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer, new SignupFragment()).commit();
            }
        });

    }
}