package iit.edu.backend.controller;

import iit.edu.backend.model.Configuration;
import iit.edu.backend.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping
    public Configuration getConfiguration() {
        return configurationService.getConfiguration();
    }

    @PostMapping
    public void saveConfiguration(@RequestBody Configuration configuration) {
        configurationService.saveConfiguration(configuration);
    }
}

