package org.java.example.networing;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8888);  // Connect to server on port 8888

        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        out.writeBytes("Hello from client!\n");

        String fromServer = in.readLine();
        System.out.println("Received from server: " + fromServer);

        in.close();
        out.close();
        clientSocket.close();
    }
}
