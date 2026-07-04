import dao.EmployeeDAO;
import db.DatabaseConnection;
import models.Employee;
import utils.MenuUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DatabaseConnection.getDataSource().getConnection();

        MenuUI.printWelcomeScreen();
        boolean isRunning = true;

        while (isRunning) {

            MenuUI.printMainMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    MenuUI.printEmployeeMenu();

                    EmployeeDAO employeeDAO = new EmployeeDAO(connection);

                    System.out.print("select an option: ");
                    int option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Enter all the information about the employee");
                            System.out.println("============================================");

                            Employee newEmployee = new Employee();

                            System.out.println("Please enter the first name: ");
                            String firstName = scanner.next();
                            newEmployee.setFirst_name(firstName);

                            System.out.println("Please enter the last name: ");
                            String lastName = scanner.next();
                            newEmployee.setLast_name(lastName);

                            System.out.println("Please enter the email address: ");
                            String email = scanner.next();
                            newEmployee.setEmail(email);

                            System.out.println("Please enter the phone number: ");
                            String phoneNumber = scanner.next();
                            newEmployee.setPhone(phoneNumber);

                            System.out.println("Please enter the hire date of the employee (ex. 2012-01-25): ");
                            String hireDate = scanner.next();
                            newEmployee.setHire_date(LocalDate.parse(hireDate));

                            System.out.println("Please enter the salary: ");
                            Long salary = scanner.nextLong();
                            newEmployee.setSalary(salary);

                            employeeDAO.insert(newEmployee);

                            System.out.println("Employee created successfully");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;

                    }
                    break;
                case 2:
                    MenuUI.printDepartmentMenu();
                    break;
                case 3:
                    MenuUI.printPositionMenu();
                    break;
                case 0:
                    System.out.println("\nThank you for using Employee Management System!");
                    System.out.println("Goodbye 👋");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            System.out.println("\nPress ENTER to continue...");
            scanner.nextLine(); // consume newline
            scanner.nextLine();
        }


    }
}
