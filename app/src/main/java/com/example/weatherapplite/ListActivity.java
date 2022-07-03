package com.example.weatherapplite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setListView();

    }

    public void setListView(){
        listView = findViewById(R.id.listView);
        names = new ArrayList<>();
        names.add("Tucuman");
        names.add("Buenos Aires");
        names.add("Cordoba");
        names.add("Rosario");
        names.add("Santiago del Estero");

//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,names);

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        listView.setAdapter(customAdapter);
    }


    }

