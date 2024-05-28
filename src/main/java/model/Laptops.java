package model;

import controller.AdditionServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.FileWriter;
import java.net.URISyntaxException;

public class Laptops {
    public void addLaptop(Laptop laptop) throws IOException
    {
        // создание json объекта для нового ноутбука
        JSONObject laptopJson = new JSONObject();
        laptopJson.put("price", laptop.getPrice());
        laptopJson.put("display", laptop.getDisplay());
        laptopJson.put("model", laptop.getModel());
        laptopJson.put("processor", laptop.getProcessor());
        laptopJson.put("storage_drive", laptop.getStorage_drive());
        laptopJson.put("RAM", laptop.getRAM());

        //путь к json
        String jsonPath = getJsonPath();

        // чтение содержимого
        String jsonContent = new String(Files.readAllBytes(Path.of(jsonPath)));

        //разбиение json на массив
        JSONArray jsonArray = new JSONArray(jsonContent);

        //добавление объекта ноутбука в массив
        jsonArray.put(laptopJson);

        //обновление json локально
        writeJsonToFile(jsonPath, jsonArray);

        //обновление json на сервере
        writeJsonToFile("laptops.json", jsonArray);
    }


    private String getJsonPath() {
        try {
            String parentPath = new File(AdditionServlet.class.getProtectionDomain().getCodeSource().getLocation().toURI())
                    .getParentFile().getParent();
            return parentPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "laptops.json";
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeJsonToFile(String filePath, JSONArray jsonArray) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonArray.toString(4));
        } catch (IOException ex) {
            System.out.println("Ошибка записи JSON в файл: " + ex.getMessage());
        }
    }

}
