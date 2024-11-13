package packages.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import packages.shared.Calculator;
import packages.shared.CalculatorDTO;
import packages.shared.GetCalculatorParams;

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
        CalculatorDTO dto = GetCalculatorParams.execute(clientMessage);
        Calculator calculator = new Calculator(dto.getOperator());
        float result = calculator.run(dto.getNumberParams());
        output.println("Calculator output from " + dto.getOperator() + ": " + result);
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
