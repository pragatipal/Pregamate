package com.example.pregamate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class ForgotPasswordActivity extends AppCompatActivity {
    private Button recoverBtn;
    private EditText emailEt3;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth = FirebaseAuth.getInstance();
        recoverBtn = findViewById(R.id.recoverBtn);
        emailEt3 = findViewById(R.id.emailEt3);
        clickListener();
    }

    private void clickListener() {
        recoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEt3.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (email.isEmpty() || !email.matches(emailPattern)) {
                    emailEt3.setError("Please input valid email.");
                }
                auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // do something when mail was sent successfully.
                            Toast.makeText(getApplicationContext(), "Password Reset link sent", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        } else {
                            String exception = Objects.requireNonNull(task.getException()).getMessage();
                            Toast.makeText(getApplicationContext(), "Error: "+ exception, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}