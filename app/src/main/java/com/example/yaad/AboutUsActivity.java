package com.example.yaad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;

public class AboutUsActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findById();
        setup();
    }

    private void setup() {
        toolbarSetup();
    }

    @SuppressLint("RestrictedApi")
    private void toolbarSetup() {
        toolbar.setTitle("زمونږپه اړه");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    private void findById() {
        toolbar = findViewById(R.id.activitiesToolbar);
    }
}