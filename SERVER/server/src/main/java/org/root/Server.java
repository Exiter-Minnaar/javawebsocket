package org.root;

import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

class WsServer extends WebSocketServer {
    public WsServer(int port) {
        super(new InetSocketAddress(port));
    }
    
    @Override
    public void onOpen(WebSocket connection, ClientHandshake handshake) {
        System.out.println("Connected, address: %s".formatted(connection.getRemoteSocketAddress()));
    }
    
    @Override
    public void onClose(WebSocket connection, int code, String reason, boolean remote) {
        System.out.println("Server disconnected!");
    }
    
    @Override
    public void onMessage(WebSocket connection, String message) {
        System.out.println("Recieved: %s".formatted(message));
        connection.send("Server: Recieved message, %s".formatted(message));
    }
    
    @Override
    public void onError(WebSocket connection, Exception exception) {
        exception.printStackTrace();
    }
    
    @Override
    public void onStart() {
        System.out.println("Listening on port: 6890");
    }
}

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello, Server!");
        WsServer server = new WsServer(6890);
        server.start();
    }
}
