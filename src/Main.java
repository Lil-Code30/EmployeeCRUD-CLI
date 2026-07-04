import utils.MenuUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuUI.printWelcomeScreen();
        boolean isRunning = true;

        while (isRunning) {

            MenuUI.printMainMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    MenuUI.printEmployeeMenu();
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
