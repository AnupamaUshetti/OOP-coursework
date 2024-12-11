package iit.edu.backend.service;

import iit.edu.backend.model.Configuration;
import iit.edu.backend.util.JsonUtil;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private Configuration configuration;

    public Configuration getConfiguration() {
        if (configuration == null) {
            throw new IllegalStateException("Configuration not set!");
        }
        return configuration;
    }

    public void saveConfiguration(Configuration config) {
        this.configuration = config;
        JsonUtil.saveConfiguration(config);
    }
}

