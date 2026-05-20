package com.mychatapp.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;

    public void connect(String username) {

        try {

            System.out.println("Connecting to server...");

            socket = new Socket("localhost", 1000);

            System.out.println("Connected!");

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            System.out.println("Sending username...");

            out.println(username);

            System.out.println("Username sent!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {

        out.println(message);
    }

    public BufferedReader getReader() {

        return in;
    }
}