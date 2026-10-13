import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    LocalDate startDate;

    Plan(LocalDate startDate) {
        this.startDate = startDate;
    }

    abstract int getDays();
}

class BasicPlan extends Plan {
    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    int getDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    int getDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    int getDays() {
        return 365;
    }
}

public class Assignment5_StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(startDate);
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan(startDate);
            } else {
                plan = new PremiumPlan(startDate);
            }

            LocalDate renewalDate =
                    plan.startDate.plusDays(plan.getDays());

            System.out.println(
                    name + ": " + renewalDate
            );
        }
    }
}