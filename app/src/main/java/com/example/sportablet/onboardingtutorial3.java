package com.example.sportablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class onboardingtutorial3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardingtutorial3);
        getSupportActionBar().hide();
    }
    public void ocClick(View view) {
        Intent i;
        i = new Intent(this, onboardingtutorial3.class);
        startActivity(i);
    }
    public void otClick(View view) {
        Intent i;
        i = new Intent(this, login.class);
        startActivity(i);
    }
}