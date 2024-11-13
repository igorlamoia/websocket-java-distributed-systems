### Package Descriptions

- **packages/shared**: Contains shared classes used by both TCP and UDP implementations.

  - `Calculator.java`: Implements basic arithmetic operations.
  - `CalculatorDTO.java`: Data Transfer Object for calculator operations.
  - `GetCalculatorParams.java`: Parses input strings to create `CalculatorDTO` objects.
  - `GetUserInput.java`: Utility class to get user input from the console.

- **packages/tcp/client**: Contains the TCP client implementation.

  - `TCPClient.java`: Connects to the TCP server, sends user input, and receives responses.

- **packages/tcp/server**: Contains the TCP server implementation.

  - `ClientHandler.java`: Handles individual client connections in separate threads.
  - `MultiThreadedTCPServer.java`: Listens for incoming connections and starts a new `ClientHandler` thread for each client.

- **packages/udp/client**: Contains the UDP client implementation.

  - `UDPClient.java`: Sends user input to the UDP server and receives responses.

- **packages/udp/server**: Contains the UDP server implementation.
  - `UDPServer.java`: Listens for incoming UDP packets, processes them, and sends responses.

## TCP vs UDP

### TCP (Transmission Control Protocol)

- **Connection-oriented**: Establishes a connection before data is sent.
- **Reliable**: Ensures that data is delivered in the same order it was sent.
- **Error-checking**: Provides error-checking and guarantees delivery.
- **Use Case**: Suitable for applications where data integrity and order are critical, such as file transfers, web pages, and emails.

### UDP (User Datagram Protocol)

- **Connectionless**: Sends data without establishing a connection.
- **Unreliable**: Does not guarantee delivery, order, or error-checking.
- **Faster**: Lower latency compared to TCP due to the lack of connection overhead.
- **Use Case**: Suitable for applications where speed is more critical than reliability, such as video streaming, online gaming, and voice over IP (VoIP).

## Running the Project

To compile and run the project, follow these steps:

1. **Compile the Java files**:

   ```sh
   javac packages/**/**/*.java
   ```

2. **Run the TCP Server**:

   ```sh
   java -cp . packages.tcp.server.MultiThreadedTCPServer
   ```

3. **Run the TCP Client**:

   ```sh
   java -cp . packages.tcp.client.TCPClient
   ```

4. **Run the UDP Server**:

   ```sh
   java -cp . packages.udp.server.UDPServer
   ```

5. **Run the UDP Client**:
   ```sh
   java -cp . packages.udp.client.UDPClient
   ```

## Assignment Instructions

1. **TCP Server and Client**:

   - Implement 4 types of basic arithmetic services (addition, subtraction, division, and multiplication).
   - Receive a message in the format `[op,arg1,arg2,arg3,...,argN]`, where `op` is a symbol of `+`, `-`, `/`, or `*`, and `arg` are real numbers.
   - Apply the corresponding operation to the list of elements and return the result or an error message if the operation is not possible.

2. **UDP Server and Client**:
   - Implement the same functionality as the TCP server and client using UDP.
