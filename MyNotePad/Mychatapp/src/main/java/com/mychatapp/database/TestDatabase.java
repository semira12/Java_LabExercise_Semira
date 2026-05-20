package com.mychatapp.database;

import com.mychatapp.database.DatabaseManager;

import java.sql.Connection;

public class TestDatabase {

    public static void main(String[] args) {

        DatabaseManager db =
                new DatabaseManager();

        Connection connection =
                db.getConnection();

        if (connection != null) {

            System.out.println("Database connected!");

        } else {

            System.out.println("Connection failed!");
        }
    }
}
