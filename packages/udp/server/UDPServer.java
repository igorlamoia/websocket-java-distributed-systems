package packages.udp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import packages.shared.Calculator;
import packages.shared.CalculatorDTO;
import packages.shared.GetCalculatorParams;

public class UDPServer {

    public static void main(String[] args) {
        int port = 9876;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Server is listening on port " + port);

            while (true) {
                // Buffer to receive incoming data
                byte[] buffer = new byte[1024];
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);

                // Receive a packet from the client
                socket.receive(requestPacket);
                String received = new String(requestPacket.getData(), 0, requestPacket.getLength());

                CalculatorDTO dto = GetCalculatorParams.execute(received);
                Calculator calculator = new Calculator(dto.getOperator());
                float result = calculator.run(dto.getNumberParams());

                // Prepare a response
                String responseMessage = "Calculator output: " + result;
                byte[] responseData = responseMessage.getBytes();

                // Send the response back to the client
                InetAddress clientAddress = requestPacket.getAddress();
                int clientPort = requestPacket.getPort();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress,
                        clientPort);
                socket.send(responsePacket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
