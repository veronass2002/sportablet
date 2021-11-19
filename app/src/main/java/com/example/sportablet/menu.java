package com.example.sportablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
    }
}