package org.funtimecoding.java.mysql.example;

import java.sql.*;

public class ExampleMain {
    public static void main(String[] args) {
        ExampleMain main = new ExampleMain();

        try {
            main.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void run() throws SQLException, ClassNotFoundException {
        String database = System.getenv("DATABASE");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");
        String connect = database + "?user=" + username + "&password=" + password + "&zeroDateTimeBehavior=convertToNull";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connect);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM example.user");
        System.out.println("Printing schema for table: " + resultSet.getMetaData().getTableName(1));
        int columnCount = resultSet.getMetaData().getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println(i + " " + resultSet.getMetaData().getColumnName(i));
        }

        System.out.println("Searching for example user.");
    }
}
