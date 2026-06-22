package org.root;

import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

//WebSocketServer is an abstract class.
class WsServer extends WebSocketServer {
    public WsServer(int port) {
        //Access the parent class parameter.
        super(new InetSocketAddress(port));
    }
    
    //Fires when a client connects.
    @Override
    public void onOpen(WebSocket connection, ClientHandshake handshake) {
        System.out.println("Connected, address: %s".formatted(connection.getRemoteSocketAddress()));
    }
    
    //Fires when a client disconnects.
    @Override
    public void onClose(WebSocket connection, int code, String reason, boolean remote) {
        System.out.println("Server disconnected!");
    }
    
    //Fires when the client sends data.
    @Override
    public void onMessage(WebSocket connection, String message) {
        System.out.println("Recieved: %s".formatted(message));
        connection.send("Server: Recieved message, %s".formatted(message));
    }
    
    //If an error occurs this code handles it.
    @Override
    public void onError(WebSocket connection, Exception exception) {
        exception.printStackTrace();
    }
    
    //Fires when the server is activated.
    @Override
    public void onStart() {
        System.out.println("Listening on port: 6890");
    }
}

//Main java entry point.
public class Server {
    public static void main(String[] args) {
        System.out.println("Hello, Server!");
        WsServer server = new WsServer(6890);
        server.start();
    }
}
