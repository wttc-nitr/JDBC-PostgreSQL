package com.student.mgmt;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/student_mgmt";
            String user = "animesh";
            String password = "postgres";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
}