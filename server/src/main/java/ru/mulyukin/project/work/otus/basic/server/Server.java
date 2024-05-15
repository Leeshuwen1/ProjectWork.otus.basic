package ru.mulyukin.project.work.otus.basic.server;

import ru.mulyukin.project.work.otus.basic.client.CalculatorApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {

    ServerApplycation serverApplycation = new ServerApplycation();
    CalculatorApp calculatorApp = new CalculatorApp();

    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Server(DataInputStream inputStream, DataOutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void mathematicalCalcu() throws IOException {
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
