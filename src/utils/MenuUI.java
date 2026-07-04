package utils;

public class MenuUI {

    public static void printWelcomeScreen() {
        System.out.println("""
                ╔══════════════════════════════════════════════════════════════════════════╗
                ║                                                                          ║
                ║   ███████╗███╗   ███╗███████╗                                            ║
                ║   ██╔════╝████╗ ████║██╔════╝                                            ║
                ║   █████╗  ██╔████╔██║███████╗                                            ║
                ║   ██╔══╝  ██║╚██╔╝██║╚════██║                                            ║
                ║   ███████╗██║ ╚═╝ ██║███████║                                            ║
                ║   ╚══════╝╚═╝     ╚═╝╚══════╝                                            ║
                ║                                                                          ║
                ║             EMPLOYEE MANAGEMENT SYSTEM                                   ║
                ║                                                                          ║
                ║  Efficiently manage Employees, Departments and Positions                 ║
                ║                                                                          ║
                ║  ✔ Employee CRUD                                                         ║
                ║  ✔ Department Management                                                 ║
                ║  ✔ Position Management                                                   ║
                ║  ✔ Search, Filter & Sorting                                              ║
                ║                                                                          ║
                ║  Developed with Java • JDBC • PostgreSQL                                 ║
                ║                                                                          ║
                ╚══════════════════════════════════════════════════════════════════════════╝
                """);
    }

    public static void printMainMenu() {
        System.out.println("""
                ┌───────────────────────────────────────────────────────────────┐
                │                         MAIN MENU                             │
                ├───────────────────────────────────────────────────────────────┤
                │                                                               │
                │   1. Employee Management                                      │
                │   2. Department Management                                    │
                │   3. Position Management                                      │
                │                                                               │
                │   0. Exit                                                     │
                │                                                               │
                └───────────────────────────────────────────────────────────────┘
                """);
    }

    public static void printEmployeeMenu() {
        System.out.println("""
                ╔══════════════════════════════════════════════════════════════╗
                ║                    EMPLOYEE MANAGEMENT                       ║
                ╠══════════════════════════════════════════════════════════════╣
                ║                                                              ║
                ║   1. Create Employee                                         ║
                ║   2. Update Employee                                         ║
                ║   3. Delete Employee                                         ║
                ║   4. View Employee                                           ║
                ║   5. View All Employees                                      ║
                ║   6. Search Employee by Name                                 ║
                ║   7. Filter by Department                                    ║
                ║   8. Filter by Salary                                        ║
                ║   9. Sort by Hire Date                                       ║
                ║                                                              ║
                ║   0. Back                                                    ║
                ║                                                              ║
                ╚══════════════════════════════════════════════════════════════╝
                """);
    }

    public static void printDepartmentMenu() {
        System.out.println("""
                ╔══════════════════════════════════════════════════════════════╗
                ║                   DEPARTMENT MANAGEMENT                      ║
                ╠══════════════════════════════════════════════════════════════╣
                ║                                                              ║
                ║   1. Add Department                                          ║
                ║   2. Update Department                                       ║
                ║   3. Delete Department                                       ║
                ║   4. List Departments                                        ║
                ║                                                              ║
                ║   0. Back                                                    ║
                ║                                                              ║
                ╚══════════════════════════════════════════════════════════════╝
                """);
    }

    public static void printPositionMenu() {
        System.out.println("""
                ╔══════════════════════════════════════════════════════════════╗
                ║                     POSITION MANAGEMENT                      ║
                ╠══════════════════════════════════════════════════════════════╣
                ║                                                              ║
                ║   1. Add Position                                            ║
                ║   2. Update Position                                         ║
                ║   3. Delete Position                                         ║
                ║                                                              ║
                ║   0. Back                                                    ║
                ║                                                              ║
                ╚══════════════════════════════════════════════════════════════╝
                """);
    }

}
