package org.examples.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 自定义WebSocket客户端
 * WebSocket客户端 核心依赖包-
 *         <dependency>
 *             <groupId>org.java-websocket</groupId>
 *             <artifactId>Java-WebSocket</artifactId>
 *             <version>1.5.5</version>
 *         </dependency>
 */
public class CLientSocketHandler {

    /**
     * 日志
     */
    private final Logger log = LoggerFactory.getLogger(WebSocketConfig.class);

    private final WebSocketClient webSocketClient;

    private WebSocketSession session;

    public CLientSocketHandler () throws URISyntaxException, InterruptedException {
        webSocketClient = new WebSocketClient(new URI("wss://u236684-8642-dcfdda86.westb.seetacloud.com:8443/queue/join"), new Draft_6455()) {

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                log.info("[websocket] 连接成功");
            }


            @Override
            public void onMessage(String message) {
                log.info("[websocket] 收到消息={}",message);
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


            @Override
            public void onClose(int code, String reason, boolean remote) {
                log.info("[websocket] 退出连接");
            }


            @Override
            public void onError(Exception ex) {
                log.info("[websocket] 连接错误={}",ex.getMessage());
            }
        };

        webSocketClient.connect();
//        Thread.sleep(1000);
//        webSocketClient.send("{\"fn_index\":1179,\"session_hash\":\"3suv88sp57d\"}");
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public WebSocketClient getWebSocketClient() {
        return webSocketClient;
    }
}