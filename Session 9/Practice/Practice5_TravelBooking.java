import java.util.Scanner;

abstract class Travel {
    double distance;
    static final double BOOKING_FEE = 50.0;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class BusTravel extends Travel {
    BusTravel(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainTravel extends Travel {
    TrainTravel(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightTravel extends Travel {
    FlightTravel(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class Practice5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (mode.equals("BUS")) {
                travel = new BusTravel(distance);
            } else if (mode.equals("TRAIN")) {
                travel = new TrainTravel(distance);
            } else {
                travel = new FlightTravel(distance);
            }

            System.out.printf("%s: %.2f%n",
                    travel.getMode(), travel.calculateTotal());
        }

        sc.close();
    }
}