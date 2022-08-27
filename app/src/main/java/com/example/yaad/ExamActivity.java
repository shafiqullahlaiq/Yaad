package com.example.yaad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class ExamActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        
        findById();
        setup();
    }

    private void setup() {
        toolbarSetup();
    }

    @SuppressLint("RestrictedApi")
    private void toolbarSetup() {
        toolbar.setTitle("ازمویني");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    private void findById() {
        toolbar = findViewById(R.id.activitiesToolbar);
    }
}