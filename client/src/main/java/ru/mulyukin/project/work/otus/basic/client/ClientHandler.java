package ru.mulyukin.project.work.otus.basic.client;

import java.io.*;

public class ClientHandler implements Closeable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ClientHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public int send(char sing, int a, int b) throws IOException {
        outputStream.writeChar(sing);
        outputStream.writeInt(a);
        outputStream.writeInt(b);
        outputStream.flush();
        int result = inputStream.readInt();
        System.out.println(result);
        return result;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
    }
}
