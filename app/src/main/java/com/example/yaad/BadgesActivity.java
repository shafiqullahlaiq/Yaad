package com.example.yaad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

public class BadgesActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);
        
        findById();
        setup();
        
    }

    private void setup() {
        toolbarSetup();
    }

    @SuppressLint("RestrictedApi")
    private void toolbarSetup() {
        toolbar.setTitle("نښانونه");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, "Data is not inserted", Toast.LENGTH_LONG).show();
    }

    private void findById() {
        toolbar = findViewById(R.id.activitiesToolbar);
    }
}