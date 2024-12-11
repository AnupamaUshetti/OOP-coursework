package iit.edu.backend.util;

import iit.edu.backend.model.Configuration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {
    private static final String FILE_PATH = "configurations.json";

    public static synchronized void saveConfiguration(Configuration config) {
        if (config == null) {
            throw new IllegalArgumentException("Configuration object cannot be null");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(FILE_PATH);

        try {
            file.getParentFile().mkdirs();
            try (FileWriter writer = new FileWriter(file, false)) {
                gson.toJson(config, writer);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + FILE_PATH + " - " + e.getMessage());
            e.printStackTrace();
        }
    }
}

