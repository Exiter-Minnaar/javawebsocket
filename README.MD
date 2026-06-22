# JavaWebSocket

A minimal Java WebSocket example — the simplest way to get a WebSocket server and client up and running in Java.

## Overview

This project is a straightforward reference for implementing WebSocket communication in Java. It covers setting up a server that listens on a port and a client that connects to it — useful if you're learning WebSockets or need a clean starting point.

## How It Works

**Server** — listens on port `6890`:

```java
public class Server {
    public static void main(String[] args) {
        WsServer server = new WsServer(6890);
        server.start();
    }
}
```

**Client** — connects to the server via WebSocket URI:

```java
public class Client {
    public static void main(String[] args) throws Exception {
        WsClient client = new WsClient(new URI("ws://localhost:6890"));
        client.connect();
    }
}
```

> Run the server first, then the client in a separate shell tab. Both communicate over `ws://localhost:6890`.

## Getting Started

```bash
git clone https://github.com/Exiter-Minnaar/javawebsocket.git
cd javawebsocket
```

Open the project in your preferred Java IDE and run `Server.java` and `Client.java` each in a separate shell tab.

## Author

**Reinhard Cornelius Minnaar**

## License

[MIT](LICENSE)