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

            preparedStatement.executeUpdate(); // fire queries
            connection.close(); // close the connection after operation
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
            connection.close(); // close the connection after operation
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
            PreparedStatement preparedStatement = connection.prepareStatement(query); // create query

            ResultSet resultSet = preparedStatement.executeQuery(); // fire query to get result
            connection.close(); // close the connection
            // process the result
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
        int id = student.getId();
        String name = student.getName();
        String city = student.getCity();
        String phone = student.getPhone();

        boolean ok = false;
        try (Connection connection = ConnectDB.connect();) {
            String query = "UPDATE students SET name = ?, city = ?, phone = ? WHERE id = ? ;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            connection.close();

            ok = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ok;
    }
}
