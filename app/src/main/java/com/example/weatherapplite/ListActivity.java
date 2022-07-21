package com.example.weatherapplite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<String> ciudades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setListView();

    }

    public void setListView(){
        lista = (ListView)findViewById(R.id.listView);
        ciudades = new ArrayList<String>();
        ciudades.add("Tucuman");
        ciudades.add("Buenos Aires");
        ciudades.add("Cordoba");
        ciudades.add("Rosario");
        ciudades.add("Santiago del Estero");

//        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,ciudades);

//        CustomAdapter customAdapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, names);
//        listView.setAdapter(customAdapter);

        CustomAdapter miDiseño = new CustomAdapter
                (getApplicationContext(), android.R.layout.simple_list_item_1, ciudades);
        lista.setAdapter(miDiseño);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                redirectDetail(ciudades.get(position));
            }
        });
}

    private void redirectDetail(String ciudades) {
        Intent miIntencion = new Intent(this, DetailActivity.class);

        miIntencion.putExtra("valorListaCiudad", ciudades);
//      miIntencion.putExtra("valorListaCiudad", "" + ciudades);
        startActivity(miIntencion);
    }
}

