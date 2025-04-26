package com.samit.webserver.singlethreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket=new ServerSocket(8080);
            System.out.println("Multi-threaded Server started on port 8080...");
            while(true){
                Socket socket=serverSocket.accept();
                new MultiThreadedServerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class MultiThreadedServerThread extends Thread{
    private Socket clientSocket;

    public MultiThreadedServerThread(Socket socket){
        this.clientSocket=socket;
    }

    @Override
    public void run() {
        System.out.println("Client connected: " + this.clientSocket.getInetAddress());

        BufferedReader in = null;
        PrintWriter out=null;
        String request=null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handle client
            request = in.readLine();
            System.out.println("Received: " + request);
            request = in.readLine();
            System.out.println("Received: " + request);

            // Send response
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println(request);
            out.println("Hello from multi-threaded server!");
            out.println("-----------------------------------");

            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}