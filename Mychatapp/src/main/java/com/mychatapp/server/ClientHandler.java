package com.mychatapp.server;

import com.mychatapp.server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;

    private String username;

    public ClientHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            System.out.println("Handler started");

            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true
            );

            System.out.println("Waiting for username...");

            username = in.readLine();

            System.out.println("USERNAME RECEIVED: " + username);

            String message;

            while ((message = in.readLine()) != null) {

                System.out.println(username + ": " + message);

                broadcastMessage(
                        username + ": " + message
                );
            }

            System.out.println("Client disconnected");

            socket.close();

            Server.clients.remove(this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {

        for (ClientHandler client : Server.clients) {

            if (client.out != null) {

                client.out.println(message);
            }
        }
    }
}