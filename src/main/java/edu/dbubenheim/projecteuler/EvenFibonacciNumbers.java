package edu.dbubenheim.projecteuler;

import java.math.BigInteger;

/**
 * @author dbubenheim@communicode.de
 */
public class EvenFibonacciNumbers {

    private static final int FOUR_MILLION = 4_000_000;
    private static final BigInteger FOUR_MILLION_BIG_INTEGER = BigInteger.valueOf(FOUR_MILLION);
    private static final BigInteger TWO_BIG_INTEGER = BigInteger.valueOf(2);

    /**
     * 0 ... 1 ... 2 ... 3 ... 5 ... 8 ... 13
     * 4 --> 5
     * 5 --> 8
     * 6 --> 13
     // sums:
     // 1 = 1
     // 3 = 1 + 2
     // 6 = 1 + 2 + 3
     // 11 = 1 + 2 + 3 + 5
     // 19 = 1 + 2 + 3 + 5 + 8
     // 32 = 1 + 2 + 3 + 5 + 8 + 13
     * @param args
     */
    public static void main(final String... args) {

        calculateFibonacci();
        calculateFibonacciBigInteger();
    }

    public static void calculateFibonacciBigInteger() {
        BigInteger sum = BigInteger.ZERO;
        BigInteger fibonacci = BigInteger.ZERO;
        BigInteger prePredecessor = BigInteger.ZERO;
        BigInteger predecessor = BigInteger.ZERO;
        while (fibonacci.compareTo(FOUR_MILLION_BIG_INTEGER) <= 0) {
            fibonacci = prePredecessor.equals(BigInteger.ZERO) ? BigInteger.ONE : predecessor.add(prePredecessor);
            if (fibonacci.remainder(TWO_BIG_INTEGER).equals(BigInteger.ZERO)) {
                sum = sum.add(fibonacci);
            }
            prePredecessor = predecessor;
            predecessor = fibonacci;
        }
        System.out.println(String.format("sum: %s", sum));
    }

    public static void calculateFibonacci() {
        long sum = 0;
        long fibonacci = 0;
        long prePredecessor = 0;
        long predecessor = 0;
        while (fibonacci <= FOUR_MILLION ) {
            fibonacci = (prePredecessor == 0) ? 1 : predecessor + prePredecessor;
            if (fibonacci % 2 == 0) {
                sum += fibonacci;
            }
            prePredecessor = predecessor;
            predecessor = fibonacci;
        }
        System.out.println(String.format("sum: %s", sum));
    }
}