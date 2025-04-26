package com.samit.webserver.singlethreaded;

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), false);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send request
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost");
        out.flush();
        // Read and print response
        String responseLine;
        while ((responseLine = in.readLine()) != null) {
            System.out.println(responseLine);
        }
        socket.close();
    }
}
