package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.EmailLogin.getText().toString().isEmpty() || binding.PasswordLogin.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Пожалуйста Заполните все поля", Toast.LENGTH_SHORT).show();

                }else{
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.EmailLogin.getText().toString(), binding.PasswordLogin.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(activity_login.this, MainMenu.class));
                                    }
                                }
                            });
                }
            }
        });
    }
}