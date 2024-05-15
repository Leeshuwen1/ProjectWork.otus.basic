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
        ServerSocket serverSocket = new ServerSocket(8189);


        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                Server server = new Server(new DataInputStream(clientSocket.getInputStream()), new DataOutputStream(clientSocket.getOutputStream()));
                server.mathematicalCalcu();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
