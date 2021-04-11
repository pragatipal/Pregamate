package com.example.pregamate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {

    private EditText nameEt, emailEt,  passwordEt, confirm_passwordEt;
    private TextView loginTv;
    private Button signUpBtn;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        loginTv = findViewById(R.id.loginTv);
        progressBar = findViewById(R.id.progressBar);
        signUpBtn = findViewById(R.id.signupBtn);
        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        confirm_passwordEt = findViewById(R.id.confirm_passwordEt);
        auth = FirebaseAuth.getInstance();

        clickListener();
    }
    private void clickListener() {

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpBtn.setVisibility(View.GONE);
                loginTv.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= nameEt.getText().toString();
                String email= emailEt.getText().toString();
                String password= passwordEt.getText().toString();
                String confirmPassword= confirm_passwordEt.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (name.isEmpty()|| name.equals(" ")){
                    nameEt.setError("Please enter a valid name");
                    return;

                }
                if (email.isEmpty() || !email.matches(emailPattern)){
                    emailEt.setError("Please enter a valid email");
                    return;

                }
                if (password.isEmpty()|| password.length() < 6){
                    passwordEt.setError("Please enter a valid 6 or more digit password");
                    return;
                }
                if (!confirmPassword.equals(password)){
                    confirm_passwordEt.setError("Password not matched");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                createAccount(name, email, password);
                signUpBtn.setVisibility(View.GONE);
                loginTv.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void createAccount(String name, String email, String password) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            assert user != null;
                            uploadUser(user,name,email);
                            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getApplicationContext(), "Email verification link sent", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            String exception = Objects.requireNonNull(task.getException()).getMessage();
                            Toast.makeText(getApplicationContext(), "Error: "+ exception, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void uploadUser(FirebaseUser user, String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
        map.put("profileImage", " ");
        map.put("uid", user.getUid());

        FirebaseFirestore.getInstance().collection("Users").document(user.getUid())
                .set(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "Error"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}