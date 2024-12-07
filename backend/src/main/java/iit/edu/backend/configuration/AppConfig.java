package iit.edu.backend.configuration;

import iit.edu.backend.model.TicketPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {
    @Bean
    public TicketPool ticketPool() {
        return new TicketPool();
    }

}
