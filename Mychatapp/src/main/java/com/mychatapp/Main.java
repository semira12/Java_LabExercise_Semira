package com.mychatapp;

import java.net.ServerSocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        try{
            ServerSocket serverSocket=new ServerSocket(1050);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
