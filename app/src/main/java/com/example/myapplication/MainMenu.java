package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);


    }
    public void startChastActivity(View v){
        Intent intent = new Intent(this, Chast_Activity.class);
        startActivity(intent);

    }
    public void startBusinessActivity(View v){
        Intent intent = new Intent(this, BusinesActivity.class);
        startActivity(intent);
    }
    public void startEnjoyActivity(View v){
        Intent intent = new Intent(this, EnjoyActivity.class);
        startActivity(intent);
    }
}