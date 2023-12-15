package org.example.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
    public static Connection getConnection() throws SQLException, IOException {

//        Properties props = new Properties();
//        try (FileInputStream fis = new FileInputStream(
//                "C:\\Repo\\Final_test\\final_test\\backend\\src\\main\\resources\\aplication.properties")) {
//
//            props.load(fis);
//            String url = props.getProperty("url");
//            String username = props.getProperty("username");
//            String password = props.getProperty("password");
//
//            return DriverManager.getConnection(url, username, password);
//        }
        String url ="jdbc:mysql://localhost/friends_of_man?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "root";
        String password = "12345678";

        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
