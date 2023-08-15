package org.java.example.day0;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);  // Server will run on port 8888
        System.out.println("Server started and waiting for client connection...");

        Socket clientSocket = serverSocket.accept();  // This will block until a client connects

        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine();
        System.out.println("Received from client: " + inputLine);

        out.writeBytes("Hello from server!\n");

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
