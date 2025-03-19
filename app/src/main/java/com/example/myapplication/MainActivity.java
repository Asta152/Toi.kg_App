package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startRegActivity(View v){
        Intent intent = new Intent(this, Registration_Activity.class);
        startActivity(intent);
    }
    public void startLoginActivity(View v){
        Intent intent = new Intent(this, activity_login.class);
        startActivity(intent);
    }
}