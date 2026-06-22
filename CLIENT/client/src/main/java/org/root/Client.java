package org.root;

import java.net.URI;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

//WebSocketClient is an abstract class.
class WsClient extends WebSocketClient {
    public WsClient(URI serverURI) {
        super(serverURI);
    }
    
    //Fires when a servee connects.
    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("Connected!");
        send("Hi from client!");
    }
    
    //Fires when the server sends data.
    @Override
    public void onMessage(String message) {
        System.out.println("From server: %s".formatted(message));
    }
    
    //Fires when the server disconnects.
    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Disconnected!");
    }
    
    //Handles possible connection failure.
    @Override
    public void onError(Exception exception) {
        exception.printStackTrace();
    }
}

//Nain java entry point.
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Client!");
        WsClient client = new WsClient(new URI("ws://localhost:6890"));
        
        client.connect();
    }
}