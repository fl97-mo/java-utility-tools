package com.utilitytools.coloradapter;

import java.awt.Color;
import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class ColorAdapter extends TypeAdapter<Color> {
    //Serializes a java.awt.Color object into its JSON representation.
    @Override
    public void write(JsonWriter out, Color value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.beginObject();
        out.name("red").value(value.getRed());
        out.name("green").value(value.getGreen());
        out.name("blue").value(value.getBlue());
        out.name("alpha").value(value.getAlpha());
        out.endObject();
    }

    //Deserialize a JSON object into a java.awt.Color object.
    @Override
    public Color read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        int r = 0, g = 0, b = 0, a = 255;

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "red" -> r = in.nextInt();
                case "green" -> g = in.nextInt();
                case "blue" -> b = in.nextInt();
                case "alpha" -> a = in.nextInt();
            }
        }
        in.endObject();
        return new Color(r, g, b, a);
    }
}
