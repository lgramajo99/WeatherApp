package com.example.weatherapplite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends ListActivity {

    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        datos = getIntent().getExtras();
        String datosObtenidos = datos.getString("valorListaCiudad");
        TextView nombreC = (TextView) findViewById(R.id.nombreCiudadIdTxt);
      nombreC.setText(datosObtenidos);

//        Intent miIntencion = getIntent();
 //       String name = miIntencion.getStringExtra("valorListaCiudad");
   //     TextView textView = (TextView)findViewById(R.id.nombreCiudadIdTxt);
     //   textView.setText(name);
    }

}