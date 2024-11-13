package packages.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import packages.shared.GetUserInput;

public class UDPClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9876;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(hostname);
            // Message to send to the server

            String userInput = GetUserInput.execute();
            byte[] buffer = userInput.getBytes();

            // Send packet to server
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length, serverAddress, port);
            socket.send(requestPacket);
            System.out.println("Message sent to the server");

            // Buffer to receive response from server
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            // Receive response from server
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Received from server: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
