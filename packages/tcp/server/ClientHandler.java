package packages.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import packages.shared.Calculator;

public class ClientHandler extends Thread {
  private Socket socket;

  public ClientHandler(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

      output.println("Welcome to the server!");
      String clientMessage;

      // Echo received messages back to the client
      while ((clientMessage = input.readLine()) != null) {
        // System.out.println("Received from client: " + clientMessage);
        String[] params = clientMessage.split(" ");
        String operator = params[0];

        // Create a new float array for the remaining parameters
        float[] numberParams = new float[params.length - 1];
        for (int i = 1; i < params.length; i++)
          numberParams[i - 1] = Float.parseFloat(params[i]);
        Calculator calculator = new Calculator(operator);
        float result = calculator.run(numberParams);
        output.println("Server result from operation " + operator + ": " + result);
      }

    } catch (IOException e) {
      System.out.println("Error handling client: " + e.getMessage());
    } finally {
      try {
        socket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Connection with client closed");
    }
  }

}
