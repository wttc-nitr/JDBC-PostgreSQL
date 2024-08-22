package com.student.mgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    public static boolean insertToDB (Student student) {

        boolean ok = false;
        try (Connection connection = ConnectDB.connect()) {
            String query = "INSERT INTO students VALUES(DEFAULT, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPhone());
            preparedStatement.setString(3, student.getCity());

            preparedStatement.executeUpdate();
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public static boolean deleteFromDB (int id) {
        boolean ok = false;
        try (Connection connection = ConnectDB.connect();) {
            String query = "DELETE FROM students WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            ok = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public static void showAllStudents () {
        try (Connection connection = ConnectDB.connect();) {
            String query = "SELECT * FROM students;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                String city = resultSet.getString(4);

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("City: " + city + "\n\n");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean updateStudentDetails (Student student) {
        boolean ok = false;
        int id = student.getId();

        return ok;
    }
}
