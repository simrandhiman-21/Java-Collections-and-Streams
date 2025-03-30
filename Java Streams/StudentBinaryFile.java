import java.io.*;
import java.util.Scanner;

public class StudentBinaryFile {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Students");
        System.out.println("2. Display Students");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        if (option == 1) {
            addStudents(sc);
        } else if (option == 2) {
            displayStudents();
        } else {
            System.out.println("Invalid option!");
        }

        sc.close();
    }

    // Method to add student details to binary file
    private static void addStudents(Scanner sc) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");

                System.out.print("Roll Number: ");
                int rollNumber = sc.nextInt();
                sc.nextLine();  // Consume newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("GPA: ");
                double gpa = sc.nextDouble();

                // Write to binary file
                dos.writeInt(rollNumber);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }

            System.out.println("Student details saved successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to read and display student details from binary file
    private static void displayStudents() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {

            System.out.println("\nStudent Details:");
            
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

