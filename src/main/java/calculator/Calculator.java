package calculator;

import java.math.BigInteger;

public class Calculator {

    public static double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Cannot sqrt negative number");
        return Math.sqrt(x);
    }

    public static BigInteger factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Cannot factorial negative number");
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("ln undefined for <=0");
        return Math.log(x);
    }

    public static double pow(double x, double b) {
        return Math.pow(x, b);
    }
}
