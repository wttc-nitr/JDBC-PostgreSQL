import com.student.mgmt.Student;
import com.student.mgmt.StudentDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to Student-mgmt cli...");
        Scanner sc = new Scanner(System.in);
        boolean ok = true;
        while (ok) {
            System.out.println("press:\n1 to add.\n2 to delete.\n3 to display all.\n4 to update.\n5 to exit.");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter student details:\nEnter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter phone:");
                    String phone = sc.nextLine();
                    System.out.println("Enter city:");
                    String city =  sc.nextLine();

                    Student st = new Student(name, phone, city);
                    boolean isInserted = StudentDAO.insertToDB(st);

                    if (isInserted)
                        System.out.println("inserted successfully");
                    else System.out.println("failed, try again...");
                    break;
                case 2:
                    System.out.println("Enter Student id:");
                    int id = Integer.parseInt(sc.nextLine());

                    boolean isDeleted = StudentDAO.deleteFromDB(id);
                    if (isDeleted)
                        System.out.println("deleted successfully");
                    else System.out.println("something went wrong...");
                    break;
                case 3:
                    StudentDAO.showAllStudents();
                    break;
                case 4:

                case 5:
                    ok = false;
                    System.out.println("pressed 4, exiting...\n");
                    break;
                default:
                    System.out.println("please press valid key.\n");
            }
        }
        sc.close();
    }
}