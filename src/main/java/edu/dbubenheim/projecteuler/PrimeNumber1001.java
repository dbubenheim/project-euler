package edu.dbubenheim.projecteuler;

import java.math.BigInteger;

/**
 * Problem 7
 *
 * 10001st prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * @author daniel.bubenheim@gmail.com
 */
public class PrimeNumber1001 {

    public static void main(final String... args) {
        final BigInteger prime = findPrimeNumberAt(BigInteger.valueOf(10001));
        System.out.printf("The 10001st prime number is %s%n", prime);
    }

    public static BigInteger findPrimeNumberAt(final BigInteger index) {
        BigInteger counter = BigInteger.ZERO;
        BigInteger number = BigInteger.ZERO;
        while (counter.compareTo(index) != 0) {
            number = number.add(BigInteger.ONE);
            if (isPrime(number)) {
                counter = counter.add(BigInteger.ONE);
            }
        }
        return number;
    }

    public static boolean isPrime(final BigInteger number) {
        return number.isProbablePrime(99);
    }
}