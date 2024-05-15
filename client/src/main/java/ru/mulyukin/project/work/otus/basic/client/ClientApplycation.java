package ru.mulyukin.project.work.otus.basic.client;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApplycation {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localHost", 8189)) {
            ClientHandler clientHandler = new ClientHandler(socket.getInputStream(), socket.getOutputStream());
            new Thread(() -> {
                while (true) {
                    System.out.println("Выберите символ: +, -, *, /");
                    char sing = scanner.next().charAt(0);
                    System.out.println("Введите числа ");
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    try {
                        clientHandler.send(sing, a, b);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        clientHandler.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("На ноль делить нельзя " + e);
        }


    }
}
