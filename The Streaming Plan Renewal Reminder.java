
import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Subscription subscription;

            switch (type) {
                case "BASIC":
                    subscription = new Basic(name, startDate);
                    break;
                case "STANDARD":
                    subscription = new Standard(name, startDate);
                    break;
                default:
                    subscription = new Premium(name, startDate);
            }

            LocalDate renewalDate =
                    subscription.calculateRenewalDate();

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
