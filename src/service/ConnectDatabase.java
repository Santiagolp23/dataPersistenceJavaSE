package service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectDatabase {
    private static Connection myConnection;

    private ConnectDatabase() {
    }

    public static Connection getConnection() {
        if (myConnection == null) {
            try {
                myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_messages", "root", "");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return myConnection;
    }
}
