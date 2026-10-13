import java.util.Scanner;

interface SaverMode {
    double reduceEnergy(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceEnergy(double units) {
        return units * 0.75;
    }

    String getType() {
        return "AC";
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceEnergy(double units) {
        return units * 0.75;
    }

    String getType() {
        return "WASHER";
    }
}

public class Assignment5_ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                sc.skip("[ \\t]*");
                if (sc.hasNext("SAVER")) {
                    sc.next();
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliance = new Television(hours);
            } else {
                appliance = new WashingMachine(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).reduceEnergy(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}