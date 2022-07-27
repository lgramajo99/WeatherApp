package com.example.weatherapplite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends ListActivity {
    Bundle datos;
    TextView nombreCiudadIdTxt, tempActual, tempDescripcion, tempMin, tempMax;
    Float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        datos = getIntent().getExtras();
        String datosObtenidos = datos.getString("valorListaCiudad");
        TextView nombreC = (TextView) findViewById(R.id.nombreCiudadIdTxt);
        nombreC.setText(datosObtenidos);

        //Obtener latitud y longitud
        Intent intent = getIntent();
        latitud = intent.getFloatExtra("lat", 0.0F);
        longitud = intent.getFloatExtra("lon", 0.0F);

        //Obtener los textView
        nombreCiudadIdTxt = findViewById(R.id.nombreCiudadIdTxt);
        tempActual = findViewById(R.id.tempActual);
        tempDescripcion = findViewById(R.id.tempDescripcion);
        tempMin= findViewById(R.id.tempMin);
        tempMax = findViewById(R.id.tempMax);

        getActualWeather();

    }

    public void getActualWeather() {
        //Llamamos a la API
        Call<Results>call= RetrofitClient.getInstance().getMyApi().getActualWeather(latitud, longitud, API.token, API.unidades, API.lenguaje);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results results = response.body();
                nombreCiudadIdTxt.setText(results.name);
                tempActual.setText(String.valueOf(results.main.temp.shortValue()));
                tempMin.setText(String.valueOf(results.main.temp_min.shortValue()));
                tempMax.setText(String.valueOf(results.main.temp_min.shortValue()));

                Results.Weather weather = results.weather.get(0);
                tempDescripcion.setText(weather.description);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

            }
        });
    }
}