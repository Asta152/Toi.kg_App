package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityRegistrationBinding;
import android.view.View;

import java.util.HashMap;

public class Registration_Activity extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void startMainMenuActivity(View v){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}