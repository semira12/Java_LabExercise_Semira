package com.mychatapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseManager {

    private final String URL =
            "jdbc:mysql://localhost:3306/chatapp";

    private final String USER =
            "root";

    private final String PASSWORD =
            "";

    public Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
    public void saveMessage(String sender, String message) {
        try {

            Connection connection =
                    getConnection();

            String sql =
                    "INSERT INTO messages(sender, message) VALUES (?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, sender);

            statement.setString(2, message);

            statement.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }
    public boolean registerUser(
            String username,
            String password) {

        try {

            Connection connection =
                    getConnection();

            String sql =
                    "INSERT INTO users(username, password) VALUES (?, ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, username);

            statement.setString(2, password);

            statement.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    public boolean validateLogin(
            String username,
            String password) {

        try {

            Connection connection =
                    getConnection();

            String sql =
                    "SELECT * FROM users WHERE username = ? AND password = ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, username);

            statement.setString(2, password);

            ResultSet resultSet =
                    statement.executeQuery();

            return resultSet.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

}