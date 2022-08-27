package com.example.yaad;

import com.example.yaad.data.*;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,MainOptions.OptionClickListener{
    Toolbar toolbar;
    DrawerLayout lyt_drawer;
    NavigationView nav_main;
    ActionBarDrawerToggle toggle;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();
        setup();
    }
    // ====================== Connect front with Back ================
    private void findById() {
        nav_main = findViewById(R.id.nav_main_navigation);
        lyt_drawer = findViewById(R.id.lyt_drawer);
        toolbar = findViewById(R.id.main_toolbar);
        recycler = findViewById(R.id.recycler_view_main);
    }
    // ====================== All Activity Setup =====================
    private void setup() {
        toolbarSetup();
        setupDashboard();
    }

    private void setupDashboard() {
        ArrayList<String> str = new ArrayList<>();
        str = MainOptionDataModel.getStr();
        ArrayList<Integer> srcs = new ArrayList<>();
        srcs = MainOptionDataModel.getSrcs();
        MainOptions option = new MainOptions(str,srcs,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position == 0){
                    return 2;
                }else {
                    return 1;
                }
            }
        });
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(option);



    }

    // ========================== Toolbar setup ======================
    @SuppressLint("RestrictedApi")
    private void toolbarSetup() {

        toggle = new ActionBarDrawerToggle(this,
                lyt_drawer,
                R.string.open_drawer,
                R.string.close_drawer);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lyt_drawer.addDrawerListener(toggle);
        nav_main.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        toggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            if(lyt_drawer.isDrawerOpen(Gravity.RIGHT)){
                lyt_drawer.closeDrawer(Gravity.RIGHT);
            }else{
                lyt_drawer.openDrawer(Gravity.RIGHT);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(this,"This",Toast.LENGTH_LONG).show();
                intent = new Intent(MainActivity.this,MainActivity.class);
                break;
            case R.id.add_word:
                intent = new Intent(MainActivity.this,AddWord.class);
                break;
            case R.id.repeat_word:
                intent = new Intent(MainActivity.this,RepeatWordActivity.class);
                break;
            case R.id.exam:
                intent = new Intent(MainActivity.this,ExamActivity.class);
                break;
            case R.id.badges:
                intent = new Intent(MainActivity.this,BadgesActivity.class);
                break;
            case R.id.set_target:
                intent = new Intent(MainActivity.this,SetGoalsActivity.class);
                break;
            case R.id.about_us:
                intent = new Intent(MainActivity.this,AboutUsActivity.class);
                break;
            default:
                intent = new Intent(MainActivity.this,MainActivity.class);

        }
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(lyt_drawer.isDrawerOpen(Gravity.RIGHT)){
            lyt_drawer.closeDrawer(Gravity.RIGHT);
        }else{
            super.onBackPressed();
        }

    }
//
    @Override
    public void onOptionClick(int position) {
        Intent intent = null;
        switch (position){
            case 1:
                intent = new Intent(MainActivity.this,AddWord.class);
                break;
            case 2:
                intent = new Intent(MainActivity.this,RepeatWordActivity.class);
                break;
            case 3:
                intent = new Intent(MainActivity.this,ExamActivity.class);
                break;
            case 4:
                intent = new Intent(MainActivity.this,BadgesActivity.class);
                break;
            case 5:
                intent = new Intent(MainActivity.this,SetGoalsActivity.class);
                break;
            case 6:
                intent = new Intent(MainActivity.this,AboutUsActivity.class);
                break;
        }

        startActivity(intent);

    }
}