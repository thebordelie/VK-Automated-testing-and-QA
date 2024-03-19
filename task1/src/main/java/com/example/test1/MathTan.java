package com.example.test1;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathTan {
    public static double calculateTan(double x, int step) {
        x %= Math.PI;
        BigDecimal result = new BigDecimal(0);
        for (int n = 1; n < step; n++) {
            result = result.add(calculateCurrentTan(x, n));
        }
        return result.doubleValue();
    }

    private static BigDecimal calculateCurrentTan(double x, int n) {
        BigDecimal bernulli = BigDecimal.valueOf(bernouilli(2 * n).doubleValue());
        BigDecimal factorial = calculateFactorial(2 * n);
        BigDecimal value = BigDecimal.valueOf(Math.pow(-4, n) * (1 - Math.pow(4, n)) * Math.pow(x, 2 * n - 1));
        return bernulli.multiply(value).divide(factorial, 10, RoundingMode.HALF_UP);
    }

    private static BigDecimal calculateFactorial(int x) {
        if (x <= 2) {
            return new BigDecimal(x);
        }
        return new BigDecimal(x).multiply(calculateFactorial(x - 1));
    }

    private static BigFraction bernouilli(int n) {
        BigFraction[] A = new BigFraction[n + 1];
        for (int m = 0; m <= n; m++) {
            A[m] = new BigFraction(1, (m + 1));
            for (int j = m; j >= 1; j--)
                A[j - 1] = (A[j - 1].subtract(A[j])).multiply(new BigFraction(j));
        }
        return A[0];
    }
}
