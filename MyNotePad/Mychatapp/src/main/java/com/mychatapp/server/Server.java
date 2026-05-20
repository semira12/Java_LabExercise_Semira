package com.mychatapp.server;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<ClientHandler> clients= new ArrayList<>();
    public static void main() throws IOException {

        try {

            ServerSocket serverSocket = new ServerSocket(1000);

            System.out.println("Server started...");

            while (true) {

                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
                clients.add(clientHandler);


        }
            //System.out.println("Client connected!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }