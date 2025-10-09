package calculator;

import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Calculator Display===");
            System.out.println("1) Square root (√x)");
            System.out.println("2) Factorial (!x)");
            System.out.println("3) Natural logarithm (ln x)");
            System.out.println("4) Power (x^b)");
            System.out.println("5) Exit");
            System.out.print("Choose an option: ");

            String opt = sc.nextLine().trim();
            try {
                switch (opt) {
                    case "1":
                        System.out.print("Enter x: ");
                        double x = Double.parseDouble(sc.nextLine());
                        System.out.println("Result: " + Calculator.sqrt(x));
                        break;
                    case "2":
                        System.out.print("Enter n: ");
                        int n = Integer.parseInt(sc.nextLine());
                        BigInteger res = Calculator.factorial(n);
                        System.out.println(n + "! = " + res);
                        break;
                    case "3":
                        System.out.print("Enter x: ");
                        double y = Double.parseDouble(sc.nextLine());
                        System.out.println("Result: " + Calculator.ln(y));
                        break;
                    case "4":
                        System.out.print("Enter base x: ");
                        double base = Double.parseDouble(sc.nextLine());
                        System.out.print("Enter exponent b: ");
                        double exp = Double.parseDouble(sc.nextLine());
                        System.out.println("Result: " + Calculator.pow(base, exp));
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting...");
        sc.close();
    }
}
