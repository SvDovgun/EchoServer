package com.luxoft.echoserver.old;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientByte {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 3000); //  ищем сервер по хосту и порту
        ) {

            System.out.println("Please enter message for server ");
            Scanner scanner = new Scanner(System.in);
            String messageToServer = scanner.nextLine();

            socket.getOutputStream().write(messageToServer.getBytes());
            System.out.println("Message is sent to server ");

            System.out.println("reading message from server ");
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);
            String messageFromServer = new String(buffer, 0, count);
            System.out.println( messageFromServer);
            System.out.println("Finish ");
        }
    }
}
