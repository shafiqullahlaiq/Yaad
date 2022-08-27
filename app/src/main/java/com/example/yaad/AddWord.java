package com.example.yaad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yaad.data.YaadWordStoreHelper;
import com.google.android.material.textfield.TextInputEditText;

public class AddWord extends AppCompatActivity {
    Toolbar toolbar;
    Button btn_add,btn_cancel;
    TextInputEditText n_word,n_mean;
//    SQLiteOpenHelper dbHelper = new YaadWordStoreHelper(this);
//    SQLiteDatabase db = dbHelper.getWritableDatabase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        findById();
        setup();
    }

    private void setup() {
        toolbarSetup();
        Toast.makeText(this, "Data is not inserted", Toast.LENGTH_LONG).show();
        clickListeners();
    }

    private void clickListeners() {
        btn_add.setOnClickListener((View v)->{
            String word,mean;
//
            word = n_word.getText().toString();
            mean = n_word.getText().toString();
            YaadWordStoreHelper yaad = new YaadWordStoreHelper(this);
            boolean check = yaad.add_word(word,mean);
            if(check == true){
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Data is not inserted", Toast.LENGTH_LONG).show();
            }



        });

        btn_cancel.setOnClickListener((View v)->{
            // delete the entered word and mean from the edite text erea
            n_word.setText("");
            n_mean.setText("");
        });
    }

    @SuppressLint("RestrictedApi")
    private void toolbarSetup() {
        toolbar.setTitle("اضافه کوول");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    private void findById() {
        toolbar = findViewById(R.id.activitiesToolbar);
        btn_add = findViewById(R.id.btn_add);
        btn_cancel = findViewById(R.id.btn_cancel);
        n_word = findViewById(R.id.edt_add_word);
        n_mean = findViewById(R.id.edt_add_mean);
    }
}