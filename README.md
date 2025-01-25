# Java Utility Tools

A small collection of different java tools to make your projects easier and more efficient.

## Tools

### ColorAdapter
- A **Gson TypeAdapter** for serializing and deserializing `java.awt.Color` objects to/from JSON.
- **Features**:
  - Converts `java.awt.Color` to JSON with `red`, `green`, `blue`, and `alpha` fields.
  - Reads JSON and creates a `java.awt.Color` object.
- **Example**:
  ```java
  Gson gson = new GsonBuilder()
      .registerTypeAdapter(Color.class, new ColorAdapter())
      .create();

  // Serialize
  Color color = new Color(100, 150, 200);
  String json = gson.toJson(color);
  System.out.println(json); // {"red":100,"green":150,"blue":200,"alpha":255}

  // Deserialize
  Color newColor = gson.fromJson("{\"red\":50,\"green\":100,\"blue\":150}", Color.class);
  System.out.println(newColor); // java.awt.Color[r=50,g=100,b=150]
---
