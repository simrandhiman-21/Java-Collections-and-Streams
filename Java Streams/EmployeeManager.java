import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class (Serializable)
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;  // Serialization ID
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class EmployeeManager {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("1. Add Employees");
        System.out.println("2. Display Employees");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        if (option == 1) {
            addEmployees(sc, employees);
            serializeEmployees(employees);
        } else if (option == 2) {
            List<Employee> retrieved = deserializeEmployees();
            System.out.println("\nEmployee List from File:");
            for (Employee emp : retrieved) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Invalid option!");
        }

        sc.close();
    }

    // Method to add employees
    private static void addEmployees(Scanner sc, List<Employee> employees) {
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();  // Consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Department: ");
            String dept = sc.nextLine();

            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, dept, salary));
        }
    }

    // Serialize (Save) Employees to File
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees saved to file: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }

    // Deserialize (Retrieve) Employees from File
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error retrieving employees: " + e.getMessage());
        }
        return employees;
    }
}
