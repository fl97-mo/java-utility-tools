# Java Utility Tools
A small collection of different java tools to make your projects easier and more efficient.

## Tools:

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
### WrapLayout
- A **custom FlowLayout** that wraps components to the next line when the container width is exceeded.
- **Features**:
  - Automatically breaks components into new rows when they exceed the available container width.
  - Supports alignment options: `FlowLayout.LEFT`, `FlowLayout.CENTER`, and `FlowLayout.RIGHT`.
  - Allows setting horizontal and vertical gaps between components.
- **Example**:
  ```java
  JPanel panel = new JPanel(new WrapLayout(FlowLayout.LEFT, 10, 10));
  panel.add(new JButton("Button 1"));
  panel.add(new JButton("Button 2"));
  panel.add(new JButton("Button 3"));
  panel.add(new JButton("Button 4"));
  panel.add(new JButton("Button 5"));

  JFrame frame = new JFrame("WrapLayout Example");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.add(panel);
  frame.pack();
  frame.setVisible(true);
  ```
---
### How to Use
1. **Clone the repository**:
   ```bash
   git clone https://github.com/fl97-mo/java-utility-tools.git
   ```
2. **Add the classes to your project**:
   - Copy the `com.utilitytools.swingutils.WrapLayout` class if you need a custom FlowLayout.
   - Copy the `com.utilitytools.coloradapter.ColorAdapter` class if you need a Gson TypeAdapter for `java.awt.Color`.
3. **Compile and run**:
   - Compile the Java files and include them in your project.
   - Use the classes in your project as shown in the examples above.
---
