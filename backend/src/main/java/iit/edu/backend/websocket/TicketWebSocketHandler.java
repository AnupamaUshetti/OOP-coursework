package iit.edu.backend.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TicketWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Process the incoming message
        String payload = message.getPayload(); // Incoming message payload
        System.out.println("Received message: " + payload);

        // Example: Respond with a simple message
        String responseMessage = "Message received: " + payload;
        session.sendMessage(new TextMessage(responseMessage));
    }
}
