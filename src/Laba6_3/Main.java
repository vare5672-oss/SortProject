package Laba6_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        sc.close();

        double low = 1.0;
        double high = 100000.0;

        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            if (f(mid) < a) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.printf("%.6f%n", (low + high) / 2.0);
    }

    static double f(double x) {
        return x * x - x + Math.sqrt(x);
    }
}
