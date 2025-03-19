package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityLoginBinding;

public class activity_login extends AppCompatActivity {

    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void startMainMenuActivity(View v){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

}