package com.example.sportablet;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class onboardingtutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboardingtutorial);
        getSupportActionBar().hide();
    }
    public void ocClick(View view) {
        Intent i;
        i = new Intent(this, onboardingtutorial2.class);
        startActivity(i);
    }
    public void otClick(View view) {
        Intent i;
        i = new Intent(this, login.class);
        startActivity(i);
    }
}