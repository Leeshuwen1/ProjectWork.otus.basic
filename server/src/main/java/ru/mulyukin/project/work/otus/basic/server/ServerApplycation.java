package ru.mulyukin.project.work.otus.basic.server;

import ru.mulyukin.project.work.otus.basic.client.CalculatorApp;
import ru.mulyukin.project.work.otus.basic.client.ClientHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplycation {
    public static void main(String[] args) throws IOException {
        CalculatorApp calculatorApp = new CalculatorApp();
        ServerSocket serverSocket = new ServerSocket(8189);


        while (true) {
            Socket clientSocket = serverSocket.accept();
            //   new ClientHandler(new DataInputStream(clientSocket.getInputStream()), clientSocket.getOutputStream());

            DataInputStream inputStream = new DataInputStream((clientSocket.getInputStream()));
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());


            char clientRequest = inputStream.readChar();
            System.out.println(clientRequest);
            int clientInt = inputStream.readInt();
            System.out.println(clientInt);
            int secondInt = inputStream.readInt();
            System.out.println(secondInt);
            int result = calculatorApp.calculator(clientRequest, clientInt, secondInt);
            System.out.println(result);
            outputStream.writeInt(result);
            outputStream.flush();
        }
    }
}
