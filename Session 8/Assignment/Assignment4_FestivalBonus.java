import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {
    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class Assignment4_FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee =
                        new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee =
                        new PartTimeEmployee(name, salary);
            } else {
                employee =
                        new InternEmployee(name, salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n",
                    employee.name, bonus);

            total += bonus;
        }

        System.out.printf(
                "Total Bonus: %.2f%n", total);
    }
}
