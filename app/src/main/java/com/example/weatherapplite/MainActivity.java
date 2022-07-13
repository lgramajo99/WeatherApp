package com.example.weatherapplite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void redirectListActivity(View view){
        intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }

    public void redirectDetail(View view){
        intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}