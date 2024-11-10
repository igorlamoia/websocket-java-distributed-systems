package packages.tcp.server;

import java.io.*;
import java.net.*;

public class MultiThreadedTCPServer {

    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            serverSocket.setReuseAddress(true);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Start a new thread for each client connection
                new ClientHandler(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
