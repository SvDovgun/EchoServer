package com.luxoft.echoserver.old;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerByte {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000); //start to listen port 3000

        System.out.println("Start, wait for client's message");
        Socket socket = serverSocket.accept(); //wait for client
        // get message from client
        InputStream inputStream = socket.getInputStream();
        //System.out.println("got message from client");
        byte[] content  = new byte[100];
        int count = inputStream.read(content);
        System.out.println("Message from client is '" + new String(content, 0, count) + "'");
        // change message
        String messageToClient = "echo: " +  new String(content, 0, count);

        // send changed message to client
        //System.out.println("sending changed message to client");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(messageToClient.getBytes());
        System.out.println("sent changed message to client");

        System.out.println("Finish");
    }
}
