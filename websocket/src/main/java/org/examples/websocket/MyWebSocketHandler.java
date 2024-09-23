package org.examples.websocket;

import org.java_websocket.client.WebSocketClient;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

    private WebSocketClient clientSocketHandler;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, ExecutionException, InterruptedException, URISyntaxException {
        session.sendMessage(new TextMessage("Received message: " + message.getPayload()));
        // 当接收到客户端消息时，将其转发到另一个WebSocket服务
        forwardToAnotherWebSocketService(message.getPayload(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // Handle the closed connection
        this.clientSocketHandler.close();
        this.clientSocketHandler = null;
    }

    private void forwardToAnotherWebSocketService(String message, WebSocketSession userSession) throws IOException, ExecutionException, InterruptedException, URISyntaxException {
        if (this.clientSocketHandler == null) {
            CLientSocketHandler clientSocketHandlerTemp = new CLientSocketHandler();
            clientSocketHandlerTemp.setSession(userSession);
            this.clientSocketHandler = clientSocketHandlerTemp.getWebSocketClient();
            Thread.sleep(1000);
        }
        System.out.println("user message: " + message);
        if (message.equals("ping")) {
            return;
        }
        clientSocketHandler.send(message);
    }
}
