# JavaFX Chat App

A simple real-time multi-client chat application built with Java, JavaFX, sockets, multithreading, and MySQL.

## Features

- Real-time messaging
- Multi-client support
- Login & registration
- JavaFX GUI
- MySQL database integration

## Technologies

- Java 21
- JavaFX
- MySQL
- JDBC
- Socket Programming
- Multithreading

## Database Setup

```sql
CREATE DATABASE chatapp;

USE chatapp;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE messages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender VARCHAR(50),
    message TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Run

1. Start MySQL
2. Run `Server.java`
3. Run `LoginUI.java`
4. Register/Login and start chatting
