package iit.edu.backend.configuration;

import iit.edu.backend.model.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class JsonConfig {

    private static final String CONFIG_FILE = "config.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveConfiguration(Configuration config) throws IOException {
        objectMapper.writeValue(new File(CONFIG_FILE), config);
    }

    public Configuration loadConfiguration() throws IOException {
        return objectMapper.readValue(new File(CONFIG_FILE), Configuration.class);
    }
}
