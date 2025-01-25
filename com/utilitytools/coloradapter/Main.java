package com.utilitytools.coloradapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Color.class, new ColorAdapter())
                .setPrettyPrinting()
                .create();

        Color color = new Color(100, 150, 200, 255);
        String json = gson.toJson(color);
        System.out.println("Serialized JSON: " + json);

        String jsonInput = "{\"red\":50,\"green\":100,\"blue\":150,\"alpha\":255}";
        Color deserializedColor = gson.fromJson(jsonInput, Color.class);
        System.out.println("Deserialized Color: " + deserializedColor);
    }
}
