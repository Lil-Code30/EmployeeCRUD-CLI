package utils;

import models.Employee;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeePrinter {

    public static void EmployeesTable(List<Employee> employees) {

        String format = "| %-4s | %-12s | %-12s | %-25s | %-10s | %-12s | %-10s | %-10s |%n";

        System.out.println("==============================================================================================");
        System.out.printf(format,
                "ID", "First Name", "Last Name", "Email", "Phone", "Hire Date", "Salary", "Status");
        System.out.println("==============================================================================================");

        for (Employee e : employees) {
            System.out.printf(format,
                    e.getEmployee_id(),
                    safe(e.getFirst_name()),
                    safe(e.getLast_name()),
                    safe(e.getEmail()),
                    safe(e.getPhone()),
                    e.getHire_date(),
                    e.getSalary(),
                    safe(e.getStatus())
            );
        }

        System.out.println("==============================================================================================");
        System.out.println("Total Employees: " + employees.size());
    }

    private static String safe(String value) {
        return value == null ? "N/A" : value;
    }

    private static final DateTimeFormatter DT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void EmployeeCard(Employee e){

        System.out.println("""
                ╔══════════════════════════════════════════════════════╗
                ║                  EMPLOYEE CARD                       ║
                ╠══════════════════════════════════════════════════════╣
                """);

                        System.out.printf("║ ID        : %-36s ║%n", e.getEmployee_id());
                        System.out.printf("║ Name      : %-36s ║%n", e.getFirst_name() + " " + e.getLast_name());
                        System.out.printf("║ Email     : %-36s ║%n", e.getEmail());
                        System.out.printf("║ Phone     : %-36s ║%n", e.getPhone());
                        System.out.printf("║ Hire Date : %-36s ║%n", e.getHire_date());
                        System.out.printf("║ Salary    : %-36s ║%n", e.getSalary());
                        System.out.printf("║ Status    : %-36s ║%n", e.getStatus());

                        if (e.getCreated_at() != null) {
                            System.out.printf("║ Created   : %-36s ║%n", e.getCreated_at().format(DT));
                        }

                        if (e.getUpdated_at() != null) {
                            System.out.printf("║ Updated   : %-36s ║%n", e.getUpdated_at().format(DT));
                        }

                        System.out.println("""
                ╚══════════════════════════════════════════════════════╝
        """);
    }
}
