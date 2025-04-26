package com.samit.webserver.singlethreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket=new ServerSocket(8080);
            System.out.println("Single-threaded Server started on port 8080...");
            while(true) {
                Socket socket=serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());
                BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                String input=in.readLine();
                while(!input.isEmpty()) {
                    System.out.println(input);
                    input = in.readLine();
                }
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain");
                out.println(input);
                out.println();
                out.println("Hello from single-threaded server!");
                out.close();
                socket.close();

            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
