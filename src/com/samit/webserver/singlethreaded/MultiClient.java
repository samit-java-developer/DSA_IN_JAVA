package com.samit.webserver.singlethreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiClient {
    public static void main(String[] args) {
        Socket socket=null;
        PrintWriter out=null;
        BufferedReader in=null;
        for (int i = 0; i < 10; i++) {
            try{
                socket = new Socket("localhost", 8080);
                out = new PrintWriter(socket.getOutputStream(), false);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Send request
                out.println("GET / HTTP/1.1 " +i);
                out.println(i);
                out.flush();
                // Read and print response
                String responseLine;
                while ((responseLine = in.readLine()) != null) {
                    System.out.println(responseLine);
                }
                socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
