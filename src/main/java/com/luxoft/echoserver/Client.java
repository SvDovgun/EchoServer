package com.luxoft.echoserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 3000); //  ищем сервер по хосту и порту
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {

            System.out.println("Please enter message for server ");
            Scanner scanner = new Scanner(System.in);
            String messageToServer = scanner.nextLine();

            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String messageFromServer = bufferedReader.readLine();
            System.out.println( messageFromServer);
            System.out.println("Finish ");
        }
    }
}
