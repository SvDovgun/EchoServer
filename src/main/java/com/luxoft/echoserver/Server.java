package com.luxoft.echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000); //start to listen port 3000
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            System.out.println("waiting for client's message");

            String messageFromClient = bufferedReader.readLine();

            bufferedWriter.write("echo: " + messageFromClient);
            bufferedWriter.newLine();
            System.out.println("sent changed message to client");

            bufferedWriter.flush();
        }
    }
}
