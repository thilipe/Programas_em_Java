import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Enumeration.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("==========================================================================");
            System.out.println("App read base salary from Worker");
            System.out.println("==========================================================================");

            // ===============================
            // Department
            // ===============================
            System.out.print("\nEnter department´s name: ");
            String nameDepartment = sc.nextLine();
            Department department = new Department(nameDepartment);

            // ===============================
            // Worker
            // ===============================
            System.out.println("Enter worker data:");

            System.out.print("Name: ");
            String nameWorker = sc.nextLine();

            System.out.print("Level (JUNIOR / MID_LEVEL / SENIOR): ");
            String nameLevel = sc.nextLine();
            WorkLevel wl = WorkLevel.valueOf(nameLevel.toUpperCase());

            System.out.print("Base salary: ");
            double baseSalary = sc.nextDouble();
            sc.nextLine(); // limpa buffer

            Worker worker = new Worker(nameWorker, wl, baseSalary, department);

            // ===============================
            // Contracts
            // ===============================
            System.out.print("\nHow many contracts to this worker? ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter contract #" + (i + 1) + " data:");

                System.out.print("Date (DD/MM/YYYY): ");
                String dateContract = sc.nextLine();
                Date date = sdf.parse(dateContract);

                System.out.print("Value per hour: ");
                double valueHour = sc.nextDouble();

                System.out.print("Duration (hours): ");
                int h = sc.nextInt();
                sc.nextLine();

                worker.addContract(new HourContract(date, valueHour, h));
            }

            // ===============================
            // Income calculation
            // ===============================
            System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
            String dateIncome = sc.nextLine();

            String[] parts = dateIncome.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);

            double income = worker.income(year, month);

            System.out.println("\nName: " + worker.getName());
            System.out.println("Department: " + worker.getDp().getName());
            System.out.printf("Income for %s: R$ %.2f%n", dateIncome, income);

        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid worker level! Use JUNIOR, MID_LEVEL, SENIOR.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        sc.close();
    }
}
