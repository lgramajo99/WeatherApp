package com.example.weatherapplite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    String base_url= "https://api.openweathermap.org/data/2.5/";
    String token = "b7a14427cb7c70ffc554dfb69802a7c9";
    String unidades = "metric";
    String lenguaje = "es";


    //nombre despues de la base_url
    //https://api.openweathermap.org/data/2.5/weather
    @GET("weather")
    Call<Modelo> getActualWeather(@Query("lat") float latitud, @Query("lon") float longitud, @Query("appid") String token, @Query("unidades")String unidades, @Query("lenguaje") String lenguaje);
}
