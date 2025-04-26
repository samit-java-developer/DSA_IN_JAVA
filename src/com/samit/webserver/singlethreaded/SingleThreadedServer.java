package com.samit.webserver.singlethreaded;

import java.io.*;
import java.net.*;

public class SingleThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Single-threaded Server started on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Handle client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = in.readLine();
            System.out.println("Received: " + request);
            request = in.readLine();
            System.out.println("Received: " + request);

            // Send response
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println(request);
            out.println("Hello from single-threaded server!");
            out.println("-----------------------------------");

            clientSocket.close();
        }
    }
}
