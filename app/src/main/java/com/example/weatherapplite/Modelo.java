package com.example.weatherapplite;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Modelo {
    @SerializedName("name")
    public String name;

    @SerializedName("weather")
    public ArrayList<Weather> weather = null;
    @SerializedName("main")
    public Main main = null;

    public class Main{
        @SerializedName("temp")
        public  Float temp;
        @SerializedName("temp_min")
        public  Float temp_min;
        @SerializedName("temp_max")
        public Float temp_max;
    }

public class Weather{
        @SerializedName("description")
        public String description;
}

public Modelo(String name, ArrayList<Weather> weather, Main main){
            this.name = name;
            this.weather = weather;
            this.main = main;
}


}
