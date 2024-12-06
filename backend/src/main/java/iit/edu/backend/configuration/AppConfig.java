package iit.edu.backend.configuration;

import com.example.ticketingsystem.model.TicketPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AppConfig {
    @Bean
    public TicketPool ticketPool() {
        return new TicketPool();
    }

}
