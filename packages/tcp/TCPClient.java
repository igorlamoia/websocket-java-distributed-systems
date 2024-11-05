package packages.tcp;

import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to the server");

            // Receive welcome message from server
            System.out.println("Server: " + input.readLine());

            String userInput;
            while (true) {
                // Read user input from console
                System.out.print("Enter message (type 'exit' to quit): ");
                userInput = console.readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    System.out.println("Exiting...");
                    break;
                }

                // Send message to server
                output.println(userInput);

                // Print server response
                String response = input.readLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

