package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.databinding.ActivityRegistrationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration_Activity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.RegisterButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.NameRegistration.getText().toString().isEmpty() || binding.EmailRegistration.getText().toString().isEmpty()
                        || binding.PasswordRegistration.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Пожалуйста Заполните все поля", Toast.LENGTH_SHORT).show();
                }
                else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.EmailRegistration.getText().toString(),
                                    binding.PasswordRegistration.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        HashMap<String, String> userInfo = new HashMap<>();
                                        userInfo.put("email", binding.EmailRegistration.getText().toString());
                                        userInfo.put("username", binding.NameRegistration.getText().toString());
                                        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(userInfo);

                                        startActivity(new Intent(Registration_Activity.this, MainMenu.class));
                                    }
                                }
                            });

                }
            }
        });
    }
}