package edu.dbubenheim.projecteuler;

import java.math.BigInteger;

/**
 * Problem 25
 *
 * 1000-digit Fibonacci number
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * @author daniel.bubenheim@gmail.com
 */
public class ThousandDigitFibonacciNumber {

    public static void main(String[] args) {
        final int digits = 1000;
        final BigInteger firstFibonacciOfDigits = findFirstFibonacciOfDigits(digits);
        System.out.printf("first fibonacci number of %s digits is: %s", digits, firstFibonacciOfDigits);
    }

    public static BigInteger findFirstFibonacciOfDigits(final long digits) {
        BigInteger index = BigInteger.ONE;
        BigInteger fibonacci = BigInteger.ONE;
        BigInteger previousFibonacci = BigInteger.ZERO;
        while (fibonacci.toString().length() < digits) {
            final BigInteger nextFibonacci = fibonacci.add(previousFibonacci);
            previousFibonacci = fibonacci;
            fibonacci = nextFibonacci;
            index = index.add(BigInteger.ONE);
        }
        System.out.printf("index of the fibonacci sequence with %s digits is: %s%n", digits, index);
        return fibonacci;
    }
}